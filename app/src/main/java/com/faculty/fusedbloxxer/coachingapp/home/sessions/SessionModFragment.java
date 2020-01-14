package com.faculty.fusedbloxxer.coachingapp.home.sessions;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.ModFragment;
import com.faculty.fusedbloxxer.coachingapp.databinding.SessionModLayoutBinding;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Session;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class SessionModFragment extends ModFragment {
    private TextInputEditText mDateInputEditText, mDiscussionInputEditText;
    private TextView mSessionIdTextView, mFirstTextview, mSecondTextView;
    private Spinner mProblemSpinner, mLocationSpinner;
    private Long mSessionId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SessionModLayoutBinding sessionModLayoutBinding = SessionModLayoutBinding
                .inflate(inflater, container, false);
        sessionModLayoutBinding.setFragment(this);
        return sessionModLayoutBinding.getRoot();
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vm.getAllProblems().observe(this, problems -> mProblemSpinner.setAdapter(
                new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_dropdown_item,
                        problems.stream().map(s -> s.getProblemId().toString()).collect(Collectors.toList())))
        );

        vm.getAllLocations().observe(this, locations -> {
                    final List<String> strings = locations.stream()
                            .map(s -> s.getLocationId().toString())
                            .collect(Collectors.toList());

                    strings.add("(null)");

                    mLocationSpinner.setAdapter(
                            new ArrayAdapter<>(
                                    Objects.requireNonNull(getContext()),
                                    android.R.layout.simple_spinner_dropdown_item,
                                    strings
                            )
                    );
                }
        );
    }

    @Override
    public void onAccept() {
        if (Utils.checkEditTexts(mDateInputEditText, mDiscussionInputEditText)) {
            try {

                Long locationId = null;

                if (!mLocationSpinner.getSelectedItem().toString().equals("(null)")) {
                    locationId = Long.parseLong(mLocationSpinner.getSelectedItem().toString());
                }

                final Session session = new Session(
                        Objects.requireNonNull(mDiscussionInputEditText.getText()).toString(),
                        Objects.requireNonNull(new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).parse(Objects.requireNonNull(mDateInputEditText.getText()).toString())),
                        Long.parseLong(mProblemSpinner.getSelectedItem().toString()),
                        locationId
                );

                if (mSessionId != null) {
                    session.setSessionId(mSessionId);
                    vm.updateSessions(session);
                } else {
                    vm.insertSessions(session);
                }

                onCancel();

            } catch (ParseException e) {
                mDateInputEditText.setError("Formatul datei introduse este invalid.\nFormatul este: " + Utils.DATE_FORMAT);
                e.printStackTrace();
            }
        }
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void setArgumentId() {
        if (getArguments() != null) {
            String sessionId = SessionModFragmentArgs.fromBundle(getArguments()).getSessionId();

            if (sessionId != null) {
                mSessionId = Long.parseLong(sessionId);
                vm.getSessionWithId(mSessionId).observe(this, session -> {
                    if (session != null) {
                        mDiscussionInputEditText.setText(session.getDiscussion());
                        mSessionIdTextView.setText(String.format(Locale.ENGLISH, "ID: %d", session.getSessionId()));
                        mDateInputEditText.setText(new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).format(session.getStartDate()));
                        mFirstTextview.setText(String.format(Locale.ENGLISH, "Alegeti o problema:\n(Actual: %d)", session.getProblemId()));

                        if (session.getLocationId() != null) {
                            mSecondTextView.setText(String.format(Locale.ENGLISH, "Alegeti o locatie:\n(Actual: %d)", session.getLocationId()));
                        }
                    }
                });
            }
        }
    }

    @Override
    protected void initViews(View itemView) {
        mDiscussionInputEditText = itemView.findViewById(R.id.second_text_input_edit_text);
        mDateInputEditText = itemView.findViewById(R.id.first_text_input_edit_text);
        mSessionIdTextView = itemView.findViewById(R.id.primary_key_text_view);
        mSecondTextView = itemView.findViewById(R.id.second_text_view);
        mLocationSpinner = itemView.findViewById(R.id.second_spinner);
        mFirstTextview = itemView.findViewById(R.id.first_text_view);
        mProblemSpinner = itemView.findViewById(R.id.first_spinner);
    }
}
