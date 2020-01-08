package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Feedback;

import java.util.List;

@Dao
public abstract class FeedbackDao implements BaseDao<Feedback> {
    @Query("SELECT * FROM feedbacks")
    public abstract LiveData<List<Feedback>> getAllFeedbacks();

    @Query("SELECT * FROM feedbacks ORDER BY id_feedback ASC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedByIdAsc();

    @Query("SELECT * FROM feedbacks ORDER BY id_feedback DESC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedByIdDesc();

    @Query("SELECT * FROM feedbacks ORDER BY id_sedinta ASC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedBySessionAsc();

    @Query("SELECT * FROM feedbacks ORDER BY id_sedinta DESC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedBySessionDesc();

    @Query("SELECT * FROM feedbacks ORDER BY titlu ASC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedByTitleAsc();

    @Query("SELECT * FROM feedbacks ORDER BY titlu DESC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedByTitleDesc();

    @Query("SELECT * FROM feedbacks ORDER BY LENGTH(continut) ASC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedByContentLengthAsc();

    @Query("SELECT * FROM feedbacks ORDER BY LENGTH(continut) DESC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedByContentLengthDesc();

    @Query("SELECT * FROM feedbacks ORDER BY puncte_evaluare ASC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedByRatingAsc();

    @Query("SELECT * FROM feedbacks ORDER BY puncte_evaluare DESC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedByRatingDesc();

    @Query("SELECT * FROM feedbacks ORDER BY data_emitere DESC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedByEmissionDateAsc();

    @Query("SELECT * FROM feedbacks ORDER BY data_emitere ASC")
    public abstract LiveData<List<Feedback>> getFeedbacksSortedByEmissionDateDesc();

    @Query("SELECT * FROM feedbacks WHERE id_feedback = :feedbackId")
    public abstract LiveData<Feedback> getFeedbackById(Long feedbackId);

    @Query("DELETE FROM feedbacks WHERE id_feedback = :feedbackId")
    public abstract void deleteFeedbackById(Long feedbackId);

    @Query("SELECT 1 " +
            "FROM feedbacks " +
            "WHERE id_feedback = :feedbackId " +
            "AND EXISTS(SELECT id_sedinta FROM sedinte WHERE id_feedback = :feedbackId)")
    public abstract LiveData<Long> isFeedbackConfirmed(Long feedbackId);
}
