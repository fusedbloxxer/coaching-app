package com.faculty.fusedbloxxer.coachingapp.home.roles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Role;

import java.util.List;

public class RolesFragment extends TableFragment<String> {

    private RoleAdapter roleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(roleAdapter = new RoleAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllRoles().observe(this, new Observer<List<Role>>() {
                    @Override
                    public void onChanged(List<Role> roles) {
                        vm.getAllRoles().removeObserver(this);
                        roleAdapter.setRoles(roles);
                    }
                });
                break;
            case 0:
                vm.getRolesSortedAscById().observe(this, new Observer<List<Role>>() {
                    @Override
                    public void onChanged(List<Role> roles) {
                        vm.getRolesSortedAscById().removeObserver(this);
                        roleAdapter.setRoles(roles);
                    }
                });
                break;
            case 1:
                vm.getRolesSortedDescById().observe(this, new Observer<List<Role>>() {
                    @Override
                    public void onChanged(List<Role> roles) {
                        vm.getRolesSortedDescById().removeObserver(this);
                        roleAdapter.setRoles(roles);
                    }
                });
                break;
            case 2:
                vm.getRolesSortedAscByDescLen().observe(this, new Observer<List<Role>>() {
                    @Override
                    public void onChanged(List<Role> roles) {
                        vm.getRolesSortedAscByDescLen().removeObserver(this);
                        roleAdapter.setRoles(roles);
                    }
                });
                break;
            case 3:
                vm.getRolesSortedDescByDescLen().observe(this, new Observer<List<Role>>() {
                    @Override
                    public void onChanged(List<Role> roles) {
                        vm.getRolesSortedDescByDescLen().removeObserver(this);
                        roleAdapter.setRoles(roles);
                    }
                });
                break;
            default:
                throw new RuntimeException("Bad option");
        }
    }

    @Override
    protected String getSortKey() {
        return "ROLE_SORT";
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Id (A-Z)",
                "Id (Z-A)",
                "Lungime Descriere (Mic-Mare)",
                "Lungime Descriere (Mare-Mic)"
        };
    }

    @Override
    protected void onFabClick() {
        navController.navigate(RolesFragmentDirections.actionRoluriToRoleModFragment());
    }

    @Override
    public void updateOrDelete(String roleId, int option) {
        if (option == 0) {
            navController.navigate(RolesFragmentDirections.actionRoluriToRoleModFragment().setRoleId(roleId));
        } else {
            vm.deleteRoleById(roleId);
        }
    }
}
