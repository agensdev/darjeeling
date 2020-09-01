package no.agens.darjeeling

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class DarjeelingApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DarjeelingApplication.applicationContext)
            modules(module {
                factory { MainActivity.MyDependency() }
            })
        }
    }
}