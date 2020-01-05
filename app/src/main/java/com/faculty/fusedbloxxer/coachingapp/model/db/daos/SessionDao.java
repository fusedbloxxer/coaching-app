package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Session;

@Dao
public abstract class SessionDao implements BaseDao<Session> {
    @Query("UPDATE sedinte " +
            "SET id_feedback = :feedbackId " +
            "WHERE id_sedinta = :sessionId")
    public abstract void updateFeedbackForSession(@NonNull Long feedbackId, @NonNull Long sessionId);
}
