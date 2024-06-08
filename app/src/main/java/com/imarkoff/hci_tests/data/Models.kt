package com.imarkoff.hci_tests.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

@Entity
@TypeConverters(QuestionConverter::class)
data class Test (
    @PrimaryKey(autoGenerate = true)
    val testId: Int = 0,
    var testName: String,
    var testDescription: String = "",
    var questions: List<Question>,
)

@Entity
@TypeConverters(AnswerConverter::class)
data class Question (
    @PrimaryKey(autoGenerate = true)
    val questionId: Int = 0,
    var questionText: String,
    var answers: List<Answer>,
)

@Entity
data class Answer (
    @PrimaryKey(autoGenerate = true)
    val answerId: Int = 0,
    var answerText: String,
    var isCorrect: Boolean,
)

@Entity
@TypeConverters(DateConverter::class)
data class TestResult (
    @PrimaryKey
    val resultId: Int,
    var testId: Int,
    var resultDate: Date,
    var resultScore: Int,
)

class QuestionConverter {
    @TypeConverter
    fun fromQuestionList(value: List<Question>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Question>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toQuestionList(value: String): List<Question> {
        val gson = Gson()
        val type = object : TypeToken<List<Question>>() {}.type
        return gson.fromJson(value, type)
    }
}

class AnswerConverter {
    @TypeConverter
    fun fromAnswerList(value: List<Answer>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Answer>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toAnswerList(value: String): List<Answer> {
        val gson = Gson()
        val type = object : TypeToken<List<Answer>>() {}.type
        return gson.fromJson(value, type)
    }
}

class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}