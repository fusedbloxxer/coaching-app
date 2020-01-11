package com.faculty.fusedbloxxer.coachingapp.home.tasks;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

import java.util.Locale;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    private TextView mTitleTextView, mIdTextView, mScoreTextView, mTimeTextView, mDescTextView;
    private FrameLayout mFrameLayout;
    private CardView mCardView;

    public TaskViewHolder(@NonNull View itemView, INavigable<Long> listener) {
        super(itemView);
        initViews(itemView);
        mCardView.setOnClickListener(v ->
                Utils.createItemOptions(v.getContext(), listener, (Long) mIdTextView.getTag()));
    }

    private void initViews(View itemView) {
        mCardView = itemView.findViewById(R.id.task_card_view);
        mIdTextView = itemView.findViewById(R.id.task_id_text_view);
        mFrameLayout = itemView.findViewById(R.id.task_frame_layout);
        mScoreTextView = itemView.findViewById(R.id.task_score_text_view);
        mTitleTextView = itemView.findViewById(R.id.task_title_text_view);
        mDescTextView = itemView.findViewById(R.id.task_description_text_view);
        mTimeTextView = itemView.findViewById(R.id.task_estimated_time_text_view);
    }

    public void setTitle(String title) {
        if (title != null) {
            mTitleTextView.setText(title);
        }
    }

    public void setDescription(String description) {
        if (description != null) {
            mDescTextView.setText(description);
        }
    }

    public void setId(Long id) {
        if (id != null) {
            mIdTextView.setTag(id);
            mIdTextView.setText(String.format(Locale.ENGLISH, "ID: %d", id));
        }
    }

    public void setScore(Long score) {
        if (score != null) {
            mFrameLayout.setVisibility(View.VISIBLE);
            mScoreTextView.setText(String.format(Locale.ENGLISH, "%d", score));
        } else {
            mFrameLayout.setVisibility(View.GONE);
        }
    }

    public void setTime(Long time) {
        if (time != null) {
            mTimeTextView.setVisibility(View.VISIBLE);
            mTimeTextView.setText(String.format(Locale.ENGLISH, "Sarcina dureaza undeva la %d de minute.", time));
        } else {
            mTimeTextView.setVisibility(View.GONE);
        }
    }
}
