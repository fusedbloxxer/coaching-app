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
                            new Location("https://s.inyourpocket.com/img/figure/2015-04/Lacul_din_Parcul_Titan.jpg", "Strada Baba Novac", "La Cuza"),
                            new Location("https://upload.wikimedia.org/wikipedia/commons/0/04/Parcul_Tineretului.jpg", "Parcul Tineretului", "Titanel"),
                            new Location("https://cdn.g4media.ro/wp-content/uploads/2019/08/parcul-cismigiu-640x400.jpg", "Parcul Cismigiu"),
                            new Location("https://upload.wikimedia.org/wikipedia/commons/0/0b/Parcul_Izvor_%281%29.jpg", "Parcul Izvor"),
                            new Location("https://editiadedimineata.ro/wp-content/uploads/2018/06/1-Parcul-Carol-1170x780.jpg", "Parcul Carol"),
                            new Location("https://www.planetware.com/wpimages/2019/10/asia-best-places-to-visit-mount-fuji-japan.jpg", "Fuji Japan", "Cool place"),
                            new Location("https://media.cntraveler.com/photos/5ddd54cd5776370009939c09/master/pass/Argentina_GettyImages-1146497849.jpg", "Argentina", ""),
                            new Location("https://images.adsttc.com/media/images/5d44/14fa/284d/d1fd/3a00/003d/newsletter/eiffel-tower-in-paris-151-medium.jpg?1564742900", "Paris", "The city of love"),
                            new Location("https://image.businessinsider.com/5df014b0fd9db2605576bb35?width=1100&format=jpeg&auto=webp", "China Wall", "The impenetrable fortress")
                    };
                }
            }
        }
        return sLocations;
    }
}
