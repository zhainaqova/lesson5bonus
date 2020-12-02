package com.example.lesson_bonus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public
class MainActivity extends AppCompatActivity {
    private
    BottomNavigationView bottomNavigationView;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        bottomNavigationView = findViewById (R.id.bottomNav );
        bottomNavigationView.setOnNavigationItemSelectedListener ( bottomNavMethod );
        getSupportFragmentManager ().beginTransaction ().replace ( R.id.container.new.HomeFragment() ).commit ();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod =
    new BottomNavigationView.OnNavigationItemSelectedListener () {
        @Override
        public
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment = null;
            switch (menuItem.getItemId()){
                case R.id.btn_android:
                fragment = new AndroidFragment ();
                break;

                case R.id.btn_home:
                    fragment = new HomeFragment ();
                    break;
                case R.id.btn_search:
                    fragment = new SearchFragment ();
                    break;
            }
            getSupportFragmentManager ().beginTransaction ().replace ( R.id.container,fragment ).commit ();
            return true;
        }
    };
}