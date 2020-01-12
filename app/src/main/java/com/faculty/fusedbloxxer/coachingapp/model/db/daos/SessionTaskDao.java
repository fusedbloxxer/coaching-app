package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.SessionTask;

import java.util.List;

@Dao
public abstract class SessionTaskDao implements BaseDao<SessionTask> {
    @Query("SELECT * FROM includ")
    public abstract LiveData<List<SessionTask>> getAllSessionsTasks();

    @Query("SELECT * FROM includ ORDER BY data_initiala ASC")
    public abstract LiveData<List<SessionTask>> getSessionsTasksSortedByDateAsc();

    @Query("SELECT * FROM includ ORDER BY data_initiala DESC")
    public abstract LiveData<List<SessionTask>> getSessionsTasksSortedByDateDesc();

    @Query("SELECT * FROM includ ORDER BY prioritate ASC")
    public abstract LiveData<List<SessionTask>> getSessionsTasksSortedByPriorityAsc();

    @Query("SELECT * FROM includ ORDER BY prioritate DESC")
    public abstract LiveData<List<SessionTask>> getSessionsTasksSortedByPriorityDesc();

    @Query("SELECT * FROM includ WHERE id_sedinta||' '||id_sarcina = :sessionId||' '||:taskId")
    public abstract LiveData<SessionTask> getSessionTaskByIds(@NonNull Long sessionId, @NonNull Long taskId);

    @Query("DELETE FROM includ WHERE id_sedinta||' '||id_sarcina = :sessionId||' '||:taskId")
    public abstract void deleteSessionTaskByIds(@NonNull Long sessionId, @NonNull Long taskId);
}
