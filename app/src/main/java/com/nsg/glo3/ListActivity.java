package com.nsg.glo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView mListView;
    // int [] images = {R.drawable.a , R.drawable.b , R.drawable.c};

    String [] names = {"Name-1" , "Name-2" , "Name-3" , "Name-4", "Name-5",
                       "Name-6", "Name-7", "Name-8", "Name-9", "Name-10"};

    String [] uris = {"https://www.naver.com","https://www.daum.net","https://www.nexon.com", "url-4"
                     , "url-5", "url-6", "url-7", "url-8", "url-9", "url-10"};


    RequestQueue requestQueue;
    String url;
    List<DataVo> data;
    private Object DataVo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mListView = findViewById(R.id.listview);

        MyAdapter adapter = new MyAdapter();
        mListView.setAdapter(adapter);
        DataVo = data;
        String url = "";

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
                                String content = data1.getString("content");
                                String word = data1.getString("word");
                                String mean = data1.getString("mean");

                                DataVo vo = new DataVo(title, word, content, mean);

                                data.add(vo);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
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
    class MyAdapter extends BaseAdapter{

//        @Override
//        public int getCount() {
//            return images.length;
//        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.card_listview,parent , false);
            TextView textView = convertView.findViewById(R.id.textView4);
            //ImageView imageView = convertView.findViewById(R.id.imageview);
            textView.setText(names[position]);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browerIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(uris[position]));
                    startActivity(browerIntent);
                }
            });
            //imageView.setImageResource(images[position]);
            return  convertView;
        }
    }
}