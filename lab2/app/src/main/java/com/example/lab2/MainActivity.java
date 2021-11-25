package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ContentFragment.OnFragmentSendDataListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(String selectedItem) {
        OutputFragment fragment = (OutputFragment) getSupportFragmentManager()
                .findFragmentById(R.id.outputFragment);
        if (fragment != null)
            fragment.setSelectedItem(selectedItem);
    }
}