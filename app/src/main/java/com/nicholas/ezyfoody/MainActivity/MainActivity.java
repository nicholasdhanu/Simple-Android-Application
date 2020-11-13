package com.nicholas.ezyfoody.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nicholas.ezyfoody.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyOrderActivity.transactFlag = false;
    }

    public void onMyOrderBtnClick(View view) {

    }

    public void goToDrinks(View view) {
        Intent drinksIntent = new Intent(this, MenuActivity.class);
        drinksIntent.putExtra("orderType", "drinks");
        startActivity(drinksIntent);
    }

    public void goToFoods(View view) {

        Intent foodsIntent = new Intent(this, MenuActivity.class);
        foodsIntent.putExtra("orderType", "foods");
        startActivity(foodsIntent);
    }

    public void goToSnacks(View view) {
        Intent snacksIntent = new Intent(this, MenuActivity.class);
        snacksIntent.putExtra("orderType", "snacks");
        startActivity(snacksIntent);
    }

    public void goTopUp(View view) {
    }

    public void goToMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}