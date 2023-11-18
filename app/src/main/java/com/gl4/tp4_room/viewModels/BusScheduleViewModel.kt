package com.gl4.tp4_room.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gl4.tp4_room.database.dao.ScheduleDAO
import com.gl4.tp4_room.database.entities.Schedule

class BusScheduleViewModel(private val scheduleDao:ScheduleDAO) : ViewModel() {
    fun fullSchedule(): LiveData<List<Schedule>> = scheduleDao.getAll()


    fun scheduleForStopName(name: String): LiveData<List<Schedule>> = scheduleDao.getByStopName(name)

}