package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.w3c.dom.Text;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class MainpageFragment extends Fragment {

    public String MainWeight, MainMuscle, MainFat, MainUpdateWeight, MainUpdateHeight, MainUpdateFat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_mainpage, container, false);

        // 인바디 값 가져오기
        MainWeight=CameraCheckActivity.getWeight;
        MainMuscle=CameraCheckActivity.getMuscle;
        MainFat=CameraCheckActivity.getFat;
        TextView Weight = (TextView) view.findViewById(R.id.main_weight);
        Weight.setText(MainWeight + " kg");
        TextView Muscle = (TextView) view.findViewById(R.id.main_muscle);
        Muscle.setText(MainMuscle + " kg");
        TextView fat = (TextView) view.findViewById(R.id.main_fat);
        fat.setText(MainFat + " kg");


        // 인바디 업데이트 값 가져오기
//        MainUpdateWeight=InBodyUpdateActivity1.UpdateWeight;
//        TextView UpdateWeight = (TextView) view.findViewById(R.id.main_weight);
//        UpdateWeight.setText(MainUpdateWeight + " kg");


        // 회원아이디
        TextView UserId=view.findViewById(R.id.textView12);
        Intent intent = getActivity().getIntent();
        String userID=intent.getStringExtra("userID");
        UserId.setText(userID);

        return view;
    }

}