package com.umrlookta.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private String show = "";
    private String operand = "";
    private String result = "";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.textScreen);
        screen.setText(show);
    }

    private double calculation(String numA, String numB, String opr) {
        switch (opr) {
            case "+":
                return Double.valueOf(numA) + Double.valueOf(numB);
            case "-":
                return Double.valueOf(numA) - Double.valueOf(numB);
            case "*":
                return Double.valueOf(numA) * Double.valueOf(numB);
            case "/":
                return Double.valueOf(numA) / Double.valueOf(numB);
            default:
                return -1;
        }
    }

    public void onClickNumber(View v) {
        Button b = (Button) v;
        show += b.getText();
        screen.setText(show);
    }

    public void onClickOperator(View v) {
        if (show == "") return;
        if (operand != "") return;
        Button b = (Button) v;
        operand = b.getText().toString();
        show += b.getText();
        screen.setText(show);
    }

    public void onClickEqual(View v) {
        if (show == "") return;
        if (operand == "") return;
        String[] text = show.split(Pattern.quote(operand));
        if (text.length < 2) return;
        result = String.valueOf(calculation(text[0], text[1], operand));
        screen.setText(result);
        show = "";
        operand = "";
    }

    public void onClickClear(View v) {
        show = "";
        operand = "";
        result = "";
        screen.setText("0");
    }
}