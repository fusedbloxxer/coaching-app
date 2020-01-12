package com.faculty.fusedbloxxer.coachingapp.home.sessions;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SessionViewHolder extends RecyclerView.ViewHolder {
    private TextView mDateTextView, mDiscTextView, mSessionIdTextView, mLocationIdTextView, mProblemIdTextView;
    private CardView mCardView;

    public SessionViewHolder(@NonNull View itemView, INavigable<Long> listener) {
        super(itemView);
        initViews(itemView);
        mCardView.setOnClickListener(v ->
                Utils.createItemOptions(v.getContext(), listener, (Long) mSessionIdTextView.getTag()));
    }

    private void initViews(View itemView) {
        mCardView = itemView.findViewById(R.id.session_card_view);
        mDateTextView = itemView.findViewById(R.id.sessions_date_text_view);
        mSessionIdTextView = itemView.findViewById(R.id.session_id_text_view);
        mDiscTextView = itemView.findViewById(R.id.session_description_text_view);
        mProblemIdTextView = itemView.findViewById(R.id.session_problem_id_text_view);
        mLocationIdTextView = itemView.findViewById(R.id.session_id_location_text_view);
    }

    public void setDate(Date date) {
        if (date != null) {
            mDateTextView.setText(new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).format(date));
        }
    }

    public void setDiscussion(String discussion) {
        if (discussion != null) {
            mDiscTextView.setText(discussion);
        }
    }

    public void setSessionId(Long sessionId) {
        if (sessionId != null) {
            mSessionIdTextView.setTag(sessionId);
            mSessionIdTextView.setText(String.format(Locale.ENGLISH, "Id sesiune: %d", sessionId));
        }
    }

    public void setLocationId(Long locationId) {
        if (locationId != null) {
            mLocationIdTextView.setVisibility(View.VISIBLE);
            mLocationIdTextView.setText(String.format(Locale.ENGLISH, "Id locatie: %d", locationId));
        } else {
            mLocationIdTextView.setVisibility(View.GONE);
        }
    }

    public void setProblemId(Long problemId) {
        if (problemId != null) {
            mProblemIdTextView.setText(String.format(Locale.ENGLISH, "Id problema: %d", problemId));
        }
    }

}
