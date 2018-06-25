package com.anuj.potdar.redditclient.landingPage.viewmodel;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.anuj.potdar.redditclient.APIInterface;
import com.anuj.potdar.redditclient.FeedAdapter;
import com.anuj.potdar.redditclient.R;
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
    ArrayList<Child> childrenGlobal;
    String lastSearchedUrl;
    boolean hasSearched = false;

    public HomePageViewModel(HomePageFragment fragment, ArrayList<Child> children) {
        this.fragment = fragment;
        this.context = fragment.getContext();
        this.binding = fragment.getBinding();
        this.childrenGlobal = children;
        init();
    }

    private void init(){
        apiInterface = ServiceGenerator.createService(APIInterface.class,context);
        setupRecyclerList();
//        downloadFeed();
        setupSearchView();
        setupSwipeToRefresh();
        setupRetryButton();
        displayHomeFeed();
    }

    private void displayHomeFeed() {
        binding.progressBar.setVisibility(View.GONE);
        feedAdapter = new FeedAdapter(childrenGlobal,context);
        binding.feedList.setAdapter(feedAdapter);
    }

    private void setupRetryButton() {
        binding.retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRefreshList();
                binding.progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    private void selectRefreshList(){
        if (hasSearched){
            downloadUserEnteredFeed(lastSearchedUrl);
        }else {
            downloadFeed();
        }
    }

    private void setupSearchView() {

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = binding.searchText.getText().toString();
                if(query!=null){
                    if(!query.trim().equals("")){
                        binding.swipeToRefresh.setRefreshing(true);
                        downloadUserEnteredFeed(query);
                    }
                }
            }
        });

    }

    private void downloadUserEnteredFeed(final String url) {
        Call<Feed> feedCall = apiInterface.getUserEnteredFeed("r/"+url);
        feedCall.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if(response!=null){
                    if(response.body()!=null){
                        binding.progressBar.setVisibility(View.GONE);
                        binding.swipeToRefresh.setRefreshing(false);
                        hasSearched = true;
                        lastSearchedUrl = url;
                        Feed feed = response.body();
                        ArrayList<Child> children = (ArrayList<Child>)feed.getData().getChildren();
                        feedAdapter = new FeedAdapter(children,context);
                        binding.feedList.setAdapter(feedAdapter);
                        binding.swipeToRefresh.setRefreshing(false);
                        binding.feedList.setVisibility(View.VISIBLE);
                    }

                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                hasSearched = true;
                lastSearchedUrl = url;
                binding.progressBar.setVisibility(View.GONE);
                binding.errorView.setVisibility(View.VISIBLE);
                binding.swipeToRefresh.setRefreshing(false);
                binding.feedList.setVisibility(View.GONE);
            }
        });
    }

    private void setupSwipeToRefresh() {
        binding.swipeToRefresh.setColorSchemeResources(R.color.colorPrimary);
        binding.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                selectRefreshList();
            }
        });
    }

    private void setupRecyclerList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        binding.feedList.setLayoutManager(linearLayoutManager);
    }

    private void downloadFeed() {
        binding.errorView.setVisibility(View.GONE);
        Call<Feed> feedCall = apiInterface.getHomePageFeed();
        feedCall.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if(response!=null){
                    binding.progressBar.setVisibility(View.GONE);
                    binding.swipeToRefresh.setRefreshing(false);
                    hasSearched = false;
                    Feed feed = response.body();
                    ArrayList<Child> children = (ArrayList<Child>)feed.getData().getChildren();
                    feedAdapter = new FeedAdapter(children,context);
                    binding.feedList.setAdapter(feedAdapter);
                    binding.feedList.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                binding.errorView.setVisibility(View.VISIBLE);
                hasSearched = false;
                binding.progressBar.setVisibility(View.GONE);
                binding.swipeToRefresh.setRefreshing(false);
                binding.feedList.setVisibility(View.GONE);
            }
        });
    }

}
