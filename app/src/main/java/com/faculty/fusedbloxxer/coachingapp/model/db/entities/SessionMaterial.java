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
        tableName = "atasate_la",
        primaryKeys = {
                "id_sedinta", "id_material"
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
                        entity = Material.class,
                        parentColumns = "id_material",
                        childColumns = "id_material",
                        onUpdate = CASCADE,
                        onDelete = CASCADE
                )
        },
        indices = {
                @Index(value = {"id_sedinta", "id_material"}, unique = true),
                @Index(value = "id_sedinta"),
                @Index(value = "id_material")
        }
)
public class SessionMaterial {
    @ColumnInfo(name = "timp_disponibil")
    private Long availableTime;

    @NonNull
    @ColumnInfo(name = "data_initiala")
    private Date initialDate;

    @NonNull
    @ColumnInfo(name = "id_sedinta")
    private Long sessionId;

    @NonNull
    @ColumnInfo(name = "id_material")
    private Long materialId;

    public SessionMaterial(Long availableTime, @NonNull Date initialDate, @NonNull Long sessionId, @NonNull Long materialId) {
        this.availableTime = availableTime;
        this.initialDate = initialDate;
        this.sessionId = sessionId;
        this.materialId = materialId;
    }

    public Long getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(Long availableTime) {
        this.availableTime = availableTime;
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
    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(@NonNull Long materialId) {
        this.materialId = materialId;
    }

    @NonNull
    @Override
    public String toString() {
        return "SessionMaterial{" +
                "availableTime=" + availableTime +
                ", initialDate=" + initialDate +
                ", sessionId=" + sessionId +
                ", materialId=" + materialId +
                '}';
    }

    private static SessionMaterial[] sSessionMaterials;

    @NonNull
    public static SessionMaterial[] getFakeSessionMaterials() {
        if (sSessionMaterials == null) {
            synchronized (SessionMaterial.class) {
                if (sSessionMaterials == null) {
                    sSessionMaterials = new SessionMaterial[]{
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial(null, timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length)),
                            new SessionMaterial((long) randomNumber(230), timestamp(), 1 + (long) randomNumber(Session.getFakeSessions().length), 1 + (long) randomNumber(Material.getFakeMaterials().length))
                    };
                }
            }
        }
        return sSessionMaterials;
    }
}
