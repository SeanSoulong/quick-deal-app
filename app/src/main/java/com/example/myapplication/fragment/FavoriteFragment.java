package com.example.myapplication.fragment;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.Adapter.ProductAdapter;
import com.example.myapplication.model.FavoriteViewModel;

public class FavoriteFragment extends Fragment {

    private ProductAdapter adapter;

    public FavoriteFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.favoriteRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        FavoriteViewModel viewModel = new ViewModelProvider(requireActivity()).get(FavoriteViewModel.class);
        viewModel.getFavorites().observe(getViewLifecycleOwner(), favoriteList -> {
            adapter = new ProductAdapter(favoriteList, viewModel);
            recyclerView.setAdapter(adapter);
        });

        return view;
    }
}
