package com.example.crowdmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class colorMap extends AppCompatActivity {
    ProgressBar pb;
    VideoView overlayVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_map);
        pb = findViewById(R.id.pbcolormap);
        pb.setVisibility(View.VISIBLE);
        overlayVideo = findViewById(R.id.colormapVideo);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.GONE);
                String path = "android.resource://" + getPackageName() + "/" + R.raw.colormap;
                overlayVideo.setVideoURI(Uri.parse(path));
                overlayVideo.setVideoPath("");
                overlayVideo.start();
            }
        }, 4000);
    }
}