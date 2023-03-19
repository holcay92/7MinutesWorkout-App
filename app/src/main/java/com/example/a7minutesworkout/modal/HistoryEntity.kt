package com.example.a7minutesworkout.modal

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class HistoryEntity(
    @PrimaryKey
    val date:String

)
