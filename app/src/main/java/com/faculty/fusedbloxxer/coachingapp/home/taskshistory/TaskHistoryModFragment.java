package com.faculty.fusedbloxxer.coachingapp.home.taskshistory;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.ModFragment;
import com.faculty.fusedbloxxer.coachingapp.databinding.TaskHistoryModLayoutBinding;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.TaskHistory;

import java.util.Date;
import java.util.Objects;

public class TaskHistoryModFragment extends ModFragment {
    private TextView mDateTextView, mIdTextView, mSpinnerHelpTextView;
    private Spinner mTaskHistorySpinner;
    private EditText mCommentEditText;
    private RatingBar mRatingBar;
    private Long mTaskId, mDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TaskHistoryModLayoutBinding taskHistoryModLayoutBinding = TaskHistoryModLayoutBinding
                .inflate(inflater, container, false);
        taskHistoryModLayoutBinding.setFragment(this);
        return taskHistoryModLayoutBinding.getRoot();
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vm.getAllTaskIds().observe(this, longs -> mTaskHistorySpinner.setAdapter(
                new ArrayAdapter<Long>(Objects.requireNonNull(getContext()),
                        android.R.layout.simple_spinner_dropdown_item, longs)));
    }

    @Override
    public void onAccept() {
        final TaskHistory taskHistory = new TaskHistory(
                mCommentEditText.getText().length() > 0 ? mCommentEditText.getText().toString() : null,
                (long) mRatingBar.getRating()
        );

        if (mTaskId != null && mDate != null) {
            taskHistory.setTaskId(mTaskId);
            taskHistory.setCompletionDate(new Date(mDate));
            vm.updateTasksHistory(taskHistory);
        } else {
            taskHistory.setTaskId((Long) mTaskHistorySpinner.getSelectedItem());
            taskHistory.setCompletionDate(new Date());
            vm.insertTasksHistory(taskHistory);
        }

        onCancel();
    }

    @Override
    protected void setArgumentId() {
        if (getArguments() != null) {
            String taskId = TaskHistoryModFragmentArgs.fromBundle(getArguments()).getTaskId();
            String date = TaskHistoryModFragmentArgs.fromBundle(getArguments()).getDate();

            if (taskId != null && date != null) {
                mDate = Long.parseLong(date);
                mTaskId = Long.parseLong(taskId);
                vm.getTaskHistoryByTaskIdAndDate(mTaskId, mDate).observe(this, taskHistory -> {
                            if (taskHistory != null) {
                                mIdTextView.setText(String.format("ID: %d", mTaskId));
                                mDateTextView.setText(date);

                                if (taskHistory.getConfidenceRating() != null) {
                                    mRatingBar.setRating(taskHistory.getConfidenceRating());
                                }

                                if (taskHistory.getComment() != null) {
                                    mCommentEditText.setText(taskHistory.getComment());
                                }
                            }
                        }
                );
            }
        }

        if (mTaskId != null || mDate != null) {
            mTaskHistorySpinner.setVisibility(View.GONE);
            mSpinnerHelpTextView.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initViews(View itemView) {
        mCommentEditText = itemView.findViewById(R.id.task_history_commentary_text_view);
        mSpinnerHelpTextView = itemView.findViewById(R.id.spinner_help_text_view);
        mDateTextView = itemView.findViewById(R.id.task_history_date_text_view);
        mTaskHistorySpinner = itemView.findViewById(R.id.task_history_spinner);
        mIdTextView = itemView.findViewById(R.id.task_history_id_text_view);
        mRatingBar = itemView.findViewById(R.id.task_history_rating_bar);
    }
}
