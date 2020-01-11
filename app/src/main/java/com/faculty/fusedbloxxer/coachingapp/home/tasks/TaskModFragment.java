package com.faculty.fusedbloxxer.coachingapp.home.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.ModFragment;
import com.faculty.fusedbloxxer.coachingapp.databinding.TaskModLayoutBinding;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Task;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

import java.util.Locale;

public class TaskModFragment extends ModFragment {
    private EditText mTitleEditText, mScoreEditText, mDescEditText, mTimeEditText;
    private TextView mIdTextView;
    private Long mTaskId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TaskModLayoutBinding taskModLayoutBinding = TaskModLayoutBinding
                .inflate(inflater, container, false);
        taskModLayoutBinding.setFragment(this);
        return taskModLayoutBinding.getRoot();
    }

    @Override
    public void onAccept() {
        if (Utils.checkEditTexts(mDescEditText, mTitleEditText)) {
            Long score = null;

            if (mScoreEditText.getText().length() > 0) {
                try {
                    score = Long.parseLong(mScoreEditText.getText().toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(getContext(), "Scorul introdus este invalid.", Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                if (score < 0 || score > 100) {
                    mScoreEditText.setError("Scorul trebuie sa fie intre 0 si 100 !");
                    return;
                }
            }

            Long time = null;

            if (mTimeEditText.getText().length() > 0) {
                try {
                    time = Long.parseLong(mTimeEditText.getText().toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(getContext(), "Timpul introdus este invalid.", Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                if (time < 0) {
                    mTimeEditText.setError("Timpul, in minute trebuie sa fie pozitiv !");
                    return;
                }
            }

            final Task task = new Task(
                    time,
                    mDescEditText.getText().toString(),
                    score,
                    mTitleEditText.getText().toString()
            );

            if (mTaskId != null) {
                task.setTaskId(mTaskId);
                vm.updateTasks(task);
            } else {
                vm.insertTasks(task);
            }

            onCancel();
        }
    }

    @Override
    protected void setArgumentId() {
        if (getArguments() != null) {
            String taskId = TaskModFragmentArgs.fromBundle(getArguments()).getTaskId();

            if (taskId != null) {
                mTaskId = Long.parseLong(taskId);

                vm.getTaskWithId(mTaskId).observe(this, task -> {
                    mTitleEditText.setText(task.getTitle());
                    mScoreEditText.setText(task.getRewardPoints() != null ? String.format(Locale.ENGLISH, "%d", task.getRewardPoints()) : "");
                    mDescEditText.setText(task.getDescription());
                    mTimeEditText.setText(task.getEstimatedTime() != null ? String.format(Locale.ENGLISH, "%d", task.getEstimatedTime()) : "");
                    mIdTextView.setText(String.format(Locale.ENGLISH, "ID: %d", task.getTaskId()));
                });
            }
        }
    }

    @Override
    protected void initViews(View itemView) {
        mTimeEditText = itemView.findViewById(R.id.task_estimated_time_edit_text);
        mTitleEditText = itemView.findViewById(R.id.task_title_edit_text);
        mScoreEditText = itemView.findViewById(R.id.task_score_edit_text);
        mDescEditText = itemView.findViewById(R.id.task_desc_edit_text);
        mIdTextView = itemView.findViewById(R.id.task_id_text_view);
    }
}
