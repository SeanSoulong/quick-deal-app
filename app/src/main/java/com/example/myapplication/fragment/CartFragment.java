package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.CartAdapter;
import com.example.myapplication.R;
import com.example.myapplication.model.Cart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Cart> cartList;
    private TextView tvItemTotal, tvSubtotal, tvDiscount, tvFinalTotal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerView = view.findViewById(R.id.recyclerProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        tvItemTotal = view.findViewById(R.id.tvItemTotal);
        tvSubtotal = view.findViewById(R.id.tvSubtotal);
        tvDiscount = view.findViewById(R.id.tvDiscount);
        tvFinalTotal = view.findViewById(R.id.tvFinalTotal);

        // Sample data
        cartList = new ArrayList<>();
        cartList.add(new Cart("Latest Smartphone", "$699.99", "Discount 10%", R.drawable.phone_image));
        cartList.add(new Cart("Men's Workout Shoes", "$89.99", "Discount 15%", R.drawable.nike_image));
        cartList.add(new Cart("Pepperoni Pizza", "$12.99", "Discount 20%", R.drawable.pizza_image));
        cartList.add(new Cart("Latest Smartphone", "$699.99", "Discount 10%", R.drawable.phone_image));
        cartList.add(new Cart("Men's Workout Shoes", "$89.99", "Discount 15%", R.drawable.nike_image));
        cartList.add(new Cart("Pepperoni Pizza", "$12.99", "Discount 20%", R.drawable.pizza_image));


        CartAdapter adapter = new CartAdapter(getContext(), cartList);
        recyclerView.setAdapter(adapter);

        updateSummary();

        return view;
    }

    private void updateSummary() {
        int itemTotal = cartList.size();
        double subtotal = 0;
        double totalDiscount = 0;

        for (Cart item : cartList) {
            double price = item.getPriceValue();
            double discount = item.getDiscountPercentage();
            double discountAmount = price * discount / 100.0;

            subtotal += price;
            totalDiscount += discountAmount;
        }

        double finalTotal = subtotal - totalDiscount;

        DecimalFormat df = new DecimalFormat("#.##");

        tvItemTotal.setText(String.valueOf(itemTotal));
        tvSubtotal.setText("$" + df.format(subtotal));
        tvDiscount.setText("-$" + df.format(totalDiscount));
        tvFinalTotal.setText("$" + df.format(finalTotal));
    }

}
