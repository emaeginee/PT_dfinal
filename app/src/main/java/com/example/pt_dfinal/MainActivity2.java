package com.example.pt_dfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView; // bottom navigation view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigationView = findViewById(R.id.bottomNavi);
//        bottomNavigationView.setSelectedItemId(R.id.item_fragment3);


        // 처음 화면
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new MainpageFragment()).commit(); //FrameLayout에 fragment.xml 띄우기

        //바텀 네비게이션뷰 안의 아이템 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //item을 클릭시 id값을 가져와 FrameLayout에 fragment.xml띄우기
                    case R.id.item_fragment2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new CalendarFragment()).commit();
                        break;
                    case R.id.item_fragment3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new MainpageFragment()).commit();
                        break;
                    case R.id.item_fragment4:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new CameraActivity()).commit();
                        Intent intent=new Intent(getApplicationContext(), CameraActivity.class);
                        startActivityForResult(intent, 0);
                        break;
                    case R.id.item_fragment5:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new MypageFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }
}

