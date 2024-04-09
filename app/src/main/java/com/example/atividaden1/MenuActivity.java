package com.example.atividaden1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnEncoder = findViewById(R.id.btn_encoder);
        Button btnRpsGame = findViewById(R.id.btn_rps_game);
        Button btnSecretCode = findViewById(R.id.btn_secret_code);
        Button btnRandomizer = findViewById(R.id.btn_randomizer);

        btnEncoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, EncoderDecoderActivity.class));
            }
        });

        btnRpsGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, RockPaperScissorsActivity.class));
            }
        });

        btnSecretCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, SecretCodeActivity.class));
            }
        });

        btnRandomizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, RandomizerActivity.class));
            }
        });
    }
}
