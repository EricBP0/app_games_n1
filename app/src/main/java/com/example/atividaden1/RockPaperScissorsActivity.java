package com.example.atividaden1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RockPaperScissorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        ImageButton rockButton = findViewById(R.id.buttonRock);
        ImageButton paperButton = findViewById(R.id.buttonPaper);
        ImageButton scissorsButton = findViewById(R.id.buttonScissors);
        TextView aiChoiceView = findViewById(R.id.textViewAIChoice);
        TextView resultView = findViewById(R.id.textViewResult);
        ImageView imageViewResult = findViewById(R.id.imageViewResult);

        View.OnClickListener playGame = v -> {
            int playerChoiceResId = R.drawable.neutra;
            if (v.getId() == R.id.buttonRock) {
                playerChoiceResId = R.drawable.pedra;
            } else if (v.getId() == R.id.buttonPaper) {
                playerChoiceResId = R.drawable.papel;
            } else if (v.getId() == R.id.buttonScissors) {
                playerChoiceResId = R.drawable.tesoura;
            }
            imageViewResult.setImageResource(playerChoiceResId);

            String aiChoice = getRandomChoice();
            String result = determineWinner(getResources().getResourceEntryName(playerChoiceResId), aiChoice);

            aiChoiceView.setText("IA escolheu: " + aiChoice);
            resultView.setText(result);
        };

        rockButton.setOnClickListener(playGame);
        paperButton.setOnClickListener(playGame);
        scissorsButton.setOnClickListener(playGame);
    }

    private String getRandomChoice() {
        String[] choices = {"Pedra", "Papel", "Tesoura"};
        int randomIndex = new Random().nextInt(choices.length);
        return choices[randomIndex];
    }

    private String determineWinner(String playerChoice, String aiChoice) {
        if(playerChoice.equals(aiChoice)) {
            return "Empate!";
        } else if((playerChoice.equals("Pedra") && aiChoice.equals("Tesoura")) ||
                (playerChoice.equals("Papel") && aiChoice.equals("Pedra")) ||
                (playerChoice.equals("Tesoura") && aiChoice.equals("Papel"))) {
            return "Você ganhou!";
        } else {
            return "Você perdeu!";
        }
    }
}
