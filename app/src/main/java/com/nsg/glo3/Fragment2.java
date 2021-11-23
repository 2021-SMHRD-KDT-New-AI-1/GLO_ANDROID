package com.nsg.glo3;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;



public class Fragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_2, container, false);
        WebView wv = view.findViewById(R.id.webview2);


        SharedPreferences spf = getActivity().getSharedPreferences("url_spf", Context.MODE_PRIVATE);

        String url = spf.getString("url","https://www.youtube.com/results?search_query=%EC%9A%B0%EC%9A%B8%ED%95%A0%EB%95%8C+%EB%93%A3%EB%8A%94+%EB%85%B8%EB%9E%98");
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true); // javascript 활성화
        wv.loadUrl(url);



        return view;
    }
}