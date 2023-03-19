package com.example.a7minutesworkout.viewModal

import android.app.Application
import com.example.a7minutesworkout.viewModal.HistoryDatabase

class WorkOutApp: Application() {

    val db by lazy { HistoryDatabase.getInstance(this) }
}