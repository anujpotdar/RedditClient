package com.anuj.potdar.redditclient;

import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.anuj.potdar.redditclient.databinding.ActivityMainBinding;
import com.anuj.potdar.redditclient.landingPage.fragment.HomePageFragment;
import com.anuj.potdar.redditclient.login.fragment.LoginFragment;
import com.anuj.potdar.redditclient.model.Child;
import com.anuj.potdar.redditclient.model.Feed;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements MainNavigation {

    ActivityMainBinding binding;
    private APIInterface apiInterface;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        apiInterface = ServiceGenerator.createService(APIInterface.class,this);

        navigateToSplash();

        downloadFeed();

        setContentView(binding.getRoot());
    }

    private void navigateToSplash() {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.parentFrameLayout.getId(), SplashFragment.newInstance())
                .commit();
    }

    private void downloadFeed() {

        Call<Feed> feedCall = apiInterface.getHomePageFeed();
        feedCall.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if(response!=null){

                    Feed feed = response.body();
                    ArrayList<Child> children = (ArrayList<Child>)feed.getData().getChildren();
                    navigateToHomePage(children);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                final Snackbar mSnackbar = Snackbar.make(binding.parentFrameLayout, "Unable to connect", Snackbar.LENGTH_INDEFINITE)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                downloadFeed();
                            }
                        });
                mSnackbar.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        showExitDialog();
//        super.onBackPressed();
    }

    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.msg_exit));

        String positiveText = this.getString(android.R.string.yes);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();

                    }
                });

        String negativeText = this.getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void navigateToHomePage(ArrayList<Child> children) {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.parentFrameLayout.getId(), HomePageFragment.newInstance(children))
                .commit();
    }

    public void navigateToLogin() {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.parentFrameLayout.getId(), LoginFragment.newInstance())
                .commit();
    }
}
