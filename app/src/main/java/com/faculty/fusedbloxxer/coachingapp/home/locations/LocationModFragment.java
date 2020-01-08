package com.faculty.fusedbloxxer.coachingapp.home.locations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.ModFragment;
import com.faculty.fusedbloxxer.coachingapp.databinding.LocationModLayoutBinding;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Location;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

public class LocationModFragment extends ModFragment {
    private EditText mLocationAliasEditText, mLocationStreetEditText, mLocationImageUrlEditText;
    private TextView mLocationIdTextView;
    private Long mLocationId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LocationModLayoutBinding locationModLayoutBinding = LocationModLayoutBinding
                .inflate(inflater, container, false);
        locationModLayoutBinding.setFragment(this);
        return locationModLayoutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAccept() {
        if (Utils.checkEditTexts(mLocationStreetEditText, mLocationImageUrlEditText)) {
            final Location location = new Location(
                    mLocationImageUrlEditText.getText().toString(),
                    mLocationStreetEditText.getText().toString(),
                    mLocationAliasEditText.getText().length() == 0 ? null : mLocationAliasEditText.getText().toString()
            );

            if (mLocationId != null) {
                location.setLocationId(mLocationId);
                vm.updateLocations(location);
            } else {
                vm.insertLocations(location);
            }

            onCancel();
        }
    }

    @Override
    protected void setArgumentId() {
        if (getArguments() != null) {
            String locationId = LocationModFragmentArgs.fromBundle(getArguments()).getLocationId();
            mLocationId = locationId == null ? null : Long.parseLong(locationId);
        }

        if (mLocationId != null) {
            mLocationIdTextView.setVisibility(View.VISIBLE);
            mLocationIdTextView.setText("ID: " + mLocationId);
            vm.getLocationById(mLocationId).observe(this, location -> {
                mLocationImageUrlEditText.setText(location.getImageUrl());
                mLocationStreetEditText.setText(location.getStreet());
                mLocationAliasEditText.setText(location.getAlias());
            });
        }
    }

    @Override
    protected void initViews(View itemView) {
        mLocationIdTextView = itemView.findViewById(R.id.location_id_text_view);
        mLocationAliasEditText = itemView.findViewById(R.id.location_alias_edit_text);
        mLocationStreetEditText = itemView.findViewById(R.id.location_street_edit_text);
        mLocationImageUrlEditText = itemView.findViewById(R.id.location_image_url_edit_text);
    }
}
