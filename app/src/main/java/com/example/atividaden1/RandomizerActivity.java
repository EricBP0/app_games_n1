package com.example.atividaden1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizerActivity extends AppCompatActivity {
    private List<String> values;
    private ValuesAdapter adapter;
    private TextView textViewRandomValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomizer);

        values = new ArrayList<>();
        adapter = new ValuesAdapter(values);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewValues);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        textViewRandomValue = findViewById(R.id.textViewRandomValue);

        EditText editTextValue = findViewById(R.id.editTextValue);
        Button buttonAdd = findViewById(R.id.buttonAddValue);
        buttonAdd.setOnClickListener(v -> {
            String value = editTextValue.getText().toString();
            if (!value.isEmpty()) {
                values.add(value);
                adapter.notifyDataSetChanged();
                editTextValue.setText("");
            }
        });

        Button buttonRandomize = findViewById(R.id.buttonRandomize);
        buttonRandomize.setOnClickListener(v -> {
            if (!values.isEmpty()) {
                int randomIndex = new Random().nextInt(values.size());
                String randomValue = values.get(randomIndex);
                textViewRandomValue.setText(randomValue);
                textViewRandomValue.setVisibility(View.VISIBLE);
            }
        });
    }
}
