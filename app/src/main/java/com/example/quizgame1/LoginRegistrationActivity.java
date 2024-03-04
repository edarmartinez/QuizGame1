package com.example.quizgame1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizgame1.databinding.ActivityLoginRegistrationBinding; // Correct the import

public class LoginRegistrationActivity extends AppCompatActivity {

    private ActivityLoginRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginRegistrationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Navigate to LoginActivity when the login button is clicked
        binding.btnLogin.setOnClickListener(new View.OnClickListener() { // Corrected ID
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginRegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to RegistrationActivity when the register button is clicked
        binding.btnRegister.setOnClickListener(new View.OnClickListener() { // Corrected ID
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginRegistrationActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
