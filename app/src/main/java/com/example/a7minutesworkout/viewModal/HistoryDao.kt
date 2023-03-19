package com.example.a7minutesworkout.viewModal

import androidx.room.Dao
import androidx.room.Insert
import com.example.a7minutesworkout.modal.HistoryEntity
@Dao
interface HistoryDao {
    @Insert
    suspend fun insert(historyEntity: HistoryEntity)
}