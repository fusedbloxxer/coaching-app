package com.faculty.fusedbloxxer.coachingapp.home.sessionsmaterials;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.SessionMaterial;
import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;

import java.util.ArrayList;
import java.util.List;

public class SessionMaterialAdapter extends RecyclerView.Adapter<SessionMaterialViewHolder> {
    private List<SessionMaterial> sessionMaterials;
    private INavigable<Pair<Long, Long>> listener;

    public SessionMaterialAdapter(INavigable<Pair<Long, Long>> listener) {
        this.listener = listener;
        this.sessionMaterials = new ArrayList<>();
    }

    @NonNull
    @Override
    public SessionMaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sessions_materials, parent, false);
        return new SessionMaterialViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionMaterialViewHolder holder, int position) {
        SessionMaterial sessionMaterial = sessionMaterials.get(position);
        holder.setMaterialId(sessionMaterial.getMaterialId());
        holder.setSessionId(sessionMaterial.getSessionId());
        holder.setTime(sessionMaterial.getAvailableTime());
        holder.setDate(sessionMaterial.getInitialDate());
    }

    public void setSessionMaterials(List<SessionMaterial> sessionMaterials) {
        this.sessionMaterials = sessionMaterials;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return sessionMaterials.size();
    }
}
