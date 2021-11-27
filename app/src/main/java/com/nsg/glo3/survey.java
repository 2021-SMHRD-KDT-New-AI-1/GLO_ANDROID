package com.nsg.glo3;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.Arrays;


public class survey extends AppCompatActivity {

    Button complete_btn;
    RadioGroup[] rg = new RadioGroup[20];
    RadioButton[] rb = new RadioButton[80];
    int[] score = new int[20];
    int sum1;
    View radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        complete_btn = findViewById(R.id.complete_btn);

        complete_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                for (int i = 0; i < rg.length; i++) {
                    String rgid = "rg_q" + (i+1);
                    rg[i] = findViewById(getResources().getIdentifier(rgid, "id",getPackageName()));
                }

                for (int i = 0; i < rb.length; i++) {
                    String rbid = "rb_q1_" + (i+1);
                    rb[i] = findViewById(getResources().getIdentifier(rbid, "id",getPackageName()));
                }

                for (int i = 0, j = 0; i < rb.length && j <rg.length; i=i+4, j++) {

                    if (rb[i].isChecked() == false & rb[i+1].isChecked() == false & rb[i+2].isChecked() == false & rb[i+3].isChecked() == false) {
                        Toast.makeText(getApplicationContext(), "빈 문항을 확인해주세요", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        int radioButtonID = rg[j].getCheckedRadioButtonId();
                        radioButton = rg[j].findViewById(radioButtonID);
                        int idx = rg[j].indexOfChild(radioButton);
                        score[j] = idx;
                        //  Toast.makeText(getApplicationContext(), String.valueOf(score[j]), Toast.LENGTH_SHORT).show();
                    }
                }
                if (rg[19].indexOfChild(radioButton) != -1){
                    sum1 = Arrays.stream(score).sum();
                    //Toast.makeText(getApplicationContext(), String.valueOf(sum1), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplication(),MainActivity.class);
                    intent.putExtra("score",sum1);
                    startActivity(intent);

                }


            }
        });
    }
}