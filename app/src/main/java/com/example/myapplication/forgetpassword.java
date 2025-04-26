package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.databinding.ActivityForgetpasswordBinding;
public class forgetpassword extends AppCompatActivity {
    ActivityForgetpasswordBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityForgetpasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnVerify.setOnClickListener(v -> verify());
        binding.haveAccLogin.setOnClickListener(v -> login());


    }

    private void login() {
        Intent intent = new Intent(this, welcome.class);
        startActivity(intent);
    }

    private void verify() {
        Intent intent = new Intent(this, VerifyCode.class);
        startActivity(intent);
    }


}


