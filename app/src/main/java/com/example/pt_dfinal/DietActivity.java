package com.example.pt_dfinal;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import org.w3c.dom.Text;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DietActivity extends AppCompatActivity {

    Dialog popup01, popup02;
    private static final int REQUEST_CODE=0;
    private ImageView imageView;
    private TextView textView23, textView2,contextEditText;
    //    private Button save_Btn, del_Btn, cha_Btn;
    public int year2;
    public int month2;
    public int day2;
    private int REQUEST_TEST = 200;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        year2= CalendarFragment.year1;
        month2= CalendarFragment.month1;
        day2= CalendarFragment.day1;

        TextView dateView = (TextView)findViewById(R.id.dietDate);
        dateView.setText(year2+"-"+month2+"-"+day2);

//        save_Btn = findViewById(R.id.save_Btn);
//        del_Btn = findViewById(R.id.del_Btn);
//        cha_Btn = findViewById(R.id.cha_Btn);
        textView2 = findViewById(R.id.textView2);
        contextEditText = findViewById(R.id.contextEditText);

        textView23 = findViewById(R.id.dietDate);
        CalendarView calendarView=findViewById(R.id.calendarView);

        // * 사진 등록
        ImageView imageView = (ImageView) findViewById(R.id.imageView10);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImagePopupActivity.class);
                startActivity(intent);
            }
        });
        // * 사진 설정 팝업
        popup01 = new Dialog(DietActivity.this);  //Dialog 초기화
        popup01.requestWindowFeature(Window.FEATURE_NO_TITLE); // title 제거
        popup01.setContentView(R.layout.popup_activity_calendar_image);
        // 사진 다이얼로그 띄우기
        findViewById(R.id.imageView10).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showDialog(); //showDialog 함수 호출
            }
        });

        // 메모
        popup02 = new Dialog(DietActivity.this);  //Dialog 초기화
        popup02.requestWindowFeature(Window.FEATURE_NO_TITLE); // title 제거
        popup02.setContentView(R.layout.activity_calendar_memo);
        // 메모 다이얼로그 띄우기
        findViewById(R.id.diet_Memo_show).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showDialog2(); //showDialog 함수 호출
//                startActivityForResult(getIntent(), REQUEST_TEST); // 메모를 작성하고 결과값을 받기 위해
            }
        });
    }

    public void Back(View view){
        super.onBackPressed();
    }

    // 메모 팝업창
    public void showDialog2(){
        popup02.show();
        /* 원하는 디자인, 기능 구현 */
//        popup02.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        popup02.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 팝업창 배경 없애기,
        popup02.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button save_btn = popup02.findViewById(R.id.save_Btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 저장 버튼을 클릭하여
                // 작성한 editText를 저장
//                String editContext = contextEditText.getText().toString();
                // 현재 날짜 저장
//                Date now = new Date();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm ss");
//                // 이상한 시간 조정
//                sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
//                String strnow = sdf.format(now);
                Toast.makeText(DietActivity.this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
                // String 값을 JSONObject로 변환하여 사용할 수 있도록 메모의 내용을 JSON 형식으로 저장
//                String save_form = "{\"content\":\""+editContext+"\"}";
//                // 키 값이 겹치지 않도록 현재 시간으로 부여
                // Intent로 값을 DietActivity에 전달
//                Intent intent = new Intent();
//                intent.putExtra("content", editContext);
//                setResult(RESULT_OK, intent);
//                finish();

            }
        });


    }


    // popup01 (사진 설정) 디자인하는 함수
    public void showDialog(){
        popup01.show();

        /* 원하는 디자인, 기능 구현 */

        // 앨범에서 사진 선택
        TextView textView27 = popup01.findViewById(R.id.textView27);
        textView27.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // 원하는 기능 구현
                popup01.dismiss();  // 다이얼 로그 닫기

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }

        });

        // 기본 이미지로 변경
        popup01.findViewById(R.id.textView28).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // 원하는 기능 구현
                setContentView(R.layout.activity_calendar_image3);
                popup01.dismiss();  // 다이얼 로그 닫기
            }
        });
    }



    // 앨범에서 사진 선택
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    imageView.setImageBitmap(img);
                } catch (Exception e) {

                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }


}