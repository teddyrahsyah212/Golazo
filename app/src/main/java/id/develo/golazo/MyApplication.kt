package id.develo.golazo

import android.app.Application
import id.develo.golazo.core.di.databaseModule
import id.develo.golazo.core.di.networkModule
import id.develo.golazo.core.di.repositoryModule
import id.develo.golazo.di.useCaseModule
import id.develo.golazo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}