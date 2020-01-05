package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;
import static com.faculty.fusedbloxxer.coachingapp.utilities.Utils.randomNumber;
import static com.faculty.fusedbloxxer.coachingapp.utilities.Utils.timestamp;

@Entity(
        tableName = "includ",
        primaryKeys = {
                "id_sedinta", "id_sarcina"
        },
        foreignKeys = {
                @ForeignKey(
                        entity = Session.class,
                        parentColumns = "id_sedinta",
                        childColumns = "id_sedinta",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                ),
                @ForeignKey(
                        entity = Task.class,
                        parentColumns = "id_sarcina",
                        childColumns = "id_sarcina",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                )
        },
        indices = {
                @Index(value = {"id_sedinta", "id_sarcina"}, unique = true)
        }
)
public class SessionTask {
    @ColumnInfo(name = "prioritate", defaultValue = "10")
    private Long priority;

    @NonNull
    @ColumnInfo(name = "data_initiala")
    private Date initialDate;

    @NonNull
    @ColumnInfo(name = "id_sedinta")
    private Long sessionId;

    @NonNull
    @ColumnInfo(name = "id_sarcina")
    private Long taskId;

    public SessionTask(Long priority, @NonNull Date initialDate, @NonNull Long sessionId, @NonNull Long taskId) {
        this.priority = priority;
        this.initialDate = initialDate;
        this.sessionId = sessionId;
        this.taskId = taskId;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    @NonNull
    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(@NonNull Date initialDate) {
        this.initialDate = initialDate;
    }

    @NonNull
    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(@NonNull Long sessionId) {
        this.sessionId = sessionId;
    }

    @NonNull
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(@NonNull Long taskId) {
        this.taskId = taskId;
    }

    @NonNull
    @Override
    public String toString() {
        return "SessionTask{" +
                "priority=" + priority +
                ", initialDate=" + initialDate +
                ", sessionId=" + sessionId +
                ", taskId=" + taskId +
                '}';
    }

    private static SessionTask[] sSessionTasks;

    @NonNull
    public static SessionTask[] getFakeSessionTasks() {
        if (sSessionTasks == null) {
            synchronized (SessionTask.class) {
                if (sSessionTasks == null) {
                    sSessionTasks = new SessionTask[]{
                            new SessionTask(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask((long) randomNumber(5), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask((long) randomNumber(5), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask((long) randomNumber(5), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask((long) randomNumber(5), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask((long) randomNumber(5), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask((long) randomNumber(5), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length))),
                            new SessionTask((long) randomNumber(5), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), (long) (1 + randomNumber(Task.getFakeTasks().length)))
                    };
                }
            }
        }
        return sSessionTasks;
    }
}
