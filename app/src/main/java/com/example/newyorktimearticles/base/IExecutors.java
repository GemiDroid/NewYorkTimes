package com.example.newyorktimearticles.base;

import io.reactivex.Scheduler;

public interface IExecutors {
    Scheduler getIOThread();

    Scheduler getMainThread();
}
