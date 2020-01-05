package com.faculty.fusedbloxxer.coachingapp.home;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.faculty.fusedbloxxer.coachingapp.App;

public class OptionsViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> selectedOption;
    private SharedPreferences sharedPreferences;

    public OptionsViewModel(@NonNull Application application) {
        super(application);
        this.sharedPreferences = application.getSharedPreferences(App.APP_KEY, Context.MODE_PRIVATE);
    }

    public LiveData<Integer> getSelectedOption(String key) {
        if (selectedOption == null) {
            synchronized (this) {
                if (selectedOption == null) {
                    selectedOption = new MutableLiveData<>(sharedPreferences.getInt(key, -1));
                }
            }
        }
        return selectedOption;
    }

    public void setSelectedOption(Integer selectedOption, String key) {
        this.sharedPreferences.edit().putInt(key, selectedOption).apply();
        this.selectedOption.setValue(selectedOption);
    }
}