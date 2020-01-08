package com.faculty.fusedbloxxer.coachingapp.home.feedbacks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Feedback;

import java.util.ArrayList;
import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackViewHolder> {
    private List<Feedback> mFeedbacks;
    private FeedbackFragment mFragment;

    public FeedbackAdapter(FeedbackFragment mFragment) {
        this.mFragment = mFragment;
        this.mFeedbacks = new ArrayList<>();
    }

    @NonNull
    @Override
    public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feedback, parent, false);
        return new FeedbackViewHolder(itemView, mFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackViewHolder holder, int position) {
        Feedback feedback = mFeedbacks.get(position);
        holder.setConfimedFeedback(feedback.getFeedbackId());
        holder.setSessionId(feedback.getSessionId());
        holder.setTitle(feedback.getTitle());
        holder.setRating(feedback.getRating());
        holder.setContent(feedback.getContent());
        holder.setEmissionDate(feedback.getSentDate());
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.mFeedbacks = feedbacks;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mFeedbacks.size();
    }
}
