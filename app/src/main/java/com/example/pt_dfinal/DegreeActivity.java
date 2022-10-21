package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class DegreeActivity extends AppCompatActivity {

    private CheckBox allCheckBtn;
    private CheckBox CheckBtn1;
    private CheckBox CheckBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree);

        // 약관동의 체크박스
        allCheckBtn = findViewById(R.id.checkBox2);
        CheckBtn1 = findViewById(R.id.checkBox3);
        CheckBtn2 = findViewById(R.id.checkBox4);
        // 전체 약관 동의
        // 이벤트 리스너
        allCheckBtn.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 작성
                if (((CheckBox)v).isChecked()) {
                    CheckBtn1.setChecked(true);
                    CheckBtn2.setChecked(true);
                } else {
                    CheckBtn1.setChecked(false);
                    CheckBtn2.setChecked(false);
                }
            }
        });

        // 동의 버튼 두 개 클릭시 전체동의 클릭
        CheckBtn1.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckBtn2.isChecked()) {
                    allCheckBtn.setChecked(true);
                }
            }
        });
        CheckBtn2.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckBtn1.isChecked()) {
                    allCheckBtn.setChecked(true);
                }
            }
        });

        CheckBtn1.setOnClickListener(onCheckBoxClickListener);
        CheckBtn2.setOnClickListener(onCheckBoxClickListener);
    }

    // 전체동의일때, 아래 두 동의 중 하나라도 체크해제되면,
    // 전체동의 체크 해제
    private View.OnClickListener onCheckBoxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isAllChecked()) {
                allCheckBtn.setChecked(true);
            } else {
                allCheckBtn.setChecked(false);
            }
        }
    };
    private boolean isAllChecked() {
        return (CheckBtn1.isChecked() && CheckBtn2.isChecked()) ? true : false;
    }


    // 서비스 이용약관 '>' 버튼
    public void degreecontent1_btn(View view){
        Intent intent=new Intent(getApplicationContext(), DegreeContentActivity1.class);
        startActivityForResult(intent, 0);
    }

    // 개인정보 수집 및 이용동의 '>' 버튼
    public void degreecontent2_btn(View view){
        Intent intent=new Intent(getApplicationContext(), DegreeContentActivity2.class);
        startActivityForResult(intent, 0);
    }

    // 확인 버튼
    public void degreefinish_btn(View view){
        Intent intent=new Intent(getApplicationContext(), RegisterActivity.class);
        startActivityForResult(intent, 0);
    }

}
