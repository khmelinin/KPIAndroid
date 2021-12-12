package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2.filesystem.FileSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        FileSystem.loadText(this);
    }
}