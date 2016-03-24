package com.test.androidtest.model.dbModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alber on 23/03/2016.
 */
public class FoodRealm extends RealmObject {
    @PrimaryKey private int foodKey;
    private String foodName;
    private Double foodCalories;

    public FoodRealm(){}

    public int getFoodKey() {
        return foodKey;
    }

    public String getFoodName() {
        return foodName;
    }

    public Double getFoodCalories() {
        return foodCalories;
    }

    public void setFoodKey(int foodKey) {
        this.foodKey = foodKey;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodCalories(Double foodCalories) {
        this.foodCalories = foodCalories;
    }
}
