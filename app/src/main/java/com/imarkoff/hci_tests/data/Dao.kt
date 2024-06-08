package com.imarkoff.hci_tests.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(test: Test)

    @Update
    suspend fun update(test: Test)

    @Delete
    suspend fun delete(test: Test)

    @Query("SELECT * FROM Test")
    fun getAllItems(): Flow<List<Test>>
}

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(question: Question)

    @Update
    suspend fun update(question: Question)

    @Delete
    suspend fun delete(question: Question)

    @Query("SELECT * FROM Question")
    fun getAllItems(): Flow<List<Question>>
}

@Dao
interface AnswerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(answer: Answer)

    @Update
    suspend fun update(answer: Answer)

    @Delete
    suspend fun delete(answer: Answer)

    @Query("SELECT * FROM Answer")
    fun getAllItems(): Flow<List<Answer>>
}

@Dao
interface TestResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(testResult: TestResult)

    @Update
    suspend fun update(testResult: TestResult)

    @Delete
    suspend fun delete(testResult: TestResult)

    @Query("SELECT * FROM TestResult")
    fun getAllItems(): Flow<List<TestResult>>
}