package com.example.btcuoiky;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                
                if (item.getItemId() == R.id.monitor) {
                    fragment = new FeaturedFragment();
                } else if (item.getItemId() == R.id.page) {
                    fragment = new FeedFragment();
                } else if (item.getItemId() == R.id.profile) {
                    fragment = new SettingsFragment();
                }
                else if (item.getItemId() == R.id.user) {
                    fragment = new UserFragment();
                }


                    if (fragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout_first, fragment);
                    transaction.commit(); 
                    return true;
                }

                return false; 
            }
        });

        
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout_first, new FeaturedFragment());
            transaction.commit();
        }
    }
}
