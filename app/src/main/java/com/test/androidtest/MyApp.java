package com.test.androidtest;

import android.app.Application;

import com.test.androidtest.di.Components.DaggerNetComponent;
import com.test.androidtest.di.Components.NetComponent;
import com.test.androidtest.di.Modules.ApiModule;
import com.test.androidtest.di.Modules.NetModule;

/**
 * Created by alber on 23/03/2016.
 */
public class MyApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent
                .builder()
                .netModule(new NetModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
