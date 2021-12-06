package com.nsg.glo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Content_RecyclerList extends AppCompatActivity {

    RequestQueue requestQueue;
    String url,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_recycler_list);
        String url =  "http://172.30.1.26:3002/recommend_m_a";
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        Intent intent = getIntent();
        String name= intent.getStringExtra("name");
        ListAdapter adapter = new ListAdapter();
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray list = new JSONArray(response);

                            for (int i = 0; i < list.length(); i++) {

                                JSONObject data1 = (JSONObject) list.get(i);

                                String title = data1.getString("title");
                                String content = data1.getString("url");
                                String category = data1.getString("category");
                                int score = data1.getInt("score");
                                adapter.addItem(new recomand(content,title,category,score));
                                Log.d("asd", title);


                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        recyclerView.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(request);

    }
}