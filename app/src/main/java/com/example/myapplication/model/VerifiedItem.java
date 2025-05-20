package com.example.myapplication.model;

public class VerifiedItem {
    private int imageResId;  // Resource ID for the image
    private String name;     // Name of the item
    private String discount; // Discount text

    // Constructor
    public VerifiedItem(int imageResId, String name, String discount) {
        this.imageResId = imageResId;
        this.name = name;
        this.discount = discount;
    }

    // Getter methods
    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDiscount() {
        return discount;
    }
}
