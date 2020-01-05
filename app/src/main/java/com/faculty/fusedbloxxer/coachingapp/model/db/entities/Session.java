package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;
import static androidx.room.ForeignKey.SET_NULL;
import static com.faculty.fusedbloxxer.coachingapp.utilities.Utils.timestamp;

@Entity(
        tableName = "sedinte",
        foreignKeys = {
                @ForeignKey(
                        entity = Problem.class,
                        parentColumns = "id_problema",
                        childColumns = "id_problema",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                ),
                @ForeignKey(
                        entity = Feedback.class,
                        parentColumns = "id_feedback",
                        childColumns = "id_feedback",
                        onUpdate = CASCADE,
                        onDelete = SET_NULL
                ),
                @ForeignKey(
                        entity = Location.class,
                        parentColumns = "id_locatie",
                        childColumns = "id_locatie",
                        onUpdate = CASCADE,
                        onDelete = SET_NULL
                )
        },
        indices = {
                @Index(value = "id_feedback", unique = true),
                @Index(value = "id_problema"),
                @Index(value = "id_locatie")
        }
)
public class Session {
    @NonNull
    @ColumnInfo(name = "discutie")
    private String discussion;

    @NonNull
    @ColumnInfo(name = "data_de_incepere")
    private Date startDate;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_sedinta")
    private Long sessionId;

    @NonNull
    @ColumnInfo(name = "id_problema")
    private Long problemId;

    @ColumnInfo(name = "id_feedback")
    private Long feedbackId;

    @ColumnInfo(name = "id_locatie")
    private Long locationId;

    public Session(@NonNull String discussion, @NonNull Date startDate, @NonNull Long sessionId, @NonNull Long problemId, Long feedbackId, Long locationId) {
        this.discussion = discussion;
        this.startDate = startDate;
        this.sessionId = sessionId;
        this.problemId = problemId;
        this.feedbackId = feedbackId;
        this.locationId = locationId;
    }

    @Ignore
    public Session(@NonNull String discussion, @NonNull Date startDate, @NonNull Long problemId, Long feedbackId, Long locationId) {
        this.discussion = discussion;
        this.startDate = startDate;
        this.problemId = problemId;
        this.feedbackId = feedbackId;
        this.locationId = locationId;
    }

    @NonNull
    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(@NonNull String discussion) {
        this.discussion = discussion;
    }

    @NonNull
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(@NonNull Date startDate) {
        this.startDate = startDate;
    }

    @NonNull
    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(@NonNull Long sessionId) {
        this.sessionId = sessionId;
    }

    @NonNull
    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(@NonNull Long problemId) {
        this.problemId = problemId;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @NonNull
    @Override
    public String toString() {
        return "Session{" +
                "discussion='" + discussion + '\'' +
                ", startDate=" + startDate +
                ", sessionId=" + sessionId +
                ", problemId=" + problemId +
                ", feedbackId=" + feedbackId +
                ", locationId=" + locationId +
                '}';
    }

    private static Session[] sSessions;

    @NonNull
    public static Session[] getFakeSessions() {
        if(sSessions == null) {
            synchronized (Session.class) {
                if (sSessions == null) {
                    sSessions = new Session[]{
                            new Session("In aceasta sesiune iti vom ridica moralul !", timestamp(), 1L, null, 1L),
                            new Session("Totul este ok :) ", timestamp(), 2L, null, null),
                            new Session("Nu ai de ce sa te ingrizorezi :)", timestamp(), 1L, null, 2L),
                            new Session("In aceasta sesiune iti vom ridica moralul !", timestamp(), 1L, null, 2L),
                            new Session("Totul se va rezolva imediat", timestamp(), 4L, null, null),
                            new Session("De ce crezi ca ai aceste temeri?", timestamp(), 4L, null, 4L),
                            new Session("Voi fi sprijinul tau", timestamp(), 3L, null, 4L),
                            new Session("Incepem cu cateva exercitii fizice.", timestamp(), 3L, null, 3L),
                            new Session("O sa iesim cu bine din situatia asta.", timestamp(), 3L, null, 3L)
                    };
                }
            }
        }
        return sSessions;
    }
}
