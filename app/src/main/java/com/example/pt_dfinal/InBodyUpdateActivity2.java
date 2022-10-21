package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class InBodyUpdateActivity2 extends AppCompatActivity {

    private Button updateMuscleNext;
    public static String UpdateMuscle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbodyupdate2);

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
//        if(savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction().replace(R.id.mypageInbody, MainpageActivity.newInstance())
//        }

        updateMuscleNext = findViewById(R.id.updateMuscleNext);
        updateMuscleNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InBodyUpdateActivity2.this, InBodyUpdateActivity3.class);
                startActivity(intent);

                // 페이드 효과
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

    }

}