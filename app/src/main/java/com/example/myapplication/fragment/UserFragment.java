package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentUserBinding;
import com.example.myapplication.welcome;
import com.google.firebase.auth.FirebaseAuth;

public class UserFragment extends Fragment {
    FragmentUserBinding binding;
    private FirebaseAuth mAuth;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        mAuth = FirebaseAuth.getInstance();

        ImageView imageView5 = view.findViewById(R.id.backtohome);
        imageView5.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new HomeFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        ImageView iconlogout = view.findViewById(R.id.iconlogout);

        iconlogout.setOnClickListener(v -> {
            mAuth.signOut();
            startActivity(new Intent(getActivity(), welcome.class));
            getActivity().finish();

        });


        return view; // ✅ Missing return fixed here
    }
}
