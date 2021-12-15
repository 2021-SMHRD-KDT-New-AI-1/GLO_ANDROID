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
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
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
    RequestQueue requestQueue;
    String url;
    int score;
    String reqDate;
    String id;
    SharedPreferences spf_user_info, pref1;
    SharedPreferences.Editor editor_user_info;
    ArrayList<Entry> values = new ArrayList<>();
    private static final String TAG = "profile";
    static ArrayList<String> datelist = new ArrayList<>();
    static class LineChartXAxisValueFormatter extends IndexAxisValueFormatter {

        @Override
        public String getFormattedValue(float value) {

            // Convert float value to date string
            // Convert from days back to milliseconds to format time  to show to the user
            /*long emissionsMilliSince1970Time = TimeUnit.DAYS.toMillis((long)value);
            // Show time in local version
            Date timeMilliseconds = new Date(emissionsMilliSince1970Time);
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd");*/
            Log.d("qq", "getFormattedValue: "+value);
            String d="";
            if(value<0){
                d = datelist.get(0);
            }else if( value>=datelist.size()) {
                d = datelist.get(datelist.size()-1);
            }else{
                d = datelist.get((int) value);
            }
            return d.substring(5,10);
        }
    }

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

                            for (int i = 0; i < object.length(); i++) {
                                JSONObject data1 = (JSONObject) object.get(i);

                                score = data1.getInt("score");
                                reqDate = data1.getString("reqDate");
                                datelist.add(reqDate);

                                Log.d("score", String.valueOf(score));
                                Log.d("reqDate", reqDate);
                                values.add(new Entry(i,score));
                                Log.d("dd",String.valueOf(values));

                            }
                            // values.add(new Entry(Integer.parseInt(reqDate.substring(8,10)), score));
                            LineDataSet set1;
                            set1 = new LineDataSet(values, "DataSet 1");
//
                            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                            dataSets.add(set1); // add the data sets
//
//                // create a data object with the data sets
                            LineData data = new LineData(dataSets);
//
//                // black lines and points

                            set1.setLineWidth(3);
                            set1.setColor(Color.parseColor("#19A2A3"));
                            set1.setDrawCircles(true);
                            set1.setDrawCircleHole(true);

                            set1.setCircleColor(Color.parseColor("#004648"));
                            set1.setCircleHoleColor(Color.parseColor("#004648"));
                            set1.setCircleSize(5f);

                            chart.animateXY(2000,2000);
//
//                // set data
                            chart.setTouchEnabled(false);
                            chart.setData(data);
                            Log.d(TAG, "onResponse: "+data.getEntryCount());
                            XAxis xAxis = chart.getXAxis();
                            Legend legend = chart.getLegend();
                            legend.setEnabled(false);
                            Description description = chart.getDescription();
                            description.setEnabled(false);




                            xAxis.setValueFormatter(new LineChartXAxisValueFormatter());
                            xAxis.setLabelCount(data.getEntryCount(), true);
                            if(data.getEntryCount()==1){
                                xAxis.setCenterAxisLabels(true);
                            }
                            //xAxis.setLabelRotationAngle(-45);
                            chart.invalidate();






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
        stringRequest.setTag(TAG);
        Log.d("zz",String.valueOf(values));
        requestQueue.add(stringRequest);

        // for (int i = 0; i < 1; i++) {

        //     float val = (float) (Math.random() * 10);
        //     values.add(new Entry(i, val));
        //x 축 i, y 축 val
        // }

        return view;

    }

    @Override
    public void onStop() {
        super.onStop();
        if (requestQueue != null) {
            requestQueue.cancelAll(TAG);
        }
    }
}
