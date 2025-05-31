package com.example.myapplication.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ReviewAdapter;
import com.example.myapplication.Adapter.VerifiedAdapter;
import com.example.myapplication.R;
import com.example.myapplication.model.ReviewItem;
import com.example.myapplication.model.VerifiedItem;
import com.example.myapplication.service.DataService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;

    public SearchFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        TextView usernameText = view.findViewById(R.id.usernam);

        if (user != null && user.getDisplayName() != null) {
            usernameText.setText("Hello, " + user.getDisplayName());
        } else {
            usernameText.setText("Hello, Guest");
        }

        ImageView imageView5 = view.findViewById(R.id.imageView5);
        imageView5.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new UserFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });



        // Verified Items RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        List<VerifiedItem> items = new DataService().getVerifiedItems();

        VerifiedAdapter adapter = new VerifiedAdapter(requireContext(), items, item -> {

            if (item.getName().equalsIgnoreCase("Cropped Blazer")) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new DiscountFragment()) // Make sure fragment_container is correct
                        .commit();

            }
            else if (item.getName().equalsIgnoreCase("Slim Cropped Tank Top")) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new DiscountFragment2()) // Make sure fragment_container is correct
                        .commit();

            }
        });

        recyclerView.setAdapter(adapter);

        // Reviews RecyclerView
        RecyclerView recyclerReviews = view.findViewById(R.id.recyclerReviews);
        recyclerReviews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        List<ReviewItem> reviewItems = new DataService().getReviewItems();
        ReviewAdapter reviewAdapter = new ReviewAdapter(reviewItems);
        recyclerReviews.setAdapter(reviewAdapter);

        return view;
    }
}
