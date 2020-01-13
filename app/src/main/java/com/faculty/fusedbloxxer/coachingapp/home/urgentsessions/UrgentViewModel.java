package com.faculty.fusedbloxxer.coachingapp.home.urgentsessions;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;

public class UrgentViewModel extends ViewModel {

    public static final long DEFAULT_PRIORITY = 0L;
    public static final long DEFAULT_REWARD = 0L;

    private MutableLiveData<Pair<Long, Long>> rewardAndPriority;

    public UrgentViewModel() {
        this.rewardAndPriority = new MutableLiveData<>(new Pair<>(DEFAULT_REWARD, DEFAULT_PRIORITY));
    }

    public void setRewardAndPriority(@NonNull Long rewardPoints, @NonNull Long priority) {
        this.rewardAndPriority.setValue(new Pair<>(rewardPoints, priority));
    }

    public LiveData<Pair<Long, Long>> getRewardAndPriority() {
        return rewardAndPriority;
    }
}
