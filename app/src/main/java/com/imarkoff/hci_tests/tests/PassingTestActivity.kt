package com.imarkoff.hci_tests.tests

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
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
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imarkoff.hci_tests.R
import com.imarkoff.hci_tests.data.Question
import com.imarkoff.hci_tests.data.Test
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
        setContent {
            HCITheme {
                PassingTestActivity(test)
            }
        }
    }
}

@Composable
fun QuestionRadioGroup(
    question: Question,
    onAnswerSelected: (answerId: Int) -> Unit
) {
    val selectedAnswer = remember { mutableIntStateOf(question.answeredId) }

    Column {
        question.answers.forEach { answer ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = selectedAnswer.intValue == answer.answerId,
                        onClick = {
                            selectedAnswer.intValue = answer.answerId
                            onAnswerSelected(answer.answerId)
                        }
                    )
                    .background(shape = MaterialTheme.shapes.small, color = Color.Transparent)
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
    answeredCount: MutableState<Int>
) {
    val answeredQuestions = remember { mutableStateOf(listOf<Question>()) }

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

            QuestionRadioGroup(question = question) {
                question.answeredId = it
                if (!answeredQuestions.value.contains(question)) {
                    answeredQuestions.value += question
                    answeredCount.value++
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
            )
        }
    }
}

fun onBackPressed() {
    // show dialog with question and two buttons

    /* TODO */
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassingTestActivity(test: Test) {
    val answeredCount = remember { mutableIntStateOf(0) }

    // Define your composable here
    Scaffold(
        modifier = Modifier
//            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
        ,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = test.testName)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackPressed()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                          Text(
                              text = "${answeredCount.intValue}/${test.questions.size}",
                              modifier = Modifier.padding(start = 16.dp)
                              )
                },
                floatingActionButton = {
                    ExtendedFloatingActionButton(
                        onClick = { /* do something */ },
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
            )
        }
    )
    {
        ShowQuestions(questions = test.questions, paddingValues = it, answeredCount = answeredCount)
    }
}

@Preview(showBackground = true)
@Composable
fun NewScreenPreview() {
    PassingTestScreenActivity()
}