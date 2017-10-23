package com.srikanth.dynamicfont;

import android.content.Context;
import android.graphics.Typeface;
import android.os.AsyncTask;

/**
 * Created by srikanth on 23/10/17.
 */

public class FontConfig {
    private final Context mContext;
    private FontConfig(Context context) {
        this.mContext = context;
    }


    public static FontConfig with(Context context) {
        return new FontConfig(context);
    }

    public void loadFont(final String url, final Callback<Typeface> callback) {
        new AsyncTask<Object, String, String>() {
            @Override
            protected String doInBackground(Object... objects) {
                return FontDownloader.getUrlImage(url, mContext);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callback.send(Typeface.createFromFile(s));

            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

}
