package com.imarkoff.hci_tests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.imarkoff.hci_tests.data.Answer
import com.imarkoff.hci_tests.data.MainDb
import com.imarkoff.hci_tests.data.Question
import com.imarkoff.hci_tests.data.Test
import com.imarkoff.hci_tests.data.TestResult
import kotlinx.coroutines.launch

class MainViewModel(private val database: MainDb): ViewModel() {
    val tests get() = database.testDao.getAllItems()
    val testResults get() = database.testResultDao.getAllItems()

    fun insertTest(test: Test) = viewModelScope.launch {
        database.testDao.insert(test)
    }
    fun deleteTest(test: Test) = viewModelScope.launch {
        database.testDao.delete(test)
    }

    fun saveResult(testResult: TestResult) = viewModelScope.launch {
        database.testResultDao.insert(testResult)
    }

    companion object {
        val factory: ViewModelProvider.Factory = object: ViewModelProvider.Factory {
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras): T {
                val db = (checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App).db
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(db) as T
            }
        }
    }
}

class QuestionViewModel(private val database: MainDb): ViewModel() {
    val questions = database.questionDao.getAllItems()

    fun insert(question: Question) = viewModelScope.launch {
        database.questionDao.insert(question)
    }
    fun delete(question: Question) = viewModelScope.launch {
        database.questionDao.delete(question)
    }
}

class AnswerViewModel(private val database: MainDb): ViewModel() {
    val answers = database.answerDao.getAllItems()

    fun insert(answer: Answer) = viewModelScope.launch {
        database.answerDao.insert(answer)
    }
    fun delete(answer: Answer) = viewModelScope.launch {
        database.answerDao.delete(answer)
    }
}

class TestResultViewModel(private val database: MainDb): ViewModel() {
    val testResults = database.testResultDao.getAllItems()

    fun insert(testResult: TestResult) = viewModelScope.launch {
        database.testResultDao.insert(testResult)
    }
    fun delete(testResult: TestResult) = viewModelScope.launch {
        database.testResultDao.delete(testResult)
    }
}