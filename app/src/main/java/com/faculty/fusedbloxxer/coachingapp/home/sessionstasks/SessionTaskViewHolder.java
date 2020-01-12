package com.faculty.fusedbloxxer.coachingapp.home.sessionstasks;

import android.view.View;
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

public class SessionTaskViewHolder extends RecyclerView.ViewHolder {
    private TextView mDateTextView, mPriorityTextView, mSessionIdTextView, mTaskIdTextView;
    private CardView mCardView, mPriorityCardView;

    public SessionTaskViewHolder(@NonNull View itemView, INavigable<Pair<Long, Long>> listener) {
        super(itemView);
        initViews(itemView);
        mCardView.setOnClickListener(v -> Utils.createItemOptions(v.getContext(), listener, new Pair<>(
                (Long) mSessionIdTextView.getTag(),
                (Long) mTaskIdTextView.getTag()
        )));
    }

    private void initViews(View itemView) {
        mCardView = itemView.findViewById(R.id.sessions_tasks__card_view);
        mDateTextView = itemView.findViewById(R.id.sessions_tasks_start_date);
        mTaskIdTextView = itemView.findViewById(R.id.sessions_tasks_id_task_text_view);
        mPriorityCardView = itemView.findViewById(R.id.sessions_tasks_priority_card_view);
        mPriorityTextView = itemView.findViewById(R.id.sessions_tasks_priority_text_view);
        mSessionIdTextView = itemView.findViewById(R.id.sessions_tasks_id_session_text_view);
    }

    public void setDate(Date date) {
        if (date != null) {
            mDateTextView.setText(new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).format(date));
        }
    }

    public void setPriority(Long priority) {
        if (priority != null) {
            mPriorityCardView.setVisibility(View.VISIBLE);
            mPriorityTextView.setText(String.format(Locale.ENGLISH, "Nivel prioritate: %s", priority));
        } else {
            mPriorityCardView.setVisibility(View.GONE);
        }
    }

    public void setSessionId(Long sessionId) {
        if (sessionId != null) {
            mSessionIdTextView.setTag(sessionId);
            mSessionIdTextView.setText(String.format(Locale.ENGLISH, "Id sedinta: %d", sessionId));
        }
    }

    public void setTaskId(Long taskId) {
        if (taskId != null) {
            mTaskIdTextView.setTag(taskId);
            mTaskIdTextView.setText(String.format(Locale.ENGLISH, "Id sarcina: %d", taskId));
        }
    }
}
