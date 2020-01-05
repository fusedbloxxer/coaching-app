package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "locatii")
public class Location {
    @NonNull
    @ColumnInfo(name = "url_imagine")
    private String imageUrl;

    @NonNull
    @ColumnInfo(name = "strada")
    private String street;

    @ColumnInfo(name = "denumire")
    private String alias;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_locatie")
    private Long locationId;

    public Location(@NonNull String imageUrl, @NonNull String street, String alias, @NonNull Long locationId) {
        this.imageUrl = imageUrl;
        this.street = street;
        this.alias = alias;
        this.locationId = locationId;
    }

    @Ignore
    public Location(@NonNull String imageUrl, @NonNull String street, String alias) {
        this.imageUrl = imageUrl;
        this.street = street;
        this.alias = alias;
    }

    @Ignore
    public Location(@NonNull String imageUrl, @NonNull String street) {
        this.imageUrl = imageUrl;
        this.street = street;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NonNull String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NonNull
    public String getStreet() {
        return street;
    }

    public void setStreet(@NonNull String street) {
        this.street = street;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @NonNull
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(@NonNull Long locationId) {
        this.locationId = locationId;
    }

    @NonNull
    @Override
    public String toString() {
        return "Location{" +
                "imageUrl='" + imageUrl + '\'' +
                ", street='" + street + '\'' +
                ", alias='" + alias + '\'' +
                ", locationId=" + locationId +
                '}';
    }

    private static Location[] sLocations;

    @NonNull
    public static Location[] getFakeLocations() {
        if (sLocations == null) {
            synchronized (Location.class) {
                if (sLocations == null) {
                    sLocations = new Location[]{
                            new Location("http://www.bucurestifm.ro/wp-content/uploads/sites/2/2015/08/07.-Parcul-Alexandru-Ioan-Cuza-Bucuresti-FM.jpg", "Strada Baba Novac", "La Cuza"),
                            new Location("https://upload.wikimedia.org/wikipedia/commons/0/04/Parcul_Tineretului.jpg", "Parcul Tineretului", "Titanel"),
                            new Location("https://cdn.g4media.ro/wp-content/uploads/2019/08/parcul-cismigiu-640x400.jpg", "Parcul Cismigiu"),
                            new Location("http://merg.in/thumbs/big_art/2017/09/25/parcul-izvor-18327.jpg", "Parcul Izvor"),
                            new Location("https://editiadedimineata.ro/wp-content/uploads/2018/06/1-Parcul-Carol-1170x780.jpg", "Parcul Carol")
                    };
                }
            }
        }
        return sLocations;
    }
}
