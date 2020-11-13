package com.nicholas.ezyfoody.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nicholas.ezyfoody.MainActivity.MyOrderActivity;
import com.nicholas.ezyfoody.GetterSetter.OrderListActivity;
import com.nicholas.ezyfoody.R;

import java.util.ArrayList;

//Nicholas Surya 2201816051

public class OrderListActivityAdapter extends RecyclerView.Adapter<OrderListActivityAdapter.OrderViewHolder>{

    private ArrayList<OrderListActivity> cartList;
    private Context context;

    public OrderListActivityAdapter(ArrayList<OrderListActivity> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_order_list, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int position) {
        final OrderListActivity foodCart = cartList.get(position);
        holder.foodImage.setImageResource(foodCart.getFoodPhoto());
        holder.olFoodName.setText(foodCart.getFoodName());
        holder.olFoodPrice.setText(foodCart.getFoodName() + " Price:\n Rp. " + Integer.valueOf(foodCart.getFoodPrice()) * foodCart.getQty());
        holder.olQuantity.setText(foodCart.getFoodName() +" Quantity: " + foodCart.getQty());
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOrderActivity.cartList.remove(position);
                notifyItemRemoved(position);
                notifyItemChanged(position, getItemCount());
                MyOrderActivity.olTotalPrice.setText("Rp. " + MyOrderActivity.getolTotalPrice());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {

        private ImageView foodImage;
        private TextView olFoodName, olFoodPrice, olQuantity;
        private Button deleteButton;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.foodImgButton);
            olFoodName = itemView.findViewById(R.id.foodTxtName);
            olFoodPrice = itemView.findViewById(R.id.foodTxtPrice);
            olQuantity = itemView.findViewById(R.id.foodTxtQuantity);
            deleteButton = itemView.findViewById(R.id.delButton);
        }
    }
}
