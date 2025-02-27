package com.sunbeam.day81.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.sunbeam.day81.HomeFragments.Assignment_Fragment;
import com.sunbeam.day81.HomeFragments.Attendance_Fragment;
import com.sunbeam.day81.HomeFragments.CourseReg_Fragment;
import com.sunbeam.day81.HomeFragments.EditPerson_Fragment;
import com.sunbeam.day81.HomeFragments.EventNotification_Fragment;
import com.sunbeam.day81.HomeFragments.FeeRecipt_Fragment;
import com.sunbeam.day81.HomeFragments.Fee_Fragment;
import com.sunbeam.day81.HomeFragments.Home_Fragment;
import com.sunbeam.day81.R;
import com.sunbeam.day81.HomeFragments.StudyMaterial_Fragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
                break;
            case R.id.StudyMaterial:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StudyMaterial_Fragment()).commit();
               break;
            case R.id.EventNotification:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EventNotification_Fragment()).commit();
                break;
            case R.id.CheckAtten:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Attendance_Fragment()).commit();
                break;
            case R.id.CourseRegistration:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CourseReg_Fragment()).commit();
                break;
            case R.id.FeePayment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fee_Fragment()).commit();
                break;
            case R.id.Assignment_sub:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Assignment_Fragment()).commit();
                break;
            case R.id.EditPerson:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EditPerson_Fragment()).commit();
                break;
            case R.id.DownloadFee:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeeRecipt_Fragment()).commit();
                break;
            case R.id.LogOut:
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}