package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTV, solutionTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resultTV = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);
        solutionTv.setText("");

        assignId(R.id.button_c);
        assignId(R.id.button_open_bracket);
        assignId(R.id.button_close_bracket);
        assignId(R.id.button_divide);
        assignId(R.id.button_multiply);
        assignId(R.id.button_minus);
        assignId(R.id.button_plus);
        assignId(R.id.button_dot);
        assignId(R.id.button_equals);
        assignId(R.id.button_ac);

        assignId(R.id.button_0);
        assignId(R.id.button_1);
        assignId(R.id.button_2);
        assignId(R.id.button_3);
        assignId(R.id.button_4);
        assignId(R.id.button_5);
        assignId(R.id.button_6);
        assignId(R.id.button_7);
        assignId(R.id.button_8);
        assignId(R.id.button_9);
    }

    void assignId(int id) {
        MaterialButton btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if (buttonText.equals("AC")) {
            solutionTv.setText("");
            resultTV.setText("0");
            return;
        }

        if (buttonText.equals("=")) {
            String result = getResult(dataToCalculate);
            if (!result.equals("Err")) {
                solutionTv.setText(result);
            }
            resultTV.setText(result);
            return;
        }

        if (buttonText.equals("C")) {
            if (!dataToCalculate.isEmpty()) {
                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
            }
        } else {
            dataToCalculate = dataToCalculate + buttonText;
        }

        solutionTv.setText(dataToCalculate);

        if (dataToCalculate.isEmpty()) {
            resultTV.setText("0");
            return;
        }

        String finalResult = getResult(dataToCalculate);
        if (!finalResult.equals("Err")) {
            resultTV.setText(finalResult);
        }
    }

    String getResult(String data) {
        try {
            double value = new ExpressionBuilder(data).build().evaluate();
            if (value == (long) value) {
                return String.valueOf((long) value);
            }
            return String.valueOf(value);
        } catch (Exception e) {
            return "Err";
        }
    }
}
