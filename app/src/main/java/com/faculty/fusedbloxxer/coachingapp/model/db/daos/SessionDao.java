package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Session;

import java.util.List;

@Dao
public abstract class SessionDao implements BaseDao<Session> {
    @Query(" SELECT * " +
            "FROM sedinte " +
            "WHERE id_sedinta NOT IN(SELECT id_sedinta FROM feedbacks)")
    public abstract LiveData<List<Session>> getSessionsWithoutFeedback();

    @Query("SELECT id_sedinta " +
            "FROM sedinte " +
            "WHERE id_sedinta NOT IN(SELECT id_sedinta FROM feedbacks)")
    public abstract LiveData<List<Long>> getIdsForSessionsWithoutFeedback();

    @Query(" SELECT * " +
            "FROM sedinte " +
            "WHERE id_sedinta IN(SELECT id_sedinta " +
            "                    FROM feedbacks " +
            "                    WHERE id_feedback = :feedbackId " +
            "                    AND :feedbackId IS NOT NULL)")
    public abstract LiveData<Session> getSessionByFeedbackId(@NonNull Long feedbackId);
}

// TODO: adauga motivate pentru care feedbacks este tabel separat