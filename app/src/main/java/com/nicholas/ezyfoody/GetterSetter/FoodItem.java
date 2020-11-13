package com.nicholas.ezyfoody.GetterSetter;

import java.io.Serializable;

public class FoodItem implements Serializable {
    private String foodName;
    private int foodImage;
    private String foodPrice;

    public FoodItem(String foodName, String foodPrice, int foodImage) {
        this.foodName = foodName;
        this.foodImage = foodImage;
        this.foodPrice = foodPrice;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }
}
