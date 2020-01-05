package com.faculty.fusedbloxxer.coachingapp.home.roles;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleAdapter extends RecyclerView.Adapter<RoleViewHolder> {
    private List<Role> roles;
    private INavigable<String> listener;

    public RoleAdapter(INavigable<String> listener) {
        this.roles = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public RoleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_role, parent, false);
        return new RoleViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RoleViewHolder holder, int position) {
        Role role = roles.get(position);
        holder.setDescription(role.getDescription());
        holder.setImage(role.getUrlImage());
        holder.setId(role.getIdRole());
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return roles.size();
    }
}
