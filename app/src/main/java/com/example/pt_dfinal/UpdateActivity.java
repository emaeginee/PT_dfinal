package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class UpdateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    // 이전 화면 (설정 페이지)
//    public void updatePreBtn(View view){
//        Intent intent=new Intent(getApplicationContext(), SettingActivity.class);
//        startActivityForResult(intent, 0);
//    }

    // 업데이트 버튼
    public void Update(View view){
        Intent intent=new Intent(getApplicationContext(), UpdateInfoActivity.class);
        startActivityForResult(intent, 0);
    }

}
