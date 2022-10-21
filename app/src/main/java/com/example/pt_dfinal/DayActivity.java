package com.example.pt_dfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DayActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        // 캘린더 객체 생성
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR); // 현재 년도
        int month = calendar.get(calendar.MONTH); // 현재 월
        int dayOfMonth = calendar.get(calendar.DAY_OF_MONTH); // 현재 일

        TextView textView = (TextView) findViewById(R.id.textview);
        Button btnUpdate = (Button) findViewById(R.id.update);
        Button btnGetDate = (Button) findViewById(R.id.getDate);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datepicker);

        textView.setText("초기 설정된 날짜 [월/일/년도]: \n" + year + "/" + (month + 1) + "/" + dayOfMonth);
        btnUpdate.setOnClickListener(this);
        btnGetDate.setOnClickListener(this);

        // 날짜 읽어오기 클릭시
        // fragment 에서는 그냥 findViewById로 Button id를 가져올 수 없음.
        TextView getDate = findViewById(R.id.getDate);
        //인플레이터된 view 를 사용하여 가져옴.
        getDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == btnUpdate) {
                    textView.setText("");

                } else {
                    textView.setText("선택된 날짜 : [월/일/년도] \n");
                    textView.setText(textView.getText() + "" + datePicker.getYear() +
                            "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth());
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}