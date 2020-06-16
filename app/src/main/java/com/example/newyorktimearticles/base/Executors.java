package com.example.newyorktimearticles.base;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Executors implements IExecutors {
    @Override
    public Scheduler getIOThread() {
        return Schedulers.io();
    }

    @Override
    public Scheduler getMainThread() {
        return AndroidSchedulers.mainThread();
    }
}
