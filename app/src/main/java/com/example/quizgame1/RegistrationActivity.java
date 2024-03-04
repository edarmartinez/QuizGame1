package com.example.quizgame1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast; // This is the new import
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizgame1.databinding.ActivityRegistrationBinding;


public class RegistrationActivity extends AppCompatActivity {

    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(view -> {
            String firstName = binding.etFirstName.getText().toString().trim();
            String lastName = binding.etLastName.getText().toString().trim();
            String email = binding.etEmail.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();

            // Validate inputs
            if (firstName.isEmpty()) {
                binding.etFirstName.setError("First name is required");
                binding.etFirstName.requestFocus();
                return;
            }

            if (lastName.isEmpty()) {
                binding.etLastName.setError("Last name is required");
                binding.etLastName.requestFocus();
                return;
            }

            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.setError("Valid email is required");
                binding.etEmail.requestFocus();
                return;
            }

            if (password.isEmpty() || password.length() < 6) {
                binding.etPassword.setError("Password must be 6 characters or more");
                binding.etPassword.requestFocus();
                return;
            }

            // Save user details locally using SharedPreferences
            SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FirstName", firstName);
            editor.putString("LastName", lastName);
            editor.putString("Email", email);
            editor.putString("Password", password);
            editor.apply();

            // Notify user of successful registration
            Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();

            // Navigate the user to the login screen
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Finish this activity so the user can't return to it with the back button
        });
    }
}
