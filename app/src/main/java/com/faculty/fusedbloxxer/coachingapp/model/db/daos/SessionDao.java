package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Session;

import java.util.List;

@Dao
public abstract class SessionDao implements BaseDao<Session> {
    @Query("UPDATE sedinte " +
            "SET id_feedback = :feedbackId " +
            "WHERE id_sedinta = :sessionId")
    public abstract void updateFeedbackForSession(@NonNull Long feedbackId, @NonNull Long sessionId);

    @Query("SELECT * FROM sedinte WHERE id_feedback IS NULL")
    public abstract LiveData<List<Session>> getSessionsWithoutFeedback();

    @Query("SELECT * FROM sedinte WHERE id_feedback = :feedbackId")
    public abstract LiveData<Session> getSessionByFeedbackId(Long feedbackId);
}
