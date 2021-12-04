package com.nsg.glo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;

public class LoadingActivity extends AppCompatActivity {

    ConstraintLayout v,CL;
    LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        // CL = findViewById(R.id.CL);
        // inflater = (LayoutInflater) getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        // v = (ConstraintLayout) inflater.inflate( R.layout.test, null);
        // setContentView(v);
        startLoading();
    }// onCreate()..

    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {





                Intent intent= new Intent(getApplicationContext(), Login.class);
                startActivity(intent);  //Loagin화면을 띄운다.
                finish();   //현재 액티비티 종료
            }
        }, 2000); // 화면에 Logo 2초간 보이기
    }// startLoading Method..
}// MainActivity Class..
