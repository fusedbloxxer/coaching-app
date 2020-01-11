package com.faculty.fusedbloxxer.coachingapp.home.materials;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

public class MaterialViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    private String materialSource;
    private ImageView materialImage;
    private TextView materialTitle, materialId, materialSummary, materialEstimatedTime;


    public MaterialViewHolder(@NonNull View itemView, INavigable<Long> listener) {
        super(itemView);
        initViews(itemView);

        cardView.setOnClickListener(v -> {
            Intent openSourceIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(materialSource));
            if (openSourceIntent.resolveActivity(v.getContext().getPackageManager()) != null) {
                v.getContext().startActivity(openSourceIntent);
            }
        });

        materialId.setOnClickListener(v ->
                Utils.createItemOptions(v.getContext(), listener, (Long) materialId.getTag()));
    }

    private void initViews(View itemView) {
        cardView = itemView.findViewById(R.id.material_card_view);
        materialId = itemView.findViewById(R.id.material_id_text_view);
        materialImage = itemView.findViewById(R.id.material_image_view);
        materialTitle = itemView.findViewById(R.id.material_title_edit_text);
        materialSummary = itemView.findViewById(R.id.material_summary_text_View);
        materialEstimatedTime = itemView.findViewById(R.id.material_estimated_time_text_view);
    }

    public void setMaterialImage(String materialImage) {
        if (materialImage != null) {
            this.materialImage.setVisibility(View.VISIBLE);
            Glide.with(this.materialImage.getContext())
                    .load(materialImage)
                    .fitCenter()
                    .into(this.materialImage);
        } else {
            this.materialImage.setVisibility(View.GONE);
        }
    }

    public void setMaterialTitle(String title) {
        if (title != null) {
            materialTitle.setText(title);
        }
    }

    public void setMaterialId(Long materialId) {
        if (materialId != null) {
            this.materialId.setTag(materialId);
            this.materialId.setText(String.format("ID: %d", materialId));
        }
    }

    public void setMaterialSummary(String materialSummary) {
        if (materialSummary != null) {
            this.materialSummary.setVisibility(View.VISIBLE);
            this.materialSummary.setText(materialSummary);
        } else {
            this.materialSummary.setVisibility(View.GONE);
        }
    }

    public void setMaterialEstimatedTime(Long materialEstimatedTime) {
        if (materialEstimatedTime != null) {
            this.materialEstimatedTime.setVisibility(View.VISIBLE);
            this.materialEstimatedTime.setText(String.format("Timp estimat: %d de minute.", materialEstimatedTime));
        } else {
            this.materialEstimatedTime.setVisibility(View.GONE);
        }
    }

    public void setMaterialSource(String materialSource) {
        if (materialSource != null) {
            this.materialSource = materialSource;
        }
    }
}
