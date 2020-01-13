package com.faculty.fusedbloxxer.coachingapp.model.db.containers;

import androidx.annotation.NonNull;

public class UrgentSession {
    private String username, problemTitle, sessionTitle, sessionDescription, imageUrl, street;
    private Long rewardPoints, priority, estimatedTime;

    public UrgentSession(String username, String problemTitle, String sessionTitle, String sessionDescription, String imageUrl, String street, Long rewardPoints, Long priority, Long estimatedTime) {
        this.username = username;
        this.problemTitle = problemTitle;
        this.sessionTitle = sessionTitle;
        this.sessionDescription = sessionDescription;
        this.imageUrl = imageUrl;
        this.street = street;
        this.rewardPoints = rewardPoints;
        this.priority = priority;
        this.estimatedTime = estimatedTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public String getSessionTitle() {
        return sessionTitle;
    }

    public void setSessionTitle(String sessionTitle) {
        this.sessionTitle = sessionTitle;
    }

    public String getSessionDescription() {
        return sessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Long estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    @NonNull
    @Override
    public String toString() {
        return "UrgentSession{" +
                "username='" + username + '\'' +
                ", problemTitle='" + problemTitle + '\'' +
                ", sessionTitle='" + sessionTitle + '\'' +
                ", sessionDescription='" + sessionDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", street='" + street + '\'' +
                ", rewardPoints=" + rewardPoints +
                ", priority=" + priority +
                ", estimatedTime=" + estimatedTime +
                '}';
    }
}
