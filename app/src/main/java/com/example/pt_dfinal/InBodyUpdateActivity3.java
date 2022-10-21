package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class InBodyUpdateActivity3 extends AppCompatActivity {

//    public static String UpdateFat;
    private Button FatNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbodyupdate3);

        FatNext = findViewById(R.id.updateBodyfatNext);
        FatNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InBodyUpdateActivity3.this, MainActivity2.class);
                startActivity(intent);

                // 페이드 효과
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                // 체중 가져오기
//                EditText UpdateFat = (EditText) findViewById(R.id.updateFat);
//                UpdateFat = UpdateFat.getText().toString();

            }
        });
    }
}
