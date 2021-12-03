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


public class main3_music extends Fragment {

    CardView cardview1, cardview2, cardview3, cardview4, cardview5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.main3_music, container, false);

        cardview1 = view.findViewById(R.id.cardview1);

        cardview2 = view.findViewById(R.id.cardview2);
        cardview3 = view.findViewById(R.id.cardview3);
        cardview4 = view.findViewById(R.id.cardview4);
        cardview5 = view.findViewById(R.id.cardview5);


        List<String> data = new ArrayList<String>();

        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ListActivity.class);
                startActivity(intent);
            }
        });


        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ListActivity.class);
                startActivity(intent);
            }
        });

        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ListActivity.class);
                startActivity(intent);
            }
        });

        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ListActivity.class);
                startActivity(intent);
            }
        });

        cardview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ListActivity.class);
                startActivity(intent);
            }
        });





        return view;
    }
}