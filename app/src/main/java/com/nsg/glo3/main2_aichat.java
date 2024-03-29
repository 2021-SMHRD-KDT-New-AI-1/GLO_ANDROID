package com.nsg.glo3;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class main2_aichat extends Fragment {
    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList dataList;
    String url;
    AppCompatButton btn_send;
    EditText edit_send;
    RequestQueue requestQueue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataList = new ArrayList<ChatData>();
        View view = inflater.inflate(R.layout.main2_aichat, container, false);
        btn_send = view.findViewById(R.id.btn_send);
        recyclerView = view.findViewById(R.id.rcChat);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.scrollToPosition(0);
        // asdfggh
        edit_send = view.findViewById(R.id.edit_send);
        chatAdapter = new ChatAdapter(dataList);

        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        }


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList.add(new ChatData("사용자",String.valueOf(edit_send.getText()), 2));

                initDataset();
                edit_send.setText("");

                recyclerView.setAdapter(chatAdapter);


            }
        });




        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initDataset() {
        Log.d("ass","ddsd");
        url ="http://10.0.2.2:5000/query/TEST?query=";
        url += String.valueOf(edit_send.getText());

       final StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dataList.add(new ChatData("GLO",String.valueOf(response), 1));
                        Log.d("ass",String.valueOf(response));
                        //임시추가
                        chatAdapter = new ChatAdapter(dataList);
                        recyclerView.setAdapter(chatAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ass", String.valueOf(error));
                    }
                }
        );
        requestQueue.add(stringRequest);


    }
}