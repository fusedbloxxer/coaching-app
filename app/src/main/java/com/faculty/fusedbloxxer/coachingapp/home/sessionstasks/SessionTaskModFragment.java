package com.faculty.fusedbloxxer.coachingapp.home.sessionstasks;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.ModFragment;
import com.faculty.fusedbloxxer.coachingapp.databinding.SessionsTasksModLayoutBinding;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.SessionTask;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class SessionTaskModFragment extends ModFragment {
    private TextInputEditText mStartDateTextInputEditText, mPriorityTextInputEditText;
    private LinearLayout mSessionLinearLayout, mTaskLinearLayout;
    private Spinner mSessionSpinner, mTaskSpinner;
    private TextView mPrimaryKeyTextView;
    private Long mSessionId, mTaskId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SessionsTasksModLayoutBinding sessionsMaterialsModLayoutBinding = SessionsTasksModLayoutBinding
                .inflate(inflater, container, false);
        sessionsMaterialsModLayoutBinding.setFragment(this);
        return sessionsMaterialsModLayoutBinding.getRoot();
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vm.getAllSessions().observe(this, sessions ->
                mSessionSpinner.setAdapter(
                        new ArrayAdapter<>(
                                Objects.requireNonNull(getContext()),
                                android.R.layout.simple_spinner_dropdown_item,
                                sessions.stream()
                                        .map(session -> session.getSessionId().toString())
                                        .collect(Collectors.toList())
                        )
                )
        );

        vm.getAllTasks().observe(this, tasks ->
                mTaskSpinner.setAdapter(
                        new ArrayAdapter<>(
                                Objects.requireNonNull(getContext()),
                                android.R.layout.simple_spinner_dropdown_item,
                                tasks.stream()
                                        .map(task -> task.getTaskId().toString())
                                        .collect(Collectors.toList())
                        )
                )
        );
    }

    public Long conditionalPick(Spinner spinner, Long def) {
        return def == null ? Long.valueOf(Long.parseLong(spinner.getSelectedItem().toString())) : def;
    }

    @Override
    public void onAccept() {
        if (Utils.checkEditTexts(mStartDateTextInputEditText)) {

            final String startDate = Objects.requireNonNull(mStartDateTextInputEditText.getText()).toString();

            try {
                Long priority = null;

                try {
                    priority = getPriority();
                } catch (Exception ex) {
                    mPriorityTextInputEditText.setError("Prioriatatea este cuprins intre 0 si 10 !");
                    return;
                }

                SessionTask sessionTask = new SessionTask(
                        priority,
                        Objects.requireNonNull(new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).parse(startDate)),
                        conditionalPick(mSessionSpinner, mSessionId),
                        conditionalPick(mTaskSpinner, mTaskId)
                );


                if (mSessionId != null && mTaskId != null) {
                    vm.updateSessionsTasks(sessionTask);
                } else {
                    vm.insertSessionsTasks(sessionTask);
                }

                onCancel();

            } catch (ParseException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Formatul datei introduse este invalid.\nFormatul este: " + Utils.DATE_FORMAT, Toast.LENGTH_LONG)
                        .show();
            }
        }

    }

    private Long getPriority() throws Exception {
        Long priority = null;

        if (Objects.requireNonNull(mPriorityTextInputEditText.getText()).length() > 0) {
            priority = Long.parseLong(mPriorityTextInputEditText.getText().toString());

            if (priority < 0 || priority > 10) {
                throw new Exception("NU E BINE :(");
            }
        }

        return priority;
    }

    @Override
    protected void setArgumentId() {
        if (getArguments() != null) {
            String sessionId = SessionTaskModFragmentArgs.fromBundle(getArguments()).getSessionId();
            String taskId = SessionTaskModFragmentArgs.fromBundle(getArguments()).getTaskId();

            if (sessionId != null) {
                mSessionId = Long.parseLong(sessionId);
            }

            if (taskId != null) {
                mTaskId = Long.parseLong(taskId);
            }

            if (mSessionId != null && mTaskId != null) {
                vm.getSessionTaskByIds(mSessionId, mTaskId).observe(this, sessionMaterial -> {
                    if (sessionMaterial != null) {
                        mSessionLinearLayout.setVisibility(View.GONE);
                        mTaskLinearLayout.setVisibility(View.GONE);
                        mStartDateTextInputEditText.setText(new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).format(sessionMaterial.getInitialDate()));
                        mPrimaryKeyTextView.setText(String.format(Locale.ENGLISH, "PRIMARY KEY: [sessionId = '%d', taskId = '%d']", mSessionId, mTaskId));
                        mPriorityTextInputEditText.setText(sessionMaterial.getPriority() == null ? "" : String.format(Locale.ENGLISH, "%d", sessionMaterial.getPriority()));
                    }
                });
            }
        }
    }

    @Override
    protected void initViews(View itemView) {
        mSessionSpinner = itemView.findViewById(R.id.first_spinner);
        mTaskSpinner = itemView.findViewById(R.id.second_spinner);
        mSessionLinearLayout = itemView.findViewById(R.id.first_linear_layout);
        mPrimaryKeyTextView = itemView.findViewById(R.id.primary_key_text_view);
        mTaskLinearLayout = itemView.findViewById(R.id.second_linear_layout);
        mStartDateTextInputEditText = itemView.findViewById(R.id.first_text_input_edit_text);
        mPriorityTextInputEditText = itemView.findViewById(R.id.second_text_input_edit_text);
    }
}
