package com.example.pt_dfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DeleteActivity extends AppCompatActivity {

//    private EditText et_id, et_pass,et_pass2, et_name, et_email, et_birth, et_height;
//    private String et_gender;
//    private Button deleteDel;
//
//    private boolean validate = false;
//    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

//        et_id = findViewById(R.id.et_id);
//        et_pass = findViewById(R.id.et_pass);
//        et_pass2 = findViewById(R.id.et_pass2);
//        et_name = findViewById(R.id.et_name);
//        et_email = findViewById(R.id.et_email);
//        et_birth = findViewById(R.id.et_birth);
//        et_height = findViewById(R.id.et_height);
//
//
//        deleteDel = findViewById(R.id.btn_register);
//        deleteDel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String userID = et_id.getText().toString();
//                String userPass = et_pass.getText().toString();
//                String userPass2 = et_pass2.getText().toString();
//                String userName = et_name.getText().toString();
//                String userEmail = et_email.getText().toString();
//                String userGender = et_gender.getBytes().toString();
//                String userBirth = et_birth.getText().toString();
//                int userHeight = Integer.parseInt(et_height.getText().toString());
//
//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonResponse = new JSONObject(response);
//                            boolean success = jsonResponse.getBoolean("success");
//                            if (success) {
//                                Toast.makeText(getApplicationContext(), "회원 탈퇴 성공.", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(DeleteActivity.this, Login.class);
//                                startActivity(intent);
//                            } else {
//                                Toast.makeText(getApplicationContext(), "회원 탈퇴 실패.", Toast.LENGTH_SHORT).show();
//                                return;
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                // 서버로 Volley를 이용해서 요청을 함.
//                DeleteRequest deleteRequest = new DeleteRequest(userID, userPass, userPass2, userName, userEmail, userGender, userBirth, userHeight, responseListener);
//                RequestQueue queue = Volley.newRequestQueue(DeleteActivity.this);
//                queue.add(deleteRequest);
//
//            }
//        });
    }

    // 회원탈퇴
    public void delete(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
    }
//
//    // 이전 화면 (설정 페이지)
//    public void deleteBtn(View view){
//        Intent intent=new Intent(getApplicationContext(), SettingActivity.class);
//        startActivityForResult(intent, 0);
//    }



//    // 회원탈퇴
//    public void btn_Delete(View v) {
//
//        new AlertDialog.Builder(this)
//                .setTitle("회원탈퇴").setMessage("탈퇴 하시겠습니까?")
//                .setPositiveButton("탈퇴", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        String userID = et_id.getText().toString();
//                        String userPass = et_pass.getText().toString();
//                        String userPass2 = et_pass2.getText().toString();
//                        String userName = et_name.getText().toString();
//                        String userEmail = et_email.getText().toString();
//                        String userGender = et_gender.getBytes().toString();
//                        String userBirth = et_birth.getText().toString();
//                        int userHeight = Integer.parseInt(et_height.getText().toString());
//
//                        Response.Listener<String> responseListener=new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                try{
//                                    JSONObject jsonResponse=new JSONObject(response);
//                                    boolean success=jsonResponse.getBoolean("success");
//                                    if(success){
//                                        Toast.makeText(getApplicationContext(),"회원 탈퇴 성공.",Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(DeleteActivity.this, Login.class);
//                                        startActivity(intent);
//                                    }else{
//                                        Toast.makeText(getApplicationContext(),"회원 탈퇴 실패.",Toast.LENGTH_SHORT).show();
//                                        return;
//                                    }
//                                }catch(JSONException e){
//                                    e.printStackTrace();
//                                }
//                            }
//                        };
//                        // 서버로 Volley를 이용해서 요청을 함.
//                        DeleteRequest deleteRequest = new DeleteRequest(userID,userPass,userPass2,userName,userEmail,userGender,userBirth,userHeight, responseListener);
//                        RequestQueue queue = Volley.newRequestQueue(DeleteActivity.this);
//                        queue.add(deleteRequest);
//
////                        Intent i = new Intent(DeleteActivity.this, Login.class);
////                        startActivity(i);
//                    }
//                })
//                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//
//                    }
//                })
//                .show();
//    }





}