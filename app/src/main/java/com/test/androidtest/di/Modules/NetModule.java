package com.test.androidtest.di.Modules;

import android.app.Application;
import android.util.Log;

import com.test.androidtest.api.FruitService;
import com.test.androidtest.utilities.Constant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alber on 23/03/2016.
 */
@Module
public class NetModule {

    private Application application;


    public NetModule(Application pApplication) {
        application = pApplication;
      }

   @Singleton
   @Provides
    Realm provideRealm() {
         return Realm.getInstance(application);
   }


    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL_TEST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        return retrofit;
    }
}
