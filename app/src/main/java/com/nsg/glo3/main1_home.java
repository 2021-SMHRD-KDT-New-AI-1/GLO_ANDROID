package com.nsg.glo3;

import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class main1_home extends Fragment implements  adapterphone.ListItemClickListener {


    RecyclerView phoneRecycler;
    RecyclerView.Adapter adapter;
    TextView textView1,textView2;
    String[] weeks = {"당신은 멋진 사람입니다",
            "지치지 않고 잘 이겨내봅시다",
            "건강, 체력 관리 철저히 합시다",
            "함께 웃는 그 날이 오기를 바래요",
            "보고싶은 친구에게 연락 먼저 어떨까요?",
            "마스크로 답답하지만 마음만은 상쾌하게",
            "당신은 도움을 받을 자격이 있습니다"};
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

        textView1.setText("hello, "+ id + " 님"); //  출력
        textView2.setText(weeks[randomNum]);

        phoneRecycler = view.findViewById(R.id.my_recycler);
        phoneRecycler();
        return view;
    }
    private void phoneRecycler() {

        //All Gradients
        GradientDrawable gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFFFFFFF, 0xFFFFFFFF});
        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFFFFFFF, 0xFFFFFFFF});
        GradientDrawable gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFFFFFFF, 0xFFFFFFFF});
        GradientDrawable gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFFFFFFF, 0xFFFFFFFF});


        phoneRecycler.setHasFixedSize(true);
        phoneRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<phonehelper> phonelocations = new ArrayList<>();
        phonelocations.add(new phonehelper(gradient1, R.drawable.leehi1, "이하이 - 한숨"));
        phonelocations.add(new phonehelper(gradient4, R.drawable.ui1, "IU - 이름에게"));
        phonelocations.add(new phonehelper(gradient2, R.drawable.parkwon1, "박원 - 나"));
        phonelocations.add(new phonehelper(gradient4, R.drawable.sondia1, "sondia - 어른"));
        phonelocations.add(new phonehelper(gradient2, R.drawable.interstella1, "인터스텔라 - First Step"));


        adapter = new adapterphone(phonelocations,this);
        phoneRecycler.setAdapter(adapter);

    }
    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }
}