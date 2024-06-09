package com.imarkoff.hci_tests.history

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imarkoff.hci_tests.MainViewModel
import com.imarkoff.hci_tests.R
import com.imarkoff.hci_tests.data.Test
import com.imarkoff.hci_tests.data.TestResult
import com.imarkoff.hci_tests.tests.startTest
import com.imarkoff.hci_tests.ui.theme.HCITheme
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun HistoryElement(
    testResult: TestResult,
    context: Context = LocalContext.current
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.inverseOnSurface,
                MaterialTheme.shapes.medium
            )
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = testResult.answeredTest.testName,
                style = MaterialTheme.typography.titleLarge
            )
            Row {
                Text(
                    text = "${stringResource(R.string.result)}: ",
                    fontWeight = FontWeight(500)
                )
                Text(text = "${testResult.result}/${testResult.total}")
            }
            Row {
                Text(
                    text = "${stringResource(R.string.passed_date)}: ",
                    fontWeight = FontWeight(500)
                )
                Text(text =
                SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.US)
                    .format(testResult.resultDate)
                )
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        startTest(context, testResult.answeredTest, answersCounted = testResult.result)
                    },
                    Modifier.padding(top = 16.dp)
                ) {
                    Text(text = stringResource(R.string.show_results))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryActivity(
    tests: List<TestResult> = emptyList()
) {
    val testViewModel: MainViewModel? = if (tests.isEmpty()) {
        viewModel(factory = MainViewModel.factory) }
    else {
        null
    }

    val testResults: List<TestResult> = tests.ifEmpty {
        testViewModel!!.testResults.collectAsState(initial = emptyList()).value.reversed()
    }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(stringResource(R.string.history))
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        val topPadding = PaddingValues(top = innerPadding.calculateTopPadding())

        LazyColumn(
            modifier = Modifier
                .padding(topPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            testResults.forEach { testResult ->
                item {
                    HistoryElement(testResult)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HistoryActivityPreview() {
    HCITheme {
        HistoryActivity(tests = listOf(
            TestResult(
                resultDate = java.util.Date(),
                answeredTest = Test(
                    testId = 0,
                    testName = "Test title",
                    questions = emptyList()
                )
            )
        ))
    }
}