package com.faculty.fusedbloxxer.coachingapp.home.users;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.navigation.ui.NavigationUI;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.BaseFragment;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.User;
import com.faculty.fusedbloxxer.coachingapp.utilities.Utils;

import java.util.List;

public class UserFragment extends TableFragment<String> {

    private UserAdapter userAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(userAdapter = new UserAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllUsers().observe(this, new Observer<List<User>>() {
                    @Override
                    public void onChanged(List<User> users) {
                        vm.getUsersSortedByUsernameAsc().removeObserver(this);
                        userAdapter.setUserList(users);
                    }
                });
                break;
            case 0:
                vm.getUsersSortedByUsernameAsc().observe(this, new Observer<List<User>>() {
                    @Override
                    public void onChanged(List<User> users) {
                        vm.getUsersSortedByUsernameAsc().removeObserver(this);
                        userAdapter.setUserList(users);

                    }
                });
                break;
            case 1:
                vm.getUsersSortedByUsernameDesc().observe(this, new Observer<List<User>>() {
                    @Override
                    public void onChanged(List<User> users) {
                        vm.getUsersSortedByUsernameDesc().removeObserver(this);
                        userAdapter.setUserList(users);

                    }
                });
                break;
            case 2:
                vm.getUsersSortedByFullNameAsc().observe(this, new Observer<List<User>>() {
                    @Override
                    public void onChanged(List<User> users) {
                        vm.getUsersSortedByFullNameAsc().removeObserver(this);
                        userAdapter.setUserList(users);

                    }
                });
                break;
            case 3:
                vm.getUsersSortedByFullNameDesc().observe(this, new Observer<List<User>>() {
                    @Override
                    public void onChanged(List<User> users) {
                        vm.getUsersSortedByFullNameDesc().removeObserver(this);
                        userAdapter.setUserList(users);

                    }
                });
                break;
            case 4:
                vm.getUsersSortedByEmailAsc().observe(this, new Observer<List<User>>() {
                    @Override
                    public void onChanged(List<User> users) {
                        vm.getUsersSortedByEmailAsc().removeObserver(this);
                        userAdapter.setUserList(users);

                    }
                });
                break;
            case 5:
                vm.getUsersSortedByEmailDesc().observe(this, new Observer<List<User>>() {
                    @Override
                    public void onChanged(List<User> users) {
                        vm.getUsersSortedByEmailDesc().removeObserver(this);
                        userAdapter.setUserList(users);

                    }
                });
                break;
        }
    }

    @Override
    protected String getSortKey() {
        return "USER_SORT";
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Nume utilizator (A-Z)",
                "Nume utilizator (Z-A)",
                "Nume si prenume (A-Z)",
                "Nume si prenume (Z-A)",
                "Adresa de email (A-Z)",
                "Adresa de email (Z-A)"
        };
    }

    @Override
    protected void onFabClick() {
        navController.navigate(UserFragmentDirections.actionUtilizatoriToUserModFragment());
    }

    @Override
    public void updateOrDelete(String username, int option) {
        if (option == 0) {
            navController.navigate(UserFragmentDirections.actionUtilizatoriToUserModFragment().setUsername(username));
        } else {
            vm.deleteUserByUsername(username);
        }
    }
}
