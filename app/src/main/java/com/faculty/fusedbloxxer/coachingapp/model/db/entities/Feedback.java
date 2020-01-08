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
import static com.faculty.fusedbloxxer.coachingapp.utilities.Utils.randomNumber;
import static com.faculty.fusedbloxxer.coachingapp.utilities.Utils.timestamp;

@Entity(
        tableName = "feedbacks",
        foreignKeys = {
                @ForeignKey(
                        entity = Session.class,
                        parentColumns = "id_sedinta",
                        childColumns = "id_sedinta",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                )
        },
        indices = {
                @Index(value = "id_sedinta", unique = true)
        }
)
public class Feedback {
    @NonNull
    @ColumnInfo(name = "data_emitere")
    private Date sentDate;

    @NonNull
    @ColumnInfo(name = "puncte_evaluare", defaultValue = "5")
    private Float rating;

    @NonNull
    @ColumnInfo(name = "continut")
    private String content;

    @NonNull
    @ColumnInfo(name = "titlu")
    private String title;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_feedback")
    private Long feedbackId;

    @NonNull
    @ColumnInfo(name = "id_sedinta")
    private Long sessionId;

    public Feedback(@NonNull Date sentDate, @NonNull Float rating, @NonNull String content, @NonNull String title, @NonNull Long feedbackId, @NonNull Long sessionId) {
        this.sentDate = sentDate;
        this.rating = rating;
        this.content = content;
        this.title = title;
        this.feedbackId = feedbackId;
        this.sessionId = sessionId;
    }

    @Ignore
    public Feedback(@NonNull Date sentDate, @NonNull Float rating, @NonNull String content, @NonNull String title, @NonNull Long sessionId) {
        this.sentDate = sentDate;
        this.rating = rating;
        this.content = content;
        this.title = title;
        this.sessionId = sessionId;
    }

    @NonNull
    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(@NonNull Date sentDate) {
        this.sentDate = sentDate;
    }

    @NonNull
    public Float getRating() {
        return rating;
    }

    public void setRating(@NonNull Float rating) {
        this.rating = rating;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(@NonNull Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    @NonNull
    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(@NonNull Long sessionId) {
        this.sessionId = sessionId;
    }

    @NonNull
    @Override
    public String toString() {
        return "Feedback{" +
                "sentDate=" + sentDate +
                ", rating=" + rating +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", feedbackId=" + feedbackId +
                ", sessionId=" + sessionId +
                '}';
    }

    private static Feedback[] sFeedbacks;

    @NonNull
    public static Feedback[] getFakeFeedbacks() {
        if (sFeedbacks == null) {
            synchronized (Feedback.class) {
                if (sFeedbacks == null) {
                    sFeedbacks = new Feedback[]{
                            new Feedback(timestamp(), randomNumber(5), "Nu ati fost foarte serios", "Un mascarici", 1L),
                            new Feedback(timestamp(), randomNumber(5), "Nu stiu daca as mai veni", "Nu-s sigur", 3L),
                            new Feedback(timestamp(), randomNumber(5), "A fost interesant", "Super", 2L),
                            new Feedback(timestamp(), 5f, "Mi-a placut cumva", "Bun", 4L),
                            new Feedback(timestamp(), randomNumber(5), "Ok", "Nu stiu", 5L),
                            new Feedback(timestamp(), randomNumber(5), "A fost o experienta placuta.", "A fost decent", 6L),
                            new Feedback(timestamp(), randomNumber(5), "Toate sarcinile mi-au trezit talentele ascunse", "O sa mai merg", 7L),
                            new Feedback(timestamp(), randomNumber(5), "E tare tipul !", "Why not ?", 8L)
                    };
                }
            }
        }
        return sFeedbacks;
    }
}
