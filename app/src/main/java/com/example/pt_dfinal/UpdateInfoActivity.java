package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class UpdateInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateinfo);
    }

    // 이전 화면 (버전정보 페이지)
//    public void updateInfoPreBtn(View view){
//        Intent intent=new Intent(getApplicationContext(), UpdateActivity.class);
//        startActivityForResult(intent, 0);
//    }


}
