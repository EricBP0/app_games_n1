package com.example.atividaden1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TryAdapter extends RecyclerView.Adapter<TryAdapter.TryViewHolder> {
    private List<Try> tries;

    public TryAdapter(List<Try> tries) {
        this.tries = tries;
    }

    @NonNull
    @Override
    public TryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_try, parent, false);
        return new TryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TryViewHolder holder, int position) {
        Try aTry = tries.get(position);
        holder.textViewAttempt.setText(aTry.getAttempt());
        holder.textViewFeedback.setText(aTry.getFeedback());
    }

    @Override
    public int getItemCount() {
        return tries.size();
    }

    public static class TryViewHolder extends RecyclerView.ViewHolder {
        TextView textViewAttempt, textViewFeedback;

        public TryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAttempt = itemView.findViewById(R.id.textViewAttempt);
            textViewFeedback = itemView.findViewById(R.id.textViewFeedback);
        }
    }
}
