package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Problem;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.User;

import java.util.List;

@Dao
public abstract class ProblemDao implements BaseDao<Problem> {
    @Query("SELECT * FROM probleme")
    public abstract LiveData<List<Problem>> getAllProblems();

    @Query("SELECT * FROM probleme ORDER BY id_problema ASC")
    public abstract LiveData<List<Problem>> getProblemsSortedByIdAsc();

    @Query("SELECT * FROM probleme ORDER BY id_problema DESC")
    public abstract LiveData<List<Problem>> getProblemsSortedByIdDesc();

    @Query("SELECT * FROM probleme ORDER BY LENGTH(description) ASC")
    public abstract LiveData<List<Problem>> getProblemsSortedByDescriptionAsc();

    @Query("SELECT * FROM probleme ORDER BY LENGTH(description) DESC")
    public abstract LiveData<List<Problem>> getProblemsSortedByDescriptionDesc();

    @Query("SELECT * FROM probleme ORDER BY stare ASC")
    public abstract LiveData<List<Problem>> getProblemsSortedByStateAsc();

    @Query("SELECT * FROM probleme ORDER BY stare DESC")
    public abstract LiveData<List<Problem>> getProblemsSortedByStateDesc();

    @Query("SELECT * FROM probleme ORDER BY titlu ASC")
    public abstract LiveData<List<Problem>> getProblemsSortedByTitleAsc();

    @Query("SELECT * FROM probleme ORDER BY titlu DESC")
    public abstract LiveData<List<Problem>> getProblemsSortedByTitleDesc();

    @Query("SELECT * FROM probleme WHERE id_problema = :problemId")
    public abstract LiveData<Problem> getProblemById(@NonNull Long problemId);

    @Query("DELETE FROM probleme WHERE id_problema = :problemId")
    public abstract void deleteProblemWithId(@NonNull Long problemId);
}
