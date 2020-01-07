package com.faculty.fusedbloxxer.coachingapp.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.faculty.fusedbloxxer.coachingapp.model.PersonalDevelopmentViewModel;
import com.faculty.fusedbloxxer.coachingapp.model.db.database.PersonalDevelopmentDatabase;

public abstract class ModFragment extends BaseFragment {
    protected PersonalDevelopmentViewModel vm;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vm = ViewModelProviders.of(this).get(PersonalDevelopmentViewModel.class);
        initViews(view);
        setArgumentId();
    }

    public void onCancel() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public abstract void onAccept();

    protected abstract void setArgumentId();

    protected abstract void initViews(View itemView);
}


