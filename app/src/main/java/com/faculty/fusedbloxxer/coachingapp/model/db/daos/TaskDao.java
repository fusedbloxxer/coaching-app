package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Task;

import java.util.List;

@Dao
public abstract class TaskDao implements BaseDao<Task> {
    @Query("SELECT id_sarcina FROM sarcini")
    public abstract LiveData<List<Long>> getAllTaksIds();

    @Query("SELECT * FROM sarcini")
    public abstract LiveData<List<Task>> getAllTasks();

    @Query("SELECT * FROM sarcini ORDER BY id_sarcina ASC")
    public abstract LiveData<List<Task>> getTasksSortedByIdAsc();

    @Query("SELECT * FROM sarcini ORDER BY id_sarcina Desc")
    public abstract LiveData<List<Task>> getTasksSortedByIdDesc();

    @Query("SELECT * FROM sarcini ORDER BY LOWER(titlu) ASC")
    public abstract LiveData<List<Task>> getTasksSortedByTitleAsc();

    @Query("SELECT * FROM sarcini ORDER BY LOWER(titlu) DESC")
    public abstract LiveData<List<Task>> getTasksSortedByTitleDesc();

    @Query("SELECT * FROM sarcini ORDER BY puncte_premiu ASC")
    public abstract LiveData<List<Task>> getTasksSortedByScoreAsc();

    @Query("SELECT * FROM sarcini ORDER BY puncte_premiu DESC")
    public abstract LiveData<List<Task>> getTasksSortedByScoreDesc();

    @Query("SELECT * FROM sarcini ORDER BY LENGTH(descriere) ASC")
    public abstract LiveData<List<Task>> getTasksSortedByDescriptionLenAsc();

    @Query("SELECT * FROM sarcini ORDER BY LENGTH(descriere) DESC")
    public abstract LiveData<List<Task>> getTasksSortedByDescriptionLenDesc();

    @Query("SELECT * FROM sarcini ORDER BY timp_estimat ASC")
    public abstract LiveData<List<Task>> getTasksSortedByTimeAsc();

    @Query("SELECT * FROM sarcini ORDER BY timp_estimat DESC")
    public abstract LiveData<List<Task>> getTasksSortedByTimeDesc();

    @Query("SELECT * FROM sarcini WHERE id_sarcina = :taskId")
    public abstract LiveData<Task> getTaskWithId(@NonNull Long taskId);

    @Query("DELETE FROM sarcini WHERE id_sarcina = :taskId")
    public abstract void deteleTaskWithId(@NonNull Long taskId);
}
