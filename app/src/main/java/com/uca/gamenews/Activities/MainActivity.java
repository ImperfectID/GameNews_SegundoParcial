package com.uca.gamenews.Activities;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uca.gamenews.DB.GN_DB;
import com.uca.gamenews.Models.New_View_Model;
import com.uca.gamenews.R;

public class MainActivity extends AppCompatActivity {

    public New_View_Model new_view_model;
    public GN_DB gn_db;
    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gn_db = GN_DB.getDB(getApplicationContext());
        setContentView(R.layout.activity_main);









    }
}
