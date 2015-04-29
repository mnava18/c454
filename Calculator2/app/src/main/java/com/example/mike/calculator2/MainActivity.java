package com.example.mike.calculator2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;

import java.text.NumberFormat;
import java.text.DecimalFormat;

import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    public String str = "";
    double num, tempNum, num2;
    NumberFormat format = new DecimalFormat("0.####");
    Character operation = 'q';
    EditText disp;
    boolean clearOnNextDigit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        disp = (EditText) findViewById(R.id.display);

        Intent intent = getIntent();
        num = intent.getDoubleExtra("saved", 0);
        disp.setText(("" + format.format(num)));


    }


    private void numDisplay(int j) {

        str = str + Integer.toString(j);
        num = Integer.valueOf(str).intValue();
        disp.setText(str);


    }

    public void deciDisplay() {
        String inputString = disp.getText().toString();

        if (clearOnNextDigit) {

            disp.setText("0.");

        }

        if (inputString.indexOf(".") < 0) {

            disp.setText((new String(inputString + ".")));

        }

    }

    public void buttonDeci(View v) {

        deciDisplay();

    }

    public void button0(View v) {
        numDisplay(0);

    }

    public void button1(View v) {
        numDisplay(1);

    }

    public void button2(View v) {

        numDisplay(2);

    }

    public void button3(View v) {
        numDisplay(3);

    }

    public void button4(View v) {
        numDisplay(4);

    }

    public void button5(View v) {
        numDisplay(5);

    }

    public void button6(View v) {

        numDisplay(6);
    }

    public void button7(View v) {
        numDisplay(7);

    }

    public void button8(View v) {
        numDisplay(8);

    }

    public void button9(View v) {
        numDisplay(9);

    }

    public void buttonAdd(View v) {
        str = "";
        tempNum = num;
        operation = '+';
        disp.setText("+");

    }

    public void buttonSub(View v) {
        str = "";
        tempNum = num;
        operation = '-';
        disp.setText("-");

    }

    public void buttonDivide(View v) {
        str = "";
        tempNum = num;
        operation = '/';
        disp.setText("÷");

    }

    public void buttonMulti(View v) {
        str = "";
        tempNum = num;
        operation = '*';
        disp.setText("x");

    }

    public void buttonEquall(View v) {
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


    private void calculate() {

        if (operation == '+') {
            num = (tempNum + num);
        } else if (operation == '-') {

            num = (tempNum - num);
        } else if (operation == '/') {
            if (num == 0) {
                disp.setText("Invalid");
                return;

            }
            if (tempNum == 0) {
                num = 0;

            } else {
                num = (tempNum / num);

            }
        } else if (operation == '*') {

            num = (tempNum * num);
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


            case R.id.action_settings_1:
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("saved", num);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                bRet = true;
                break;

            default:
                return false;
        }

        if (id == R.id.action_settings_1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
