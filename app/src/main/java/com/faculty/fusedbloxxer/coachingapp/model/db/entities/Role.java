package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "roluri")
public class Role {

    @NonNull
    @ColumnInfo(name = "url_imagine")
    private String urlImage;

    @NonNull
    @ColumnInfo(name = "descriere")
    private String description;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id_rol")
    private String idRole;

    public Role(@NonNull String urlImage, @NonNull String description, @NonNull String idRole) {
        this.urlImage = urlImage;
        this.description = description;
        this.idRole = idRole;
    }

    @NonNull
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(@NonNull String urlImage) {
        this.urlImage = urlImage;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(@NonNull String idRole) {
        this.idRole = idRole;
    }

    @NonNull
    @Override
    public String toString() {
        return "Role{" +
                "urlImage='" + urlImage + '\'' +
                ", description='" + description + '\'' +
                ", idRole='" + idRole + '\'' +
                '}';
    }

    private static Role[] sRoles;

    @NonNull
    public static Role[] getFakeRoles() {
        if (sRoles == null) {
            synchronized (Role.class) {
                if (sRoles == null) {
                    sRoles = new Role[]{
                            new Role("https://media.istockphoto.com/vectors/retention-icon-vector-id961056084?k=6&m=961056084&s=170667a&w=0&h=bs1xfnZO3qBiRdRDacXUQ-KVVXgIIjE4RZJFrkUwz5g=", "Persoana care isi doreste sa se dezvolte personal si sa ajunga departe in viata.", "client"),
                            new Role("https://imageog.flaticon.com/icons/png/512/939/939286.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF", "Persoana care a acumulat experienta in viata si stie cum sa abordeze o gama larga de probleme. Este dispus sa ii ajute pe ceilalti si sa ii ghideze catre o viata mult mai buna.", "coach")
                    };
                }
            }
        }
        return sRoles;
    }
}
