package com.example.pt_dfinal;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    // 서버 URL 설정 ( PHP 파일 연동 ) LoginPT2.php   http://ec2-13-125-49-95.ap-northeast-2.compute.amazonaws.com
    final static private String URL = "http://suminpt.dothome.co.kr/RegisterPT2.php";
    private Map<String, String> map;
    public RegisterRequest(String userID, String userPassword, String userPassword2, String userName,
                           String userEmail, String userGender, String userBirth, int userHeight,
                           Response.Listener<String> listener) {

        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword", userPassword);
        map.put("userPassword2", userPassword2);
        map.put("userName", userName);
        map.put("userEmail", userEmail);
        map.put("userGender", userGender);
        map.put("userBirth", userBirth + "");
        map.put("userHeight", userHeight + "");
    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
