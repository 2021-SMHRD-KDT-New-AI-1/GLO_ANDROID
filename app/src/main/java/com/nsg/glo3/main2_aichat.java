package com.nsg.glo3;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class main2_aichat extends Fragment {
    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList dataList;
    String url;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main2_aichat, container, false);

         recyclerView = view.findViewById(R.id.rcChat);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.scrollToPosition(0);

        chatAdapter = new ChatAdapter(dataList);
        recyclerView.setAdapter(chatAdapter);
        url ="http://127.0.0.1:5000/query/TEST?query=";




        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataList = new ArrayList<ChatData>();
        initDataset();
    }

    private void initDataset() {
        dataList.add(new ChatData("","고성욱님 입장", 0));
        dataList.add(new ChatData("","GLO 님 입장", 0));
        dataList.add(new ChatData("고성욱","안녕", 2));
        dataList.add(new ChatData("GLO","안녕하세요~!", 1));
        dataList.add(new ChatData("GLO","저는 GLO에요!", 1));
        dataList.add(new ChatData("고성욱","오늘 기분이 우울해", 2));
        dataList.add(new ChatData("GLO","무슨일 있나요?", 1));
        dataList.add(new ChatData("고성욱","친구 때문에", 2));
        dataList.add(new ChatData("GLO","그렇군요", 1));
        dataList.add(new ChatData("GLO","친구와 무슨일이 있군요", 1));
        dataList.add(new ChatData("고성욱","학교에서 친구랑 싸웠어", 2));
        dataList.add(new ChatData("GLO","친구랑 싸우셔서 속상하시겠어요", 1));
        dataList.add(new ChatData("고성욱","응 맞아...", 2));





    }
}