package com.faculty.fusedbloxxer.coachingapp.home.users;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.BaseFragment;
import com.faculty.fusedbloxxer.coachingapp.databinding.UserModLayoutBinding;
import com.faculty.fusedbloxxer.coachingapp.model.PersonalDevelopmentViewModel;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Role;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.User;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserModFragment extends BaseFragment {
    private String username;
    private Spinner spinnerRole;
    private PersonalDevelopmentViewModel vm;
    private EditText usernameEdit, nameEdit, surnameEdit, emailEdit, passEdit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        UserModLayoutBinding userModLayoutBinding = UserModLayoutBinding
                .inflate(inflater, container, false);
        userModLayoutBinding.setFragment(this);
        return userModLayoutBinding.getRoot();
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        vm = ViewModelProviders.of(this).get(PersonalDevelopmentViewModel.class);
        username = getArguments() != null ? UserModFragmentArgs.fromBundle(getArguments()).getUsername() : null;

        if (username != null) {
            vm.getUserByUsername(username).observe(this, user -> {
                usernameEdit.setEnabled(false);
                nameEdit.setText(user.getLastName());
                passEdit.setText(user.getPassword());
                usernameEdit.setText(user.getUsername());
                surnameEdit.setText(user.getFirstName());
                emailEdit.setText(user.getEmailAddress() != null ? user.getEmailAddress() : "");
            });
        }

        Fragment fragment = this;
        vm.getAllRoles().observe(this, roles -> {
            List<String> stringList = roles.stream().map(Role::getIdRole).collect(Collectors.toList());
            spinnerRole.setAdapter(new ArrayAdapter<>(Objects.requireNonNull(fragment.getContext()), android.R.layout.simple_spinner_dropdown_item, stringList));
        });
    }

    private void initViews(View view) {
        spinnerRole = view.findViewById(R.id.roles_spinner);
        usernameEdit = view.findViewById(R.id.username_editText);
        nameEdit = view.findViewById(R.id.name_editText);
        surnameEdit = view.findViewById(R.id.surname_editText);
        emailEdit = view.findViewById(R.id.email_editText);
        passEdit = view.findViewById(R.id.password_editText);
    }

    public void onCancel() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public void onAccept() {
        if (Utils.checkEditTexts(usernameEdit, nameEdit, surnameEdit, passEdit) && emailCheck() && passwordCheck()) {
            final User user = new User(
                    passEdit.getText().toString(),
                    emailEdit.getText().toString().length() == 0 ? null : emailEdit.getText().toString(),
                    surnameEdit.getText().toString(),
                    nameEdit.getText().toString(),
                    usernameEdit.getText().toString(),
                    spinnerRole.getSelectedItem().toString()
            );

            if (username != null) {
                vm.updateUsers(user);
            } else {
                vm.insertUsers(user);
            }

            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        }
    }

    private boolean emailCheck() {
        if (emailEdit.getText().length() > 0 && !emailEdit.getText().toString().matches("\\w+@\\w+\\.\\w+")) {
            emailEdit.setError("Email should contain only a-z, A-Z and 0-9!");
            return false;
        }
        return true;
    }

    private boolean passwordCheck() {
        if (passEdit.getText().length() <= 6) {
            passEdit.setError("Parola trebuie sa fie mai mare de 6 caractere !");
            return false;
        }
        return true;
    }
}
