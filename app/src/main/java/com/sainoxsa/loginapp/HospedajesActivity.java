package com.sainoxsa.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.sainoxsa.loginapp.alojamiento.HosteriaGuaytara;
import com.sainoxsa.loginapp.alojamiento.HosteriaJose;
import com.sainoxsa.loginapp.controlador.PagerController;
import com.sainoxsa.loginapp.metodos.MyToollbar;

public class HospedajesActivity extends AppCompatActivity {
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);
        navigationView = findViewById(R.id.navigation_bar3);

        MyToollbar.show(this,"Hospedaje",true);

        final Fragment guaytara         = new HosteriaGuaytara();
        final Fragment jose             = new HosteriaJose();

        //SELECCION DE CADA ITEM PARA DIRIGIRME A CADA FRAGMENTS

        if (savedInstanceState == null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contenedor2, jose).commit();

        }

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (item.getItemId() == R.id.joseMaria) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.contenedor2, jose).commit();
                }
                else if (item.getItemId() == R.id.guaytaraHodteria) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.contenedor2, guaytara).commit();
                }
                return true;
            }

        });
    }
}
