package com.faculty.fusedbloxxer.coachingapp.home.userswithroles;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.model.db.views.UserWithRole;

import java.util.ArrayList;
import java.util.List;

public class UserWithRoleAdapter extends RecyclerView.Adapter<UserWithRoleViewHolder> {
    private List<UserWithRole> userWithRoleList;

    public UserWithRoleAdapter() {
        this.userWithRoleList = new ArrayList<>();
    }

    @NonNull
    @Override
    public UserWithRoleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_with_role, parent, false);
        return new UserWithRoleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserWithRoleViewHolder holder, int position) {
        UserWithRole userWithRole = userWithRoleList.get(position);
        holder.setFullName(userWithRole.getUser().getFirstName(), userWithRole.getUser().getLastName());
        holder.setUsername(userWithRole.getUser().getUsername());
        holder.setImage(userWithRole.getRole().getUrlImage());
        holder.setRoleId(userWithRole.getRole().getIdRole());
    }

    public void setUserWithRoleList(List<UserWithRole> userWithRoleList) {
        this.userWithRoleList = userWithRoleList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userWithRoleList.size();
    }
}
