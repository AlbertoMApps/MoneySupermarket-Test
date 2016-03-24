package com.test.androidtest.api;

import com.test.androidtest.model.FoodModel.Food;
import com.test.androidtest.model.FruitModel.Fruits;

import retrofit.Call;
import retrofit.Callback;
import retrofit2.http.GET;
import rx.Observable;

/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public interface FruitService {

    @GET("fruit")
    Observable<Fruits> getFruits();
    @GET("/v1_1/search/cheddar%20cheese?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat&appId=03a90625&appKey=e633e59393b7f6dc4b03d71e621159d9")
    Observable<Food> getFood();
}
