package com.example.atividaden1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EncoderDecoderActivity extends AppCompatActivity {

    private String encode(String text, int shift) {
        shift = shift % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : text.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + shift) % 26 ));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + shift) % 26 ));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    private String decode(String text, int shift) {
        return encode(text, -shift);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder_decoder);

        EditText editText = findViewById(R.id.editTextMessage);
        Button encodeButton = findViewById(R.id.buttonEncode);
        Button decodeButton = findViewById(R.id.buttonDecode);
        TextView resultView = findViewById(R.id.textViewResult);

        encodeButton.setOnClickListener(v -> {
            String message = editText.getText().toString();
            String encoded = encode(message, 12);
            resultView.setText(encoded);
        });

        decodeButton.setOnClickListener(v -> {
            String message = editText.getText().toString();
            String decoded = decode(message, 12);
            resultView.setText(decoded);
        });
    }

}

