package com.example.examevent;

import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Event2Activity extends AppCompatActivity {

    //Member Variable
    private final String TAG = "examevent";
    private boolean D;

    private Button okbtn;
    private EditText nameTXT;
    private InputMethodManager imm; //키보드 숨기기
    long initTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i(TAG,"Key Down : " + keyCode);
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_HOME:
                break;
            case KeyEvent.KEYCODE_BACK:

                if (System.currentTimeMillis() - initTime > 3000 ) {
                    // Back bUTTON을 누른지 3초가 지나면 토스트
                    Toast.makeText(this, "종료하려면 한번 더 누르세요.",Toast.LENGTH_LONG).show();
                    // 현재시간 저장
                    initTime = System.currentTimeMillis();
                } else {
                    // 3초 이내 두번 눌린 경우 Activity 종료
                    finish();
                }
                return true;

        }
        return true;
    }



     // 하드 키 (뒤로가기 버튼 메뉴 버튼) 제어




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "touch down ( " + event.getX() + "," + event.getY() + ")");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "touch MOVE ( " + event.getX() + "," + event.getY() + ")");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "touch UP ( " + event.getX() + "," + event.getY() + ")");
                break;

            // 하드 키  화면을 클릭했을때 엑션,다운,무브,업
        }
        return true;
        }

    // member method -activity's override -----
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event2_main); //화면 설정

        init();
        if (D) Log.d(TAG, "onCreate()");

    }

    //member method -custom----
private void init(){
        //SYSTEM 서비스 객체 가져오기
        imm= (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);
        // View 객체 가져오기
        okbtn=findViewById(R.id.okBTN);
        nameTXT=findViewById(R.id.nameETXT);
        nameTXT.setOnEditorActionListener(new TextView.OnEditorActionListener() {


            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.d(TAG, "onEditorAction actionId : )" + actionId);
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    imm.hideSoftInputFromWindow(nameTXT.getWindowToken(), 0);
                }
                return true;
            }
        });
}

    // view 이벤트 리스너 설정


    //Member Method -XML onClick Method-------------
    public void click(View V){
     //소프트 키보드 숨기기 설정
        imm.hideSoftInputFromWindow(nameTXT.getWindowToken(),0); // getwindowtoken  토큰 특정 이벤트를 구분해주는 것 소프트 창 이라고 생각해도 됨 키보드의 v체크 할때

    }

    }
