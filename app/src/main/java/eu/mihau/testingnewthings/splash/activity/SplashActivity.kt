package eu.mihau.testingnewthings.splash.activity

import android.os.Bundle
import eu.mihau.testingnewthings.common.Values
import eu.mihau.testingnewthings.common.base.BaseActivity
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startApp()
    }

    private fun startApp() = Single.timer(Values.SPLASH_TIME_IN_MILLIS, TimeUnit.MILLISECONDS)
        .map { openDashboard() }
        .subscribe()

    private fun openDashboard() { TODO("open dashboard") }
}