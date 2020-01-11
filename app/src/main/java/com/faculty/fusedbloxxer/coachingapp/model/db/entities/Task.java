package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "sarcini")
public class Task {
    @ColumnInfo(name = "timp_estimat")
    private Long estimatedTime;

    @NonNull
    @ColumnInfo(name = "descriere")
    private String description;

    @ColumnInfo(name = "puncte_premiu", defaultValue = "100")
    private Long rewardPoints;

    @NonNull
    @ColumnInfo(name = "titlu")
    private String title;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_sarcina")
    private Long taskId;

    public Task(Long estimatedTime, @NonNull String description, Long rewardPoints, @NonNull String title, @NonNull Long taskId) {
        this.estimatedTime = estimatedTime;
        this.description = description;
        this.rewardPoints = rewardPoints;
        this.title = title;
        this.taskId = taskId;
    }

    @Ignore
    public Task(Long estimatedTime, @NonNull String description, Long rewardPoints, @NonNull String title) {
        this.estimatedTime = estimatedTime;
        this.description = description;
        this.rewardPoints = rewardPoints;
        this.title = title;
    }

    public Long getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Long estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public Long getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
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
        return "Task{" +
                "estimatedTime=" + estimatedTime +
                ", description='" + description + '\'' +
                ", rewardPoints=" + rewardPoints +
                ", title='" + title + '\'' +
                ", taskId='" + taskId + '\'' +
                '}';
    }

    private static Task[] sTasks;

    @NonNull
    public static Task[] getFakeTasks() {
        if (sTasks == null) {
            synchronized (Task.class) {
                if (sTasks == null) {
                    sTasks = new Task[]{
                            new Task(null, "Ai de facut 20 de flotari.", 50L, "Sport"),
                            new Task(30L, "Mergi afara si plimba-te.", 20L, "Relaxare"),
                            new Task(25L, "Suna-ti prietenii si mergeti in parc.", null, "Ieseala"),
                            new Task(null, "Fa-ti un plan de afaceri.", 100L, "Business"),
                            new Task(130L, "Vezi un film, descopera lucruri noi.", 35L, "Educatie"),
                            new Task(20L, "Mananca ceva sanatos", null, "Gustos"),
                            new Task(null, "Aranjeaza-ti lucrurile, fa curatenie in casa. Acest lucru te va ajuta sa-ti eliberezi mintea.", 24L, "Light Mind"),
                            new Task(40L, "Iesi la un maraton de jogging, ia-ti 2-3 prieteni si simte-te liber.", 89L, "Sport is life"),
                            new Task(220L, "Porneste un proiect prin care vei ajuta copii cu cancer. Acest fapt o sa te ajute sa intelegi cum sa empatizezi.", 100L, "Sharing is caring")
                    };
                }
            }
        }
        return sTasks;
    }
}


