package com.test.androidtest.di.Components;

import com.test.androidtest.api.FruitService;
import com.test.androidtest.di.Modules.ApiModule;
import com.test.androidtest.di.Modules.NetModule;
import com.test.androidtest.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by alber on 23/03/2016.
 */


    @Singleton
    @Component(modules={NetModule.class, ApiModule.class})
    public interface NetComponent {

        FruitService provideFruitService();
        Realm provideRealm();
        void inject (MainActivity main);

    }

