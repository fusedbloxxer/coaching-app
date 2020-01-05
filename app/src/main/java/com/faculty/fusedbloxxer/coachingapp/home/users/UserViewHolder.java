package com.faculty.fusedbloxxer.coachingapp.home.users;

import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private TextView usernameTextView, fullNameTextView, emailTextView, passTextView, roleTextView;
    private CardView cardView;

    public UserViewHolder(@NonNull View itemView, INavigable<String> listener) {
        super(itemView);
        initViews(itemView);
        cardView.setOnClickListener(view -> Utils.createItemOptions(view.getContext(), listener, usernameTextView.getTag().toString()));
    }

    private void initViews(View itemView) {
        cardView = itemView.findViewById(R.id.user_card_view);
        usernameTextView = itemView.findViewById(R.id.username_textView);
        fullNameTextView = itemView.findViewById(R.id.full_name_textView);
        emailTextView = itemView.findViewById(R.id.email_textView);
        passTextView = itemView.findViewById(R.id.user_password_textView);
        roleTextView = itemView.findViewById(R.id.user_role_textView);
    }

    public void setUsername(String username) {
        if (username != null) {
            usernameTextView.setText("Utilizator: " + username);
            usernameTextView.setTag(username);
        }
    }

    public void setFullName(String fullName) {
        if (fullName != null) {
            fullNameTextView.setText("Nume: " + fullName);
        }
    }

    public void setEmail(String email) {
        if (email != null) {
            emailTextView.setText("Email: " + email);
        } else {
            emailTextView.setText("Email:");
        }
    }

    public void setPassword(String password) {
        if (password != null) {
            passTextView.setText("Parola: " + password);
        }
    }

    public void setRole(String role) {
        if (role != null) {
            roleTextView.setText("Rol: " + role);
        }
    }
}
