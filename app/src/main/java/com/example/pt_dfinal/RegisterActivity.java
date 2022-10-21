package com.example.pt_dfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pass,et_pass2, et_name, et_email, et_birth, et_height;
    private String et_gender;
    private Button btn_register, btnPwdCheck, btnPwdComplete;

    private boolean validate = false;
    private AlertDialog dialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 아이디 값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_pass2=findViewById(R.id.et_pass2);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_birth = findViewById(R.id.et_birth);
        et_height = findViewById(R.id.et_height);


        // 성별
        RadioGroup genderGroup = (RadioGroup)findViewById(R.id.et_gender);
        int genderGroupID = genderGroup.getCheckedRadioButtonId();
        et_gender = ((RadioButton)findViewById(genderGroupID)).getText().toString();

        // 라디오 버튼이 눌리면 값을 바꾸어줌.
        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton genderButton = (RadioButton)findViewById(i);
                et_gender = genderButton.getText().toString();
            }
        });


        // 회원가입 버튼 클릭 시 수행
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String userID = et_id.getText().toString();
                String userPassword = et_pass.getText().toString();
                String userPass2 = et_pass2.getText().toString();
                String userName = et_name.getText().toString();
                String userEmail = et_email.getText().toString();
                String userGender = Arrays.toString(et_gender.getBytes());
                String userBirth = et_birth.getText().toString();
                int userHeight = Integer.parseInt(et_height.getText().toString());

                // 빈칸 X
                if(userID.equals("") || userPassword.equals("") || userPass2.equals("") || userName.equals("")
                        || userEmail.equals("") || userGender.equals("") || userBirth.equals("") ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("빈 칸 없이 입력해주세요.")
                            .setNegativeButton("확인",null).create();
                    dialog.show();
                    return;
                }


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);  //
                            boolean success = jsonObject.getBoolean("success"); // 성공 여부 (""success" php파일의 response -> success로 선언해준것")
                            if (success) { // 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(),"회원 등록 성공.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, CameraActivity.class); // ocr 인바디 정보 입력 페이지로 이동
                                startActivity(intent);
                            } else { // 회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(),"회원 등록 실패.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"예외 1", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                };
                // 서버로 Volley를 이용해서 요청을 함.
                RegisterRequest registerRequest = new RegisterRequest(userID,userPassword,userPass2,userName,userEmail,userGender,
                                                                        userBirth,userHeight, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });

        // 비밀번호 확인 버튼
        btnPwdCheck=findViewById(R.id.btnPwdCheck);
        btnPwdCheck.setOnClickListener(v -> {
            if(et_pass.getText().toString().equals(et_pass2.getText().toString())){
                btnPwdCheck.setText("일치");
            }else{
                Toast.makeText(RegisterActivity.this, "비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
            }
        });


        // 완료 버튼
        btnPwdComplete=findViewById(R.id.btn_register);
        btnPwdComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), RegisterCompleteActivity.class);
                startActivityForResult(intent, 0);
            }

//        // 아이디 중복 확인
//
//        // 아이디 확인
//        final Button validateButton = (Button)findViewById(R.id.validateButton);
//        validateButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                String userID = et_id.getText().toString();
//                if(validate){
//                    return; // 검증 완료
//                }
//                if(userID.equals("")){
//                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
//                    dialog = builder.setMessage("아이디는 빈 칸일 수 없습니다.")
//                            .setPositiveButton("확인",null).create();
//                    dialog.show();
//                    return;
//                }
//
//                //검증
//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonResponse = new JSONObject(response);
//                            boolean success = jsonResponse.getBoolean("success");
//                            if (success){
//                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
//                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.")
//                                        .setPositiveButton("확인",null).create();
//                                dialog.show();
//                                et_id.setEnabled(false); // 아이디 값을 바꿀수 없도록 함
//                                validate = true; // 검증 완료
//                                et_id.setBackgroundColor(getResources().getColor(R.color.colorPT));
//                                validateButton.setBackgroundColor(getResources().getColor(R.color.colorPT));
//                            }
//                            else{
//                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
//                                dialog = builder.setMessage("사용할 수 없는 아이디입니다.")
//                                        .setNegativeButton("확인",null).create();
//                                dialog.show();
//                            }
//                        }
//                        catch (Exception e){
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                ValidateRequest validateRequest = new ValidateRequest(userID, responseListener);
//                RequestQueue queue  = Volley.newRequestQueue(RegisterActivity.this);
//                queue.add(validateRequest);
//            }
//        });

    });

//    public void Back(View view){
//        super.onBackPressed();
//    }

//    @Override
//    protected void onStop(){
//        super.onStop();
//        if(dialog != null){
//            dialog.dismiss();
//            dialog = null;
//        }
//    }
    }
}


//    public void btnRegisterComplete(View view){
//        Intent intent=new Intent(getApplicationContext(), RegisterCompleteActivity.class);
//        startActivityForResult(intent, 0);
//    }


