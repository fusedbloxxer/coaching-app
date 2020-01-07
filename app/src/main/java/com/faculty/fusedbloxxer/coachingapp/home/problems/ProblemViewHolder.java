package com.faculty.fusedbloxxer.coachingapp.home.problems;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

public class ProblemViewHolder extends RecyclerView.ViewHolder {
    private TextView titleText, idText, descText, stateText, coachText, clientText;
    private CardView cardView;

    public ProblemViewHolder(@NonNull View itemView, INavigable<Long> listener) {
        super(itemView);
        initView(itemView);
        cardView.setOnClickListener(v -> Utils.createItemOptions(itemView.getContext(), listener, (Long) idText.getTag()));
    }

    private void initView(View itemView) {
        cardView = itemView.findViewById(R.id.problem_card_view);
        idText = itemView.findViewById(R.id.problem_id_text_view);
        stateText = itemView.findViewById(R.id.problem_state_text_view);
        coachText = itemView.findViewById(R.id.problem_coach_text_view);
        titleText = itemView.findViewById(R.id.problem_title_text_view);
        clientText = itemView.findViewById(R.id.problem_client_text_view);
        descText = itemView.findViewById(R.id.problem_description_text_view);
    }

    public void setTitle(String title) {
        if (title != null) {
            titleText.setText(title);
        }
    }

    public void setId(Long id) {
        if (id != null) {
            idText.setText("ID: " + id);
            idText.setTag(id);
        }
    }

    public void setDescription(String description) {
        if (description != null) {
            descText.setText(description);
        }
    }

    public void setState(String state) {
        if (state != null) {
            stateText.setText("Stare problema: " + state);
        }
    }

    public void setCoach(String coach) {
        if (coach != null) {
            coachText.setText("Coach: " + coach);
            coachText.setTag(coach);
        }
    }

    public void setClient(String client) {
        if (client != null) {
            clientText.setText("Client: " + client);
            clientText.setTag(client);
        }
    }
}
