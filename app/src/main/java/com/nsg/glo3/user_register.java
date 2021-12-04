package com.nsg.glo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

public class user_register extends AppCompatActivity {

    EditText edt_id,edt_pw,edt_age;
    RadioGroup rg_gender,diagnosis;
    RadioButton rb_man,rb_woman,rb_yes,rb_no;
    AppCompatButton survey_btn;
    RequestQueue requestQueue;
    String url = "http://172.30.1.26:3002/signup_a";
    View radioButton,radioButton2;
    int gender,exp,user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_age = findViewById(R.id.edt_age);
        rg_gender = findViewById(R.id.rg_gender);
        diagnosis = findViewById(R.id.diagnosis);
        rb_man = findViewById(R.id.rb_man);
        rb_woman = findViewById(R.id.rb_woman);
        rb_yes = findViewById(R.id.rb_yes);
        rb_no = findViewById(R.id.rb_no);
        survey_btn = findViewById(R.id.survey_btn);
        user = 0;

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        survey_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_man.isChecked() == false & rb_woman.isChecked() == false & rb_yes.isChecked() == false & rb_no.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "빈 문항을 확인해주세요", Toast.LENGTH_SHORT).show();
                }else{
                    //RadioButton rd1 = findViewById(rg_gender.getCheckedRadioButtonId());
                    //RadioButton rd2 = findViewById(diagnosis.getCheckedRadioButtonId());
                    int radioButtonID = rg_gender.getCheckedRadioButtonId();
                    radioButton = rg_gender.findViewById(radioButtonID);
                    int idx = rg_gender.indexOfChild(radioButton);
                    gender = idx;
                    int radioButtonID2 = diagnosis.getCheckedRadioButtonId();
                    radioButton2 = diagnosis.findViewById(radioButtonID2);
                    int idx2 = diagnosis.indexOfChild(radioButton2);
                    exp = idx2;
                    Log.d("확인",String.valueOf(gender));
                    Log.d("확인",String.valueOf(exp));
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
                            params.put("age",edt_age.getText().toString());
                            params.put("gender",String.valueOf(gender));
                            params.put("exp",String.valueOf(exp));
                            params.put("user",String.valueOf(user));
                            //params.put("gender",rd1.getText().toString());
                            //params.put("diagnosis",rd2.getText().toString());

                            //Log.d("check",rd1.getText().toString());




                            return params;
                        }
                    };

                    requestQueue.add(stringRequest);
                }
                Intent intent = new Intent(user_register.this,Login.class);
                startActivity(intent);
            }
        });




    }
}