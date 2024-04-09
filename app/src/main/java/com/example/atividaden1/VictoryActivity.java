package com.example.atividaden1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VictoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);

        int attempts = getIntent().getIntExtra("ATTEMPTS_EXTRA", -1);
        TextView textViewVictoryMessage = findViewById(R.id.textViewVictoryMessage);
        textViewVictoryMessage.setText("Parabéns! Você acertou o código em " + attempts + " tentativas!");
    }
}
