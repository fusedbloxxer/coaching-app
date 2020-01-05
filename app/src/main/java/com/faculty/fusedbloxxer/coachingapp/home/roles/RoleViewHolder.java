package com.faculty.fusedbloxxer.coachingapp.home.roles;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.home.INavigable;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

public class RoleViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private CardView cardView;
    private TextView textId, textDesc;

    public RoleViewHolder(@NonNull View itemView, INavigable<String> listener) {
        super(itemView);
        initViews(itemView);
        cardView.setOnClickListener(view -> Utils.createItemOptions(view.getContext(), listener, textId.getText().toString()));
    }

    private void initViews(@NonNull View itemView) {
        textId = itemView.findViewById(R.id.role_id);
        image = itemView.findViewById(R.id.role_image_view);
        cardView = itemView.findViewById(R.id.role_card_view);
        textDesc = itemView.findViewById(R.id.role_description);
    }

    public void setId(String id) {
        if (id != null) {
            textId.setText(id);
        }
    }

    public void setDescription(String description) {
        if (description != null) {
            textDesc.setText(description);
        }
    }

    public void setImage(String imageUrl) {
        if (imageUrl != null) {
            Glide.with(image.getContext())
                    .load(imageUrl)
                    .fitCenter()
                    .apply(RequestOptions.circleCropTransform())
                    .into(image);
        }
    }
}
