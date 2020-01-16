package com.faculty.fusedbloxxer.coachingapp.model.db.views;

import androidx.room.DatabaseView;

import static com.faculty.fusedbloxxer.coachingapp.model.db.views.SpecialTask.QUERY;

@DatabaseView(QUERY)
public class SpecialTask {
    public static final String QUERY = "SELECT descriere AS description, UPPER(titlu) AS upperTitle," +
            "(CASE " +
            "WHEN puncte_premiu * 2 > 100 THEN 100 " +
            "ELSE puncte_premiu * 2 " +
            "END) AS doubledRewards " +
            "FROM sarcini";

    private String upperTitle;

    private String description;

    private Long doubledRewards;

    public String getUpperTitle() {
        return upperTitle;
    }

    public void setUpperTitle(String upperTitle) {
        this.upperTitle = upperTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDoubledRewards() {
        return doubledRewards;
    }

    public void setDoubledRewards(Long doubledRewards) {
        this.doubledRewards = doubledRewards;
    }

    @Override
    public String toString() {
        return "SpecialTask{" +
                "upperTitle='" + upperTitle + '\'' +
                ", description='" + description + '\'' +
                ", doubledRewards=" + doubledRewards +
                '}';
    }
}
