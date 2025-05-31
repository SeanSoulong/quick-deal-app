package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.CardAdapter;
import com.example.myapplication.Adapter.ProductAdapter;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.model.CardItem;
import com.example.myapplication.model.ClaimItem;
import com.example.myapplication.model.FavoriteViewModel;
import com.example.myapplication.model.Product;
import com.example.myapplication.service.DataService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerViewCard, recyclerViewProduct;
    private CardAdapter cardAdapter;
    private ProductAdapter productAdapter;

    private List<CardItem> cardItems;
    private List<Product> productList;
    private List<ClaimItem> claimItems;

    private DataService dataService;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        TextView usernameText = view.findViewById(R.id.usernam);

        if (user != null && user.getDisplayName() != null) {
            usernameText.setText("Hello, " + user.getDisplayName());
        } else {
            usernameText.setText("Hello, Guest");
        }

        // Initialize DataService and Product List
        dataService = new DataService();
        productList = dataService.getProducts();

        // Setup FavoriteViewModel
        FavoriteViewModel viewModel = new ViewModelProvider(requireActivity()).get(FavoriteViewModel.class);

        // Setup Product RecyclerView
        recyclerViewProduct = view.findViewById(R.id.productRecyclerView);
        recyclerViewProduct.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        productAdapter = new ProductAdapter(productList, viewModel); // pass viewModel
        recyclerViewProduct.setAdapter(productAdapter);

        // Setup Card RecyclerView
        recyclerViewCard = view.findViewById(R.id.horizontalRecyclerView);
        recyclerViewCard.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        cardItems = dataService.getCards();
        cardAdapter = new CardAdapter(cardItems, item -> {
            if ("Ten 11".equalsIgnoreCase(item.getLabel())) {
                MainActivity.binding.bottomNavigation.setSelectedItemId(R.id.nav_search);
            }
        });
        recyclerViewCard.setAdapter(cardAdapter);

        // Setup Claim Section
        LinearLayout claimContainer = view.findViewById(R.id.claimContainer);
        claimItems = dataService.getClaims();
        for (ClaimItem item : claimItems) {
            View claimView = LayoutInflater.from(getContext()).inflate(R.layout.item_claim, claimContainer, false);

            ImageView imageView = claimView.findViewById(R.id.imageView);
            TextView titleView = claimView.findViewById(R.id.textViewTitle);
            TextView discountView = claimView.findViewById(R.id.textViewDiscount);

            imageView.setImageResource(item.getImageResId());
            titleView.setText(item.getTitle());
            discountView.setText(item.getDiscount());

            claimContainer.addView(claimView);
        }

        // User icon click -> UserFragment
        ImageView imageView5 = view.findViewById(R.id.imageView5);
        imageView5.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new UserFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        // Search logic
        binding.linearLayoutSearch.setOnClickListener(v -> {
            String input = binding.searchEditText.getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(getContext(), "Please enter something to search", Toast.LENGTH_SHORT).show();
            } else if (input.equalsIgnoreCase("ten11")) {
                MainActivity.binding.bottomNavigation.setSelectedItemId(R.id.nav_search);
            } else {
                Toast.makeText(getContext(), "Does not have", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
