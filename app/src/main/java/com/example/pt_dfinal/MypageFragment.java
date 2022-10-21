package com.example.pt_dfinal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MypageFragment extends Fragment {

    // 시각화 차트
    LineChart lineChart1;
    LineChart lineChart2;
    LineChart lineChart3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_mypage, container, false);

        //chart1
        lineChart1 = (LineChart) view.findViewById(R.id.chart1);
        List<Entry> entries1 = new ArrayList<Entry>();
        entries1.add(new Entry(1,1));
        entries1.add(new Entry(2,2));
        entries1.add(new Entry(3,3));
        entries1.add(new Entry(4,4));
        entries1.add(new Entry(5,5));


        LineDataSet dataSet1 = new LineDataSet(entries1, "체중");
        dataSet1.setLineWidth(4); //라인 두께
        dataSet1.setCircleRadius(6); // 점 크기
        dataSet1.setCircleColor(Color.parseColor("#FFA1B4DC")); // 점 색깔
        dataSet1.setDrawCircleHole(true); // 원의 겉 부분 칠할거?
        dataSet1.setColor(Color.parseColor("#FFA1B4DC")); // 라인 색깔
        XAxis bottomAxis1 = lineChart1.getXAxis();
        bottomAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);
        bottomAxis1.setEnabled(false);
        YAxis RightAxis1 = lineChart1.getAxisRight();
        RightAxis1.setEnabled(false);

        LineData lineData1 = new LineData(dataSet1);
        lineChart1.getAxisRight().setAxisMinimum(0);
        lineChart1.getAxisLeft().setAxisMinimum(0);
        lineChart1.getAxisRight().setAxisMaximum(120);
        lineChart1.getAxisLeft().setAxisMaximum(120);
        lineChart1.setData(lineData1);
        lineChart1.invalidate();
        Description des1 = lineChart1.getDescription();
        des1.setEnabled(false);

        //chart2
        lineChart2 = (LineChart) view.findViewById(R.id.chart2);
        List<Entry> entries2 = new ArrayList<Entry>();
        entries2.add(new Entry(1,1));
        entries2.add(new Entry(2,2));
        entries2.add(new Entry(3,3));
        entries2.add(new Entry(4,4));
        entries2.add(new Entry(5,5));


        LineDataSet dataSet2 = new LineDataSet(entries2, "골격근량");
        dataSet2.setLineWidth(4); //라인 두께
        dataSet2.setCircleRadius(6); // 점 크기
        dataSet2.setCircleColor(Color.parseColor("#FFA1B4DC")); // 점 색깔
        dataSet2.setDrawCircleHole(true); // 원의 겉 부분 칠할거?
        dataSet2.setColor(Color.parseColor("#FFA1B4DC")); // 라인 색깔
        XAxis bottomAxis2 = lineChart2.getXAxis();
        bottomAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
        bottomAxis2.setEnabled(false);
        YAxis RightAxis2 = lineChart2.getAxisRight();
        RightAxis2.setEnabled(false);

        LineData lineData2 = new LineData(dataSet2);
        lineChart2.getAxisRight().setAxisMinimum(0);
        lineChart2.getAxisLeft().setAxisMinimum(0);
        lineChart2.getAxisRight().setAxisMaximum(120);
        lineChart2.getAxisLeft().setAxisMaximum(120);
        lineChart2.setData(lineData2);
        lineChart2.invalidate();
        Description des2 = lineChart2.getDescription();
        des2.setEnabled(false);


        //chart3
        lineChart3 = (LineChart) view.findViewById(R.id.chart3);
        List<Entry> entries3 = new ArrayList<Entry>();
        entries3.add(new Entry(1,1));
        entries3.add(new Entry(2,2));
        entries3.add(new Entry(3,3));
        entries3.add(new Entry(4,4));
        entries3.add(new Entry(5,5));


        LineDataSet dataSet3 = new LineDataSet(entries3, "골격근량");
        dataSet3.setLineWidth(4); //라인 두께
        dataSet3.setCircleRadius(6); // 점 크기
        dataSet3.setCircleColor(Color.parseColor("#FFA1B4DC")); // 점 색깔
        dataSet3.setDrawCircleHole(true); // 원의 겉 부분 칠할거?
        dataSet3.setColor(Color.parseColor("#FFA1B4DC")); // 라인 색깔
        XAxis bottomAxis3 = lineChart3.getXAxis();
        bottomAxis3.setPosition(XAxis.XAxisPosition.BOTTOM);
        bottomAxis3.setEnabled(false);
        YAxis RightAxis3 = lineChart3.getAxisRight();
        RightAxis3.setEnabled(false);

        LineData lineData3 = new LineData(dataSet3);
        lineChart3.getAxisRight().setAxisMinimum(0);
        lineChart3.getAxisLeft().setAxisMinimum(0);
        lineChart3.getAxisRight().setAxisMaximum(120);
        lineChart3.getAxisLeft().setAxisMaximum(120);
        lineChart3.setData(lineData3);
        lineChart3.invalidate();

        Description des3 = lineChart3.getDescription();
        des3.setEnabled(false);


        // userID
        TextView UserId=view.findViewById(R.id.UserId);
        Intent intent = getActivity().getIntent();
        String userID=intent.getStringExtra("userID");
        UserId.setText(userID);

        // fragment 에서는 그냥 findViewById로 Button id를 가져올 수 없음.
        TextView mypageInbody = view.findViewById(R.id.mypageInbody);
        //인플레이터된 view 를 사용하여 가져옴.
        mypageInbody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), InBodyUpdateActivity1.class);
                startActivity(intent);
            }
        });

        // 고객센터
        ImageView center1 = view.findViewById(R.id.imageView11);
        center1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CenterActivity.class);
                startActivity(intent);
            }
        });
        ImageView center2 = view.findViewById(R.id.imageView20);
        center2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CenterActivity.class);
                startActivity(intent);
            }
        });
        TextView center3 = view.findViewById(R.id.dietDate);
        center3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CenterActivity.class);
                startActivity(intent);
            }
        });


        // 공지사항
        ImageView notice1 = view.findViewById(R.id.imageView12);
        notice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), NoticeActivity.class);
                startActivity(intent);
            }
        });
        ImageView notice2 = view.findViewById(R.id.imageView23);
        notice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), NoticeActivity.class);
                startActivity(intent);
            }
        });
        TextView notice3 = view.findViewById(R.id.textView24);
        notice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        // 설정
        ImageView setting1 = view.findViewById(R.id.imageView13);
        setting1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });
        ImageView setting2 = view.findViewById(R.id.imageView18);
        setting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });
        TextView setting3 = view.findViewById(R.id.textView25);
        setting3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });


        // 회원정보 수정 -> 프로필 사진 변경으로 추후 수정 예정****!!!!
//        ImageView registerUpdate = view.findViewById(R.id.imageView16);
//        //인플레이터된 view 를 사용하여 가져옴.
//        registerUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity().getApplicationContext(), RegisterUpdateActivity.class);
//                startActivity(intent);
//            }
//        });
//        ImageView registerUpdate2 = view.findViewById(R.id.imageView15);
//        //인플레이터된 view 를 사용하여 가져옴.
//        registerUpdate2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity().getApplicationContext(), RegisterUpdateActivity.class);
//                startActivity(intent);
//            }
//        });


        return view;
    }

}