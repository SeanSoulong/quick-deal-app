package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.ClaimItem2;

import java.util.List;

public class ClaimAdapter2 extends RecyclerView.Adapter<ClaimAdapter2.ClaimViewHolder> {

    private List<ClaimItem2> claimList;

    public ClaimAdapter2(List<ClaimItem2> claimList) {
        this.claimList = claimList;
    }

    @NonNull
    @Override
    public ClaimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_claim, parent, false);
        return new ClaimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClaimViewHolder holder, int position) {
        ClaimItem2 item = claimList.get(position);
        holder.imageView.setImageResource(item.getImageResId());
        holder.textViewTitle.setText(item.getTitle());
        holder.textViewDiscount.setText(item.getDiscount());
    }

    @Override
    public int getItemCount() {
        return claimList.size();
    }

    static class ClaimViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle, textViewDiscount;

        public ClaimViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDiscount = itemView.findViewById(R.id.textViewDiscount);
        }
    }
}
