package com.imarkoff.hci_tests.tests

import com.imarkoff.hci_tests.MainViewModel
import com.imarkoff.hci_tests.data.Question
import com.imarkoff.hci_tests.data.Test
import com.imarkoff.hci_tests.data.TestResult
import java.util.Date

fun processTest(test: Test, questions: List<Question>, testViewModel: MainViewModel): TestResult {
    // Process test

    val answeredTest = test.copy(questions = questions)

    val testResult = TestResult(
        resultDate = Date(),
        answeredTest = answeredTest,
    )

    // save result to database
    testViewModel.saveResult(testResult)

    return testResult
}