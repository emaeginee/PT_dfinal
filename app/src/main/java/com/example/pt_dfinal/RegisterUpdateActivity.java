package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class RegisterUpdateActivity extends AppCompatActivity {

    private TextView et_id, et_pass, et_pass2, et_name, et_email, et_birth, et_height;
    private Button Success;
    private RadioGroup et_gender;

    final static private String URL = "http://suminpt.dothome.co.kr/LoginPT2.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerupdate);

        et_id=findViewById(R.id.et_id);
        et_pass=findViewById(R.id.et_pass);
        et_pass2=findViewById(R.id.et_pass2);
        et_name=findViewById(R.id.et_name);
        et_email=findViewById(R.id.et_email);
//        et_gender=findViewById(R.id.et_gender);
        et_birth=findViewById(R.id.et_birth);
        et_height=findViewById(R.id.et_height);

        Intent intent = getIntent();
        String userID=intent.getStringExtra("userID");
        String userPassword=intent.getStringExtra("userPassword");
        String userPassword2=intent.getStringExtra("userPassword2");
        String userName=intent.getStringExtra("userName");
        String userEmail=intent.getStringExtra("userEmail");
//        String userGender=intent.getStringExtra("userGender");
        String userBirth=intent.getStringExtra("userBirth");
        String userHeight=intent.getStringExtra("userHeight");

        et_id.setText(userID);
        et_pass.setText(userPassword);
        et_pass2.setText(userPassword2);
        et_name.setText(userName);
        et_email.setText(userEmail);
//        et_gender.setCe(userGender);
        et_birth.setText(userBirth);
        et_height.setText(userHeight);


        Success = findViewById(R.id.btn_register);
        Success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterUpdateActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    // btnRegisterUpdateComplete(회원정보 수정 완료) 버튼 클릭시,
    // 마이 페이지로 이동


//    public void btnRegisterUpdateComplete(View view){
//        Intent intent=new Intent(getApplicationContext(), MainActivity2.class);
//        startActivityForResult(intent, 0);
//    }
}
