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
                            new Location("https://image.businessinsider.com/5df014b0fd9db2605576bb35?width=1100&format=jpeg&auto=webp", "China Wall", "The impenetrable fortress"),
                            new Location("https://images.unsplash.com/photo-1493931585036-a789ff27398b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80", "Banff National Park", "La munte"),
                            new Location("https://images.unsplash.com/photo-1484511487972-0e3e438c63b2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80", "Mt. Rushmore", "La capete"),
                            new Location("https://images.unsplash.com/photo-1507478565570-152c046eb559?ixlib=rb-1.2.1&auto=format&fit=crop&w=1355&q=80", "Grand Canyon, Arizona", "La canion, la caldurica"),
                            new Location("https://media-cdn.tripadvisor.com/media/photo-s/0b/9e/8a/f9/parks-in-marianske-lazne.jpg", "Marianske Lazne Park", "Cuibusor"),
                            new Location("https://www.delcopa.gov/departments/parks/images/rosetree.jpg", "Rose Tree Park - Delaware County, Pennsylvania", "Ceasul Magic"),
                            new Location("https://upload.wikimedia.org/wikipedia/commons/5/59/Regent%27s_Park_bandstand.jpg", "Reagent's Park", "La verdeata"),
                            new Location("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHE6HX6Z0sLWnqCVsa_Qy_ypWPuKR2MjBWAGFjx_G1PZbvcXXmfA&s", "Brushy Creek Park", "Bancuta fermecata"),
                            new Location("https://www.thoughtco.com/thmb/b_CaurkYlW2mXMKpKO_D_iMZaRI=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1060161030-1f65aeb45b134cc099bea94af556ddc9.jpg", "Minnesota National Park", "Iluzii optice"),
                            new Location("https://www.stlouispark.org/Home/ShowPublishedImage/3432/636656054385870000", "Aquila Park", "La parculet"),
                            new Location("https://uploads.pl-internal.com/YWQ3MmIwNWYtMDIxZS00ZmYxLTgwMzctNDViNjVkZTg5MTNi/content/2019/04/black_mudd_web_header.jpg", "Kentuckiana", "La leagane"),
                            new Location("https://static.thainationalparks.com/img/hero-space/tnp/mu-ko-chang-national-park.jpg", "Mu Ko Chang National Park"),
                            new Location("http://romaniatourism.com/images/carpathian-mountains/ceahlau-national-nature-park-romania.jpg", "Ceahlau National Park"),
                            new Location("https://www.durham.gov.uk/media/10194/Wharton-Park-distant-shot/menulistfour/DistantShot_Thirdorquarterwidth.jpg?m=636010802039170000", "Wharton Park"),
                            new Location("https://www.durham.gov.uk/media/5064/Hardwick-Park-volunteering/menulistfour/HardwickPark_ThreeImageRow.jpg?m=636125800370770000", "Hardwick Park"),
                            new Location("https://www.durham.gov.uk/media/10408/Riverside-Splashpad/menulistfour/Splashpad_Thirdorquarterwidth.jpg?m=636252815772200000", "Chester-le-Street Riverside Park"),
                            new Location("https://www.durham.gov.uk/media/28158/Blackhill-and-Consett-Park-Visitor-Information/menulistfour/BlackhillConsettVisitorInformation.jpg?m=636861769924670000", "Blackhill and Consett Park"),
                            new Location("https://www.cincinnatiparks.com/wp-content/uploads/2016/05/DSC_0063.jpg", "Cincinatii Park"),
                            new Location("https://cityofnanjing.com/wp-content/uploads/2018/09/78_park.jpg", "Xuanwu Lake Park"),
                            new Location("https://cityofnanjing.com/wp-content/uploads/2018/09/75_park.jpg", "Wuchaomen Park"),
                            new Location("https://cityofnanjing.com/wp-content/uploads/2018/09/76_park.jpg", "Qingliangshan Park"),
                            new Location("https://cityofnanjing.com/wp-content/uploads/2018/09/74_park.jpg", "Mochou Lake Park"),
                            new Location("https://cityofnanjing.com/wp-content/uploads/2018/09/73_park.jpg", "China Gate Castle Park"),
                            new Location("https://www.thewisetravellers.com/wp-content/uploads/2019/08/Nam-Ha-National-Biodiversity-Conservation-Area.jpg", "Nam Ha National Biodiversity Conservation Area"),
                            new Location("https://www.thewisetravellers.com/wp-content/uploads/2019/08/Dong-Hua-Sao-National-Protected-Area-national-parks-in-laos.jpg", "Dong Hua Sao National Protected Area (Champasak)"),
                            new Location("https://www.thewisetravellers.com/wp-content/uploads/2019/08/Bokeo-yellow-gibbon-national-parks-in-laos.jpg", "Bokeo Nature Reserve (Bokeo Province)"),
                            new Location("https://www.thewisetravellers.com/wp-content/uploads/2019/08/Phou-Khao-Khuay-National-Protected-Area-laos.jpg", "Phou Khao Khuay National Protected Area (Vientiane)")
                    };
                }
            }
        }
        return sLocations;
    }
}
