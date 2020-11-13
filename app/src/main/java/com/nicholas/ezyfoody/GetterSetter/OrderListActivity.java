package com.nicholas.ezyfoody.GetterSetter;

public class OrderListActivity {
    private String foodName;
    private String foodPrice;
    private Integer qty;
    private Integer foodPhoto;

    public OrderListActivity(String foodName, String foodPrice, Integer qty, Integer foodPhoto) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.qty = qty;
        this.foodPhoto = foodPhoto;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getFoodPhoto() {
        return foodPhoto;
    }

    public void setFoodPhoto(Integer foodPhoto) {
        this.foodPhoto = foodPhoto;
    }
}
