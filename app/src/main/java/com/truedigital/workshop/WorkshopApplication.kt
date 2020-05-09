package com.truedigital.workshop

import android.app.Application
import android.content.Context
import com.truedigital.workshop.di.dependenciesModuleList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WorkshopApplication : Application() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        setupKoin()
    }


    private fun setupKoin() {
        startKoin {
            androidContext(this@WorkshopApplication)
            modules(dependenciesModuleList)

            apply {
                if (BuildConfig.DEBUG) {
                    this.printLogger()
                }
            }
        }
    }
}