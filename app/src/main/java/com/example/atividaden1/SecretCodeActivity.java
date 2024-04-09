package com.example.atividaden1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SecretCodeActivity extends AppCompatActivity {
    private String secretCode;
    private List<Try> tries;
    private TryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_code);

        secretCode = generateSecretCode();
        tries = new ArrayList<>();
        adapter = new TryAdapter(tries);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewAttempts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        EditText editTextGuess = findViewById(R.id.editTextGuess);
        Button buttonSubmit = findViewById(R.id.buttonSubmitGuess);
        buttonSubmit.setOnClickListener(v -> {
            String guess = editTextGuess.getText().toString();
            if (guess.length() != 4) {
                Toast.makeText(this, "Digite 4 dígitos.", Toast.LENGTH_SHORT).show();
                return;
            }

            Try attempt = new Try(guess, checkGuess(guess));
            tries.add(attempt);
            adapter.notifyDataSetChanged();
            editTextGuess.setText("");

            if (attempt.getFeedback().equals("++++")) {
                showVictoryMessage(tries.size());
            }
        });
    }

    private String generateSecretCode() {
        return new Random().ints(4, 0, 10)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    private String checkGuess(String guess) {
        StringBuilder feedback = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == secretCode.charAt(i)) {
                feedback.append("V");
            } else if (secretCode.contains(String.valueOf(guess.charAt(i)))) {
                feedback.append("?");
            } else {
                feedback.append("X");
            }
        }
        return feedback.toString();
    }

    private void showVictoryMessage(int attempts) {
        Intent intent = new Intent(SecretCodeActivity.this, VictoryActivity.class);
        intent.putExtra("ATTEMPTS_EXTRA", attempts);
        startActivity(intent);
    }
}