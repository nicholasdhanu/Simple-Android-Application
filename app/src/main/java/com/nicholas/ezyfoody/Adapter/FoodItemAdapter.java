package com.nicholas.ezyfoody.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.nicholas.ezyfoody.GetterSetter.FoodItem;
import com.nicholas.ezyfoody.MainActivity.OrderActivity;
import com.nicholas.ezyfoody.R;

import java.util.ArrayList;

//Nicholas Surya 2201816051

public class FoodItemAdapter extends RecyclerView.Adapter <FoodItemAdapter.ItemViewHolder> {

    private ArrayList <FoodItem> foodItemList;
    private Context context;

    public FoodItemAdapter(ArrayList<FoodItem> foodItemList, Context context) {
        this.foodItemList = foodItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_menu, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final FoodItem fitem = foodItemList.get(position);
        holder.imageButton.setImageResource(fitem.getFoodImage());
        holder.foodTextView.setText(fitem.getFoodName());
        holder.priceView.setText("Rp. " + fitem.getFoodPrice());
        holder.rlitemMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("food", fitem);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageButton imageButton;
        private TextView foodTextView, priceView;
        private CardView rlitemMenu;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.foodImgButton);
            foodTextView = itemView.findViewById(R.id.foodTxtName);
            priceView = itemView.findViewById(R.id.foodTxtPrice);
            rlitemMenu = itemView.findViewById(R.id.ilMenu);
        }
    }
}
