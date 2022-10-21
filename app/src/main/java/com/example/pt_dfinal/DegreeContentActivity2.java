package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class DegreeContentActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degreecontent_2);
    }

    // 화면 상단 이전 버튼
    // 클릭시 DegreeActivity로 이동
    public void PreDegree2(View view){
        Intent intent=new Intent(getApplicationContext(), DegreeActivity.class);
        startActivityForResult(intent, 0);
    }

}
