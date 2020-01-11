package com.faculty.fusedbloxxer.coachingapp.model.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "materiale")
public class Material {

    @ColumnInfo(name = "timp_estimat")
    private Long estimatedTime;

    @ColumnInfo(name = "rezumat")
    private String summary;

    @ColumnInfo(name = "url_imagine")
    private String imageUrl;

    @NonNull
    @ColumnInfo(name = "url_sursa")
    private String sourceUrl;

    @NonNull
    @ColumnInfo(name = "titlu")
    private String title;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_material")
    private Long materialId;

    public Material(Long estimatedTime, String summary, String imageUrl, @NonNull String sourceUrl, @NonNull String title, @NonNull Long materialId) {
        this.estimatedTime = estimatedTime;
        this.summary = summary;
        this.imageUrl = imageUrl;
        this.sourceUrl = sourceUrl;
        this.title = title;
        this.materialId = materialId;
    }

    @Ignore
    public Material(Long estimatedTime, String summary, String imageUrl, @NonNull String sourceUrl, @NonNull String title) {
        this.estimatedTime = estimatedTime;
        this.summary = summary;
        this.imageUrl = imageUrl;
        this.sourceUrl = sourceUrl;
        this.title = title;
    }

    public Long getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Long estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NonNull
    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(@NonNull String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
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
        return "Material{" +
                "estimatedTime=" + estimatedTime +
                ", summary='" + summary + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", title='" + title + '\'' +
                ", materialId=" + materialId +
                '}';
    }

    private static Material[] sMaterials;

    @NonNull
    public static Material[] getFakeMaterials() {
        if (sMaterials == null) {
            synchronized (Material.class) {
                if (sMaterials == null) {
                    sMaterials = new Material[]{
                            new Material(45L, null, "https://www.greatcontent.com/wp-content/uploads/2019/10/gary-vee-content-model.jpg", "https://www.youtube.com/watch?v=gciMslEFH60", "Just Because It’s Simple, Doesn’t Mean It’s Easy"),
                            new Material(50L, null, "https://firstdownfunding.com/wp-content/uploads/2019/12/Gary-Vaynerchuk.jpg", "https://www.youtube.com/watch?v=FY9N42Rwudw", "How to Find Your ‘Why’ in 2020"),
                            new Material(null, null, "https://d3t3ozftmdmh3i.cloudfront.net/production/podcast_uploaded_episode/2454369/2454369-1573863046557-301cf9b2fcea5.jpg", "https://www.youtube.com/watch?v=EOrdicZ8miA", "Be happy !"),
                            new Material(null, "Very interesting video", "https://i.ytimg.com/vi/v8cBTK45Uqw/maxresdefault.jpg", "https://www.youtube.com/watch?v=FpEszCguMJU", "Be strong :)"),
                            new Material(null, "It will be amazing how much your life will change !", "https://trendjackers.com/wp-content/uploads/2018/05/Gary-Vee-Instagram-Strategy.jpg", "https://www.youtube.com/watch?v=PL9Gj_xQlEQ", "You've got it !"),
                            new Material(null, null, "https://pbs.twimg.com/profile_images/1194087055736922113/iQmEx150_400x400.jpg", "https://www.youtube.com/watch?v=vyhu7SgvSW8", "Don't miss it !"),
                            new Material(null, null, null, "https://jamesclear.com/motivation#What%20is%20Motivation?", "Be motivated !!"),
                            new Material(30L, "Let's talk about how to overcome our tendency to multitask and focus on one thing at a time.", null, "https://jamesclear.com/motivation#Common%20Misconceptions%20About%20Motivation", "Common mistakes"),
                            new Material(null, null, null, "https://jamesclear.com/motivation#What%20to%20Do%20When%20Motivation%20Fades", "Never give up !"),
                            new Material(1000L, null, "https://pbs.twimg.com/profile_images/472421066007015424/MHUJj15g_400x400.jpeg", "https://drautoilpkl.weebly.com/uploads/1/0/8/9/108941633/before_you_quit_your_job.pdf", "Change the way you think"),
                            new Material(300L, "It advocates the importance of financial literacy, financial independence and building wealth through investing in assets,", "https://adevarul.ro/assets/adevarul.ro/MRImage/2019/05/06/5cd0092b445219c57e4d1e36/646x404.jpg?1557137730", "https://experts.richdadworld.com/assets/files/rd_fake_0519.pdf", "You have the control"),
                            new Material(400L, null, "https://americanconsequences.com/wp-content/uploads/2018/06/AMC_July2018_Kiyosaki-1500x500.jpg", "http://rd-downloads-01.s3.amazonaws.com/UnfairAdvantageDownload.pdf", "Money will mean something different"),
                            new Material(null, "Robert Toru Kiyosaki is an American businessman and author. Kiyosaki is the founder of Rich Global LLC and the Rich Dad Company, a private financial education company that provides personal finance and business education", "https://media12.s-nbcnews.com/j/MSNBC/Components/Video/201908/d_better_inv_kiyosaki_1908212.760;428;7;70;5.jpg", "https://s3.amazonaws.com/rd-downloads-01/Rich-Dad-Poor-Dad-eBook.pdf", "You will not regret it.")
                    };
                }
            }
        }
        return sMaterials;
    }
}
