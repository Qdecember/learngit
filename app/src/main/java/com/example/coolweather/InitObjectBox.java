package com.example.coolweather;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import com.example.coolweather.bean.MyObjectBox;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

public class InitObjectBox extends Application {

    private static BoxStore boxStore;
    private static String TAG = "InitObjectBox";

    @Override
    public void onCreate() {
        super.onCreate();
        boxStore = MyObjectBox.builder()
                .androidContext(getApplicationContext())
                .build();
        Log.d(TAG, "onCreate: ");
        if (BuildConfig.DEBUG) {
            new AndroidObjectBrowser(boxStore).start(this);
        }

    }

    public static BoxStore getBoxStore() {
        return boxStore;
    }
}
