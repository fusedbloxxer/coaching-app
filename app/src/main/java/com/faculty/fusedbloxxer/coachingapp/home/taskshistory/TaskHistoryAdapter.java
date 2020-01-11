package com.faculty.fusedbloxxer.coachingapp.home.taskshistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.TaskHistory;
import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;

import java.util.ArrayList;
import java.util.List;

public class TaskHistoryAdapter extends RecyclerView.Adapter<TaskHistoryViewHolder> {
    private List<TaskHistory> taskHistoryList;
    private INavigable<Pair<Long, Long>> listener;

    public TaskHistoryAdapter(INavigable<Pair<Long, Long>> listener) {
        this.listener = listener;
        this.taskHistoryList = new ArrayList<>();
    }

    @NonNull
    @Override
    public TaskHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task_history, parent, false);
        return new TaskHistoryViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHistoryViewHolder holder, int position) {
        TaskHistory taskHistory = taskHistoryList.get(position);
        holder.setRating(taskHistory.getConfidenceRating());
        holder.setDate(taskHistory.getCompletionDate());
        holder.setCommentary(taskHistory.getComment());
        holder.setTaskId(taskHistory.getTaskId());
    }

    public void setTaskHistoryList(List<TaskHistory> taskHistoryList) {
        this.taskHistoryList = taskHistoryList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return taskHistoryList.size();
    }
}
