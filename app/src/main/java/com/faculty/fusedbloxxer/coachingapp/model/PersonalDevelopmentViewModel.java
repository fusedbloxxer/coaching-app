package com.faculty.fusedbloxxer.coachingapp.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.database.PersonalDevelopmentDatabase;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Role;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.User;

import java.util.List;

public class PersonalDevelopmentViewModel extends AndroidViewModel {
    private PersonalDevelopmentDatabase personalDevelopmentDatabase;

    public PersonalDevelopmentViewModel(@NonNull final Application application) {
        super(application);
        personalDevelopmentDatabase = PersonalDevelopmentDatabase.getDatabase(application);
    }

    public LiveData<List<Role>> getAllRoles() {
        return personalDevelopmentDatabase.roleDao().getAllRoles();
    }

    public LiveData<List<Role>> getRolesSortedAscById() {
        return personalDevelopmentDatabase.roleDao().getRolesSortedAscById();
    }

    public LiveData<List<Role>> getRolesSortedDescById() {
        return personalDevelopmentDatabase.roleDao().getRolesSortedDescById();
    }

    public LiveData<List<Role>> getRolesSortedAscByDescLen() {
        return personalDevelopmentDatabase.roleDao().getRolesSortedAscByDescLen();
    }

    public LiveData<List<Role>> getRolesSortedDescByDescLen() {
        return personalDevelopmentDatabase.roleDao().getRolesSortedDescByDescLen();
    }

    public LiveData<Role> getRoleById(@NonNull String roleId) {
        return personalDevelopmentDatabase.roleDao().getRoleById(roleId);
    }

    public void insertRoles(Role... roles) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.roleDao().insert(roles));
    }

    public void updateRoles(Role... roles) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.roleDao().update(roles));
    }

    public void deleteRoleById(String roleId) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.roleDao().deleteRoleById(roleId));
    }

    public LiveData<List<User>> getUsersSortedByUsernameAsc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByUsernameAsc();
    }

    public LiveData<List<User>> getUsersSortedByUsernameDesc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByUsernameDesc();
    }

    public LiveData<List<User>> getUsersSortedByFullNameAsc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByFullNameAsc();
    }

    public LiveData<List<User>> getUsersSortedByFullNameDesc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByFullNameDesc();
    }

    public LiveData<List<User>> getUsersSortedByEmailAsc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByEmailAsc();
    }

    public LiveData<List<User>> getUsersSortedByEmailDesc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByEmailDesc();
    }

    public LiveData<User> getUserByUsername(String username) {
        return personalDevelopmentDatabase.userDao().getUserByUsername(username);
    }

    public LiveData<List<User>> getAllUsers() {
        return personalDevelopmentDatabase.userDao().getAllUsers();
    }

    public void deleteUserByUsername(String username) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.userDao().deleteUserByUsername(username));
    }

    public void updateUsers(User... users) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.userDao().update(users));
    }

    public void insertUsers(User... users) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.userDao().insert(users));
    }
}
