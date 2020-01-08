package com.faculty.fusedbloxxer.coachingapp.home.locations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder> {
    private List<Location> locationList;
    private INavigable<Long> listener;

    public LocationAdapter(INavigable<Long> listener) {
        this.listener = listener;
        this.locationList = new ArrayList<>();
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_location, parent, false);
        return new LocationViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        Location location = locationList.get(position);
        holder.setLocationAlias(location.getAlias());
        holder.setLocationId(location.getLocationId());
        holder.setLocationImage(location.getImageUrl());
        holder.setLocationStreet(location.getStreet());
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }
}
