package com.example.lab2;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        loadText();
    }

    private void loadText(){
        try (BufferedReader reader = new BufferedReader(new FileReader(this.getFilesDir() + "content.txt"))) {
            String line = reader.readLine();
            if(line==null){
                Toast.makeText(this,"File is empty", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder res = new StringBuilder();
            res.append(line);
            res.append("\n");

            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }

            TextView textView = findViewById(R.id.textViewOpen);
            textView.setText(res.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}