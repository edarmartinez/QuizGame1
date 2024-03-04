package com.example.quizgame1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup radioGroup;
    private Button submitAnswerButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    // Example questions and options. In a real app, consider using a more scalable storage or retrieval method
    private String[][] questions = {
            {"What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris"},
            {"Who painted the Mona Lisa?", "Vincent Van Gogh", "Leonardo Da Vinci", "Pablo Picasso", "Claude Monet", "Leonardo Da Vinci"},
            {"What is the largest planet in our solar system?", "Earth", "Jupiter", "Mars", "Saturn", "Jupiter"},
            {"What is the chemical symbol for gold?", "Au", "Ag", "Fe", "O", "Au"},
            {"Which element has the atomic number 1?", "Oxygen", "Hydrogen", "Helium", "Carbon", "Hydrogen"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.questionText);
        radioGroup = findViewById(R.id.radioGroup);
        submitAnswerButton = findViewById(R.id.submitAnswerButton);

        displayQuestion(currentQuestionIndex);

        submitAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                if (selectedRadioButton != null && selectedRadioButton.getText().equals(questions[currentQuestionIndex][5])) {
                    score++;
                }
                if (currentQuestionIndex < questions.length - 1) {
                    currentQuestionIndex++;
                    displayQuestion(currentQuestionIndex);
                } else {
                    // Quiz is finished, navigate to ResultActivity
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("SCORE", score);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void displayQuestion(int questionIndex) {
        questionText.setText(questions[questionIndex][0]);
        radioGroup.removeAllViews(); // Clear previous options

        // Dynamically add radio buttons for the current question's options
        for (int i = 1; i <= 4; i++) {
            RadioButton rb = new RadioButton(this);
            rb.setId(View.generateViewId());
            rb.setText(questions[questionIndex][i]);
            radioGroup.addView(rb);
        }
    }
}
