package com.anuj.potdar.redditclient;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anuj.potdar.redditclient.databinding.ActivityMainBinding;
import com.anuj.potdar.redditclient.landingPage.fragment.HomePageFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        navigateToHomePage();

        setContentView(binding.getRoot());
    }

    @Override
    public void onBackPressed() {
//        AlertDialog alertDialog = new AlertDialog(this,true,new CancelLis)
        super.onBackPressed();
    }

    private void navigateToHomePage() {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.parentFrameLayout.getId(), HomePageFragment.newInstance())
                .commit();
    }
}
