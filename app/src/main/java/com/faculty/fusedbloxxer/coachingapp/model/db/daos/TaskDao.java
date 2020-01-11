package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Task;

import java.util.List;

@Dao
public abstract class TaskDao implements BaseDao<Task> {
    @Query("SELECT id_sarcina FROM sarcini")
    public abstract LiveData<List<Long>> getAllTaksIds();
}
