package com.nsg.glo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class main4_media extends Fragment {


    CardView cardview6, cardview7, cardview8, cardview9, cardview10;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.main4_media, container, false);
       // WebView wv = view.findViewById(R.id.webview3);


       // SharedPreferences spf = getActivity().getSharedPreferences("url_spf", Context.MODE_PRIVATE);

       // String url = spf.getString("url","https://www.youtube.com/results?search_query=%EC%9A%B0%EC%9A%B8%ED%95%A0%EB%95%8C+%EB%B3%B4%EB%8A%94+%EC%98%81%EC%83%81");
       // wv.setWebViewClient(new WebViewClient());
       // wv.getSettings().setJavaScriptEnabled(true);
       // wv.loadUrl(url);



        cardview6 = view.findViewById(R.id.cardview6);

        cardview7 = view.findViewById(R.id.cardview7);
        cardview8 = view.findViewById(R.id.cardview8);
        cardview9 = view.findViewById(R.id.cardview9);
        cardview10 = view.findViewById(R.id.cardview10);


        List<String> data = new ArrayList<String>();

        cardview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Content_RecyclerList.class);
                intent.putExtra("name", "동기부여");
                intent.putExtra("media", "video");
                startActivity(intent);
            }
        });


        cardview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Content_RecyclerList.class);
                intent.putExtra("name", "동물");
                intent.putExtra("media", "video");
                startActivity(intent);
            }
        });

        cardview8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Content_RecyclerList.class);
                intent.putExtra("name", "밈");
                intent.putExtra("media", "video");
                startActivity(intent);
            }
        });

        cardview9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Content_RecyclerList.class);
                intent.putExtra("name", "웃긴 영상");
                intent.putExtra("media", "video");
                startActivity(intent);
            }
        });

        cardview10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Content_RecyclerList.class);
                intent.putExtra("name", "전문가");
                intent.putExtra("media", "video");
                startActivity(intent);
            }
        });



        return view;
    }
}