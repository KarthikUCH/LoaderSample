package com.loadersample;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by karthikeyan on 18/2/17.
 */

public class StringLoader extends android.support.v4.content.AsyncTaskLoader<ArrayList<String>> {

    public StringLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
       // super.onStartLoading();

        forceLoad();
    }

    @Override
    public ArrayList<String> loadInBackground() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(Arrays.asList(getContext().getResources().getStringArray(R.array.item_lst)));
    }

    @Override
    protected void onReset() {
        super.onReset();
    }
}
