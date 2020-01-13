package com.faculty.fusedbloxxer.coachingapp.model.db.containers;

public class CoachWithScores {
    private String coachName;
    private Float avgScore, maxScore;

    public CoachWithScores(String coachName, Float avgScore, Float maxScore) {
        this.coachName = coachName;
        this.avgScore = avgScore;
        this.maxScore = maxScore;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Float avgScore) {
        this.avgScore = avgScore;
    }

    public Float getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Float maxScore) {
        this.maxScore = maxScore;
    }
}
