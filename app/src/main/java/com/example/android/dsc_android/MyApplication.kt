package com.example.android.dsc_android

import android.app.Application
import androidx.work.*
import com.example.android.dsc_android.workers.DataInsertingWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MyApplication : Application() {
    /**
     * Creating a work manager instance is a heavy job. Heavy jobs on the application oncreate
     * can lead to main thread issues. That is why it has to run on a background thread.
     */
    private val applicationScope = CoroutineScope(Dispatchers.Default)
    override fun onCreate() {
        super.onCreate()
        delayedInit()
    }

    private fun delayedInit() {
        applicationScope.launch { setupRecurringWork() }
    }

    private fun setupRecurringWork() {
        val periodicWorkRequest =
            PeriodicWorkRequestBuilder<DataInsertingWorker>(
                15,
                TimeUnit.MINUTES,
            ).build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            DataInsertingWorker.WORKER_NAME, ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest
        )
    }
}