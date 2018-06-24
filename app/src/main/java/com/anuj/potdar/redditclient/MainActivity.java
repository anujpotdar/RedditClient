package com.anuj.potdar.redditclient;

import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anuj.potdar.redditclient.databinding.ActivityMainBinding;
import com.anuj.potdar.redditclient.landingPage.fragment.HomePageFragment;
import com.anuj.potdar.redditclient.login.fragment.LoginFragment;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements MainNavigation {

    ActivityMainBinding binding;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        navigateToLogin();

        navigateToSplash();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToHomePage();
            }
        }, 3000);


        setContentView(binding.getRoot());
    }

    private void navigateToSplash() {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.parentFrameLayout.getId(), SplashFragment.newInstance())
                .commit();
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

    public void navigateToHomePage() {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.parentFrameLayout.getId(), HomePageFragment.newInstance())
                .commit();
    }

    public void navigateToLogin() {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.parentFrameLayout.getId(), LoginFragment.newInstance())
                .commit();
    }
}
