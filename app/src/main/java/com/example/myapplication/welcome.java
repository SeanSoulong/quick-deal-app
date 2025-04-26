package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.databinding.ActivityWelcomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class welcome extends AppCompatActivity {

    private ActivityWelcomeBinding binding;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        mAuth = FirebaseAuth.getInstance();

        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> singupacc());
        binding.textView3.setOnClickListener(v -> fogetpass());
        binding.button1.setOnClickListener(v ->  onSignInClicked());

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String email = data.getStringExtra("email");
                        String password = data.getStringExtra("password");

                        binding.email.setText(email);
                        binding.password.setText(password);
                    }
                }
        );

    }


    private void fogetpass() {
        Intent intent = new Intent(this, forgetpassword.class);
        startActivity(intent);
    }

    private void singupacc() {
        Intent intent = new Intent(this, singup.class);
        activityResultLauncher.launch(intent);
    }

    private void onSignInClicked() {
        binding.pbLoginProgress.setVisibility(View.VISIBLE);
        String email = binding.email.getText().toString().trim();
        String password = binding.password.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            binding.pbLoginProgress.setVisibility(View.INVISIBLE);
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        binding.pbLoginProgress.setVisibility(View.INVISIBLE);
                        if (task.isSuccessful()) {
                            reload();
                        } else {
                            Exception e = task.getException();
                            String message = "Authentication failed.";

                            if (e != null && e.getMessage() != null) {
                                if (e.getMessage().contains("no user record")) {
                                    message = "No account found for this email. Please sign up first.";
                                } else if (e.getMessage().contains("password is invalid")) {
                                    message = "Invalid password. Please try again.";
                                }
                            }

                            Toast.makeText(welcome.this, message, Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}