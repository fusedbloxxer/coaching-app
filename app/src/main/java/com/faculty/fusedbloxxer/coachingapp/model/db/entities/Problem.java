package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        tableName = "probleme",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "nume_utilizator",
                        childColumns = "id_coach",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                ),
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "nume_utilizator",
                        childColumns = "id_client",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                )
        },
        indices = {
                @Index(value = "id_coach"),
                @Index(value = "id_client")
        }
)
public class Problem {

    private static final String DEFAULT_STATE = "noua";

    @NonNull
    @ColumnInfo(name = "stare", defaultValue = DEFAULT_STATE)
    private String state;

    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    @NonNull
    @ColumnInfo(name = "titlu")
    private String title;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id_problema")
    private Long problemId;

    @NonNull
    @ColumnInfo(name = "id_coach")
    private String coachId;

    @NonNull
    @ColumnInfo(name = "id_client")
    private String clientId;

    public Problem(@NonNull String state, @NonNull String description, @NonNull String title, @NonNull Long problemId, @NonNull String coachId, @NonNull String clientId) {
        this.state = state;
        this.description = description;
        this.title = title;
        this.problemId = problemId;
        this.coachId = coachId;
        this.clientId = clientId;
    }

    @Ignore
    public Problem(@NonNull String state, @NonNull String description, @NonNull String title, @NonNull String coachId, @NonNull String clientId) {
        this.state = state;
        this.description = description;
        this.title = title;
        this.coachId = coachId;
        this.clientId = clientId;
    }

    @Ignore
    public Problem(@NonNull String description, @NonNull String title, @NonNull Long problemId, @NonNull String coachId, @NonNull String clientId) {
        this.description = description;
        this.title = title;
        this.problemId = problemId;
        this.coachId = coachId;
        this.clientId = clientId;
        this.state = DEFAULT_STATE;
    }

    @Ignore
    public Problem(@NonNull String description, @NonNull String title, @NonNull String coachId, @NonNull String clientId) {
        this.description = description;
        this.title = title;
        this.coachId = coachId;
        this.clientId = clientId;
        this.state = DEFAULT_STATE;
    }

    @NonNull
    public String getState() {
        return state;
    }

    public void setState(@NonNull String state) {
        this.state = state;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(@NonNull Long problemId) {
        this.problemId = problemId;
    }

    @NonNull
    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(@NonNull String coachId) {
        this.coachId = coachId;
    }

    @NonNull
    public String getClientId() {
        return clientId;
    }

    public void setClientId(@NonNull String clientId) {
        this.clientId = clientId;
    }

    @NonNull
    @Override
    public String toString() {
        return "Problem{" +
                "state='" + state + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", problemId=" + problemId +
                ", coachId='" + coachId + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }

    private static Problem[] sProblems;

    @NonNull
    public static Problem[] getFakeProblems() {
        if (sProblems == null) {
            synchronized (Problem.class) {
                if (sProblems == null) {

                    sProblems = new Problem[]{
                            new Problem("Stau foarte mult jos, m-am ingrasat tare !", "Nu-mi place miscarea", "LENzymPE", "AckAriUm"),
                            new Problem("Vine sesiunea si nu am invatat nimic, ce sa fac ?", "Facultatea e obositoare", "LENzymPE", "deCtRIbl"),
                            new Problem("Imi e frica sa vorbesc cu oamenii la telefon. Ma intimideaza!", "Frica de telefon", "master", "IlExuate"),
                            new Problem("Am foarte multe teme la facultate si nu stiu ce sa mai fac", "Facultatea ma omoara", "master", "deCtRIbl"),
                            new Problem("De fiecare data cand ma supara cineva bag in mine ca spartul :(", "Mananc foarte mult", "master", "deCtRIbl"),
                            new Problem("Dorm foarte mult, in fiecare zi cel putin 12 ore. Nu mai am timp de altceva... ajutor!", "Sunt cam lenes", "master", "deCtRIbl")
                    };
                }
            }
        }
        return sProblems;
    }
}
