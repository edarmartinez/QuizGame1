package com.example.quizgame1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizgame1.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Fetch the quiz results passed from QuizActivity
        // For now, let's assume a placeholder score
        int score = getIntent().getIntExtra("SCORE", 0);
        binding.resultText.setText("Your Score: " + score);

        // Implement any additional features like restarting the quiz
    }
}
