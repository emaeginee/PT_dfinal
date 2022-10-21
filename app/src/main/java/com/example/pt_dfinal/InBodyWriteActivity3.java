package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class InBodyWriteActivity3 extends AppCompatActivity {

    private Button completeNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbodywrite3);

        completeNext = findViewById(R.id.completeNext);
        completeNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InBodyWriteActivity3.this, MainActivity2.class);
                startActivity(intent);

                // 페이드 효과
//                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                // 체중 가져오기
//                EditText UpdateFat = (EditText) findViewById(R.id.updateFat);
//                UpdateFat = UpdateFat.getText().toString();

            }
        });



    }

//    public void completeNext(View view){
//        Intent intent=new Intent(getApplicationContext(), MainpageFragment.class);
//        startActivityForResult(intent, 0);
//    }

}
