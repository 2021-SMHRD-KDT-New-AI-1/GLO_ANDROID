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
    String[] weeks = {"평온한 하루 보내시길 바래요",
            "지치지 않고 잘 이겨내봅시다",
            "건강, 체력 관리 철저히 합시다",
            "함께 웃는 그 날이 오기를 바래요",
            "보고싶은 친구에게 연락 먼저 어떨까요?",
            "마스크로 답답하지만 마음만은 상쾌하게",
            "추운 겨울 감기 조심 합시다"};
    String id;
    SharedPreferences spf_user_info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main1_home, container, false);

        textView1 =view.findViewById(R.id.textView1);
        textView2 =view.findViewById(R.id.textView2);

        id = "Alfred";
        spf_user_info = getActivity().getSharedPreferences("user_info",0);
        id = spf_user_info.getString("id","user");
        int randomNum = (int)(Math.random() * weeks.length);

        textView1.setText("hello, "+ id + " 님!"); //  출력
        textView2.setText(weeks[randomNum]);


        return view;
    }
}