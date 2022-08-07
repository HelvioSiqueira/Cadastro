package com.example.cadastro

import android.app.Application
import com.example.cadastro.di.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class CadastroApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CadastroApp)
            modules(listOf(androidModule))
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}