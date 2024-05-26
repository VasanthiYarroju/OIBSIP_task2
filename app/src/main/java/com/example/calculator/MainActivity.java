package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etFirstNumber, etSecondNumber;
    private Spinner spinnerOperations;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        spinnerOperations = findViewById(R.id.spinneroperations);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        String firstNumber = etFirstNumber.getText().toString();
        String secondNumber = etSecondNumber.getText().toString();
        String operation = spinnerOperations.getSelectedItem().toString();

        if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
            tvResult.setText("Please enter both numbers.");
            return;
        }

        double num1 = Double.parseDouble(firstNumber);
        double num2 = Double.parseDouble(secondNumber);
        double result = 0;

        switch (operation) {
            case "Addition":
                result = num1 + num2;
                break;
            case "Subtraction":
                result = num1 - num2;
                break;
            case "Multiplication":
                result = num1 * num2;
                break;
            case "Division":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    tvResult.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        tvResult.setText("Result: " + result);
    }
}