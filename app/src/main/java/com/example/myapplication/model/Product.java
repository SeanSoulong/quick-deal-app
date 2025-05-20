package com.example.myapplication.model;

import java.util.Objects;

public class Product {

    private final int imageResId;
    private final String title;
    private final String offer;
    private boolean isFavorite = false;

    public Product(int imageResId, String title, String offer) {
        this.imageResId = imageResId;
        this.title = title;
        this.offer = offer;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getOffer() {
        return offer;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    // ✅ Override equals and hashCode for proper comparison in lists
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return imageResId == product.imageResId &&
                title.equals(product.title) &&
                offer.equals(product.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageResId, title, offer);
    }
}
