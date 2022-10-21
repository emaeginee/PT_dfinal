package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class CameraCheckActivity extends AppCompatActivity {

    public static String getWeight;
    public static String getMuscle;
    public static String getFat;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameracheck);

        // 카메라 실행시 즉, 폰으로 실행 시에 주석 지우고 실행할 것**!
//        EditText weightView =(EditText)findViewById(R.id.weight);
//        EditText muscleView =(EditText)findViewById(R.id.muscle);
//        EditText fatView =(EditText)findViewById(R.id.editTextNumber3);
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
 //       String weight= bundle.getString("weight");
//        String muscle= bundle.getString("muscle");
//        String fat= bundle.getString("fat");
//        weightView.setText(weight);
//        muscleView.setText(muscle);
 //       fatView.setText(fat);

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CameraCheckActivity.this, MainActivity2.class);
                startActivity(intent);

                EditText weight = (EditText) findViewById(R.id.updateWeight);
                EditText muscle = (EditText) findViewById(R.id.muscle);
                EditText fat = (EditText) findViewById(R.id.check_fat);
                // 체중 가져오기
                getWeight = weight.getText().toString();
                // 골격근량 가져오기
                getMuscle = muscle.getText().toString();
                // 체지방량 가져오기
                getFat = fat.getText().toString();
            }
        });


    }



}

//    public void btnInbodySave(View view){
//        Intent intent=new Intent(getApplicationContext(), MypageActivity.class);
//        startActivityForResult(intent, 0);
//    }


