package com.faculty.fusedbloxxer.coachingapp.home.bestcoaches;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.model.db.containers.CoachWithScores;

import java.util.ArrayList;
import java.util.List;

public class BestCoachesAdapter extends RecyclerView.Adapter<BestCoachesViewHolder> {
    private List<CoachWithScores> coachWithScoresList;

    public BestCoachesAdapter() {
        this.coachWithScoresList = new ArrayList<>();
    }

    @NonNull
    @Override
    public BestCoachesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_best_coaches, parent, false);
        return new BestCoachesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestCoachesViewHolder holder, int position) {
        CoachWithScores coachWithScores = coachWithScoresList.get(position);
        holder.setName(coachWithScores.getCoachName());
        holder.setAvg(coachWithScores.getAvgScore());
        holder.setMax(coachWithScores.getMaxScore());
    }

    public void setCoachWithScoresList(List<CoachWithScores> coachWithScoresList) {
        this.coachWithScoresList = coachWithScoresList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return coachWithScoresList.size();
    }
}
