package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxS;
    private CheckBox checkBoxP;
    private RadioGroup radioGroup1;
    private RadioButton radioButtonCircle;
    private RadioButton radioButtonRectangle;
    private RadioButton radioButtonTriangle;
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxS = findViewById(R.id.checkBoxS);
        checkBoxP = findViewById(R.id.checkBoxP);
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioButtonCircle = findViewById(R.id.radioButtonCircle);
        radioButtonRectangle = findViewById(R.id.radioButtonRectangle);
        radioButtonTriangle = findViewById(R.id.radioButtonTriangle);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void buttonOkClick(View view) {
        textViewResult.setText("Result: ");

        if(checkBoxS.isChecked())
        {
            if(radioButtonCircle.isChecked()){
                textViewResult.setText(textViewResult.getText()+"S=Pi*r^2 ");
            }
            else
            if(radioButtonRectangle.isChecked()){
                textViewResult.setText(textViewResult.getText()+"S=a*b ");
            }
            else
            if(radioButtonTriangle.isChecked()){
                textViewResult.setText(textViewResult.getText()+"S=sqrt(p*(p−a)*(p−b)*(p−c)) ");
            }
            else
                textViewResult.setText(textViewResult.getText()+"Choose the option! ");
        }
        if(checkBoxP.isChecked())
        {
            if(radioButtonCircle.isChecked()){
                textViewResult.setText(textViewResult.getText()+"P=2*Pi*r ");
            }
            else
            if(radioButtonRectangle.isChecked()){
                textViewResult.setText(textViewResult.getText()+"P=2*(a+b) ");
            }
            else
            if(radioButtonTriangle.isChecked()){
                textViewResult.setText(textViewResult.getText()+"P=a+b+c ");
            }
            else
                textViewResult.setText(textViewResult.getText()+"Choose the option! ");
        }
        if(!checkBoxP.isChecked() && !checkBoxS.isChecked())
            textViewResult.setText(textViewResult.getText()+"Choose the option! ");
    }
}