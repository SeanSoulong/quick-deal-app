package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.UserReview;

import java.util.List;

public class UserReviewAdapter extends RecyclerView.Adapter<UserReviewAdapter.UserReviewViewHolder> {

    private List<UserReview> reviewList;

    // ✅ Fixed constructor to accept List<UserReview>
    public UserReviewAdapter(List<UserReview> reviewList) {
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public UserReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_review, parent, false);
        return new UserReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserReviewViewHolder holder, int position) {
        UserReview review = reviewList.get(position);
        holder.userImage.setImageResource(review.getImageResId());
        holder.userName.setText(review.getUsername());
        holder.userComment.setText(review.getComment());
        holder.userRating.setImageResource(review.getStarResId());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    static class UserReviewViewHolder extends RecyclerView.ViewHolder {
        ImageView userImage, userRating;
        TextView userName, userComment;

        public UserReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.user_image);
            userName = itemView.findViewById(R.id.user_name);
            userComment = itemView.findViewById(R.id.user_comment);
            userRating = itemView.findViewById(R.id.user_rating);
        }
    }
}
