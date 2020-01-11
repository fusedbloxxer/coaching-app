package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.TaskHistory;

import java.util.List;

@Dao
public abstract class TaskHistoryDao implements BaseDao<TaskHistory> {
    @Query("SELECT * FROM istoric_sarcini")
    public abstract LiveData<List<TaskHistory>> getAllTasksHistory();

    @Query("SELECT * FROM istoric_sarcini ORDER BY data_completare DESC")
    public abstract LiveData<List<TaskHistory>> getTasksHistorySortedByDateAsc();

    @Query("SELECT * FROM istoric_sarcini ORDER BY data_completare ASC")
    public abstract LiveData<List<TaskHistory>> getTasksHistorySortedByDateDesc();

    @Query("SELECT * FROM istoric_sarcini ORDER BY evaluare_incredere ASC")
    public abstract LiveData<List<TaskHistory>> getTasksHistorySortedByRatingAsc();

    @Query("SELECT * FROM istoric_sarcini ORDER BY evaluare_incredere DESC")
    public abstract LiveData<List<TaskHistory>> getTasksHistorySortedByRatingDesc();

    @Query("SELECT * FROM istoric_sarcini ORDER BY LENGTH(comentariu) ASC")
    public abstract LiveData<List<TaskHistory>> getTasksHistorySortedByCommentLenAsc();

    @Query("SELECT * FROM istoric_sarcini ORDER BY LENGTH(comentariu) DESC")
    public abstract LiveData<List<TaskHistory>> getTasksHistorySortedByCommentLenDesc();

    @Query("SELECT * FROM istoric_sarcini ORDER BY id_sarcina ASC")
    public abstract LiveData<List<TaskHistory>> getTasksHistorySortedByTaskIdAsc();

    @Query("SELECT * FROM istoric_sarcini ORDER BY id_sarcina DESC")
    public abstract LiveData<List<TaskHistory>> getTasksHistorySortedByTaskIdDesc();

    @Query("SELECT * FROM istoric_sarcini WHERE id_sarcina||' '||data_completare LIKE :taskId||' '||:date")
    public abstract LiveData<TaskHistory> getTaskHistoryByTaskIdAndDate(@NonNull Long taskId, @NonNull Long date);

    @Query("DELETE FROM istoric_sarcini WHERE id_sarcina||' '||data_completare LIKE :taskId||' '||:date")
    public abstract void deleteTaskHistoryByTaskIdAndDate(@NonNull Long taskId, @NonNull Long date);
}
