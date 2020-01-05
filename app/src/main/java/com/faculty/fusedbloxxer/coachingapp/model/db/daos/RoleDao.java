package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Role;

import java.util.List;

@Dao
public abstract class RoleDao implements BaseDao<Role> {

    @Query("SELECT * FROM roluri")
    public abstract LiveData<List<Role>> getAllRoles();

    @Query("SELECT * FROM roluri ORDER BY id_rol ASC")
    public abstract LiveData<List<Role>> getRolesSortedAscById();

    @Query("SELECT * FROM roluri ORDER BY id_rol DESC")
    public abstract LiveData<List<Role>> getRolesSortedDescById();

    @Query("SELECT * FROM roluri ORDER BY LENGTH(descriere) ASC")
    public abstract LiveData<List<Role>> getRolesSortedAscByDescLen();

    @Query("SELECT * FROM roluri ORDER BY LENGTH(descriere) DESC")
    public abstract LiveData<List<Role>> getRolesSortedDescByDescLen();

    @Query("SELECT * FROM roluri WHERE LOWER(id_rol) LIKE LOWER(:roleId)")
    public abstract LiveData<Role> getRoleById(@NonNull String roleId);

    @Query("DELETE FROM roluri WHERE id_rol = :roleId")
    public abstract void deleteRoleById(String roleId);
}
