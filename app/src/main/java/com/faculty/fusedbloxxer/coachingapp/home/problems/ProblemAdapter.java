package com.faculty.fusedbloxxer.coachingapp.home.problems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Problem;

import java.util.ArrayList;
import java.util.List;

public class ProblemAdapter extends RecyclerView.Adapter<ProblemViewHolder> {
    private List<Problem> problems;
    private INavigable<Long> listener;

    public ProblemAdapter(INavigable<Long> listener) {
        this.listener = listener;
        this.problems = new ArrayList<>();
    }

    @NonNull
    @Override
    public ProblemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_problem, parent, false);
        return new ProblemViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProblemViewHolder holder, int position) {
        Problem problem = problems.get(position);
        holder.setTitle(problem.getTitle());
        holder.setState(problem.getState());
        holder.setId(problem.getProblemId());
        holder.setCoach(problem.getCoachId());
        holder.setClient(problem.getClientId());
        holder.setDescription(problem.getDescription());
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return problems.size();
    }
}
