package com.faculty.fusedbloxxer.coachingapp.home.feedbacks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.faculty.fusedbloxxer.coachingapp.core.ModFragment;
import com.faculty.fusedbloxxer.coachingapp.databinding.FeedbackModLayoutBinding;

public class FeedbackModFragment extends ModFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FeedbackModLayoutBinding feedbackModLayoutBinding = FeedbackModLayoutBinding
                .inflate(inflater, container, false);
        feedbackModLayoutBinding.setFragment(this);
        return feedbackModLayoutBinding.getRoot();
    }

    @Override
    public void onAccept() {

    }

    @Override
    protected void setArgumentId() {

    }

    @Override
    protected void initViews(View itemView) {

    }
}
