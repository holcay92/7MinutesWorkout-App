package com.example.a7minutesworkout.viewModal


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.a7minutesworkout.modal.HistoryEntity
import kotlinx.coroutines.flow.Flow

//create a dao interface with insert method
@Dao
interface HistoryDao {

    @Insert
    suspend fun insert(historyEntity: HistoryEntity)

    @Query("Select * from `history-table`")
    fun fetchALlDates():Flow<List<HistoryEntity>>
}