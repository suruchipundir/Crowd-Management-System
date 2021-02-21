package com.example.crowdmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {
    VideoView originalVideo, flowVideo, overlayVideo, colormapVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        originalVideo = findViewById(R.id.originalVideo);
        /*overlayVideo = findViewById(R.id.overlayVideo);
        flowVideo = findViewById(R.id.flowVideo);
        colormapVideo = findViewById(R.id.colormapVideo);*/
        String path = "android.resource://" + getPackageName() + "/" + R.raw.original;
        originalVideo.setVideoURI(Uri.parse(path));
        originalVideo.start();
    }

    public void onOverlayClicked(View view){
        Intent intent = new Intent(this, Overlay.class);
        startActivity(intent);
    }
    public void oncolorMapClicked(View view){
        Intent intent = new Intent(this, colorMap.class);
        startActivity(intent);

    }
    public void onFlowClicked(View view){
        Intent intent = new Intent(this, flow.class);
        startActivity(intent);
        /*String path = "android.resource://" + getPackageName() + "/" + R.raw.overlay;
        overlayVideo.setVideoURI(Uri.parse(path));
        overlayVideo.setVideoPath("");
        overlayVideo.start();
        path = "android.resource://" + getPackageName() + "/" + R.raw.colormap;
        colormapVideo.setVideoURI(Uri.parse(path));
        colormapVideo.setVideoPath("");
        colormapVideo.start();
        path = "android.resource://" + getPackageName() + "/" + R.raw.flow;
        flowVideo.setVideoURI(Uri.parse(path));
        flowVideo.setVideoPath("");
        flowVideo.start();*/
    }
}