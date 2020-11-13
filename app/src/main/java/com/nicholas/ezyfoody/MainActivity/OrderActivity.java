package com.nicholas.ezyfoody.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nicholas.ezyfoody.GetterSetter.FoodItem;
import com.nicholas.ezyfoody.GetterSetter.OrderListActivity;
import com.nicholas.ezyfoody.R;

public class OrderActivity extends AppCompatActivity {

    private ImageButton foodImage;
    private TextView foodName, foodPrice;
    private EditText quantity;
    private FoodItem fitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        fitem = (FoodItem) intent.getSerializableExtra("food");

        foodImage = findViewById(R.id.aoFoodImage);
        foodName = findViewById(R.id.aoFoodTxtName);
        foodPrice = findViewById(R.id.aoFoodTxtPrice);
        quantity = findViewById(R.id.aoQuantity);

        foodImage.setImageResource(fitem.getFoodImage());
        foodName.setText(fitem.getFoodName());
        foodPrice.setText("Rp. " + fitem.getFoodPrice());
    }

    public void order (View view) {
        String qty = quantity.getText().toString();
        OrderListActivity cart = new OrderListActivity(fitem.getFoodName(), String.valueOf(fitem.getFoodPrice()), Integer.valueOf(qty), fitem.getFoodImage());
        MyOrderActivity.addItem(cart);
        Toast.makeText(this, "Order Inputted", Toast.LENGTH_SHORT).show();
    }

    public void addMore (View view) {
        finish();
    }

    public void goToMyOrder (View view){
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}