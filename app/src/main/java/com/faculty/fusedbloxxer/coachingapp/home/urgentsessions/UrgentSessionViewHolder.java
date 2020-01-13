package com.faculty.fusedbloxxer.coachingapp.home.urgentsessions;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.faculty.fusedbloxxer.coachingapp.R;

import java.util.Locale;

public class UrgentSessionViewHolder extends RecyclerView.ViewHolder {
    private TextView mTimeTextView, mStreetTextView, mProblemTextView, mSessionTextView,
            mDescriptionTextView, mRewardTextView, mPriorityTextView, mUserTextView;
    private ImageView mLocationImageView;

    public UrgentSessionViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mDescriptionTextView = itemView.findViewById(R.id.description_text_view);
        mTimeTextView = itemView.findViewById(R.id.estimated_time_text_view);
        mLocationImageView = itemView.findViewById(R.id.location_image_view);
        mPriorityTextView = itemView.findViewById(R.id.priority_text_view);
        mSessionTextView = itemView.findViewById(R.id.session_text_view);
        mProblemTextView = itemView.findViewById(R.id.problem_text_view);
        mStreetTextView = itemView.findViewById(R.id.street_text_view);
        mRewardTextView = itemView.findViewById(R.id.reward_text_view);
        mUserTextView = itemView.findViewById(R.id.user_text_view);
    }

    public void setTime(Long time) {
        if (time != null) {
            mTimeTextView.setText(String.format(Locale.ENGLISH, "%d min", time));
        }
    }

    public void setStreet(String street) {
        if (street != null) {
            mStreetTextView.setText(street);
        }
    }

    public void setProblem(String problem) {
        if (problem != null) {
            mProblemTextView.setText(problem);
        }
    }

    public void setSession(String session) {
        if (session != null) {
            mSessionTextView.setText(session);
        }
    }

    public void setDescription(String description) {
        if (description != null) {
            mDescriptionTextView.setText(description);
        }
    }

    public void setReward(Long reward) {
        if (reward != null) {
            mRewardTextView.setText(String.format(Locale.ENGLISH, "Premiu: %dp", reward));
        }
    }

    public void setPriority(Long priority) {
        if (priority != null) {
            mPriorityTextView.setText(String.format(Locale.ENGLISH, "Prioritate: %d", priority));
        }
    }

    public void setLocationImageUrl(String imageUrl) {
        if (imageUrl != null) {
            Glide.with(mLocationImageView.getContext())
                    .load(imageUrl)
                    .centerCrop()
                    .into(mLocationImageView);
        }
    }

    public void setUser(String user) {
        if (user != null) {
            mUserTextView.setText(String.format(Locale.ENGLISH, "Utilizator: %s", user));
        }
    }
}
