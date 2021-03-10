package com.example.examevent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class settingActivity extends AppCompatActivity {


    //Member Variable
    private final String TAG = "examevent1";


    private EditText IdETXT;
    private Button addbtn, modbtn, canbtn;

    private CheckBox autocheck, wificheck;

    private RadioGroup radioGroup;
    private RadioButton whtierbtn, darkrbtn, bluerbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init(); //초기화
        Log.i(TAG, "OnCreate()");

    }

    private void init() {

        IdETXT = findViewById(R.id.nameETXT);
        addbtn = findViewById(R.id.save);
        modbtn = findViewById(R.id.modi);
        canbtn = findViewById(R.id.cancel);
        autocheck = findViewById(R.id.Ckauto);
        wificheck = findViewById(R.id.Ckwifi);
        whtierbtn = findViewById(R.id.Ckwhite);
        darkrbtn = findViewById(R.id.Ckdark);
        bluerbtn = findViewById(R.id.Ckblue);
        Log.i(TAG, "init()");
    }
/*
        modbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IdETXT.setClickable(true);
                IdETXT.setFocusable(true);

            }
        });


        canbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdETXT.setText("");


            }
        });
*/


    public void onClick(View v) {
        Log.i(TAG, "OnClick save");
        switch (v.getId()) {
            case R.id.save:
                IdETXT.setClickable(false);
                IdETXT.setFocusable(false);
                Log.i(TAG, "name " + IdETXT.getText() + "autocheck " + autocheck.isChecked() + wificheck.isChecked() + whtierbtn + darkrbtn.isChecked() + bluerbtn.isChecked());
                /*if (IdETXT.getText().length() > 0 && (autocheck.isChecked() || wificheck.isChecked()) && (whtierbtn.isChecked() || darkrbtn.isChecked() || bluerbtn.isChecked())) {


       } else {
            Log.i(TAG, "NO ");
       }*/
                break;



        }
    }
}