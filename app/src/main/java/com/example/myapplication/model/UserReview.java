package com.example.myapplication.model;

public class UserReview {
    private int imageResId;
    private String username;
    private String comment;
    private int starResId;

    public UserReview(int imageResId, String username, String comment, int starResId) {
        this.imageResId = imageResId;
        this.username = username;
        this.comment = comment;
        this.starResId = starResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public int getStarResId() {
        return starResId;
    }
}
