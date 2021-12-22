package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {
    VideoView videoPlayer;
    Uri myVideoUri;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoPlayer = findViewById(R.id.videoPlayer);
        myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.shrek);
        videoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);


    }

    public void play(View view){
        videoPlayer.start();
    }
    public void pause(View view){
        videoPlayer.pause();
    }
    public void stop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }

    public void goToVideo(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void goToAudio(View view) {
        startActivity(new Intent(this, AudioActivity.class));
    }

    public void goToWeb(View view) {
        startActivity(new Intent(this, WebActivity.class));
    }
}