package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Location;

import java.util.List;

@Dao
public abstract class LocationDao implements BaseDao<Location> {
    @Query("SELECT * FROM locatii")
    public abstract LiveData<List<Location>> getAllLocations();

    @Query("SELECT * FROM locatii ORDER BY denumire ASC")
    public abstract LiveData<List<Location>> getLocationsSortedByAliasAsc();

    @Query("SELECT * FROM locatii ORDER BY denumire DESC")
    public abstract LiveData<List<Location>> getLocationsSortedByAliasDesc();

    @Query("SELECT * FROM locatii ORDER BY strada ASC")
    public abstract LiveData<List<Location>> getLocationsSortedByStreetAsc();

    @Query("SELECT * FROM locatii ORDER BY strada DESC")
    public abstract LiveData<List<Location>> getLocationsSortedByStreetDesc();

    @Query("SELECT * FROM locatii ORDER BY id_locatie ASC")
    public abstract LiveData<List<Location>> getLocationsSortedByIdAsc();

    @Query("SELECT * FROM locatii ORDER BY id_locatie DESC")
    public abstract LiveData<List<Location>> getLocationsSortedByIdDesc();

    @Query("SELECT * FROM locatii WHERE id_locatie = :locationId")
    public abstract LiveData<Location> getLocationById(@NonNull Long locationId);

    @Query("DELETE FROM locatii WHERE id_locatie = :locationId")
    public abstract void deleteLocationById(@NonNull Long locationId);
}