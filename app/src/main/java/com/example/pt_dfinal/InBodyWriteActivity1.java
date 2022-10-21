package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class InBodyWriteActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbodywrite1);
    }

    public void weightNext(View view){
        Intent intent=new Intent(getApplicationContext(), InBodyWriteActivity2.class);
        startActivityForResult(intent, 0);
    }

}
