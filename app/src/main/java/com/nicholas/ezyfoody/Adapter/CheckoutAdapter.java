package com.nicholas.ezyfoody.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nicholas.ezyfoody.GetterSetter.OrderListActivity;
import com.nicholas.ezyfoody.R;

import java.util.ArrayList;

//Nicholas Surya 2201816051

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.OrderViewHolder>{

    private ArrayList<OrderListActivity> cartList;
    private Context context;

    public CheckoutAdapter(ArrayList<OrderListActivity> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_checkout, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int position) {
        final OrderListActivity foodCart = cartList.get(position);
        holder.acfoodImage.setImageResource(foodCart.getFoodPhoto());
        holder.acFoodName.setText(foodCart.getFoodName());
        holder.acFoodPrice.setText(foodCart.getFoodName() + " Price:\n Rp. " + Integer.valueOf(foodCart.getFoodPrice()) * foodCart.getQty());
        holder.acQuantity.setText(foodCart.getFoodName() +" Quantity: " + foodCart.getQty());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {

        private ImageView acfoodImage;
        private TextView acFoodName, acFoodPrice, acQuantity;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            acfoodImage = itemView.findViewById(R.id.acImgView);
            acFoodName = itemView.findViewById(R.id.acFoodName);
            acFoodPrice = itemView.findViewById(R.id.acFoodPrice);
            acQuantity = itemView.findViewById(R.id.acFoodQty);
        }
    }
}
