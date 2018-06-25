package com.anuj.potdar.redditclient.login.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.anuj.potdar.redditclient.APIInterface;
import com.anuj.potdar.redditclient.MainNavigation;
import com.anuj.potdar.redditclient.databinding.FragmentLoginBinding;
import com.anuj.potdar.redditclient.login.fragment.LoginFragment;
import com.anuj.potdar.redditclient.login.model.CheckLogin;
import com.anuj.potdar.redditclient.model.Feed;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by potda on 6/23/2018.
 */

public class LoginViewModel {

    public static final String LOGIN_URL = "https://www.reddit.com/api/login/";
    private static final String TAG = "LoginViewModel";
    private MainNavigation mainNavigation;

    private FragmentLoginBinding binding;
    private LoginFragment fragment;
    private Context context;

    public LoginViewModel(LoginFragment fragment){
        this.binding = fragment.getBinding();
        this.context = fragment.getContext();
        this.fragment = fragment;
        init();
    }

    private void init(){

        mainNavigation = (MainNavigation) fragment.getActivity();

        binding.loginLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainNavigation.navigateToHomePage(null);
            }
        });

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.user.getText().toString();
                String password = binding.password.getText().toString();

                if(username==null){
                    binding.userTextInput.setError("Required field");
                }

                if(password==null){
                    binding.passwordTextInput.setError("Required field");
                }

                if (username!=null && password!=null){
                    if(!username.isEmpty() && !password.isEmpty()){
                        binding.userTextInput.setErrorEnabled(false);
                        binding.passwordTextInput.setErrorEnabled(false);
                        authenticateUser(username,password);
//                        mainNavigation.navigateToHomePage();
                    }
                }
            }
        });
    }

    private void authenticateUser(final String username, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LOGIN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");

        binding.progressBar.setVisibility(View.VISIBLE);
        binding.loginButton.setVisibility(View.GONE);

        Call<CheckLogin> signIn = apiInterface.signIn(headerMap,username,username, password, "json");

        signIn.enqueue(new Callback<CheckLogin>() {
            @Override
            public void onResponse(Call<CheckLogin> call, Response<CheckLogin> response) {
                if(response.body()!=null){
                    if(response.body().getJson().getData()!=null){
                        String modhash = response.body().getJson().getData().getModhash();
                        String cookie = response.body().getJson().getData().getCookie();

                        if(modhash!=null){
                            if(!modhash.equals("")){
                                setSessionParams(username, modhash, cookie);
                                binding.progressBar.setVisibility(View.GONE);
                                binding.user.setText("");
                                binding.password.setText("");

                                mainNavigation.navigateToHomePage(null);
                            }
                        }
                    }else{
                        binding.progressBar.setVisibility(View.GONE);
                        binding.loginButton.setVisibility(View.VISIBLE);
                        Snackbar snackbar = Snackbar.make(binding.layoutForSnackbar,"Invalid Username or Password",Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }

                }

            }

            @Override
            public void onFailure(Call<CheckLogin> call, Throwable t) {

            }
        });

    }

    private void setSessionParams(String username, String modhash, String cookie){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("@string/SessionUsername", username);
        editor.commit();
        editor.putString("@string/SessionModhash", modhash);
        editor.commit();
        editor.putString("@string/SessionCookie", cookie);
        editor.commit();
    }
}
