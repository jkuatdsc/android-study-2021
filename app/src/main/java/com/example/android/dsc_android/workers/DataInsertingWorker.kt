package com.example.android.dsc_android.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.android.dsc_android.data.StudentData
import com.example.android.dsc_android.data.StudentDatabase
import java.util.*

class DataInsertingWorker(appContext: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(appContext, workerParameters) {
    companion object{
        const val WORKER_NAME = "DataInsertingWorker"
    }
    override suspend fun doWork(): Result {
        val database = StudentDatabase.initializeDatabase(applicationContext)
        val dao = database.dao()


        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val text = "The hourly worker saved this at $hour:$minute"
        val dataClass = StudentData(name = text, course = "Worker")

        dao.insert(dataClass)
        return Result.success()
    }

}