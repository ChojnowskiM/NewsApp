package pl.skylos.newsapp;

import java.net.URL;

/**
 * Created by Misiek on 05.03.2018.
 */

public class News {
    // News title
    private String mWebTitle;

    // News section
    private String mSection;

    // News date
    private String mDate;
    // News URL
    private String mUrl;
    /*
    * Create a new AndroidFlavor object.
    *
    * @param vTitle is the title of article.
    * @param vSection is the corresponding section of article.
    * @param vDate is date published of corresponding article.
    * @param vUrl is corresponding URL link to article.
    * */
    public News(String title, String vSection, String vDate, String vUrl)
    {
        mWebTitle = title;
        mSection = vSection;
        mDate = vDate;
        mUrl = vUrl;
    }

    /**
     * Get the title of article
     */
    public String getTitle() {
        return mWebTitle;
    }

    /**
     * Get the section of article
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Get the publish date of article
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Get the URL to article
     */
    public String getUrl() {
        return mUrl;
    }
}
