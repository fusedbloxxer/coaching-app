package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;
import static com.faculty.fusedbloxxer.coachingapp.utilities.Utils.randomNumber;
import static com.faculty.fusedbloxxer.coachingapp.utilities.Utils.timestamp;

@Entity(
        tableName = "istoric_sarcini",
        primaryKeys = {
                "id_sarcina", "data_completare"
        },
        foreignKeys = {
                @ForeignKey(
                        entity = Task.class,
                        parentColumns = "id_sarcina",
                        childColumns = "id_sarcina",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                )
        },
        indices = {
                @Index(
                        value = {
                                "id_sarcina", "data_completare"
                        },
                        unique = true
                )
        }
)
public class TaskHistory {

    @ColumnInfo(name = "comentariu")
    private String comment;

    @ColumnInfo(name = "evaluare_incredere", defaultValue = "10")
    private Long confidenceRating;

    @NonNull
    @ColumnInfo(name = "id_sarcina")
    private Long taskId;

    @NonNull
    @ColumnInfo(name = "data_completare")
    private Date completionDate;

    public TaskHistory(String comment, Long confidenceRating, @NonNull Long taskId, @NonNull Date completionDate) {
        this.comment = comment;
        this.confidenceRating = confidenceRating;
        this.taskId = taskId;
        this.completionDate = completionDate;
    }

    @Ignore
    public TaskHistory(String comment, Long confidenceRating) {
        this.comment = comment;
        this.confidenceRating = confidenceRating;
    }

    @Ignore
    public TaskHistory(String comment, Long confidenceRating, @NonNull Long taskId) {
        this.comment = comment;
        this.confidenceRating = confidenceRating;
        this.taskId = taskId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getConfidenceRating() {
        return confidenceRating;
    }

    public void setConfidenceRating(Long confidenceRating) {
        this.confidenceRating = confidenceRating;
    }

    @NonNull
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(@NonNull Long taskId) {
        this.taskId = taskId;
    }

    @NonNull
    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(@NonNull Date completionDate) {
        this.completionDate = completionDate;
    }

    @NonNull
    @Override
    public String toString() {
        return "TaskHistory{" +
                "comment='" + comment + '\'' +
                ", confidenceRating=" + confidenceRating +
                ", taskId=" + taskId +
                ", completionDate=" + completionDate +
                '}';
    }

    private static TaskHistory[] sTaskHistories;

    @NonNull
    public static TaskHistory[] getFakeTaskHistories() {
        if (sTaskHistories == null) {
            synchronized (TaskHistory.class) {
                if (sTaskHistories == null) {
                    sTaskHistories = new TaskHistory[]{
                            new TaskHistory("M-am distrat", 3L, 5L, timestamp()),
                            new TaskHistory("M-am distrat", 3L, 5L, timestamp()),
                            new TaskHistory("M-am distrat", 3L, 5L, timestamp()),
                            new TaskHistory("M-am distrat", 3L, 5L, timestamp()),
                            new TaskHistory("M-am descurcat bine!", (long) randomNumber(5), 1L, timestamp()),
                            new TaskHistory("M-am descurcat bine!", (long) randomNumber(5), 1L, timestamp()),
                            new TaskHistory("M-am descurcat bine!", (long) randomNumber(5), 1L, timestamp()),
                            new TaskHistory("M-am descurcat bine!", (long) randomNumber(5), 1L, timestamp()),
                            new TaskHistory("A fost cam epuizant...", (long) randomNumber(5), 1L, timestamp()),
                            new TaskHistory("A fost cam epuizant...", (long) randomNumber(5), 1L, timestamp()),
                            new TaskHistory("A fost cam epuizant...", (long) randomNumber(5), 1L, timestamp()),
                            new TaskHistory("A fost cam epuizant...", (long) randomNumber(5), 1L, timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp()),
                            new TaskHistory(null, (long) randomNumber(5), 1 + (long) randomNumber(Task.getFakeTasks().length), timestamp())
                    };
                }
            }
        }
        return sTaskHistories;
    }
}
