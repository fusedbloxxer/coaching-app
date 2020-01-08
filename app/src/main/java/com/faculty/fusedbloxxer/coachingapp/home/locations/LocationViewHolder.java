package com.faculty.fusedbloxxer.coachingapp.home.locations;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

public class LocationViewHolder extends RecyclerView.ViewHolder {
    private TextView mLocationIdTextView, mLocationAliasEditText, mLocationStreetEditText;
    private ImageView mLocationImageView;
    private CardView mCardView;
    private Long mLocationId;

    public LocationViewHolder(@NonNull View itemView, INavigable<Long> listener) {
        super(itemView);
        initViews(itemView);
        mCardView.setOnClickListener(v -> Utils.createItemOptions(itemView.getContext(), listener, mLocationId));
    }

    private void initViews(View itemView) {
        mCardView = itemView.findViewById(R.id.location_card_view);
        mLocationIdTextView = itemView.findViewById(R.id.location_id_text_view);
        mLocationImageView = itemView.findViewById(R.id.location_image_view);
        mLocationAliasEditText = itemView.findViewById(R.id.location_alias_text_view);
        mLocationStreetEditText = itemView.findViewById(R.id.location_street_text_view);
    }

    public void setLocationId(Long locationId) {
        if (locationId != null) {
            mLocationId = locationId;
            mLocationIdTextView.setText(String.format("ID: %d", locationId));
        }
    }

    public void setLocationAlias(String alias) {
        if (alias != null) {
            mLocationAliasEditText.setText(alias);
        } else {
            mLocationAliasEditText.setVisibility(View.GONE);
        }
    }

    public void setLocationStreet(String street) {
        if (street != null) {
            mLocationStreetEditText.setText(street);
        }
    }

    public void setLocationImage(String imageUrl) {
        if (imageUrl != null) {
            Glide.with(mLocationImageView.getContext())
                    .load(imageUrl)
                    .fitCenter()
                    .into(mLocationImageView);
        }
    }
}
