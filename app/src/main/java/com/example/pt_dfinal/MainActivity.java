package com.example.pt_dfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Loginpage(View view){
        Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent, 0);
    }


}