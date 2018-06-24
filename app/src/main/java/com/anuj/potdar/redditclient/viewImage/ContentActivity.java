package com.anuj.potdar.redditclient.viewImage;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.anuj.potdar.redditclient.R;
import com.anuj.potdar.redditclient.databinding.ActivityImageBinding;
import com.anuj.potdar.redditclient.model.Child;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ContentActivity extends AppCompatActivity {

    ActivityImageBinding binding;
    Child child;
    public static final String SELFTEXT = "selftext";
    public static final String IMAGE = "image";
    public static final String VIDEO = "video";

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image);

        String type= getIntent().getStringExtra("type");
        child = (Child) getIntent().getSerializableExtra("child");

        switch (type){
            case IMAGE : setupImage();
                        break;

            case VIDEO : setupVideo();
                        break;

            case SELFTEXT : setupSelfText();
                        break;

            default: break;
        }

        setContentView(binding.getRoot());
    }

    private void setupVideo() {
    }

    private void setupSelfText() {
        binding.selfTextScroll.setVisibility(View.VISIBLE);
        binding.title.setText(child.getData().getTitle());
        binding.selfText.setText(child.getData().getSelftext());
    }

    private void setupImage(){
        binding.selectedImage.setVisibility(View.VISIBLE);

        RequestOptions options = new RequestOptions()
//                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .dontTransform()
                .placeholder(R.drawable.imageloading)
                .error(R.drawable.imageloading);

        Glide.with(this).load(child.getData().getUrl()).apply(options).into(binding.selectedImage);
    }
}
