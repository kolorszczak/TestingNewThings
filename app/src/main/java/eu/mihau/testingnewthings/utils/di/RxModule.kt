package eu.mihau.testingnewthings.utils.di

import eu.mihau.testingnewthings.utils.provider.AppSchedulerProvider
import eu.mihau.testingnewthings.utils.provider.SchedulerProvider
import io.reactivex.schedulers.Schedulers.single
import org.koin.dsl.module

val rxModule = module {
    single<SchedulerProvider> { AppSchedulerProvider() }
}