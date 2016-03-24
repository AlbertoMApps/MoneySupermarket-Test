package com.test.androidtest.di.Modules;

import com.test.androidtest.api.FruitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by alber on 23/03/2016.
 */
@Module
public class ApiModule {
    @Singleton
    @Provides
    FruitService provideFruitService(Retrofit retrofit) {
          return retrofit.create(FruitService.class);
       }
}
