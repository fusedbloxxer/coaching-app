package com.faculty.fusedbloxxer.coachingapp.home.sessions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Session;

import java.util.ArrayList;
import java.util.List;

public class SessionAdapter extends RecyclerView.Adapter<SessionViewHolder> {
    private List<Session> sessionList;
    private INavigable<Long> listener;

    public SessionAdapter(INavigable<Long> listener) {
        this.listener = listener;
        this.sessionList = new ArrayList<>();
    }

    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_session, parent, false);
        return new SessionViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionViewHolder holder, int position) {
        Session session = sessionList.get(position);
        holder.setDiscussion(session.getDiscussion());
        holder.setLocationId(session.getLocationId());
        holder.setProblemId(session.getProblemId());
        holder.setSessionId(session.getSessionId());
        holder.setDate(session.getStartDate());
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return sessionList.size();
    }
}
