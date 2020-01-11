package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Material;

import java.util.List;

@Dao
public abstract class MaterialDao implements BaseDao<Material> {
    @Query("SELECT * FROM materiale")
    public abstract LiveData<List<Material>> getAllMaterials();

    @Query("SELECT * FROM materiale ORDER BY id_material ASC")
    public abstract LiveData<List<Material>> getMaterialsSortedByIdAsc();

    @Query("SELECT * FROM materiale ORDER BY id_material DESC")
    public  abstract LiveData<List<Material>> getMaterialsSortedByIdDesc();

    @Query("SELECT * FROM materiale ORDER BY timp_estimat ASC")
    public abstract LiveData<List<Material>> getMaterialsSortedByTimeAsc();

    @Query("SELECT * FROM materiale ORDER BY timp_estimat DESC")
    public abstract LiveData<List<Material>> getMaterialsSortedByTimeDesc();

    @Query("SELECT * FROM materiale ORDER BY titlu ASC")
    public abstract LiveData<List<Material>> getMaterialsSortedByTitleAsc();

    @Query("SELECT * FROM materiale ORDER BY titlu DESC")
    public abstract LiveData<List<Material>> getMaterialsSortedByTitleDesc();

    @Query("DELETE FROM materiale WHERE id_material = :materialId")
    public abstract void deleteMaterialById(@NonNull Long materialId);

    @Query("SELECT * FROM materiale WHERE id_material = :materialId")
    public abstract LiveData<Material> getMaterialWithId(@NonNull Long materialId);
}
