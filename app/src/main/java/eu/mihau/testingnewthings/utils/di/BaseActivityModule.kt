package eu.mihau.testingnewthings.utils.di

import android.content.Context
import eu.mihau.testingnewthings.common.Keys
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val baseActivityModule = module {
    single { androidApplication().getSharedPreferences(Keys.SHARED_PREFS, Context.MODE_PRIVATE) }
}