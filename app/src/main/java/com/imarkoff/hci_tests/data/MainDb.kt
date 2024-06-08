package com.imarkoff.hci_tests.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Test::class,
        Question::class,
        Answer::class,
        TestResult::class
               ],
    version = 1
)
abstract class MainDb : RoomDatabase() {
    abstract val testDao: TestDao
    abstract val questionDao: QuestionDao
    abstract val answerDao: AnswerDao
    abstract val testResultDao: TestResultDao

    companion object {
        fun create(context: Context) : MainDb {
            return Room.databaseBuilder(
                context,
                MainDb::class.java,
                "tests.db"
            ).build()
        }
    }
}