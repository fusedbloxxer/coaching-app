package com.faculty.fusedbloxxer.coachingapp;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

import timber.log.Timber;

public class App extends Application {

    public static final String APP_KEY = "android_coaching_key";

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        AndroidThreeTen.init(this);

        Timber.d("App has been initialized...");
    }
}
