package com.faculty.fusedbloxxer.coachingapp.home.bestcoaches;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;

public class BestCoachesViewHolder extends RecyclerView.ViewHolder {

    private TextView mNameTextView, mMaxTextView, mAvgTextView;

    public BestCoachesViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mNameTextView = itemView.findViewById(R.id.best_coach_name_text_view);
        mMaxTextView = itemView.findViewById(R.id.best_coach_max_score_text_view);
        mAvgTextView = itemView.findViewById(R.id.best_coach_avg_score_text_view);
    }

    public void setName(String name) {
        if (name != null) {
            mNameTextView.setText(name);
        }
    }

    public void setMax(Float max) {
        if (max != null) {
            mMaxTextView.setText(String.format("MAX: %s", max));
        } else {
            mMaxTextView.setText("MAX: N/A");
        }
    }

    public void setAvg(Float avg) {
        if (avg != null) {
            mAvgTextView.setText(String.format("AVG: %s", avg));
        } else {
            mAvgTextView.setText("AVG: N/A");
        }
    }
}
