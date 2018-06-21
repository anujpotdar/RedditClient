package com.anuj.potdar.redditclient.landingPage.viewmodel;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.anuj.potdar.redditclient.APIInterface;
import com.anuj.potdar.redditclient.FeedAdapter;
import com.anuj.potdar.redditclient.ServiceGenerator;
import com.anuj.potdar.redditclient.databinding.FragmentHomePageBinding;
import com.anuj.potdar.redditclient.landingPage.fragment.HomePageFragment;
import com.anuj.potdar.redditclient.model.Child;
import com.anuj.potdar.redditclient.model.Feed;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by potda on 6/20/2018.
 */

public class HomePageViewModel {

    private HomePageFragment fragment;
    private FragmentHomePageBinding binding;
    private Context context;
    private APIInterface apiInterface;
    private FeedAdapter feedAdapter;

    public HomePageViewModel(HomePageFragment fragment) {
        this.fragment = fragment;
        this.context = fragment.getContext();
        this.binding = fragment.getBinding();
        init();
    }

    private void init(){
        apiInterface = ServiceGenerator.createService(APIInterface.class,context);
        setupRecyclerList();
        downloadFeed();
        setupSearchView();
        setupSwipeToRefresh();
    }

    private void setupSearchView() {
        binding.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(!query.trim().equals("") && query!=null){
                    downloadUserEnteredFeed(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void downloadUserEnteredFeed(String url) {
        Call<Feed> feedCall = apiInterface.getUserEnteredFeed(url);
        feedCall.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if(response!=null){
                    if(response.body()!=null){
                        binding.progressBar.setVisibility(View.GONE);
                        binding.swipeToRefresh.setRefreshing(false);
                        Feed feed = response.body();
                        ArrayList<Child> children = (ArrayList<Child>)feed.getData().getChildren();
                        feedAdapter = new FeedAdapter(children,context);
                        binding.feedList.setAdapter(feedAdapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {

            }
        });
    }

    private void setupSwipeToRefresh() {

        binding.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                downloadFeed();
            }
        });
    }

    private void setupRecyclerList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        binding.feedList.setLayoutManager(linearLayoutManager);
    }

    private void downloadFeed() {
        Call<Feed> feedCall = apiInterface.getHomePageFeed();
        feedCall.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if(response!=null){
                    binding.progressBar.setVisibility(View.GONE);
                    binding.swipeToRefresh.setRefreshing(false);
                    Feed feed = response.body();
                    ArrayList<Child> children = (ArrayList<Child>)feed.getData().getChildren();
                    feedAdapter = new FeedAdapter(children,context);
                    binding.feedList.setAdapter(feedAdapter);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                    binding.swipeToRefresh.setRefreshing(false);
            }
        });
    }

}
