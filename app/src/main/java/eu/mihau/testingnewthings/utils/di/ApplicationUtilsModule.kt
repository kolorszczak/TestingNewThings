package eu.mihau.testingnewthings.utils.di

import eu.mihau.testingnewthings.utils.lifecycle.ActivityLifecycleManager
import eu.mihau.testingnewthings.utils.lifecycle.ActivityLifecycleObservable
import eu.mihau.testingnewthings.utils.lifecycle.AppVisibilityResolver
import org.koin.dsl.bind
import org.koin.dsl.module

val applicationUtilsModule = module {
    single { ActivityLifecycleManager(get()) }
    single { AppVisibilityResolver() } bind ActivityLifecycleObservable::class
}