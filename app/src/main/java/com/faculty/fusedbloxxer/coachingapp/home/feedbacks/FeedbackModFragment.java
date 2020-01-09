package com.faculty.fusedbloxxer.coachingapp.home.feedbacks;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.ModFragment;
import com.faculty.fusedbloxxer.coachingapp.databinding.FeedbackModLayoutBinding;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Feedback;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

import java.util.Date;
import java.util.stream.Collectors;

public class FeedbackModFragment extends ModFragment {
    private TextView mDateTextView, mSessionTextView, mFeedbackIdTextView;
    private EditText mTitleEditText, mContentEditText;
    private Long mFeedbackId, mSessionId;
    private Spinner mSessionSpinner;
    private RatingBar mRatingBar;

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
        if (Utils.checkEditTexts(mTitleEditText, mContentEditText)) {
            final Feedback feedback = new Feedback(
                    new Date(),
                    mRatingBar.getRating(),
                    mContentEditText.getText().toString(),
                    mTitleEditText.getText().toString(),
                    Long.parseLong(mSessionSpinner.getSelectedItem().toString())
            );

            if (mFeedbackId != null) {
                feedback.setFeedbackId(mFeedbackId);
                vm.updateFeedbacks(feedback);
            } else {
                vm.insertFeedbacks(feedback);
            }

            onCancel();
        }
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void setArgumentId() {
        if (getArguments() != null) {
            String feedbackId = FeedbackModFragmentArgs.fromBundle(getArguments()).getFeedbackId();
            if (feedbackId != null) {
                mFeedbackId = Long.parseLong(feedbackId);
                vm.getFeedbackById(mFeedbackId).observe(this, feedback -> {
                    mRatingBar.setRating(feedback.getRating());
                    mTitleEditText.setText(feedback.getTitle());
                    mContentEditText.setText(feedback.getContent());
                    mFeedbackIdTextView.setText(String.format("Id feedback: %d", mFeedbackId));
                    mDateTextView.setText(String.format("A fost emis la data %s", feedback.getFormattedDate()));
                    mSessionTextView.setText(String.format("Id sedinta originala: %d", mSessionId = feedback.getSessionId()));
                });
            }
        }

        vm.getIdsForSessionsWithoutFeedback().observe(this, sessions -> {
            if (mSessionId != null) {
                sessions.add(mSessionId);
            }
            mSessionSpinner.setAdapter(new ArrayAdapter<>(mSessionSpinner.getContext(), android.R.layout.simple_spinner_dropdown_item,
                    sessions.parallelStream().map(Object::toString).collect(Collectors.toList())));
        });
    }

    @Override
    protected void initViews(View itemView) {
        mRatingBar = itemView.findViewById(R.id.feedback_rating_bar);
        mFeedbackIdTextView = itemView.findViewById(R.id.feedback_id_text_view);
        mTitleEditText = itemView.findViewById(R.id.feedback_title_edit_text);
        mSessionSpinner = itemView.findViewById(R.id.feedback_session_spinner);
        mContentEditText = itemView.findViewById(R.id.feedback_content_edit_text);
        mDateTextView = itemView.findViewById(R.id.feedback_emission_date_text_view);
        mSessionTextView = itemView.findViewById(R.id.feedback_original_session_id_text_view);
    }
}
