package com.nicholas.ezyfoody.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nicholas.ezyfoody.Adapter.OrderListActivityAdapter;
import com.nicholas.ezyfoody.GetterSetter.OrderListActivity;
import com.nicholas.ezyfoody.R;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {
    public static ArrayList<OrderListActivity> cartList;
    private RecyclerView myOrderRv;
    private OrderListActivityAdapter olAdapter;
    private TextView noData;
    public static TextView olTotalPrice;
    public static boolean transactFlag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_rv);
        noData = findViewById(R.id.noData);
        olTotalPrice = findViewById(R.id.totalPrice);
        if (cartList == null || cartList.size() == 0) {
            cartList = new ArrayList<>();
            noData.setVisibility(View.VISIBLE);
        }
        myOrderRv = findViewById(R.id.amRecycleView);
        olAdapter = new OrderListActivityAdapter(cartList, this);
        myOrderRv.setLayoutManager(new LinearLayoutManager(this));
        myOrderRv.setAdapter(olAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        olTotalPrice.setText("RP. " + getolTotalPrice());
        if(transactFlag){
            olAdapter.notifyDataSetChanged();
            MyOrderActivity.transactFlag = false;
        }
    }

    public static void addItem(OrderListActivity cart) {
        if (cartList == null) cartList = new ArrayList<>();
        cartList.add(cart);
    }

    public static String getolTotalPrice (){
        Long totalPrice = 0L;
        for (OrderListActivity olactivity: cartList) {
            totalPrice += (Integer.parseInt(olactivity.getFoodPrice()) * olactivity.getQty());
        }
        return totalPrice.toString();
    }

    public void checkOut(View view) {
        Intent intent = new Intent(this, CheckoutActivity.class);
        transactFlag = true;
        startActivity(intent);
    }
}
