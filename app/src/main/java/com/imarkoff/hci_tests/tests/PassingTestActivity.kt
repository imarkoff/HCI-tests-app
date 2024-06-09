package com.imarkoff.hci_tests.tests

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imarkoff.hci_tests.MainViewModel
import com.imarkoff.hci_tests.R
import com.imarkoff.hci_tests.data.Answer
import com.imarkoff.hci_tests.data.Question
import com.imarkoff.hci_tests.data.Test
import com.imarkoff.hci_tests.data.TestResult
import com.imarkoff.hci_tests.ui.theme.HCITheme

@Suppress("DEPRECATION")
class PassingTestScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // make navigation bar transparent when 3-button navigation
        val systemBarStyle = when (val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> SystemBarStyle.light(Color.Transparent.toArgb(), Color.Transparent.toArgb())
            Configuration.UI_MODE_NIGHT_YES -> SystemBarStyle.dark(Color.Transparent.toArgb())
            else -> error("Illegal State, current mode is $currentNightMode")
        }

        enableEdgeToEdge(
            statusBarStyle = systemBarStyle,
            navigationBarStyle = systemBarStyle,
        )


        val test = intent.getParcelableExtra<Test>("test") ?: throw IllegalArgumentException("Test is null")
        val answersCounted = intent.getIntExtra("answersCounted", -1)
        setContent {
            HCITheme {
                PassingTestActivity(
                    test,
                    answeredCounted = answersCounted,
                    closeActivity = { closeActivity() }
                )
            }
        }
    }

    private fun closeActivity() {
        super.finish()
    }
}

@Composable
fun QuestionRadioGroup(
    question: Question,
    passing: MutableState<Boolean>,
    onAnswerSelected: (answerId: Int) -> Unit
) {
    val selectedAnswer = remember { mutableIntStateOf(question.answeredId) }

    Column {
        question.answers.forEach { answer ->

            val color = if (!passing.value && selectedAnswer.intValue == answer.answerId) {
                if (answer.isCorrect) {
                    Color(0x4E0CFF21)
                } else {
                    Color(0x4EFF1313)
                }
            } else {
                Color.Transparent
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = selectedAnswer.intValue == answer.answerId,
                        onClick = {
                            if (passing.value) {
                                selectedAnswer.intValue = answer.answerId
                                onAnswerSelected(answer.answerId)
                            }
                        }
                    )
                    .background(color = color)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (selectedAnswer.intValue == answer.answerId),
                    onClick = null, // null recommended for accessibility with screenreaders
                    modifier = Modifier
                        .padding(end = 16.dp)
                )

                Text(text = answer.answerText)
            }
        }
    }
}

@Composable
fun ShowQuestions(
    questions: List<Question>,
    paddingValues: PaddingValues,
    answeredCount: MutableState<Int>,
    passing: MutableState<Boolean>,
    getAnsweredQuestions: (List<Question>) -> Unit = {}
) {
    val answeredQuestions = remember { mutableStateOf(questions) }
    getAnsweredQuestions(answeredQuestions.value) // initial value

    LazyColumn (
        contentPadding = paddingValues,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        itemsIndexed(questions) { index, question ->
            Text(
                text = "${index + 1}. ${question.questionText}",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 16.dp)
            )

            QuestionRadioGroup(question = question, passing = passing) {
                if(question.answeredId == -1) {
                    answeredCount.value++
                }

                question.answeredId = it

                getAnsweredQuestions(answeredQuestions.value)
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
            )
        }
    }
}

