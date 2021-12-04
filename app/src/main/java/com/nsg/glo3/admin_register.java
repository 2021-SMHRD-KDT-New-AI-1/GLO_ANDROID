package com.nsg.glo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

public class admin_register extends AppCompatActivity {


    EditText edt_id,edt_pw,edt_place,edt_major;
    AppCompatButton button;
    RequestQueue requestQueue;
    int admin;
    String url = "http://172.30.1.26:3002/signup_a";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_place = findViewById(R.id.edt_place);
        edt_major = findViewById(R.id.edt_major);
        button = findViewById(R.id.button);
        admin = 1;

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final StringRequest stringRequest = new StringRequest(
                        Request.Method.POST,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {


                                try {
                                    JSONObject object = new JSONObject(response);




                                } catch (JSONException e) {
                                    e.printStackTrace();
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

                        params.put("id",edt_id.getText().toString());
                        params.put("pw",edt_pw.getText().toString());
                        //params.put("place",edt_place.getText().toString());
                        // params.put("major",edt_major.getText().toString());
                        params.put("admin",String.valueOf(admin));

                        //params.put("gender",rd1.getText().toString());
                        //params.put("diagnosis",rd2.getText().toString());

                        //Log.d("check",rd1.getText().toString());




                        return params;
                    }
                };

                requestQueue.add(stringRequest);

                Intent intent = new Intent(admin_register.this,Login.class);
                startActivity(intent);
            }
        });

    }
}