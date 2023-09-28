package com.tonys.onerepmaxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText repsEditText;
    private TextView resultText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }



    private void findViews(){
        weightEditText = findViewById(R.id.text_view_weight);
        repsEditText = findViewById(R.id.text_view_reps);
        resultText = findViewById(R.id.text_view_result);
        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = calculateOneRepMax();

                displayResult(result);
            }
        });
    }



    private double calculateOneRepMax(){
        String weightText = weightEditText.getText().toString();
        String repsText = repsEditText.getText().toString();

        int weight = Integer.parseInt(weightText);
        int reps = Integer.parseInt(repsText);

        return weight / (1.0278 - (0.0278 * reps));
    }

    private void displayResult(double oneRepMax){
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String oneRepMaxResult = myDecimalFormatter.format(oneRepMax);

        String finalResult = "Your 1RM is " + oneRepMaxResult;

        resultText.setText(finalResult);

    }

}