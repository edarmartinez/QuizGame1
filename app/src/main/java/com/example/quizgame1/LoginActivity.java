package com.example.quizgame1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizgame1.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(view -> {
            String email = binding.etEmail.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();

            // Validate inputs
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.setError("Invalid email address");
                return;
            }

            if (password.isEmpty()) {
                binding.etPassword.setError("Password cannot be empty");
                return;
            }

            // Check credentials
            if (validateCredentials(email, password)) {
                // Credentials are correct, navigate to QuizActivity
                Intent intent = new Intent(LoginActivity.this, QuizActivity.class);
                startActivity(intent);
                finish(); // Finish LoginActivity
            } else {
                // Credentials are incorrect, show an error message
                Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validateCredentials(String email, String password) {
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String registeredEmail = prefs.getString("Email", "");
        String registeredPassword = prefs.getString("Password", "");

        // Check if the entered credentials match the stored credentials
        return email.equals(registeredEmail) && password.equals(registeredPassword);
    }
}
