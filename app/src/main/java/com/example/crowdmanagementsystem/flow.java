package com.example.crowdmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class flow extends AppCompatActivity {
    ProgressBar pb;
    VideoView overlayVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        pb = findViewById(R.id.pbFlow);
        pb.setVisibility(View.VISIBLE);
        overlayVideo = findViewById(R.id.flowVideo);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.GONE);
                String path = "android.resource://" + getPackageName() + "/" + R.raw.flow;
                overlayVideo.setVideoURI(Uri.parse(path));
                overlayVideo.setVideoPath("");
                overlayVideo.start();
            }
        }, 4000);
    }
}