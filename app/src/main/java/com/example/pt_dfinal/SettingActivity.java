package com.example.pt_dfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingActivity extends AppCompatActivity {

    private EditText et_id, et_pass,et_pass2, et_name, et_email, et_birth, et_height;
    private String et_gender;
    private Button btn_register, btnPwdCheck, setDelete;

    private boolean validate = false;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

    }

    // 공지사항 (NoticeActivity)
    public void Notice(View view){
        Intent intent=new Intent(getApplicationContext(), NoticeActivity.class);
        startActivityForResult(intent, 0);
    }

    // 버전 정보 (UpdateActivity)
    public void Version(View view){
        Intent intent=new Intent(getApplicationContext(), UpdateActivity.class);
        startActivityForResult(intent, 0);
    }

    // 개인정보 변경 (RegisterUpdateActivity)
    public void RegisterUpdate(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterUpdateActivity.class);
        startActivityForResult(intent, 0);
    }

//    public void Back(View view){
//        super.onBackPressed();
//    }

    // 로그아웃 (클릭 시, 앱 시작 첫 화면(MainActvity) 으로 이동)
    public void btn_logout(View v) {
        new AlertDialog.Builder(this)
                .setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("로그아웃", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent i = new Intent(SettingActivity.this, MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(i);
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                })
                .show();
    }

    // 회원탈퇴
    public void delete(View view){
        Intent intent=new Intent(getApplicationContext(), DeleteActivity.class);
        startActivityForResult(intent, 0);
    }


}