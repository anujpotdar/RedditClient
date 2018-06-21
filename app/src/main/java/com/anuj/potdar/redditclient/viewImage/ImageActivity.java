package com.anuj.potdar.redditclient.viewImage;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anuj.potdar.redditclient.R;
import com.anuj.potdar.redditclient.databinding.ActivityImageBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class ImageActivity extends AppCompatActivity {

    ActivityImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image);

        String imageUrl= getIntent().getStringExtra("imageUrl");

        RequestOptions options = new RequestOptions()
//                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .dontTransform()
                .placeholder(R.drawable.imageloading)
                .error(R.drawable.imageloading);

        Glide.with(this).load(imageUrl).apply(options).into(binding.selectedImage);

        setContentView(binding.getRoot());
    }
}
