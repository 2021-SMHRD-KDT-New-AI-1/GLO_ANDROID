package com.nsg.glo3;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class survey extends AppCompatActivity {

    Button complete_btn;
    RadioGroup[] rg = new RadioGroup[20];
    RadioButton[] rb = new RadioButton[80];
    int[] score = new int[20];
    int sum1;
    View radioButton;
    RequestQueue requestQueue;
    String url = "http://172.30.1.26:3002/score_a";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        complete_btn = findViewById(R.id.complete_btn);

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Log.d("id",id);
        complete_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                for (int i = 0; i < rg.length; i++) {
                    String rgid = "rg_q" + (i+1);
                    rg[i] = findViewById(getResources().getIdentifier(rgid, "id",getPackageName()));
                }

                for (int i = 0; i < rb.length; i++) {
                    String rbid = "rb_q1_" + (i+1);
                    rb[i] = findViewById(getResources().getIdentifier(rbid, "id",getPackageName()));
                }

                for (int i = 0, j = 0; i < rb.length && j <rg.length; i=i+4, j++) {

                    if (rb[i].isChecked() == false & rb[i+1].isChecked() == false & rb[i+2].isChecked() == false & rb[i+3].isChecked() == false) {
                        Toast.makeText(getApplicationContext(), "빈 문항을 확인해주세요", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        int radioButtonID = rg[j].getCheckedRadioButtonId();
                        radioButton = rg[j].findViewById(radioButtonID);
                        int idx = rg[j].indexOfChild(radioButton);
                        score[j] = idx;
                        //  Toast.makeText(getApplicationContext(), String.valueOf(score[j]), Toast.LENGTH_SHORT).show();
                    }
                }
                if (rg[19].indexOfChild(radioButton) != -1){
                    //sum1 = Arrays.stream(score).sum();
                    ArrayList sum_score = new ArrayList();
                    sum_score.add(Arrays.stream(score).sum());
                    Toast.makeText(getApplicationContext(), String.valueOf(sum_score), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), String.valueOf(sum1), Toast.LENGTH_SHORT).show();

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
                            params.put("score", String.valueOf(sum_score.get(0)));
                            params.put("id",id);
                            // params.put("score", String.valueOf(1));
                            Log.d("check",id);
                            Log.d("check",String.valueOf(sum_score.get(0)));



                            return params;
                        }
                    };

                    requestQueue.add(stringRequest);


                    main5_myprofile main5_myprofile = new main5_myprofile();
                    Bundle bundle = new Bundle(); // 파라미터의 숫자는 전달하려는 값의 갯수
                    bundle.putString("id", id);
                    bundle.putString("score", String.valueOf(sum_score.get(0)));

                    main5_myprofile.setArguments(bundle);
                    Log.d("bundle",bundle.getString("id"));
                    //Log.d("check",String.valueOf(main5.getArguments()));
                    Intent intent = new Intent(getApplication(),MainActivity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);

                }



            }
        });
    }
}