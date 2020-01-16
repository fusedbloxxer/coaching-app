package com.faculty.fusedbloxxer.coachingapp.home.userswithroles;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

public class UserWithRoleViewHolder extends RecyclerView.ViewHolder {
    private TextView mRoleTextView, mUsernameTextView, mFullNameTextView;
    private ImageView mRoleImageView;

    public UserWithRoleViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mRoleImageView = itemView.findViewById(R.id.user_with_role_image_view);
        mRoleTextView = itemView.findViewById(R.id.user_with_role_id_text_view);
        mUsernameTextView = itemView.findViewById(R.id.user_with_role_username_text_view);
        mFullNameTextView = itemView.findViewById(R.id.user_with_role_first_last_name_text_view);
    }

    public void setRoleId(String roleId) {
        if (roleId != null) {
            mRoleTextView.setText(Utils.capitalize(roleId));
        }
    }

    public void setUsername(String username) {
        if (username != null) {
            mUsernameTextView.setText(username);
        }
    }

    public void setFullName(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            mFullNameTextView.setText(String.format("%s %s", Utils.capitalize(firstName), Utils.capitalize(lastName)));
        }
    }

    public void setImage(String imageUrl) {
        if (imageUrl != null) {
            Glide.with(mRoleImageView.getContext())
                    .load(imageUrl)
                    .fitCenter()
                    .into(mRoleImageView);
        }
    }
}
