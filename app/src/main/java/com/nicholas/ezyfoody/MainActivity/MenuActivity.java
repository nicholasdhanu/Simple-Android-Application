package com.nicholas.ezyfoody.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nicholas.ezyfoody.Adapter.FoodItemAdapter;
import com.nicholas.ezyfoody.GetterSetter.FoodItem;
import com.nicholas.ezyfoody.R;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private FoodItemAdapter foodItemAdapter;
    private RecyclerView foodRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rv);
        foodRecyclerView = findViewById(R.id.amRecycleView);
        Intent intent = getIntent();
        ArrayList <FoodItem> foodData = new ArrayList<>();
        String orderType = intent.getStringExtra("orderType");

        setTitle("Item Menu Page");
        if (orderType.equals("foods")){
            foodData = getFoodItems();
        }
        else if (orderType.equals("snacks")){
            foodData = getSnackItems();
        }
        else if (orderType.equals("drinks")){
            foodData = getDrinksItems();
        }
        foodItemAdapter = new FoodItemAdapter(foodData,this);
        foodRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        foodRecyclerView.setAdapter(foodItemAdapter);
    }

    public ArrayList <FoodItem> getFoodItems () {
        ArrayList <FoodItem> foodData = new ArrayList<>();
        foodData.add(new FoodItem("White Rice", "25000", R.drawable.ic_rice_svgrepo_com));
        foodData.add(new FoodItem("Noodle", "45000", R.drawable.ic_chinese_food_svgrepo_com));
        foodData.add(new FoodItem("Pasta", "54000", R.drawable.ic_spaghetti_pasta_svgrepo_com));
        foodData.add(new FoodItem("Hamburger", "60000", R.drawable.ic_hamburger_svgrepo_com));
        return foodData;
    }
    public ArrayList <FoodItem> getDrinksItems () {
        ArrayList <FoodItem> drinkData = new ArrayList<>();
        drinkData.add(new FoodItem("Juice", "25000", R.drawable.ic_juice_svgrepo_com));
        drinkData.add(new FoodItem("Soda", "45000", R.drawable.ic_soda_svgrepo_com));
        drinkData.add(new FoodItem("Wine", "340000", R.drawable.ic_wine_svgrepo_com));
        drinkData.add(new FoodItem("Coffee", "36000", R.drawable.ic_coffee_svgrepo_com));
        return drinkData;
    }

    public ArrayList <FoodItem> getSnackItems () {
        ArrayList <FoodItem> snackData = new ArrayList<>();
        snackData.add(new FoodItem("Popcorn", "25000", R.drawable.ic_snacks_popcorn_svgrepo_com));
        snackData.add(new FoodItem("Salads", "45000", R.drawable.ic_salad_svgrepo_com));
        snackData.add(new FoodItem("French Fries", "340000", R.drawable.ic_french_fries_svgrepo_com));
        snackData.add(new FoodItem("Nachos", "36000", R.drawable.ic_nachos_snack_svgrepo_com));
        return snackData;
    }

    public void goToMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}