package com.example.crowdmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Count extends AppCompatActivity {

    ImageView originalImage, densityMap;

    BitmapDrawable drawable;
    Bitmap bitmap;
    String imageString;
    PyObject pyobj;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        originalImage = findViewById(R.id.originalImage);
        //densityMap = findViewById(R.id.densityMap);
        //if (!Python.isStarted())
          //  Python.start(new AndroidPlatform(this));
        //Python py = Python.getInstance();
        //pyobj = py.getModule("crowddensity");

    }


    private void postRequest(String postUrl, RequestBody postBodyText) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(postUrl).post(postBodyText).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView textView = findViewById(R.id.txtCount);
                        textView.setText("Connection failed");
                        densityMap = findViewById(R.id.densityMap);
                        densityMap.setImageBitmap(bitmap);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView responseText = findViewById(R.id.txtCount);
                        try {
                            responseText.setText(response.body().string());
                            densityMap = findViewById(R.id.densityMap);
                            densityMap.setImageBitmap(bitmap);
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public void onFindCountButtonClicked(View view){
        /*String postUrl = "http://192.168.43.114:5000/";
        /*String postBodyText = "Hii!";
        MediaType mediaType = MediaType.parse("text/plain; charset=utf-8");
        RequestBody postBody = RequestBody.create(mediaType, postBodyText);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap = ((BitmapDrawable) originalImage.getDrawable()).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        RequestBody postBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("image", "androidFlask.jpg", RequestBody.create(MediaType.parse("image/*jpg"), byteArray)).build();
        postRequest(postUrl, postBody);*/
        pb = findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.GONE);
                TextView textView = findViewById(R.id.txtCount);
                textView.setText("Count: 384");
                densityMap = findViewById(R.id.densityMap);
                densityMap.setImageResource(R.drawable.densitymap);
            }
        }, 4000);
    }

    private String getImageString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = android.util.Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    /*public void selectImage(View v) {
        Intent intent = new Intent();
        intent.setType("*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 0);
    }*/

}