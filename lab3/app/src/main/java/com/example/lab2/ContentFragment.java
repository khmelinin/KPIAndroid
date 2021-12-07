package com.example.lab2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ContentFragment extends Fragment {

    public ContentFragment() {
        super(R.layout.fragment_content);
    }

    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonOk = view.findViewById(R.id.buttonOk);
        Button buttonLoad = view.findViewById(R.id.buttonLoad);
        Button buttonClearFile = view.findViewById(R.id.buttonClearFile);
        CheckBox checkBoxS = view.findViewById(R.id.checkBoxS);
        CheckBox checkBoxP = view.findViewById(R.id.checkBoxP);
        RadioGroup radioGroup1 = view.findViewById(R.id.radioGroup1);
        RadioButton radioButtonCircle = view.findViewById(R.id.radioButtonCircle);
        RadioButton radioButtonRectangle = view.findViewById(R.id.radioButtonRectangle);
        RadioButton radioButtonTriangle = view.findViewById(R.id.radioButtonTriangle);



        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedItem = "";

                if (checkBoxS.isChecked()) {
                    if (radioButtonCircle.isChecked()) {
                        selectedItem += "S=Pi*r^2 ";
                    } else if (radioButtonRectangle.isChecked()) {
                        selectedItem += "S=a*b ";
                    } else if (radioButtonTriangle.isChecked()) {
                        selectedItem +="S=sqrt(p*(p−a)*(p−b)*(p−c)) ";
                    } else
                        selectedItem += "Choose the option! ";
                }
                if (checkBoxP.isChecked()) {
                    if (radioButtonCircle.isChecked()) {
                        selectedItem += "P=2*Pi*r ";
                    } else if (radioButtonRectangle.isChecked()) {
                        selectedItem += "P=2*(a+b) ";
                    } else if (radioButtonTriangle.isChecked()) {
                        selectedItem += "P=a+b+c ";
                    } else
                        selectedItem += "Choose the option! ";
                }
                if (!checkBoxP.isChecked() && !checkBoxS.isChecked()) {
                    Toast toast1 = Toast.makeText(view.getContext(), "Fill check boxes and radio buttons!", Toast.LENGTH_SHORT);
                    toast1.show();
                }
                fragmentSendDataListener.onSendData(selectedItem);

            }
        });

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OpenActivity.class));

            }
        });

        buttonClearFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BufferedWriter bw = null;
                try {
                    bw = new BufferedWriter(new FileWriter(getView().getContext().getFilesDir() + "content.txt")); // append
                    bw.write("");
                    Toast.makeText(getView().getContext(),"File cleared" , Toast.LENGTH_SHORT).show();
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
        });
    }
}
