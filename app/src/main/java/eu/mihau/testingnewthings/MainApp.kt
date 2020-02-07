package eu.mihau.testingnewthings

import android.app.Application
import eu.mihau.testingnewthings.utils.di.applicationUtilsModule
import eu.mihau.testingnewthings.utils.di.baseActivityModule
import eu.mihau.testingnewthings.utils.di.restModule
import eu.mihau.testingnewthings.utils.di.rxModule
import eu.mihau.testingnewthings.utils.lifecycle.ActivityLifecycleManager
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeLogger()
        initializeDI()
        registerActivityLifecycleCallbacks(get<ActivityLifecycleManager>())
    }

    private fun initializeLogger() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initializeDI() {
        startKoin {
            androidContext(this@MainApp)
            modules(modules)
        }
    }

    companion object {
        val modules = listOf(
            baseActivityModule,
            restModule,
            rxModule,
            applicationUtilsModule
        )
    }
}