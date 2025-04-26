package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.myapplication.databinding.ActivityVerifyCodeBinding;

public class VerifyCode extends AppCompatActivity {
    ActivityVerifyCodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityVerifyCodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnVerify.setOnClickListener(v -> conformpass());



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void conformpass() {
        Intent intent = new Intent(this, newpasswrod.class);
        startActivity(intent);
    }
}