package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.SessionMaterial;

import java.util.Date;
import java.util.List;

@Dao
public abstract class SessionMaterialDao implements BaseDao<SessionMaterial> {
    @Query("SELECT * FROM atasate_la")
    public abstract LiveData<List<SessionMaterial>> getAllSessionsMaterials();

    @Query("SELECT * FROM atasate_la ORDER BY data_initiala ASC")
    public abstract LiveData<List<SessionMaterial>> getSessionsMaterialsSortedByStartDateAsc();

    @Query("SELECT * FROM atasate_la ORDER BY data_initiala DESC")
    public abstract LiveData<List<SessionMaterial>> getSessionsMaterialsSortedByStartDateDesc();

    @Query("SELECT * FROM atasate_la ORDER BY timp_disponibil ASC")
    public abstract LiveData<List<SessionMaterial>> getSessionsMaterialsSortedByTimeAsc();

    @Query("SELECT * FROM atasate_la ORDER BY timp_disponibil DESC")
    public abstract LiveData<List<SessionMaterial>> getSessionsMaterialsSortedByTimeDesc();

    @Query("SELECT * FROM atasate_la WHERE id_sedinta||' '||id_material = :sessionId||' '||:materialId")
    public abstract LiveData<SessionMaterial> getSessionMaterialByIds(@NonNull Long sessionId, @NonNull Long materialId);

    @Query("DELETE FROM atasate_la WHERE id_sedinta||' '||id_material = :sessionId||' '||:materialId")
    public abstract void deleteSessionMaterialByIds(@NonNull Long sessionId, @NonNull Long materialId);

    @Query("UPDATE atasate_la " +
            "SET id_sedinta = :sessionId, " +
            "id_material = :materialId, " +
            "data_initiala = :initialDate, " +
            "timp_disponibil = :availableTime " +
            "WHERE id_sedinta||' '||id_material = :sessionId||' '||:materialId")
    public abstract void updateSessionMaterialByIds(@NonNull Long sessionId, @NonNull Long materialId, @NonNull Date initialDate, Long availableTime);
}
