package com.example.pt_dfinal;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest extends StringRequest {
    // 서버 URL 설정 ( PHP 파일 연동 )
    final static private String URL = "http://suminpt.dothome.co.kr/DeletePT.php";

    private Map<String, String> parameters;
    public DeleteRequest(String userID, String userPassword, String userPassword2, String userName, String userEmail, String userGender, String userBirth, int userHeight, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userPassword2", userPassword2);
        parameters.put("userName", userName);
        parameters.put("userEmail", userEmail);
        parameters.put("userGender", userGender);
        parameters.put("userBirth", userBirth + "");
        parameters.put("userHeight", userHeight + "");

//    private Map<String, String> map;
//    public DeleteRequest(String userID, String userPassword, String userPassword2, String userName, String userEmail, String userGender, String userBirth, int userHeight, Response.Listener<String> listener) {
//
//        super(Method.POST, URL, listener, null);
//        map = new HashMap<>();
//        map.put("userID",userID);
//        map.put("userPassword", userPassword);
//        map.put("userPassword2", userPassword2);
//        map.put("userName", userName);
//        map.put("userEmail", userEmail);
//        map.put("userGender", userGender);
//        map.put("userBirth", userBirth + "");
//        map.put("userHeight", userHeight + "");
    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }
}
