package pl.skylos.newsapp;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Misiek on 05.03.2018.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public static final String LOG_TAG = MainActivity.class.getName();
    private static final String LOCATION_SEPARATOR = " of ";

    public NewsAdapter(Activity context, ArrayList<News> newses) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, newses);
    }
    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link News} object located at this position in the list
        News currentNews = getItem(position);

        String sectionName = currentNews.getSection();
        // Find the TextView in the list_item.xml layout with the ID section
        TextView sectionTextView = listItemView.findViewById(R.id.section);
        // Get the section name from the current News object and
        // set this text on the name TextView
        sectionTextView.setText(sectionName);

        // Get the title string from the News object.
        String newsTitle = currentNews.getTitle();
        // Assign title string to current News object.
        TextView titleTextView = listItemView.findViewById(R.id.title);
        titleTextView.setText(newsTitle);

        // Find the TextView with view ID date
        TextView dateView = listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String date = currentNews.getDate();
        // Display the date of the current earthquake in that TextView
        dateView.setText(date);


        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}