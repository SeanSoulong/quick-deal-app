package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.VerifiedItem;

import java.util.List;

public class VerifiedAdapter extends RecyclerView.Adapter<VerifiedAdapter.VerifiedViewHolder> {

    private Context context;
    private List<VerifiedItem> itemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(VerifiedItem item);
    }

    public VerifiedAdapter(Context context, List<VerifiedItem> itemList, OnItemClickListener listener) {
        this.context = context;
        this.itemList = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VerifiedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_verified, parent, false);
        return new VerifiedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerifiedViewHolder holder, int position) {
        VerifiedItem item = itemList.get(position);
        holder.imageView.setImageResource(item.getImageResId());
        holder.nameText.setText(item.getName());
        holder.discountText.setText(item.getDiscount());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class VerifiedViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameText, discountText;

        public VerifiedViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.product_image);
            nameText = itemView.findViewById(R.id.product_name);
            discountText = itemView.findViewById(R.id.product_discount);
        }
    }
}
