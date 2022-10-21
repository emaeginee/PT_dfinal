package com.example.pt_dfinal;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.pt_dfinal.util.ImageResizeUtils;
import com.gun0912.tedpermission.PermissionListener;
//import com.gun0912.tedpermission.TedPermission; xxxxxxxxxxxxxxxx
import com.gun0912.tedpermission.TedPermissionUtil;
import com.gun0912.tedpermission.normal.TedPermission;

import com.soundcloud.android.crop.Crop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CameraActivity extends AppCompatActivity {
    private static final String TAG = "blackjin";

    private static final int PICK_FROM_ALBUM = 1;
    private static final int PICK_FROM_CAMERA = 2;

    private Boolean isCamera = false;
    private File tempFile;
    public File cropFile;

    private PermissionListener permissionListener;
    private Boolean isPermission = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        SharedPreferences sharedPref = getSharedPreferences("PREF", Context.MODE_PRIVATE);

        final String ocrApiGwUrl = sharedPref.getString("ocr_api_gw_url", "https://1nmqgfe05o.apigw.ntruss.com/custom/v1/17593/1159858723a553520011325a7a8b07c5ed8e3c5e6e2131c93f34f717abe1e3eb/general");
        final String ocrSecretKey = sharedPref.getString("ocr_secret_key", "ZEJEaFdGQnZVVHFOSEllT2JTTXFzZmFyV3N4S092dXU=");


        // 인바디 정보 수정/확인 버튼 클릭 시 수행
        Button btn_inbodyCheck = (Button) findViewById(R.id.inbodyCheck);
        btn_inbodyCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CameraCheckActivity.class);
                startActivity(intent);
            }
        });

        // 수기입력 버튼 클릭 시 수행
        Button btn_cameraWrite = (Button) findViewById(R.id.cameraWrite);
        btn_cameraWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InBodyWriteActivity1.class);
                startActivity(intent);
            }
        });

