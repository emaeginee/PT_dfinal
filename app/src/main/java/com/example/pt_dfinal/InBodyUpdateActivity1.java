package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class InBodyUpdateActivity1 extends AppCompatActivity {

//    public static String UpdateWeight;
    private Button weightNext;
    private ImageButton PreWeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbodyupdate1);

        // 화면 상단 이전 버튼
        // 클릭시 마이페이지(MyPageActivity)로 이동
//        PreWeight = findViewById(R.id.weight_pre);
//        PreWeight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(InBodyUpdateActivity1.this, MainpageFragment.class);
//                startActivity(intent);
//            }
//        });


        weightNext = findViewById(R.id.updateWeightNext);
        weightNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InBodyUpdateActivity1.this, InBodyUpdateActivity2.class);
                startActivity(intent);

                // 페이드 효과
//                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                // 슬라이드(부자연)
//                overridePendingTransition(R.anim.right_enter, R.anim.left_enter);

                // 체중 가져오기
//                EditText Updateweight = (EditText) findViewById(R.id.updateWeight);
//                UpdateWeight = Updateweight.getText().toString();

            }
        });
    }

}
