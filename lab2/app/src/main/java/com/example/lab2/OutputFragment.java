package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OutputFragment extends Fragment {
    public OutputFragment(){
        super(R.layout.fragment_output);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                              Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_output, container, false);
//    }

    public void setSelectedItem(String selectedItem) {
        TextView view = getView().findViewById(R.id.textViewResult);
        view.setText(selectedItem);
    }
}
