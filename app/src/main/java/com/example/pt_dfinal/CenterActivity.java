package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
    }

    // 이전 화면 (설정 페이지)
//    public void centerBtn(View view){
//        Intent intent=new Intent(getApplicationContext(), MypageActivity.class);
//        startActivityForResult(intent, 0);
//    }

}
