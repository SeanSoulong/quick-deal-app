package com.example.myapplication.model;

public class CardItem {
    private int imageResId;
    private String label;

    public CardItem(int imageResId, String label) {
        this.imageResId = imageResId;
        this.label = label;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getLabel() {
        return label;
    }
}