//        Button ocrTranslateBtn;
//        ocrTranslateBtn = (Button) findViewById(R.id.btn_ocr_translate);
//        ocrTranslateBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                OcrTask ocrTask = new OcrTask();
//                ocrTask.execute(ocrApiGwUrl, ocrSecretKey);
//            }
//        });



        tedPermission();
        //boolean isGranted = TedPermissionUtil.isGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION);
        boolean isGranted = TedPermissionUtil.isGranted(Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS,Manifest.permission.READ_EXTERNAL_STORAGE);
        Log.d("ted", "isGranted: " + isGranted);
        List<String> deniedPermissions = TedPermissionUtil.getDeniedPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS,Manifest.permission.READ_EXTERNAL_STORAGE);
        Log.d("ted", "deniedPermissions: " + deniedPermissions);



        findViewById(R.id.btnGallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAlbum();
            }
        });

        findViewById(R.id.btnCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePhoto();
            }
        });


    }





    //protected void tedPermission() { xxxxxxxxxx
    private void tedPermission() {
        permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(CameraActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(CameraActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };

        TedPermission.create()
                .setPermissionListener(permissionListener)
                .setRationaleTitle(R.string.rationale_title)
                .setRationaleMessage(R.string.rationale_message)
                .setDeniedTitle("Permission denied")
                .setDeniedMessage(
                        "If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setGotoSettingButtonText("SETTING")
                //Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION
                .setPermissions(Manifest.permission.READ_CONTACTS,Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_SHORT).show();

            if (tempFile != null) {
                if (tempFile.exists()) {

                    if (tempFile.delete()) {
                        Log.e(TAG, tempFile.getAbsolutePath() + " 삭제 성공");
                        tempFile = null;
                    } else {
                        Log.e(TAG, "tempFile 삭제 실패");
                    }

                } else {
                    Log.e(TAG, "tempFile 존재하지 않음");
                }
            } else {
                Log.e(TAG, "tempFile is null");
            }

            return;
        }

        switch (requestCode) {
            case PICK_FROM_ALBUM: {

                Uri photoUri = data.getData();
                Log.d(TAG, "PICK_FROM_ALBUM photoUri : " + photoUri);

                cropImage(photoUri);

                break;
            }
            case PICK_FROM_CAMERA: {

                // 앨범에 있지만 카메라 에서는 data.getData()가 없음
                Uri photoUri = Uri.fromFile(tempFile);
                Log.d(TAG, "takePhoto photoUri : " + photoUri);

                cropImage(photoUri);

                break;
            }
            case Crop.REQUEST_CROP: {
                setImage();
//                File cropFile = new File(Crop.getOutput(data).getPath()); //Crop.REQUEST_CROP 에서  크롭한 파일을 가져오는 방법
//                SharedPreferences sharedPref = getSharedPreferences("PREF", Context.MODE_PRIVATE);
//
//                final String ocrApiGwUrl = sharedPref.getString("ocr_api_gw_url", "https://1nmqgfe05o.apigw.ntruss.com/custom/v1/17593/1159858723a553520011325a7a8b07c5ed8e3c5e6e2131c93f34f717abe1e3eb/general");
//                final String ocrSecretKey = sharedPref.getString("ocr_secret_key", "ZEJEaFdGQnZVVHFOSEllT2JTTXFzZmFyV3N4S092dXU=");
//                OcrTask ocrTask = new OcrTask();
//                ocrTask.cropFile1 = cropFile;
//                ocrTask.execute(ocrApiGwUrl, ocrSecretKey);
            }
        }
    }

    /**
     * 앨범에서 이미지 가져오기
     */
    private void goToAlbum() {
        isCamera = false;

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    /**
     * 카메라에서 이미지 가져오기
     */
    private void takePhoto() {
        isCamera = true;

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);



        try {
            tempFile = createImageFile();
        } catch (IOException e) {
            Toast.makeText(this, "111이미지 처리 오류! 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
            finish();
            e.printStackTrace();
        }
        if (tempFile != null) {

            /**
             *  안드로이드 OS 누가 버전 이후부터는 file:// URI 의 노출을 금지로 FileUriExposedException 발생
             *  Uri 를 FileProvider 도 감싸 주어야 합니다.
             *
             *  참고 자료 http://programmar.tistory.com/4 , http://programmar.tistory.com/5
             */
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {

                Uri photoUri = FileProvider.getUriForFile(this,
                        "com.example.pt_dfinal.provider", tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, PICK_FROM_CAMERA);

            } else {

                Uri photoUri = Uri.fromFile(tempFile);
                Log.d(TAG, "takePhoto photoUri : " + photoUri);

                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, PICK_FROM_CAMERA);

            }
        }
    }

    /**
     * Crop 기능
     */
    private void cropImage(Uri photoUri) {

        Log.d(TAG, "tempFile : " + tempFile);

        /**
         *  갤러리에서 선택한 경우에는 tempFile이 없으므로 새로 생성해줍니다.
         */
        if (tempFile == null) {
            try {
                tempFile = createImageFile();
            } catch (IOException e) {
                Toast.makeText(this, "222이미지 처리 오류! 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                finish();
                e.printStackTrace();
            }
        }

        //크롭에 후 저장할 Uri
        Uri savingUri = Uri.fromFile(tempFile); //크롭 된 결과를 전역 변수 tempFile 의 uri에 저장하기 때문에 이 tempFile에 이미지가 있어야 됩니다

        Crop.of(photoUri, savingUri).start(this);
    }

    /**
     * 폴더 및 파일 만들기
     */
    private File createImageFile() throws IOException {

        // 이미지 파일 이름 ( blackJin_{시간}_ )
        String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
        String imageFileName = "blackJin_" + timeStamp + "_";
        System.out.println(imageFileName);


        // 이미지가 저장될 파일 이름 ( blackJin )
        File storageDir = new File(Environment.getExternalStorageDirectory() + "/blackJin/");
        if (!storageDir.exists()) storageDir.mkdirs();
        System.out.println(storageDir.getAbsolutePath());

        // 빈 파일 생성
        //File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        File image = File.createTempFile(imageFileName, ".jpg"); //********************
        System.out.println(image.getAbsolutePath());
        Log.d(TAG, "createImageFile : " + image.getAbsolutePath());

        return image;
    }

    /**
     * tempFile 을 bitmap 으로 변환 후 ImageView 에 설정한다.
     */

    public void setImage() {
        String ocrMessage = "";
//        OcrTask ocrTask = new OcrTask();
        String ocrApiURL = "https://1nmqgfe05o.apigw.ntruss.com/custom/v1/17593/1159858723a553520011325a7a8b07c5ed8e3c5e6e2131c93f34f717abe1e3eb/general";
        String ocrsecretKey = "ZEJEaFdGQnZVVHFOSEllT2JTTXFzZmFyV3N4S092dXU=";
        String imageFile = tempFile.getAbsolutePath();

//        File cropFile = new File(Crop.getOutput(data).getPath());

//        ImageView imageView = findViewById(R.id.imageVeiew);

        ImageResizeUtils.resizeFile(tempFile, tempFile,1280,isCamera);
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        Bitmap originalBm = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);
        Log.d(TAG, "setImage : " + tempFile.getAbsolutePath());
        tempFile = null;
        new Thread() {
            public void run() {
//                String result = "";
                try {
                    URL url = new URL(ocrApiURL);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setUseCaches(false);
                    con.setDoInput(true);
                    con.setDoOutput(true);
                    con.setReadTimeout(30000);
                    con.setRequestMethod("POST");
                    String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
                    con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
                    con.setRequestProperty("X-OCR-SECRET", ocrsecretKey);

                    JSONObject json = new JSONObject();
                    json.put("version", "V2");
                    json.put("requestId", UUID.randomUUID().toString());
                    json.put("timestamp", System.currentTimeMillis());
                    JSONObject image = new JSONObject();
                    image.put("format", "jpg");
                    image.put("name", "demo");
                    JSONArray images = new JSONArray();
                    images.put(image);
                    json.put("images", images);
                    String postParams = json.toString();

                    con.connect();
                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                    long start = System.currentTimeMillis();
                    File file = new File(imageFile);
                    writeMultiPart(wr, postParams, file, boundary);
                    wr.close();


                    int responseCode = con.getResponseCode();
                    BufferedReader br;
                    if (responseCode == 200) {
                        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    } else {
                        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                    }
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = br.readLine()) != null) {
                        response.append(inputLine);
                    }
                    br.close();

                    System.out.println(response);
                    runOnUiThread(new Runnable() {
                        public void run() {
                            String result = "";
                            try {
                                result = jsonToString(response.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(result);
                        }
                    });

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();




//        imageView.setImageBitmap(originalBm);

        /**
         *  tempFile 사용 후 null 처리를 해줘야 합니다.
         *  (resultCode != RESULT_OK) 일 때 (tempFile != null)이면 해당 파일을 삭제하기 때문에
         *  기존에 데이터가 남아 있게 되면 원치 않은 삭제가 이뤄집니다.
         */


    }

    private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
            IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
        sb.append(jsonMessage);
        sb.append("\r\n");

        out.write(sb.toString().getBytes("UTF-8"));
        out.flush();

        if (file != null && file.isFile()) {
            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
            StringBuilder fileString = new StringBuilder();
            fileString
                    .append("Content-Disposition:form-data; name=\"file\"; filename=");
            fileString.append("\"" + file.getName() + "\"\r\n");
            fileString.append("Content-Type: application/octet-stream\r\n\r\n");
            out.write(fileString.toString().getBytes("UTF-8"));
            out.flush();

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, count);
                }
                out.write("\r\n".getBytes());
            }

            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
        }
        out.flush();
    }

    public String jsonToString(String jsonResultStr) throws JSONException {
        String resultText = "";
        // API 호출 결과 받은 JSON 형태 문자열에서 텍스트 추출
        // JSONParser  사용하지 않음
        // images / 0 / fields / inferText 추출
        JSONObject jsonObj = new JSONObject(jsonResultStr);
        JSONArray imageArray = (JSONArray) jsonObj.get("images");
        if(imageArray != null) {
            JSONObject tempObj = (JSONObject) imageArray.get(0);
            JSONArray fieldArray = (JSONArray) tempObj.get("fields");
            if(fieldArray != null) {
                for(int i=0; i<fieldArray.length(); i++) {
                    tempObj = (JSONObject) fieldArray.get(i);
                    resultText += (String) tempObj.get("inferText") + " ";
                }
            }
        } else {
            System.out.println("없음");
        }
        String[] array = resultText.split(" ");
        List<String> inbodyresult = new ArrayList<>();
        //출력
        for(int s=0; s<array.length; s++) {
            if (array[s].contains(".")) {
                inbodyresult.add(array[s]);
            }
        }
        System.out.println("체중:"+ inbodyresult.get(0));
        System.out.println("골격근량:"+ inbodyresult.get(1));
        System.out.println("체지방량:"+ inbodyresult.get(2));
        TextView txtweight = (TextView) findViewById(R.id.updateWeight);
        txtweight.setText(inbodyresult.get(0));
        TextView txtmuscle = (TextView) findViewById(R.id.muscle);
        txtmuscle.setText(inbodyresult.get(1));
        TextView txtfat = (TextView) findViewById(R.id.fat);
        txtfat.setText(inbodyresult.get(2));

        // 값 전달
        // 카메라 페이지 -> 카메라체크페이지
        Intent intent = new Intent(getBaseContext(),CameraCheckActivity.class);
        intent.putExtra("weight",inbodyresult.get(0));
        intent.putExtra("muscle",inbodyresult.get(1));
        intent.putExtra("fat",inbodyresult.get(2));
        startActivity(intent);

        return resultText;
    }
}
