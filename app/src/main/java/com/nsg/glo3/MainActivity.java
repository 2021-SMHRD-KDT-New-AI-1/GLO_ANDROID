package com.nsg.glo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {



    TextView textView1,textView2;
    MeowBottomNavigation bottomNavigation;
    String[] weeks = {"월","화","수","목","금","토","일"};
    String id;
    SharedPreferences spf_user_info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 =findViewById(R.id.textView1);
        textView2 =findViewById(R.id.textView2);
        bottomNavigation = findViewById(R.id.nav_view);
        spf_user_info = getSharedPreferences("user_info",0);
        id = spf_user_info.getString("id","2");
        int randomNum = (int)(Math.random() * weeks.length);

        textView1.setText("hi! "+ id + " 님"); //  출력
        textView2.setText(weeks[randomNum]);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_chat_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_queue_music_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_live_tv_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_auto_graph_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_baseline_auto_graph_24));


        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                Fragment fragment = null;


                switch (item.getId()) {
                    case 1:
                        fragment = new main1_home();
                        break;
                    case 2:
                        fragment = new main2_aichat();
                        break;
                    case 3:
                        fragment = new main3_music();
                        break;
                    case 4:
                        fragment = new main4_media();
                        break;
                    case 5:
                        fragment = new main5_myprofile();
                        break;
                }

                loadFragment(fragment);

            }
        });

        bottomNavigation.setCount(1, "10");

        bottomNavigation.show(1, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),
                        "You Clicked" + item.getId(),
                        Toast.LENGTH_SHORT).show();
                
            }
        });

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),
                        "You Reselected" + item.getId(),
                        Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();


    }
    //123123
}