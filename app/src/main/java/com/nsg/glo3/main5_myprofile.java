package com.nsg.glo3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main5_myprofile extends Fragment {
    private LineChart chart;
    Button survey_btn;
    ArrayList sum2;
    RequestQueue requestQueue;
    String url;
    int score;
    String reqDate;
    String id;
    String arr[];
    SharedPreferences spf_user_info, pref1;
    SharedPreferences.Editor editor_user_info;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main5_myprofile, container, false);
        chart = view.findViewById(R.id.linechart);
        survey_btn = view.findViewById(R.id.survey_btn);
        spf_user_info = this.getActivity().getSharedPreferences("user_info",0);
        id = spf_user_info.getString("id","2");
        Log.d("checkid",id);
        pref1 = this.getActivity().getSharedPreferences("isFirst", survey.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref1.edit();

        url =  "http://172.30.1.26:3002/score_a2";

        ArrayList<Entry> values = new ArrayList<>();

        survey_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                editor.putBoolean("isFirst", true);
//                editor.commit();
//                Intent intent = new Intent(view.getContext(), survey.class);
//                startActivity(intent);
                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
                }

                Log.d("score", String.valueOf(score));
                final StringRequest stringRequest = new StringRequest(
                        Request.Method.POST,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                String result = "";

                                try {
                                    JSONArray object = new JSONArray(response);
                                    Log.d("asdf", String.valueOf(response));
                                    // for (int i = 0; i < 7; i++) {
                                    //    arr[i] = object.getString("score");
                                    // }
                                    // Log.d("score2",arr[0]);
                                    //score = object.getString("score");

                                    for (int i = 0; i < object.length(); i++) {
                                        JSONObject data1 = (JSONObject) object.get(i);

                                        score = data1.getInt("score");
                                        reqDate = data1.getString("reqDate");


                                        Log.d("score", String.valueOf(score));
                                        Log.d("reqDate", reqDate);
                                    }
                                    values.add(new Entry(Integer.parseInt(reqDate.substring(8,10)), score));
                                    LineDataSet set1;
                                    set1 = new LineDataSet(values, "DataSet 1");

                                    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                                    dataSets.add(set1); // add the data sets

                                    // create a data object with the data sets
                                    LineData data = new LineData(dataSets);

                                    // black lines and points
                                    set1.setColor(Color.BLACK);
                                    set1.setCircleColor(Color.BLACK);

                                    // set data
                                    chart.setData(data);

//                            spf_user_info = getSharedPreferences("user_info", Context.MODE_PRIVATE);
//                            editor_user_info = spf_user_info.edit();
//                            editor_user_info.putString("id", id);
//                            editor_user_info.putString("pw", pw);



                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("asd", String.valueOf(error));

                            }
                        }
                ) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();

                        params.put("id",id);

                        Log.d("check",id);


                        return params;
                    }
                };
                requestQueue.add(stringRequest);
                //ArrayList<Entry> values = new ArrayList<>();




                for (int i = 0; i < 1; i++) {

                    float val = (float) (Math.random() * 10);
                    //values.add(new Entry(i, val));
                    //x 축 i, y 축 val


                }
                //values.add(new Entry(1, Integer.parseInt(score)));
                //values.add(new Entry(1,Integer.parseInt(arr[0])));
                //values.add(new Entry(1,score));
                //Toast.makeText(getContext(), "dd", Toast.LENGTH_SHORT).show();

//                LineDataSet set1;
//                set1 = new LineDataSet(values, "DataSet 1");
//
//                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
//                dataSets.add(set1); // add the data sets
//
//                // create a data object with the data sets
//                LineData data = new LineData(dataSets);
//
//                // black lines and points
//                set1.setColor(Color.BLACK);
//                set1.setCircleColor(Color.BLACK);
//
//                // set data
//                chart.setData(data);

            }
        });

        return view;

    }

}