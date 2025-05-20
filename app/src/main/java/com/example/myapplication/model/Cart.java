package com.example.myapplication.model;

public class Cart {
    private String name;
    private String price;     // like "$699.99"
    private String discount;  // like "Discount 10%"
    private int imageResId;

    public Cart(String name, String price, String discount, int imageResId) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getDiscount() { return discount; }
    public int getImageResId() { return imageResId; }

    public double getPriceValue() {
        return Double.parseDouble(price.replace("$", ""));
    }

    public double getDiscountPercentage() {
        String value = discount.replaceAll("[^0-9]", "");
        return value.isEmpty() ? 0 : Double.parseDouble(value);
    }
}


