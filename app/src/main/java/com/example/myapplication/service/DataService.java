package com.example.myapplication.service;

import com.example.myapplication.R;
import com.example.myapplication.model.ClaimItem2;
import com.example.myapplication.model.Product;
import com.example.myapplication.model.CardItem;
import com.example.myapplication.model.ClaimItem;
import com.example.myapplication.model.ReviewItem;
import com.example.myapplication.model.UserReview;
import com.example.myapplication.model.VerifiedItem;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    // Fetch the product list
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.product_a, "Product A", "25% Off"));
        products.add(new Product(R.drawable.product_b, "Product B", "Buy 1 Get 1 Free"));
        products.add(new Product(R.drawable.product_a, "Product C", "Buy 2 Get 1 Free"));
        products.add(new Product(R.drawable.product_b, "Product D", "75% Off"));
        products.add(new Product(R.drawable.product_a, "Product E", "Buy 3 Get 1 Free"));
        products.add(new Product(R.drawable.product_a, "Product F", "Buy 2 Get 1 Free"));

        return products;
    }

    // Fetch the card items
    public List<CardItem> getCards() {
        List<CardItem> cards = new ArrayList<>();
        cards.add(new CardItem(R.drawable.logo_food, "Food Panda"));
        cards.add(new CardItem(R.drawable.seveneleven, "7 Eleven"));
        cards.add(new CardItem(R.drawable.ten11, "Ten 11"));
        cards.add(new CardItem(R.drawable.profile, "Profile"));
        cards.add(new CardItem(R.drawable.profile, "Profile"));
        return cards;
    }

    // Fetch the claim items
    public List<ClaimItem> getClaims() {
        List<ClaimItem> claims = new ArrayList<>();
        claims.add(new ClaimItem(R.drawable.card_clim, "Food Discount", "50% OFF"));
        claims.add(new ClaimItem(R.drawable.card_clim, "Fashion Discount", "30% OFF"));
        return claims;
    }
    public List<ClaimItem2> getClaimItem2List() {
        List<ClaimItem2> claims = new ArrayList<>();
        claims.add(new ClaimItem2(R.drawable.card_clim2, "Related Product 1", "20%"));
        claims.add(new ClaimItem2(R.drawable.card_clim2, "Related Product 2", "30%"));
        return claims;
    }



    public List<VerifiedItem> getVerifiedItems() {
        List<VerifiedItem> items = new ArrayList<>();
        items.add(new VerifiedItem(R.drawable.tanktop, "Slim Cropped Tank Top", "20% off"));
        items.add(new VerifiedItem(R.drawable.blazer, "Cropped Blazer", "35% off"));
        return items;
    }

    public List<ReviewItem> getReviewItems() {
        List<ReviewItem> reviews = new ArrayList<>();
        reviews.add(new ReviewItem(R.drawable.profile1, "Sulong", "Great service and amazing discounts!", R.drawable.rate_star));
        reviews.add(new ReviewItem(R.drawable.profile2, "វីតក្មេងតូច", "Love the variety of clothing options available.", R.drawable.rate_star));
        reviews.add(new ReviewItem(R.drawable.profile3, "Khoung", "Love the variety of clothing options available.", R.drawable.rate_star));
        reviews.add(new ReviewItem(R.drawable.profile2, "វីតក្មេងតូច", "Love the variety of clothing options available.", R.drawable.rate_star));
        reviews.add(new ReviewItem(R.drawable.profile3, "Khoung", "Love the variety of clothing options available.", R.drawable.rate_star));
        return reviews;
    }

    public List<UserReview> getUserReviewItems() {
        List<UserReview> items = new ArrayList<>();
        items.add(new UserReview(R.drawable.profile1, "TheSou", "Great discount!", R.drawable.rate_star));
        items.add(new UserReview(R.drawable.profile2, "KakVith", "Love this offer!", R.drawable.rate_star));
        items.add(new UserReview(R.drawable.profile1, "SouLux", "Great discount!", R.drawable.rate_star));
        items.add(new UserReview(R.drawable.profile2, "វីតក្មេងតូច", "Love this offer!", R.drawable.rate_star));
        items.add(new UserReview(R.drawable.profile4, "Sk1", "ថោកហើយគុណភាពល្អទៀត!", R.drawable.rate_star));
        items.add(new UserReview(R.drawable.profile5, "Panha2", "Love this offer!", R.drawable.rate_star));
        return items;
    }



}
