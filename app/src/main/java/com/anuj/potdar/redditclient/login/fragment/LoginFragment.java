package com.anuj.potdar.redditclient.login.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anuj.potdar.redditclient.R;
import com.anuj.potdar.redditclient.databinding.FragmentLoginBinding;
import com.anuj.potdar.redditclient.login.viewmodel.LoginViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    private LoginViewModel viewmodel;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(){
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);

        viewmodel = new LoginViewModel(this);

        return binding.getRoot();
    }

    public FragmentLoginBinding getBinding(){
        return binding;
    }

}
