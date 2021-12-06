package com.nsg.glo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.ProgressBar;

public class LoadingActivity extends AppCompatActivity {

    ConstraintLayout v,CL;
    LayoutInflater inflater;
    ProgressBar progressBar;
    Handler handler = new Handler();
    int value = 0;
    int add = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        progressBar = findViewById(R.id.progressBar);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    value = value + add;
                    if(value>=100){
                        Intent intent= new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);  //Loagin화면을 띄운다.
                        break;
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(value);
                        }
                    });
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }// onCreate()..

}// MainActivity Class..
