package com.example.labpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


//import android.support.design.widget.BottomNavigationView;
//import android.support.v4.app.Fragment;
//import android.support.v7.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class homemenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawwer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homemenu);
        // getSupportActionBar().hide();
        Toolbar toolbar = findViewById(R.id.toolbar);
        getSupportActionBar();
  toolbar.setLogo(R.drawable.logofied); //setting the logo on tollbar
        drawwer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawwer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawwer.addDrawerListener(toggle);
        toggle.syncState();


     /* Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);**/

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }

    public void OnBackPressed() {
        if (drawwer.isDrawerOpen(GravityCompat.START)) {
            drawwer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
        super.onBackPressed();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_notification:
                            selectedFragment = new NotificationsFragment();
                            break;
                        case R.id.nav_reports:
                            selectedFragment = new ReportsFragment();
                            break;
                        case R.id.nav_samples:
                            selectedFragment = new SamlpesFragment();
                            break;
                        case R.id.nav_addplus:
                            selectedFragment = new AddFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.logout:
                Intent gtfp = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(gtfp);
                break;
            case R.id.find_shipping:
                Toast.makeText(getApplicationContext(), "Not implemeneted", Toast.LENGTH_SHORT);
                break;

        }
        return true;
    }
}

