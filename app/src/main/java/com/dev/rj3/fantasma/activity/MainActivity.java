package com.dev.rj3.fantasma.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;

import com.dev.rj3.fantasma.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        setUpNavigation();

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

    }


    public void setUpNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.navBar);
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNav,navController);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.toolbar_menu, menu);


        return true;
    }
}