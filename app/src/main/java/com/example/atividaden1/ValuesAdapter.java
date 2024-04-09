package com.example.atividaden1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ValuesAdapter extends RecyclerView.Adapter<ValuesAdapter.ValueViewHolder> {
    private List<String> values;

    public ValuesAdapter(List<String> values) {
        this.values = values;
    }

    @NonNull
    @Override
    public ValueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ValueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ValueViewHolder holder, int position) {
        String value = values.get(position);
        holder.textView.setText(value);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public static class ValueViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ValueViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
