package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Product;
import com.example.myapplication.model.FavoriteViewModel;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> productList;
    private final FavoriteViewModel viewModel;

    public ProductAdapter(List<Product> productList, FavoriteViewModel viewModel) {
        this.productList = productList;
        this.viewModel = viewModel;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProduct, imageViewHeart;
        TextView textViewTitle, textViewOffer;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
            imageViewHeart = itemView.findViewById(R.id.imageViewHeart);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewOffer = itemView.findViewById(R.id.textViewOffer);
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.imageViewProduct.setImageResource(product.getImageResId());
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewOffer.setText(product.getOffer());

        updateHeartIcon(holder.imageViewHeart, viewModel.isFavorite(product));

        holder.imageViewHeart.setOnClickListener(v -> {
            viewModel.toggleFavorite(product);
            updateHeartIcon(holder.imageViewHeart, viewModel.isFavorite(product));
        });
    }

    private void updateHeartIcon(ImageView imageView, boolean isFavorite) {
        imageView.setImageResource(isFavorite ? R.drawable.heart_regular : R.drawable.mdi_heart);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
