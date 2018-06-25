package com.anuj.potdar.redditclient.landingPage.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anuj.potdar.redditclient.APIInterface;
import com.anuj.potdar.redditclient.FeedAdapter;
import com.anuj.potdar.redditclient.R;
import com.anuj.potdar.redditclient.ServiceGenerator;
import com.anuj.potdar.redditclient.databinding.FragmentHomePageBinding;
import com.anuj.potdar.redditclient.landingPage.viewmodel.HomePageViewModel;
import com.anuj.potdar.redditclient.model.Child;
import com.anuj.potdar.redditclient.model.Feed;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {

    private FragmentHomePageBinding binding;
    private static final String ARG_CHILDREN = "childrenList";
    private ArrayList<Child> children;

    public HomePageFragment() {
        // Required empty public constructor
    }

    public static HomePageFragment newInstance(ArrayList<Child> children){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CHILDREN, children);

        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page,container,false);
        Bundle args = getArguments();
        if (args != null) {
            children = (ArrayList<Child>) args.getSerializable(ARG_CHILDREN);
        }
        HomePageViewModel viewModel = new HomePageViewModel(this,children);

        return binding.getRoot();
    }


    public FragmentHomePageBinding getBinding() {
        return binding;
    }
}
