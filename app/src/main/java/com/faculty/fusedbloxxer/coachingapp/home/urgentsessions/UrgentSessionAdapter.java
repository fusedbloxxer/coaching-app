package com.faculty.fusedbloxxer.coachingapp.home.urgentsessions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.model.db.containers.UrgentSession;

import java.util.ArrayList;
import java.util.List;

public class UrgentSessionAdapter extends RecyclerView.Adapter<UrgentSessionViewHolder> {
    private List<UrgentSession> urgentSessions;

    public UrgentSessionAdapter() {
        this.urgentSessions = new ArrayList<>();
    }

    @NonNull
    @Override
    public UrgentSessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_urgent_session, parent, false);
        return new UrgentSessionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UrgentSessionViewHolder holder, int position) {
        UrgentSession urgentSession = urgentSessions.get(position);
        holder.setDescription(urgentSession.getSessionDescription());
        holder.setLocationImageUrl(urgentSession.getImageUrl());
        holder.setProblem(urgentSession.getProblemTitle());
        holder.setSession(urgentSession.getSessionTitle());
        holder.setReward(urgentSession.getRewardPoints());
        holder.setTime(urgentSession.getEstimatedTime());
        holder.setPriority(urgentSession.getPriority());
        holder.setStreet(urgentSession.getStreet());
        holder.setUser(urgentSession.getUsername());
    }

    public void setUrgentSessions(List<UrgentSession> urgentSessions) {
        this.urgentSessions = urgentSessions;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return urgentSessions.size();
    }
}
