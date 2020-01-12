package com.faculty.fusedbloxxer.coachingapp.home.sessionsmaterials;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SessionMaterialViewHolder extends RecyclerView.ViewHolder {
    private TextView mDateTextView, mTimeTextView, mSessionIdTextView, mMaterialIdTextView;
    private CardView mCardView, mTimeCardView;

    public SessionMaterialViewHolder(@NonNull View itemView, INavigable<Pair<Long, Long>> listener) {
        super(itemView);
        initViews(itemView);
        mCardView.setOnClickListener(v -> Utils.createItemOptions(v.getContext(), listener, new Pair<>(
                (Long) mSessionIdTextView.getTag(),
                (Long) mMaterialIdTextView.getTag()
        )));
    }

    private void initViews(View itemView) {
        mCardView = itemView.findViewById(R.id.session_card_view);
        mTimeCardView = itemView.findViewById(R.id.session_materials_time_card_view);
        mTimeTextView = itemView.findViewById(R.id.session_materials_time_text_view);
        mDateTextView = itemView.findViewById(R.id.sessions_materials_date_text_view);
        mSessionIdTextView = itemView.findViewById(R.id.sessions_materials_id_session_text_view);
        mMaterialIdTextView = itemView.findViewById(R.id.sessions_materials_id_material_text_view);
    }

    public void setDate(Date date) {
        if (date != null) {
            mDateTextView.setText(new SimpleDateFormat(Utils.DATE_FORMAT, Locale.ENGLISH).format(date));
        }
    }

    public void setTime(Long time) {
        if (time != null) {
            mTimeCardView.setVisibility(View.VISIBLE);
            mTimeTextView.setText(String.format(Locale.ENGLISH, "Timp disponibil: %s minute", time));
        } else {
            mTimeCardView.setVisibility(View.GONE);
        }
    }

    public void setSessionId(Long sessionId) {
        if (sessionId != null) {
            mSessionIdTextView.setTag(sessionId);
            mSessionIdTextView.setText(String.format(Locale.ENGLISH, "Id sedinta: %d", sessionId));
        }
    }

    public void setMaterialId(Long materialId) {
        if (materialId != null) {
            mMaterialIdTextView.setTag(materialId);
            mMaterialIdTextView.setText(String.format(Locale.ENGLISH, "Id material: %d", materialId));
        }
    }
}
