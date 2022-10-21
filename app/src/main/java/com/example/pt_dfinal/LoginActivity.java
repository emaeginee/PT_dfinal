package com.example.pt_dfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    private EditText et_id, et_pass;
    private TextView btn_register;
    private Button btn_login;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);


        // 회원가입 버튼을 클릭 시 수행
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, DegreeActivity.class);
                startActivity(intent);
            }
        });

        // 로그인 버튼
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CameraActivity.class);
                startActivity(intent);

            }
//                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
//                String userID = et_id.getText().toString();
//                String userPassword = et_pass.getText().toString();
//                // 빈칸 X, ID, Password 미입력시 로그인 X
//                if(userID.equals("") || userPassword.equals("") ){
//                    Toast.makeText(getApplicationContext(),"ID, Password를 입력해주세요.",Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
////                            System.out.println(" " + response);
//                            JSONObject jsonObject = new JSONObject(response);
//                            boolean success = jsonObject.getBoolean("success");
//                            if (success) { // 로그인에 성공한 경우
//                                String userID = jsonObject.getString("userID");
//                                String userPassword = jsonObject.getString("userPassword");  // "userPassword" : php파일에서의 키값
//                                Toast.makeText(getApplicationContext(),"로그인에 성공하였습니다.",Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(Login.this, MainActivity2.class);
//                                intent.putExtra("userID", userID); // 데이터를 담아줌. (로그인 유저를 알려주기 위함)
//                                intent.putExtra("userPassword", userPassword);
//                                startActivity(intent);
//                            } else { // 로그인에 실패한 경우
//                                Toast.makeText(getApplicationContext(),"로그인에 실패하였습니다.",Toast.LENGTH_SHORT).show();
//                                return;
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(getApplicationContext(), "예외1", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                    }
//                };
//                LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
//                RequestQueue queue = Volley.newRequestQueue(Login.this);
//                queue.add(loginRequest);
//            }
        });
    }
}


//        id=findViewById(R.id.editTextTextPersonName);
//        pwd=findViewById(R.id.pwd);
//        register=findViewById(R.id.register_btn);
//        btnlogin=findViewById(R.id.login);
//
//        // 회원가입
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Login.this,RegisterActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final String userID=id.getText().toString();
//                String userPass=pwd.getText().toString();
//
//
//                Response.Listener<String> responseListener=new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jasonObject=new JSONObject(response);
//                            boolean success=jasonObject.getBoolean("success");
//                            if (success) {//회원등록 성공한 경우
//                                String userID = jasonObject.getString("userID");
//                                String userPass = jasonObject.getString("userPassword");
//                                Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(Login.this, MainActivity.class);
//                                intent.putExtra("log", "User");
//                                intent.putExtra("userID", userID);
//                                startActivity(intent);
//                            }
//
//
//                            else{//회원등록 실패한 경우
//                                Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
//                                return;
//
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                LoginRequest loginRequest=new LoginRequest(userID,userPass,responseListener);
//                RequestQueue queue= Volley.newRequestQueue(Login.this);
//                queue.add(loginRequest);
//            }
//        });
        // 로그인 버튼




//    // 회원가입 버튼
//   public void processRegister(View view){
//        Intent intent = new Intent(getApplicationContext(), DegreeActivity.class);
//        startActivityForResult(intent, 0);
//    }
//}
