package com.faculty.fusedbloxxer.coachingapp.home.materials;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Material;

import java.util.ArrayList;
import java.util.List;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialViewHolder> {
    private List<Material> materials;
    private INavigable<Long> listener;

    public MaterialAdapter(INavigable<Long> listener) {
        this.listener = listener;
        this.materials = new ArrayList<>();
    }

    @NonNull
    @Override
    public MaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_material, parent, false);
        return new MaterialViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialViewHolder holder, int position) {
        Material material = materials.get(position);
        holder.setMaterialTitle(material.getTitle());
        holder.setMaterialId(material.getMaterialId());
        holder.setMaterialImage(material.getImageUrl());
        holder.setMaterialSummary(material.getSummary());
        holder.setMaterialSource(material.getSourceUrl());
        holder.setMaterialEstimatedTime(material.getEstimatedTime());
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return materials.size();
    }
}
