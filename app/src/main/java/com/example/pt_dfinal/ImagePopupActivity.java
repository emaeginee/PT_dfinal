package com.example.pt_dfinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class ImagePopupActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_activity_calendar_image);



//        //UI 객체생성
//        txtText = (TextView)findViewById(R.id.textView26);
//        txtText = (TextView)findViewById(R.id.textView27);
//        txtText = (TextView)findViewById(R.id.textView28);

//        //데이터 가져오기
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("data");
//        txtText.setText(data);
    }



}
