package com.anuj.potdar.redditclient;

import retrofit2.Call;

import com.anuj.potdar.redditclient.model.Feed;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by potda on 6/19/2018.
 */

public interface APIInterface {

    @GET(".json")
    Call<Feed> getHomePageFeed();

    @GET("r/{feed_name}/.json")
    Call<Feed> getUserEnteredFeed(@Path("feed_name") String url);

}
