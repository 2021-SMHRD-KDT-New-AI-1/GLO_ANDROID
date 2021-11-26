package com.nsg.glo3;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private static final String TAG = "MAIN";
    EditText edt_id, edt_pw;
    AppCompatButton btLogin, tvRegister;
    RequestQueue requestQueue;
    SharedPreferences spf_user_info;
    SharedPreferences.Editor editor_user_info;
    String url = "http://172.30.1.26:3002/Login2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btLogin = findViewById(R.id.btLogin);
        tvRegister = findViewById(R.id.user_regis);

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        final StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String result = "";

                        try {
                            JSONObject object = new JSONObject(response);

                            result = object.getString("result");
                            String id = object.getString("id");
                            String pw = object.getString("pw");

                            spf_user_info = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                            editor_user_info = spf_user_info.edit();
                            editor_user_info.putString("id", id);
                            editor_user_info.putString("pw", pw);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast toast = null;

                        if(result.equals("login_success")){
                            toast = Toast.makeText(getApplicationContext(),"로그인 성공", Toast.LENGTH_SHORT);
                            toast.show();

                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);

                        }else if(response.equals("login_fail")){
                            toast = Toast.makeText(getApplicationContext(), "ID와 PW 확인", Toast.LENGTH_SHORT);
                            toast.show();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", edt_id.getText().toString());
                params.put("pw", edt_pw.getText().toString());

                return params;
            }
        };
        stringRequest.setTag(TAG);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestQueue.add(stringRequest);
            }
        });

//        tvRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Login.this, register.class);
//                startActivity(intent);
//            }
//        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        if (requestQueue != null) {
            requestQueue.cancelAll(TAG);
        }
    }
}