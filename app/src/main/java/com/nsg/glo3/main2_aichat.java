package com.nsg.glo3;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class main2_aichat extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main2_aichat, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rcChat);

        ArrayList<ChatData> list = new ArrayList<>();

        list.add(new ChatData("고성욱","리싸이클러뷰 너무 어렵", 0));
        list.add(new ChatData("이진화","저도 봐주세요", 1));


        ChatAdapter adapter = new ChatAdapter(list);

        recyclerView.setAdapter(adapter);


        return view;
    }
}