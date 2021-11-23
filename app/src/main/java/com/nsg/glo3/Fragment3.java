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

public class Fragment3 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_3, container, false);
        WebView wv = view.findViewById(R.id.webview3);


        SharedPreferences spf = getActivity().getSharedPreferences("url_spf", Context.MODE_PRIVATE);

        String url = spf.getString("url","https://www.youtube.com/results?search_query=%EC%9A%B0%EC%9A%B8%ED%95%A0%EB%95%8C+%EB%B3%B4%EB%8A%94+%EC%98%81%EC%83%81");
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true); // javascript 활성화
        wv.loadUrl(url);



        return view;
    }
}