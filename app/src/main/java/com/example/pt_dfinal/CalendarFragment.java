package com.example.pt_dfinal;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class CalendarFragment extends Fragment{

    public static int year1;
    public static int month1;
    public static int day1;
    Dialog popup01, popup02;

    public TextView diaryTextView;
    TextView date_txt;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Millisecond 형태의 하루(24 시간)
    private final int ONE_DAY = 24 * 60 * 60 * 1000;

    // 현재 날짜를 알기 위해 사용
    private Calendar mCalendar;

    // D-day result
    private TextView mTvResult;



    // DatePicker 에서 날짜 선택 시 호출
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker a_view, int a_year, int a_monthOfYear, int a_dayOfMonth) {
            // D-day 계산 결과 출력
            mTvResult.setText(getDday(a_year, a_monthOfYear, a_dayOfMonth));
        }
    };




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_calendar, container, false);


        // fragment 에서는 그냥 findViewById로 Button id를 가져올 수 없음.
        TextView diaryTextView = view.findViewById(R.id.diaryTextView);
        TextView memoText = view.findViewById(R.id.memoText);

        CalendarView calendarView=view.findViewById(R.id.calendarView);
        // 이벤트 처리
        View.OnClickListener onClickListener = new OnClickListener();
        diaryTextView.setOnClickListener(onClickListener);

        // 금일 일자관련 출력
        long now = System.currentTimeMillis(); // 현재시간 가져오기
        Date date = new Date(now); //Date 형식으로 Convert
        String getTime = dateFormat.format(date);
        diaryTextView.setText(getTime);

        year1 = Integer.parseInt(getTime.substring(0, 4));
        month1 = Integer.parseInt(getTime.substring(5, 7));
        day1 = Integer.parseInt(getTime.substring(8));

        // 한국어 설정 (ex: date picker)
        Locale.setDefault(Locale.KOREAN);

        // 현재 날짜를 알기 위해 사용
        mCalendar = new GregorianCalendar();

        // D-day 보여주기
        mTvResult = view.findViewById(R.id.date_txt);


        // 디데이 클릭시  ******
        TextView date_txt = view.findViewById(R.id.date_txt);
        date_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int year= mCalendar.get(Calendar.YEAR);
                final int month = mCalendar.get(Calendar.MONTH);
                final int day = mCalendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getActivity(), mDateSetListener, year, month, day);
                dialog.show();
            }
        });



//        // 디데이 클릭시
//        TextView date_txt = view.findViewById(R.id.date_txt);
//        date_txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity().getApplicationContext(), DayActivity.class);
//                startActivity(intent);
//            }
//        });

        // 선택한 날짜 표시
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint({"WrongConstant", "SetTextI18n"})
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {

                diaryTextView.setText("" + year+ "-"+(month+1)+"-"+dayOfMonth);
                year1=year;
                month1=month+1;
                day1=dayOfMonth;
            }
        });


        //인플레이터된 view 를 사용하여 가져옴.
        memoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), DietActivity.class);
                startActivity(intent);
            }
        });

        return view;


//        // * 사진 설정 팝업
//        popup01 = new Dialog(CalendarActivity.this);  //Dialog 초기화
//        popup01.requestWindowFeature(Window.FEATURE_NO_TITLE); // title 제거
//        popup01.setContentView(R.layout.popup_activity_calendar_image);

//        // 사진 다이얼로그 띄우기
//        ImageView popup01 = view.findViewById(R.id.imageView10);
//        popup01.setOnClickListener(new View.OnClickListener(){
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onClick(View view){
//                DatePickerDialog dialog = new DatePickerDialog(getActivity());
//                dialog.show(); //showDialog 함수 호출
//            }
//        });


        // 메모
//        popup02 = new Dialog(CalendarActivity.this);  //Dialog 초기화
//        popup02.requestWindowFeature(Window.FEATURE_NO_TITLE); // title 제거
//        popup02.setContentView(R.layout.activity_calendar_memo);

        // 메모 다이얼로그 띄우기
//        TextView memoText = view.findViewById(R.id.memoText);
//        memoText.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                showDialog2(); //showDialog 함수 호출
//
//            }
//
//            private void showDialog2() {
//            }
//        });


    }




    /**
     * D-day 반환
     */
    private String getDday(int a_year, int a_monthOfYear, int a_dayOfMonth) {
        // D-day 설정
        final Calendar ddayCalendar = Calendar.getInstance();
        ddayCalendar.set(a_year, a_monthOfYear, a_dayOfMonth);

        // D-day 를 구하기 위해 millisecond 으로 환산하여 d-day 에서 today 의 차를 구한다.
        final long dday = ddayCalendar.getTimeInMillis() / ONE_DAY;
        final long today = Calendar.getInstance().getTimeInMillis() / ONE_DAY;
        long result = dday - today;

        // 출력 시 d-day 에 맞게 표시
        final String strFormat;
        if (result > 0) {
            strFormat = "D-%d";
        } else if (result == 0) {
            strFormat = "D-Day";
        } else {
            result *= -1;
            strFormat = "D+%d";
        }

        final String strCount = (String.format(strFormat, result));
        return strCount;
    }


    /**
     * Today 반환
     */
    private String getToday() {
        // 지정된 format 으로 string 표시
        final String strFormat = getString(R.string.format_today);
        SimpleDateFormat CurDateFormat = new SimpleDateFormat(strFormat);
        return CurDateFormat.format(mCalendar.getTime());
    }


    // 현재날짜 가져오기
    class OnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
//            String str_getDate = diaryTextView.getText().toString() + " 00:00:00";
            Date date = null;
            switch(view.getId()) {
                case R.id.date_txt:
                    String str_date = diaryTextView.getText().toString();
                    int i_year = Integer.parseInt(str_date.substring(0, 4));
                    int i_month = Integer.parseInt(str_date.substring(5, 7));
                    int i_day = Integer.parseInt(str_date.substring(8));

                    break;
            }
        }
    }

//    public void callDateDialog(View view){
//        DialogFragment dateFragment=new DatePickerFragment();
//        dateFragment.show(getSupportFragmentManager(), "dateFragment");
//    }



}

//        CalendarView calendarView=view.findViewById(R.id.calendarView);
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//           @Override
//            public void onSelectedDayChange(@NonNull  CalendarView view, int year, int month, int dayOfMonth) {
//                diaryTextView.setVisibility(View.VISIBLE);
//                diaryTextView.setText(String.format("%d / %d / %d", year, month + 1, dayOfMonth));
//            }
//        });
