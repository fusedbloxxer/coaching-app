package com.faculty.fusedbloxxer.coachingapp.utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;

import com.faculty.fusedbloxxer.coachingapp.home.INavigable;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static final int GEN_COUNT = 35;
    public static final String DATE_FORMAT = "E, dd MMM yyyy HH:mm:ss";
    public static final String SORT_TITLE = "Sorteaza dupa: ";

    public static Date timestamp() {
        return new Date(ThreadLocalRandom.current().nextInt() * 1000L);
    }

    public static float randomNumber(float bound) {
        return Math.abs(new Random().nextInt()) % bound;
    }

    public static boolean checkEditText(EditText editText) {
        if (editText.getText().length() <= 0) {
            editText.setError("Acest camp este obligatoriu!");
            return false;
        }
        return true;
    }

    public static boolean checkEditTexts(EditText... editTexts) {
        for (EditText e : editTexts) {
            if (!checkEditText(e)) {
                return false;
            }
        }
        return true;
    }

    public static String[] getItemOptions() {
        return new String[]{
                "Modificare informatii",
                "Stergere informatii"
        };
    }

    public static <T> void createItemOptions(final Context context, INavigable<T> listener, T elementId) {
        createItemOptions(context, listener, elementId, getItemOptions());
    }

    public static <T> void createItemOptions(final Context context, INavigable<T> listener, T elementId, String[] options) {
        new AlertDialog.Builder(context)
                .setTitle("Optiuni:")
                .setItems(options, (dialogInterface, i) -> listener.updateOrDelete(elementId, i))
                .create()
                .show();
    }
}
