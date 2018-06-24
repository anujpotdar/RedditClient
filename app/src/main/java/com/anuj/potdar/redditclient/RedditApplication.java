package com.anuj.potdar.redditclient;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by potda on 6/24/2018.
 */

public class RedditApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MyriadProRegular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
