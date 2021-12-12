package com.example.lab2.filesystem;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab2.OpenActivity;
import com.example.lab2.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileSystem {
    public static void saveText(View view, String selectedItem) {
        //BufferedWriter bw = null;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(view.getContext().getFilesDir() + "content.txt", true))) {
            //bw = new BufferedWriter(new FileWriter(getView().getContext().getFilesDir() + FILE_NAME, true)); // append
            bw.write(selectedItem);
            bw.newLine();
            Toast.makeText(view.getContext(), "Saved to: " + view.getContext().getFilesDir().getPath(), Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {

            Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
//        finally{
//            try{
//                if(bw!=null)
//                    bw.close();
//            }
//            catch(IOException ex){
//
//                Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
    }

    public static void loadText(Activity activity) {
        try (BufferedReader reader = new BufferedReader(new FileReader(activity.getFilesDir() + "content.txt"))) {
            String line = reader.readLine();
            if (line == null) {
                Toast.makeText(activity, "File is empty", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder res = new StringBuilder();
            res.append(line);
            res.append("\n");

            while ((line = reader.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }

            TextView textView = activity.findViewById(R.id.textViewOpen);
            textView.setText(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void clearText(View view) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(view.getContext().getFilesDir() + "content.txt"))) {
            bw.write("");
            Toast.makeText(view.getContext(), "File cleared", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {

            Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
