package com.example.myapplication.model;

public class ReviewItem {
    private int profileImage;
    private String username;
    private String message;
    private int starImage;

    public ReviewItem(int profileImage, String username, String message, int starImage) {
        this.profileImage = profileImage;
        this.username = username;
        this.message = message;
        this.starImage = starImage;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public int getStarImage() {
        return starImage;
    }
}