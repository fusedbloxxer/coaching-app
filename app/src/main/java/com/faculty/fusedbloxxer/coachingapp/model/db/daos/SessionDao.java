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

    @Query("SELECT * FROM sedinte")
    public abstract LiveData<List<Session>> getAllSessions();

    @Query("SELECT * FROM sedinte ORDER BY id_sedinta ASC")
    public abstract LiveData<List<Session>> getSessionsSotedBySessionIdAsc();

    @Query("SELECT * FROM sedinte ORDER BY id_sedinta DESC")
    public abstract LiveData<List<Session>> getSessionsSotedBySessionIdDesc();

    @Query("SELECT * FROM sedinte ORDER BY data_de_incepere ASC")
    public abstract LiveData<List<Session>> getSessionsSotedByStartDateAsc();

    @Query("SELECT * FROM sedinte ORDER BY data_de_incepere DESC")
    public abstract LiveData<List<Session>> getSessionsSotedByStartDateDesc();

    @Query("SELECT * FROM sedinte ORDER BY LENGTH(discutie) ASC")
    public abstract LiveData<List<Session>> getSessionsSotedByDiscussionLenAsc();

    @Query("SELECT * FROM sedinte ORDER BY LENGTH(discutie) DESC")
    public abstract LiveData<List<Session>> getSessionsSotedByDiscussionLenDesc();

    @Query("SELECT * FROM sedinte WHERE id_sedinta = :sessionId")
    public abstract LiveData<Session> getSessionWithId(@NonNull Long sessionId);

    @Query("DELETE FROM sedinte WHERE id_sedinta = :sessionId")
    public abstract void deleteSessionWithId(@NonNull Long sessionId);

}

// TODO: adauga motivate pentru care feedbacks este tabel separat