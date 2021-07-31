package com.example.digiq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity5 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragement()).commit();
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                Fragment selected = null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        selected = new HomeFragement();
                        break;
                    case R.id.nav_profile:
                        selected = new ProfileFragment();
                        break;
                    case R.id.nav_stats:
                        selected = new StatsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selected).commit();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}