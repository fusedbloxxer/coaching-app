package com.faculty.fusedbloxxer.coachingapp.home.bestcoaches;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;

public class ScoreViewModel extends ViewModel {

    public static final float DEFAULT_AVG_SCORE = 0.0f;
    public static final float DEFAULT_MAX_SCORE = 0.0f;

    private MutableLiveData<Pair<Float, Float>> scoresMutableLiveData;

    public ScoreViewModel() {
        this.scoresMutableLiveData = new MutableLiveData<>(new Pair<>(DEFAULT_AVG_SCORE, DEFAULT_MAX_SCORE));
    }

    public void setScores(@NonNull Float avgScore, @NonNull Float maxScore) {
        this.scoresMutableLiveData.setValue(new Pair<>(avgScore, maxScore));
    }

    public LiveData<Pair<Float, Float>> getScoresLiveData() {
        return this.scoresMutableLiveData;
    }
}
