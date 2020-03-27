package com.lawlett.simplecalculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Double firstValues, secondValues, result_op;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result_field);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.seven:
                result.append("7");
                break;
            case R.id.eight:
                result.append("8");
                break;
            case R.id.clear:
                result.setText("");
                break;
        }
    }
    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                operation = "+";
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues+"+");
                break;
            case R.id.multiply:
                operation = "*";
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues+"*");
                break;
            case R.id.equal:
                if (operation != null) {
                    String two = result.getText().toString().replace(firstValues.toString() + operation , "");
                    secondValues = Double.valueOf(two);
                    switch (operation) {
                        case "+":
                            plus();
                            break;
                        case "*":
                            multiply();
                            break;
                    }
                }
        }
    }
    public void plus(){
        result_op= firstValues+secondValues;
        result.setText(firstValues + "+" + secondValues + "=" + result_op);
    }
    public void multiply(){
        result_op= firstValues*secondValues;
        result.setText(firstValues + "*" + secondValues + "=" + result);
    }
}
