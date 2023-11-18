package com.gl4.tp4_room

import android.app.Application
import com.gl4.tp4_room.database.database.AppDatabase

class BusScheduleApplication: Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}