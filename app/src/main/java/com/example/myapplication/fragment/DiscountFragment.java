package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.Adapter.ClaimAdapter2;

import com.example.myapplication.Adapter.UserReviewAdapter;
import com.example.myapplication.R;
import com.example.myapplication.model.ClaimItem2;
import com.example.myapplication.model.UserReview;
import com.example.myapplication.service.DataService;

import java.util.List;

public class DiscountFragment extends Fragment {

    public DiscountFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discount, container, false);

        ImageView backToSearch = view.findViewById(R.id.backtosearch);
        backToSearch.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new SearchFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });


        // Setup User Reviews
        RecyclerView recyclerReviews = view.findViewById(R.id.recyclerReviews);
        recyclerReviews.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)
        );
        List<UserReview> reviewItems = new DataService().getUserReviewItems();
        UserReviewAdapter adapter = new UserReviewAdapter(reviewItems);
        recyclerReviews.setAdapter(adapter);

        // Setup ClaimItem2
        RecyclerView recyclerClaims = view.findViewById(R.id.recyclerClaims);
        recyclerClaims.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)
        );
        List<ClaimItem2> claimItems2 = new DataService().getClaimItem2List();  // <-- Make sure this method exists
        ClaimAdapter2 claimAdapter2 = new ClaimAdapter2(claimItems2);
        recyclerClaims.setAdapter(claimAdapter2);

        return view;
    }
}
