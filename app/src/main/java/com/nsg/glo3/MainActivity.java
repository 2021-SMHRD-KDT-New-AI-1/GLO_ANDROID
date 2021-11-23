package com.nsg.glo3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // BottomNavigationView 선택감지
    // -> view에 listener 설정되어 있어야 함
    // -> view를 find해야 listener 를 설정할 수 있음

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
                // 매개변수 item? -> 선택한 메뉴의 정보가 전달
                // 어떤 메뉴를 선택했는지 감지하려면 item의 id값으로 구분

                if (item.getItemId() == R.id.menu1) {
                    // 지금 선택한 메뉴의 id가 menu1 이라면
                    // Fragment 갈아끼우는 코드
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment1()).commit();
                }else if (item.getItemId() == R.id.menu2) {
                    // 지금 선택한 메뉴의 id가 menu2 이라면
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment2()).commit();
                }else if (item.getItemId() == R.id.menu3) {
                    // 지금 선택한 메뉴의 id가 menu3 이라면
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment3()).commit();
                }else if (item.getItemId() == R.id.menu4) {
                    // 지금 선택한 메뉴의 id가 menu4 이라면
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment4()).commit();
                }else if (item.getItemId() == R.id.menu5) {
                    // 지금 선택한 메뉴의 id가 menu5 이라면
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment5()).commit();
                }

                return true;
                // return true로 해야 Fragment 같이 아이콘 바뀜
            }
        });
    }
}