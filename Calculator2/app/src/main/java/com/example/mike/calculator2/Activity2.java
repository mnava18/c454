package com.example.mike.calculator2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.lang.*;


public class Activity2 extends ActionBarActivity {

    public String str = "";
    double num, tempNum, num2;
    NumberFormat format = new DecimalFormat("0.####");
    Character operation = 'q';
    EditText disp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);


        disp = (EditText) findViewById(R.id.display);
        Intent intent = getIntent();

        num = intent.getDoubleExtra("saved", 0);
        disp.setText(("" + format.format(num)));

        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);


    }



    public void buttonLp(View v) {
        str = "";
        operation = '(';
        calculate();


    }

    public void buttonRp(View v) {
        str = "";
        operation = ')';
        calculate();


    }


    public void buttonSin(View v) {
        str = "";
        tempNum = num;
        operation = 'S';
        calculate();


    }

    public void buttonCos(View v) {
        str = "";
        operation = 'c';
        calculate();


    }

    public void buttonTan(View v) {
        str = "";
        operation = 't';
        calculate();


    }

    public void buttonPower(View v) {
        str = "";
        operation = '^';

        calculate();


    }

    public void buttonI(View v) {
        disp.setText("invalid");


    }

    public void buttonSquare(View v) {
        str = "";
        operation = 'q';
        calculate();


    }

    public void buttonPi(View v) {
        str = "";
        operation = 'p';
        disp.setText("π");
        calculate();


    }

    public void buttonFact(View v) {
        str = "";
        tempNum = num;
        operation = 'f';
        calculate();


    }

    public void buttonLog(View v) {
        str = "";
        tempNum = num;
        operation = 'l';
        disp.setText("Log");
        calculate();


    }

    public void buttonLn(View v) {
        str = "";
        tempNum = num;
        operation = 'n';

        calculate();


    }

    public void buttonE(View v) {
        str = "";
        tempNum = num;
        operation = 'e';

        calculate();


    }

    public void buttonPercent(View v) {
        str = "";
        tempNum = num;
        operation = '%';

        calculate();


    }


    public void buttonClear(View v) {
        reset();
    }

    private void reset() {

        str = "";
        operation = 'q';
        num = 0;
        tempNum = 0;
        disp.setText("");
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        else return n * factorial(n - 1);
    }


    private void calculate() {

        if (operation == 'S') {
            num = Math.sin(num);


        } else if (operation == '(') {
               String l=disp.getText().toString();
           disp.setText( l+ "(");
            return;
        } else if (operation == ')') {
            String l=disp.getText().toString();
            disp.setText(l + ")");
            return;
        } else if (operation == 'c') {
            num = Math.cos(num);

        } else if (operation == 't') {
            num = Math.tan(num);

        } else if (operation == '^') {
            num = Math.pow(num, 2);

        } else if (operation == 'q') {
            if (num < 0) {

                disp.setText("Invalid");
                return;
            } else {
                num = Math.sqrt(num);
            }
        } else if (operation == 'p') {

            num = Math.PI;

        } else if (operation == 'f') {
            if (num < 0) {

                disp.setText("Invalid");
                return;
            } else {

                num = factorial(((int) num));
            }

        } else if (operation == 'l') {
            if (num < 0) {

                disp.setText("Invalid");
                return;
            } else {

                num = Math.log(num) / Math.log(10);
            }

        } else if (operation == 'n') {
            if (num < 0) {

                disp.setText("Invalid");
                return;
            } else {

                num = Math.log(num);
            }

        } else if (operation == 'e') {

            num = 2.718281828 * num;

        } else if (operation == '%') {
            if (num < 0) {

                disp.setText("Invalid");
                return;
            } else {

                num = num / 100;

            }
        }
        disp.setText("" + format.format(num));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean bRet = false;

        int id = item.getItemId();
        switch (id) {


            case R.id.action_settings_2:
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                intent.putExtra("saved", num);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                bRet = true;
                break;
            default:
                return false;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_2) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
