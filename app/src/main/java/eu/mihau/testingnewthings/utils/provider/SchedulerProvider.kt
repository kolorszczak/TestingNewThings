package eu.mihau.testingnewthings.utils.provider

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun io(): Scheduler
    fun ui(): Scheduler
    fun computation(): Scheduler
}