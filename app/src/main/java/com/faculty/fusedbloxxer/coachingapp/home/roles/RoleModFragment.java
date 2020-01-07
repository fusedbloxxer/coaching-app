package com.faculty.fusedbloxxer.coachingapp.home.roles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.BaseFragment;
import com.faculty.fusedbloxxer.coachingapp.core.ModFragment;
import com.faculty.fusedbloxxer.coachingapp.databinding.RoleModLayoutBinding;
import com.faculty.fusedbloxxer.coachingapp.model.PersonalDevelopmentViewModel;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Role;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

public class RoleModFragment extends ModFragment {
    public String roleId;
    private EditText roleIdEdit, roleDescEdit, roleImageEdit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        RoleModLayoutBinding roleModLayoutBinding = RoleModLayoutBinding
                .inflate(inflater, container, false);

        roleModLayoutBinding.setFragment(this);
        roleModLayoutBinding.setLifecycleOwner(this);

        return roleModLayoutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void initViews(@NonNull View view) {
        roleIdEdit = view.findViewById(R.id.role_id_editText);
        roleImageEdit = view.findViewById(R.id.role_image_url_editText);
        roleDescEdit = view.findViewById(R.id.role_description_editText);
    }

    @Override
    protected void setArgumentId() {
        roleId = getArguments() != null ? RoleModFragmentArgs.fromBundle(getArguments()).getRoleId() : null;

        if (roleId != null) {
            vm.getRoleById(roleId).observe(this, role -> {
                roleIdEdit.setEnabled(false);
                roleIdEdit.setText(role.getIdRole());
                roleImageEdit.setText(role.getUrlImage());
                roleDescEdit.setText(role.getDescription());
            });
        }
    }

    @Override
    public void onAccept() {
        if (Utils.checkEditTexts(roleIdEdit, roleDescEdit, roleImageEdit)) {
            final Role role = new Role(roleImageEdit.getText().toString(),
                    roleDescEdit.getText().toString(), roleIdEdit.getText().toString());

            if (roleId != null) {
                vm.updateRoles(role);
            } else {
                vm.insertRoles(role);
            }

            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        }
    }
}
