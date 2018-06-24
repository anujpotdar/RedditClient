package com.anuj.potdar.redditclient;

import okhttp3.ResponseBody;
import retrofit2.Call;

import com.anuj.potdar.redditclient.login.model.CheckLogin;
import com.anuj.potdar.redditclient.model.Feed;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by potda on 6/19/2018.
 */

public interface APIInterface {

    @GET(".json")
    Call<Feed> getHomePageFeed();

    @GET("{feed_name}/.json")
    Call<Feed> getUserEnteredFeed(@Path("feed_name") String url);

    @GET("{feed_name}/.json")
    Call<ResponseBody> getCommentsFeed(@Path("feed_name") String url);

    @POST("{user}")
    Call<CheckLogin> signIn(
            @HeaderMap Map<String, String> headers,
            @Path("user") String username,
            @Query("user") String user,
            @Query("passwd") String password,
            @Query("api_type") String type
    );

}
