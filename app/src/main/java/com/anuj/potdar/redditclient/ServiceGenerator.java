package com.anuj.potdar.redditclient;



import android.content.Context;

import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by potda on 6/19/2018.
 */

public class ServiceGenerator {


    public static final String BASE_URL = "https://www.reddit.com/";


    private static OkHttpClient.Builder httpClient;

    //Here a logging interceptor is created
    private static HttpLoggingInterceptor logging ;

    static {
        logging = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);


        //The logging interceptor will be added to the http client
        httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();

                return chain.proceed(request);
            }
        });

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);

    }


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create()))
                    .client(httpClient.build());

    private static Retrofit retrofit;


    public static <S> S createService(Class<S> serviceClass, Context context) {

        OkHttpClient client = httpClient.build();
        retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);

    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }


}