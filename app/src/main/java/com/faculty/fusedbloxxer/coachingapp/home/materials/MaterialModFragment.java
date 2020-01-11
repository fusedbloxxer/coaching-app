package com.faculty.fusedbloxxer.coachingapp.home.materials;

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
import com.faculty.fusedbloxxer.coachingapp.databinding.MaterialModLayoutBinding;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Material;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

public class MaterialModFragment extends ModFragment {
    private Long mMaterialId;
    private TextView mIdTextView;
    private EditText mTitleEditText, mSourceEditText, mImageEditText, mSummaryEditText, mTimeEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MaterialModLayoutBinding materialModLayoutBinding = MaterialModLayoutBinding
                .inflate(inflater, container, false);
        materialModLayoutBinding.setFragment(this);
        return materialModLayoutBinding.getRoot();
    }

    @Override
    public void onAccept() {
        if (Utils.checkEditTexts(mSourceEditText, mTitleEditText)) {
            try {

                final Material material = new Material(
                        mTimeEditText.getText().length() > 0 ? Long.parseLong(mTimeEditText.getText().toString()) : null,
                        mSummaryEditText.getText().toString(),
                        mImageEditText.getText().length() > 0 ? mImageEditText.getText().toString() : null,
                        mSourceEditText.getText().toString(),
                        mTitleEditText.getText().toString()
                );


                if (mMaterialId != null) {
                    material.setMaterialId(mMaterialId);
                    vm.updateMaterials(material);
                } else {
                    vm.insertMaterials(material);
                }

                onCancel();

            } catch (Exception ex) {
                Toast.makeText(mTimeEditText.getContext(), "Something went wrong . . .", Toast.LENGTH_LONG)
                        .show();
            }
        }
    }

    @Override
    protected void setArgumentId() {
        if (getArguments() != null) {
            String materialId = MaterialModFragmentArgs.fromBundle(getArguments()).getMaterialId();
            if (materialId != null) {
                mMaterialId = Long.parseLong(materialId);
            }
        }

        if (mMaterialId != null) {
            vm.getMaterialWithId(mMaterialId).observe(this, material -> {
                mTitleEditText.setText(material.getTitle());
                mSourceEditText.setText(material.getSourceUrl());
                mIdTextView.setText(String.format("ID: %d", material.getMaterialId()));

                if (material.getImageUrl() != null) {
                    mImageEditText.setText(material.getImageUrl());
                }

                if (material.getSummary() != null) {
                    mSummaryEditText.setText(material.getSummary());
                }

                if (material.getEstimatedTime() != null) {
                    mTimeEditText.setText(material.getEstimatedTime() + "");
                }
            });
        }
    }

    @Override
    protected void initViews(View itemView) {
        mIdTextView = itemView.findViewById(R.id.material_id_text_view);
        mTimeEditText = itemView.findViewById(R.id.material_time_edit_text);
        mImageEditText = itemView.findViewById(R.id.material_image_edit_text);
        mTitleEditText = itemView.findViewById(R.id.material_title_edit_text);
        mSourceEditText = itemView.findViewById(R.id.material_source_edit_text);
        mSummaryEditText = itemView.findViewById(R.id.material_summary_edit_text);
    }
}
