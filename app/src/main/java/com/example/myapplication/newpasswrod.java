package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityNewpasswrodBinding;
import com.example.myapplication.databinding.ActivitySingupBinding;

public class newpasswrod extends AppCompatActivity {
    ActivityNewpasswrodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityNewpasswrodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnVerify.setOnClickListener(v -> welcom());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    private void welcom() {
        Intent intent = new Intent(this, welcome.class);
        startActivity(intent);
    }
}