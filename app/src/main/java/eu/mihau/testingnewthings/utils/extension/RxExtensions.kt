package eu.mihau.testingnewthings.utils.extension

import eu.mihau.testingnewthings.utils.provider.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.Single

fun <T> Single<T>.schedule(schedulerProvider: SchedulerProvider): Single<T> = this.subscribeOn(schedulerProvider.io())
    .observeOn(schedulerProvider.ui())

fun <T> Observable<T>.schedule(schedulerProvider: SchedulerProvider): Observable<T> = this.subscribeOn(schedulerProvider.io())
    .observeOn(schedulerProvider.ui())