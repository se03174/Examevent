package com.example.examevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.SplittableRandom;

public class MainActivity extends AppCompatActivity {

    //Member Variable
    private final String TAG = "examevent";
    private boolean D;

    private Button exambtn;
    private TextView msgTXT;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton redrbtn,bluerbtnn;
    private ConstraintLayout layout;


    // member method -activity's override -----
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //화면 설정

        init(); //초기화
        if (D) Log.d(TAG, "onCreate()");

    }

    //member method -custom----
    //초기화 메서드
    private void init() {
        exambtn = findViewById(R.id.leftBTN);
        msgTXT = findViewById(R.id.msgTXT);
        checkBox=findViewById(R.id.checkBox);
        redrbtn=findViewById(R.id.redbtn);
        bluerbtnn=findViewById(R.id.bluebtn);
        radioGroup=findViewById(R.id.radiogroup);


        // view 이벤트 리스너 설정
        exambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"leftBTN - onclick()");

            }
        });
        msgTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Log.i(TAG , "msgTXT- onclick()");

            }
        });
        exambtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
               Log.i(TAG,"exambtn - long");
                return false;

            }
        });
        //체크박스 의 체크 여부에 따른 동작 체크하는 순간 배경색 변경 여러개 중에 아이디 받아서
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.i(TAG,"CHECK"+ isChecked); //체크 확인 현재 체크되어있는지 확인
            layout.setBackgroundColor(isChecked ? Color.CYAN : Color.WHITE);

            }
        });
//변경할려는 순간을 보는
radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.i(TAG,"radio-checkedId"+
                ((RadioButton)findViewById( checkedId)).getText());

    }
});
//버튼 각각 주는 방법
redrbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.i(TAG,"radio-checkedId"+ buttonView.getText());


    }
});
    }


    }
