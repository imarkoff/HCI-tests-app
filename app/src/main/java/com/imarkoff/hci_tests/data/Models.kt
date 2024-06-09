package com.imarkoff.hci_tests.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

@Parcelize
@Entity
@TypeConverters(QuestionConverter::class)
data class Test (
    @PrimaryKey(autoGenerate = false)
    val testId: Int,
    var testName: String,
    var testDescription: String = "",
    val questions: List<Question> // Make sure Question is Parcelable or Serializable
) : Parcelable


@Parcelize
@Entity
@TypeConverters(AnswerConverter::class)
data class Question (
    @PrimaryKey(autoGenerate = true)
    val questionId: Int = 0,
    var questionText: String,
    var answers: List<Answer>,
    var answeredId: Int = -1,
) : Parcelable

@Parcelize
@Entity
data class Answer (
    @PrimaryKey(autoGenerate = true)
    val answerId: Int = 0,
    var answerText: String,
    var isCorrect: Boolean,
) : Parcelable

@Entity
@TypeConverters(DateConverter::class, QuestionConverter::class)
data class TestResult (
    @PrimaryKey(autoGenerate = true)
    val resultId: Int = 0,
    var testId: Int,
    var resultDate: Date,
    var answeredQuestions: List<Question>,
    var result: Int = 0
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