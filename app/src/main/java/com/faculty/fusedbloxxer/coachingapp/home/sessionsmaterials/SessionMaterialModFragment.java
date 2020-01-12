package com.faculty.fusedbloxxer.coachingapp.home.sessionsmaterials;

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
import com.faculty.fusedbloxxer.coachingapp.databinding.SessionsMaterialsModLayoutBinding;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.SessionMaterial;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class SessionMaterialModFragment extends ModFragment {
    private TextInputEditText mStartDateTextInputEditText, mAvailableTimeTextInputEditText;
    private LinearLayout mSessionLinearLayout, mMaterialLinearLayout;
    private Spinner mSessionSpinner, mMaterialSpinner;
    private TextView mPrimaryKeyTextView;
    private Long mSessionId, mMaterialId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SessionsMaterialsModLayoutBinding sessionsMaterialsModLayoutBinding = SessionsMaterialsModLayoutBinding
                .inflate(inflater, container, false);
        sessionsMaterialsModLayoutBinding.setFragment(this);
        return sessionsMaterialsModLayoutBinding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
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
        vm.getAllMaterials().observe(this, materials ->
                mMaterialSpinner.setAdapter(
                        new ArrayAdapter<>(
                                Objects.requireNonNull(getContext()),
                                android.R.layout.simple_spinner_dropdown_item,
                                materials.stream()
                                        .map(material -> material.getMaterialId().toString())
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
            Long availableTime = getAvailableTime();

            final String startDate = Objects.requireNonNull(mStartDateTextInputEditText.getText()).toString();

            try {
                final SessionMaterial sessionMaterial = new SessionMaterial(
                        availableTime,
                        Objects.requireNonNull(new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).parse(startDate)),
                        conditionalPick(mSessionSpinner, mSessionId),
                        conditionalPick(mMaterialSpinner, mMaterialId)
                );

                if (mSessionId != null && mMaterialId != null) {
                    vm.updateSessionsMaterials(sessionMaterial);
                } else {
                    vm.insertSessionsMaterials(sessionMaterial);
                }

                onCancel();

            } catch (ParseException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Formatul datei introduse este invalid.\nFormatul este: " + Utils.DATE_FORMAT, Toast.LENGTH_LONG)
                        .show();
            }
        }
    }

    private Long getAvailableTime() {
        Long availableTime = null;

        if (Objects.requireNonNull(mAvailableTimeTextInputEditText.getText()).length() > 0) {
            availableTime = Long.parseLong(mAvailableTimeTextInputEditText.getText().toString());

            if (availableTime < 0) {
                mAvailableTimeTextInputEditText.setError("Timpul nu poate fi negativ !");
                throw new RuntimeException("E negativ !!!! NU E BINE :(");
            }
        }

        return availableTime;
    }

    @Override
    protected void setArgumentId() {
        if (getArguments() != null) {
            String sessionId = SessionMaterialModFragmentArgs.fromBundle(getArguments()).getSessionId();
            String materialId = SessionMaterialModFragmentArgs.fromBundle(getArguments()).getMaterialId();

            if (sessionId != null) {
                mSessionId = Long.parseLong(sessionId);
            }

            if (materialId != null) {
                mMaterialId = Long.parseLong(materialId);
            }

            if (mSessionId != null && mMaterialId != null) {
                vm.getSessionMaterialByIds(mSessionId, mMaterialId).observe(this, sessionMaterial -> {
                    if (sessionMaterial != null) {
                        mSessionLinearLayout.setVisibility(View.GONE);
                        mMaterialLinearLayout.setVisibility(View.GONE);
                        mStartDateTextInputEditText.setText(new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).format(sessionMaterial.getInitialDate()));
                        mPrimaryKeyTextView.setText(String.format(Locale.ENGLISH, "PRIMARY KEY: [sessionId = '%d', materialId = '%d']", mSessionId, mMaterialId));
                        mAvailableTimeTextInputEditText.setText(sessionMaterial.getAvailableTime() == null ? "" : String.format(Locale.ENGLISH, "%d", sessionMaterial.getAvailableTime()));
                    }
                });
            }
        }
    }

    @Override
    protected void initViews(View itemView) {
        mSessionSpinner = itemView.findViewById(R.id.first_spinner);
        mMaterialSpinner = itemView.findViewById(R.id.second_spinner);
        mSessionLinearLayout = itemView.findViewById(R.id.first_linear_layout);
        mPrimaryKeyTextView = itemView.findViewById(R.id.primary_key_text_view);
        mMaterialLinearLayout = itemView.findViewById(R.id.second_linear_layout);
        mStartDateTextInputEditText = itemView.findViewById(R.id.first_text_input_edit_text);
        mAvailableTimeTextInputEditText = itemView.findViewById(R.id.second_text_input_edit_text);
    }
}
