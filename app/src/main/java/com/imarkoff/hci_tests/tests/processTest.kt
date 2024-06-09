package com.imarkoff.hci_tests.tests

import com.imarkoff.hci_tests.data.Question
import com.imarkoff.hci_tests.data.Test
import com.imarkoff.hci_tests.data.TestResult
import java.util.Date

fun processTest(test: Test, questions: List<Question>): TestResult {
    // Process test

    val testResult = TestResult(
        testId = test.testId,
        resultDate = Date(),
        answeredQuestions = questions
    )

    // calculate result
    val result = test.questions.count { question ->
        if (question.answeredId == -1) {
            return@count false
        }
        question.answers[question.answeredId].isCorrect
    }

    // save result
    testResult.result = result

    // save result to database
    // testViewModel.saveResult(testResult)

    return testResult
}