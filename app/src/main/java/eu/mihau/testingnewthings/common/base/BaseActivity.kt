package eu.mihau.testingnewthings.common.base

import androidx.appcompat.app.AppCompatActivity
import eu.mihau.testingnewthings.utils.provider.SchedulerProvider
import org.koin.android.ext.android.inject

abstract class BaseActivity : AppCompatActivity() {

    val schedulerProvider: SchedulerProvider by inject()
}