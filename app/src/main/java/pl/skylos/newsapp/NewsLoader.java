package pl.skylos.newsapp;

/**
 * Created by Misiek on 05.03.2018.
 */

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Loads a list of newses by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /** Tag for log messages */
    private static final String LOG_TAG = NewsLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        Log.v("starting", "StartLoading working");
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        Log.v("background", "Background working");
        // Perform the network request, parse the response, and extract a list of newses.
        List<News> newses = QueryUtils.fetchNewsData(mUrl);
        return newses;
    }
}