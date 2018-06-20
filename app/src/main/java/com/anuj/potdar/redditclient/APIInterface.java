package com.anuj.potdar.redditclient;

import retrofit2.Call;

import com.anuj.potdar.redditclient.model.Feed;

import retrofit2.http.GET;

/**
 * Created by potda on 6/19/2018.
 */

public interface APIInterface {

    @GET(".json")
    Call<Feed> getFeed();

}
