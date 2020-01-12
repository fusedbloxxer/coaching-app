package com.faculty.fusedbloxxer.coachingapp.home.sessionstasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.SessionTask;
import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;

import java.util.ArrayList;
import java.util.List;

public class SessionTaskAdapter extends RecyclerView.Adapter<SessionTaskViewHolder> {
    private List<SessionTask> sessionTasks;
    private INavigable<Pair<Long, Long>> listener;

    public SessionTaskAdapter(INavigable<Pair<Long, Long>> listener) {
        this.listener = listener;
        this.sessionTasks = new ArrayList<>();
    }

    @NonNull
    @Override
    public SessionTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sessions_tasks, parent, false);
        return new SessionTaskViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionTaskViewHolder holder, int position) {
        SessionTask sessionTask = sessionTasks.get(position);
        holder.setSessionId(sessionTask.getSessionId());
        holder.setDate(sessionTask.getInitialDate());
        holder.setPriority(sessionTask.getPriority());
        holder.setTaskId(sessionTask.getTaskId());
    }

    public void setSessionTasks(List<SessionTask> sessionTasks) {
        this.sessionTasks = sessionTasks;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return sessionTasks.size();
    }
}
