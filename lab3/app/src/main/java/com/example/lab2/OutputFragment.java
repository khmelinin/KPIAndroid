package com.example.lab2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFragment extends Fragment {

    private final static String FILE_NAME = "content.txt";

    public OutputFragment(){
        super(R.layout.fragment_output);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setSelectedItem(String selectedItem) {
        TextView view = getView().findViewById(R.id.textViewResult);
        view.setText(selectedItem);
        saveText(view, selectedItem);
    }

    private ContentFragment.OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (ContentFragment.OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    public void saveText(View view, String selectedItem){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(getView().getContext().getFilesDir() + FILE_NAME, true)); // append
            bw.write(selectedItem);
            bw.newLine();
            Toast.makeText(getView().getContext(),"Saved to: " + getView().getContext().getFilesDir().getPath() , Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(bw!=null)
                    bw.close();
            }
            catch(IOException ex){

                Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

//    public void openText(View view){
//
//        FileInputStream fin = null;
//        try {
//            fin = new FileInputStream(FILE_NAME);
//            byte[] bytes = new byte[fin.available()];
//            fin.read(bytes);
//            String text = new String (bytes);
//            fragmentSendDataListener.onSendData(text);
//        }
//        catch(IOException ex) {
//
//            Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//        finally{
//
//            try{
//                if(fin!=null)
//                    fin.close();
//            }
//            catch(IOException ex){
//
//                Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
