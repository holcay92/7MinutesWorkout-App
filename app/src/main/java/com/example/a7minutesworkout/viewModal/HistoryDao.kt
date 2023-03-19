package com.example.a7minutesworkout.viewModal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.a7minutesworkout.modal.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert
    suspend fun insert(historyEntity: HistoryEntity)

    @Query("SELECT *FROM 'history_table'")
    fun fetchAllDates(): Flow<List<HistoryEntity>>
    // we don't use suspend here because we are using flow. it takes care of the background thread
}