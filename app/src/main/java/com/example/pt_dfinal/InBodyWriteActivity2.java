package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InBodyWriteActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbodywrite2);
    }

    // 완료 버튼 클릭 시, 메인 페이지로 이동
    public void completeNext(View view){
        Intent intent=new Intent(getApplicationContext(), InBodyWriteActivity3.class);
        startActivityForResult(intent, 0);
    }

}
