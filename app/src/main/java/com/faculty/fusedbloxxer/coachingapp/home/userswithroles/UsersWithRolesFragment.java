package com.faculty.fusedbloxxer.coachingapp.home.userswithroles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.BaseFragment;
import com.faculty.fusedbloxxer.coachingapp.model.PersonalDevelopmentViewModel;

public class UsersWithRolesFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple_recycler_view_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UserWithRoleAdapter userWithRoleAdapter = new UserWithRoleAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(userWithRoleAdapter);

//        ViewModelProviders.of(this).get(PersonalDevelopmentViewModel.class)
//                .getUsersWithRoles()
//                .observe(this, userWithRoleAdapter::setUserWithRoleList);
    }
}
