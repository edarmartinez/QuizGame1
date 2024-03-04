package com.example.quizgame1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quizgame1.databinding.ActivityGameRulesBinding;

public class GameRulesActivity extends AppCompatActivity {

    private ActivityGameRulesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameRulesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Concatenating game rules string resources
        String completeGameRules = getString(R.string.game_rules_intro) + "\n\n" +
                getString(R.string.game_rule_1) + "\n" +
                getString(R.string.game_rule_2) + "\n" +
                getString(R.string.game_rule_3) + "\n" +
                getString(R.string.game_rule_4) + "\n" +
                getString(R.string.game_rule_5) + "\n" +
                getString(R.string.game_rule_6) + "\n" +
                getString(R.string.game_rule_7) + "\n\n" +
                getString(R.string.game_rule_closing);

        // Assuming the TextView in your layout for displaying the game rules has the ID `gameRulesText`
        // Update this ID based on your actual layout
        binding.gameRulesText.setText(completeGameRules);
    }
}
