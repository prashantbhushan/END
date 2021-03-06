package com.prashant.end.util.schedulers

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

/**
 * Qualifier to define Scheduler type (io, computation, or ui main thread).
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class RunOn(val value: SchedulerType = SchedulerType.IO)