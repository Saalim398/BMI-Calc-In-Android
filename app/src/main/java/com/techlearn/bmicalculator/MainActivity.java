package com.techlearn.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate;
        LinearLayout llMain;

        llMain = findViewById(R.id.llMain);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightft);
        edtHeightIn = findViewById(R.id.edtHeightin);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.result);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int Ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                // ft to inches
                int totalIn = Ft*12 + in;

                //in cm
                double totalcm = totalIn*2.53;

                //in meter
                double totalm = totalcm/100;

                double bmi = wt/(totalm*totalm);
                if (bmi > 30){
                    txtResult.setText("Over Weight " + bmi);
                    llMain.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if(bmi<18){
                    txtResult.setText("underweight " + bmi);
                    llMain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else{
                    txtResult.setText("Normal " + bmi);
                    llMain.setBackgroundColor(getResources().getColor(R.color.green));                }


            }
        });










    }
}