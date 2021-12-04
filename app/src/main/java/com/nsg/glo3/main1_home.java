package com.nsg.glo3;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class main1_home extends Fragment {

    TextView textView1,textView2;
    String[] weeks = {"월","화","수","목","금","토","일"};
    String id;
    SharedPreferences spf_user_info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main1_home, container, false);

        textView1 =view.findViewById(R.id.textView1);
        textView2 =view.findViewById(R.id.textView2);

        id = "sg";
        spf_user_info = getActivity().getSharedPreferences("user_info",0);
        id = spf_user_info.getString("id","2");
        int randomNum = (int)(Math.random() * weeks.length);

        textView1.setText("hi! "+ id + " 님"); //  출력
        textView2.setText(weeks[randomNum]);


        return view;
    }
}