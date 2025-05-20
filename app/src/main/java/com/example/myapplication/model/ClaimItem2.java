package com.example.myapplication.model;

public class ClaimItem2 {
    private int imageResId;
    private String title;
    private String discount;

    public ClaimItem2(int imageResId, String title, String discount) {
        this.imageResId = imageResId;
        this.title = title;
        this.discount = discount;
    }

    public int getImageResId() { return imageResId; }
    public String getTitle() { return title; }
    public String getDiscount() { return discount; }
}
