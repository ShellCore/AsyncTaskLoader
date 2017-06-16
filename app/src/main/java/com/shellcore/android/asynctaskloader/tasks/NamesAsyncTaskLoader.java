package com.shellcore.android.asynctaskloader.tasks;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Cesar on 16/06/2017.
 */

public class NamesAsyncTaskLoader extends AsyncTaskLoader<ArrayList<String>> {

    public NamesAsyncTaskLoader(Context context) {
        super(context);
    }

    /**
     * This function is going to load the data when the application starts
     */
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad(); // This function will force to start loadInBackground() immediately
    }

    @Override
    public ArrayList<String> loadInBackground() {
        return loadNamesFromDB();
    }

    private ArrayList<String> loadNamesFromDB() {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.add("Anna");
        names.add("Peter");
        names.add("Steven");
        names.add("Cloe");

        return names;
    }
}
