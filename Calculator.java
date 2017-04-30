package com.google.anamika.masterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;
    private EditText editText;
    private TextView infoTextView;
    private DecimalFormat decimalFormat;
    private Button buttonDot, buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive,
            buttonSix, buttonSeven, buttonEight, buttonNine, buttonAdd, buttonSubtract,
            buttonMultiply, buttonDivide, buttonEqual, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();
        decimalFormat = new DecimalFormat("#.##########");
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + ".");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "0");
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "1");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "2");
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "3");
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "4");
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "5");
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "6");
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "7");
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "8");
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                infoTextView.setText(decimalFormat.format(valueOne) + "+");
                editText.setText(null);
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                infoTextView.setText(decimalFormat.format(valueOne) + "-");
                editText.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                infoTextView.setText(decimalFormat.format(valueOne) + "*");
                editText.setText(null);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                infoTextView.setText(decimalFormat.format(valueOne) + "/");
                editText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                infoTextView.setText(infoTextView.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().length() > 0) {
                    CharSequence currentText = editText.getText();
                    editText.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    editText.setText("");
                    infoTextView.setText("");
                }
            }
        });

    }
    private void init()
    {
//        buttonDot, buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive,
//            buttonSix, buttonSeven, buttonEight, buttonNine, buttonAdd, buttonSubtract,
//            buttonMultiply, buttonDivide, buttonEqual, buttonClear
//  
        buttonDot= (Button) findViewById(R.id.buttonDot);
        buttonZero= (Button) findViewById(R.id.buttonZero);
        buttonOne= (Button) findViewById(R.id.buttonOne);
        buttonTwo= (Button) findViewById(R.id.buttonTwo);
        buttonThree= (Button) findViewById(R.id.buttonThree);
        buttonFour= (Button) findViewById(R.id.buttonFour);
        buttonFive= (Button) findViewById(R.id.buttonFive);
        buttonSix= (Button) findViewById(R.id.buttonSix);
        buttonSeven= (Button) findViewById(R.id.buttonSeven);
        buttonEight= (Button) findViewById(R.id.buttonEight);
        buttonNine= (Button) findViewById(R.id.buttonNine);
        buttonAdd= (Button) findViewById(R.id.buttonAdd);
        buttonSubtract= (Button) findViewById(R.id.buttonSubtract);
        buttonMultiply= (Button) findViewById(R.id.buttonMultiply);
        buttonDivide= (Button) findViewById(R.id.buttonDivide);
        buttonEqual= (Button) findViewById(R.id.buttonEqual);
        buttonClear= (Button) findViewById(R.id.buttonClear);
        editText= (EditText) findViewById(R.id.editText);
        infoTextView= (TextView) findViewById(R.id.infoTextView);
    }
    private void computeCalculation()
    {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(editText.getText().toString());
            editText.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(editText.getText().toString());
            }
            catch (Exception e){}
        }
    }
}
