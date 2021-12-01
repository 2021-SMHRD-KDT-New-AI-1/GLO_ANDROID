package com.nsg.glo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {



    BottomNavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_view = findViewById(R.id.nav_view);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        nav_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {


                if (item.getItemId() == R.id.menu1) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new main2_aichat()).commit();
                }else if (item.getItemId() == R.id.menu2) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new main3_music()).commit();
                }else if (item.getItemId() == R.id.menu3) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new main4_media()).commit();
                }else if (item.getItemId() == R.id.menu4) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new main5_myprofile()).commit();
                }

                return true;

            }
        });
    }
    //123123
}