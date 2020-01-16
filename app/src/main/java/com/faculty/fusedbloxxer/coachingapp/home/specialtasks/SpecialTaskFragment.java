package com.faculty.fusedbloxxer.coachingapp.home.specialtasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.BaseFragment;

public class SpecialTaskFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple_recycler_view_layout, container, false);
    }
}
