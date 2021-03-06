package com.omegasoft.humanity.humanity;

import android.app.Application;

import com.omegasoft.humanity.BuildConfig;

import fslogger.lizsoft.lv.fslogger.FSLogger;

/**
 * Created by farhad on 16.12.2.
 */
public class HumanityAPP extends Application {

    public static final int zoom = 4;
    public static final int delayForEachFrame = 50;

    @Override
    public void onCreate() {
        super.onCreate();

        //initialize FSLogger
        FSLogger.init("Humanity");
        FSLogger.setType(FSLogger.FSLoggerLimitationType.ALLOR);
        FSLogger.enableLoggingWithBackTrace();
        FSLogger.addCode(1);
        if (!BuildConfig.DEBUG) FSLogger.disable();
    }
}