@Composable
fun OnBackPressed(
    closeDialog: (value: Boolean) -> Unit
) {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = stringResource(R.string.end_test)
            )
        },
        title = {
            Text(text = stringResource(R.string.leave_test_question))
        },
        text = {
            Text(text = stringResource(R.string.leave_test_question_description))
        },
        onDismissRequest = { closeDialog(false) },
        confirmButton = {
            TextButton(onClick = { closeDialog(true) }) {
                Text(text = stringResource(R.string.close))
            }
        },
        dismissButton = {
            TextButton(onClick = { closeDialog(false) }) {
                Text(text = stringResource(R.string.cancel))
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassingTestActivity(
    test: Test,
    closeActivity: () -> Unit,
    answeredCounted: Int = -1,
    preview: Boolean = false
) {
    val testViewModel: MainViewModel? = if (preview) {
        null
    } else {
        viewModel(factory = MainViewModel.factory)
    }

    val answeredCount = remember { mutableIntStateOf(0) }
    val answeredQuestions = remember { mutableStateOf(listOf<Question>()) }
    var onBackPressed by remember { mutableStateOf(false) }

    val passing = remember { mutableStateOf(true) }

    if (answeredCounted != -1) {
        answeredCount.intValue = answeredCounted
        passing.value = false
    }

    val testResult = remember {
        mutableStateOf<TestResult?>(null)
    }

    testResult.value?.let {
        answeredCount.intValue = it.result
        passing.value = false
    }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(text = test.testName)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackPressed = true
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    Text(
                        text = stringResource(id = (if (passing.value) R.string.passing else R.string.result)),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = ": ${answeredCount.intValue}/${test.questions.size}"
                    )
                },
                floatingActionButton = {
                    BottomButton(
                        passing = passing,
                        closeActivity = closeActivity
                    ) {
                        if (testViewModel != null) {
                            testResult.value = processTest(
                                test, answeredQuestions.value, testViewModel)
                        }
                    }
                }
            )
        }
    )
    {
        ShowQuestions(
            questions = test.questions,
            paddingValues = it,
            answeredCount = answeredCount,
            passing = passing,
        ) {questions ->
            answeredQuestions.value = questions
        }
    }

    BackHandler(onBack = {
        onBackPressed = true
    })

    if (onBackPressed) {
        if (passing.value) {
            OnBackPressed {
                if (it) {
                    closeActivity()
                } else {
                    onBackPressed = false
                }
            }
        } else {
            closeActivity()
        }
    }
}

@Composable
fun BottomButton(
    passing: MutableState<Boolean>,
    closeActivity: () -> Unit = {},
    processTest: () -> Unit,
) {
    if (passing.value) {
        ExtendedFloatingActionButton(
            onClick = {
                processTest()
            },
            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
            icon = {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = stringResource(R.string.end_test)
                )
            },
            text = {
                Text(text = stringResource(R.string.end_test))
            }
        )
    }
    else {
        ExtendedFloatingActionButton(
            onClick = {
                closeActivity()
            },
            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
            icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.leave_test)
                )
            },
            text = {
                Text(text = stringResource(R.string.leave_test))
            }
        )

    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NewScreenPreview() {
    HCITheme {
        PassingTestActivity(
            test = Test(
                testId = 0,
                testName = "Ім'я тесту",
                testDescription = "Опис тесту ...",
                questions = listOf(
                    Question(
                        questionId = 0,
                        questionText = "Питання 1",
                        answers = listOf(
                            Answer(answerId = 0, answerText = "Відповідь 1", isCorrect = true),
                            Answer(answerId = 1, answerText = "Відповідь 2", isCorrect = false),
                            Answer(answerId = 2, answerText = "Відповідь 3", isCorrect = false),
                            Answer(answerId = 3, answerText = "Відповідь 4", isCorrect = false),
                            Answer(answerId = 4, answerText = "Відповідь 5", isCorrect = false)
                        )
                    ),
                    Question(
                        questionId = 1,
                        questionText = "Питання 2",
                        answers = listOf(
                            Answer(answerId = 0, answerText = "Відповідь 1", isCorrect = false),
                            Answer(answerId = 1, answerText = "Відповідь 2", isCorrect = true),
                            Answer(answerId = 2, answerText = "Відповідь 3", isCorrect = false)
                        )
                    ),
                )
            ),
            closeActivity = {},
            preview = true
        )
    }
}