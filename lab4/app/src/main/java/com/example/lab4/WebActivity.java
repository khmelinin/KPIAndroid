package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView browser=findViewById(R.id.webBrowser);
        browser.loadUrl("https://images.all-free-download.com/footage_preview/mp4/tiny_wild_bird_searching_for_food_in_nature_6892037.mp4");
    }
//    public void goToAudio(View view) {
//        startActivity(new Intent(this, AudioActivity.class));
//    }
//    public void goToVideo(View view) {
//        startActivity(new Intent(this, MainActivity.class));
//    }
}