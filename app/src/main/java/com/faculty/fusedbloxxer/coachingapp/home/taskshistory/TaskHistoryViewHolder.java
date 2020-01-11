package com.faculty.fusedbloxxer.coachingapp.home.taskshistory;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskHistoryViewHolder extends RecyclerView.ViewHolder {
    private TextView mIdTextView, mDateTextView, mCommentaryTextView;
    private RatingBar mRatingBar;
    private CardView mCardView;

    public TaskHistoryViewHolder(@NonNull View itemView, INavigable<Pair<Long, Long>> listener) {
        super(itemView);
        initViews(itemView);
        mCardView.setOnClickListener(v ->
                Utils.createItemOptions(v.getContext(), listener,
                        new Pair<>((Long) mIdTextView.getTag(), (Long) mDateTextView.getTag())));
    }

    private void initViews(View itemView) {
        mRatingBar = itemView.findViewById(R.id.task_history_rating);
        mCardView = itemView.findViewById(R.id.task_history_card_view);
        mIdTextView = itemView.findViewById(R.id.task_history_id_text_view);
        mDateTextView = itemView.findViewById(R.id.task_history_date_text_view);
        mCommentaryTextView = itemView.findViewById(R.id.task_history_commentary_text_view);
    }

    public void setCommentary(String commentary) {
        if (commentary != null) {
            mCommentaryTextView.setVisibility(View.VISIBLE);
            mCommentaryTextView.setText(commentary);
        } else {
            mCommentaryTextView.setVisibility(View.GONE);
        }
    }

    public void setRating(Long rating) {
        if (rating != null) {
            mRatingBar.setVisibility(View.VISIBLE);
            mRatingBar.setRating(rating);
        } else {
            mRatingBar.setVisibility(View.GONE);
        }
    }

    public void setTaskId(Long taskId) {
        if (taskId != null) {
            mIdTextView.setTag(taskId);
            mIdTextView.setText(String.format("ID: %d", taskId));
        }
    }

    public void setDate(Date date) {
        if (date != null) {
            mDateTextView.setTag(date.getTime());
            mDateTextView.setText(new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).format(date));
        }
    }
}
