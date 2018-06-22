package com.anuj.potdar.redditclient;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
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

    private void navigateToHomePage() {
        getSupportFragmentManager().beginTransaction()
                .replace(binding.parentFrameLayout.getId(), HomePageFragment.newInstance())
                .commit();
    }
}
