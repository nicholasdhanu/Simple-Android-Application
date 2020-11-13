package com.nicholas.ezyfoody.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nicholas.ezyfoody.Adapter.CheckoutAdapter;
import com.nicholas.ezyfoody.GetterSetter.OrderListActivity;
import com.nicholas.ezyfoody.R;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    private RecyclerView caRecyclerView;
    private CheckoutAdapter cAdapter;
    private TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_rv);
        caRecyclerView = findViewById(R.id.acRecyclerView);

        ArrayList<OrderListActivity> olList = new ArrayList<>();
        olList.addAll(MyOrderActivity.cartList);

        totalPrice = findViewById(R.id.acTotalPrice);
        totalPrice.setText("Rp. " + MyOrderActivity.getolTotalPrice());

        cAdapter = new CheckoutAdapter(olList, this);
        caRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        caRecyclerView.setAdapter(cAdapter);
        MyOrderActivity.cartList.clear();
    }

    public String getolTotalPrice (ArrayList<OrderListActivity> totPrice){
        Long totalPrice = 0L;
        for (OrderListActivity olactivity: totPrice) {
            totalPrice += (Integer.parseInt(olactivity.getFoodPrice()) * olactivity.getQty());
        }
        return totalPrice.toString();
    }

    public void goToMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}