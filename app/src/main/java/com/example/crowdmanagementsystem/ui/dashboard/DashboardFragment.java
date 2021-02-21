package com.example.crowdmanagementsystem.ui.dashboard;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.crowdmanagementsystem.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private WebView webView;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        /*webView = (WebView) root.findViewById(R.id.webView);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                getWindow().setTitle(title); //Set Activity tile to page title.
            }
        });
        webView.setWebViewClient(new WebViewClient(){
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                String title = "Complete Action Using";
                Intent chooser = Intent.createChooser(i, title);
                root.getContext().startActivity(chooser);
                return false;
            }

            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Intent i = new Intent(Intent.ACTION_VIEW, request.getUrl());
                String title = "Complete Action Using";
                Intent chooser = Intent.createChooser(i, title);
                root.getContext().startActivity(chooser);
                return false;
            }
        });
        webView.loadUrl("http://192.168.43.114:5000");
        /*WebSettings webSettings = webView.getSettings();
        webSettings.getAllowFileAccess();
        webSettings.setJavaScriptEnabled(true);
        webSettings.getBuiltInZoomControls();*/
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://10.0.0.2:5000"));
        startActivity(browserIntent);
        return root;
    }
}