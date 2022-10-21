package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class RegisterCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registercomplete);
    }

    //
    public void btnRegisterComplete2(View view){
        Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent, 0);
    }
}
