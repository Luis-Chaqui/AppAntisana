package com.sainoxsa.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.sainoxsa.loginapp.controlador.PagerController;
import com.sainoxsa.loginapp.lugares.AntisanaFragment;
import com.sainoxsa.loginapp.lugares.LagunasFragment;
import com.sainoxsa.loginapp.lugares.ObservatorioFragment;
import com.sainoxsa.loginapp.metodos.MyToollbar;

public class LugaresTuristicosActivity extends AppCompatActivity {


    BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        final Fragment antisana         = new AntisanaFragment();
        final Fragment lagunas          = new LagunasFragment();
        final Fragment observatorios    = new ObservatorioFragment();

        navigationView = findViewById(R.id.navigationLugares);

        MyToollbar.show(this,"Lugares Turisticos",true);

        //Funcion del bottomNavigationView

        if (savedInstanceState == null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contenedorVer, antisana).commit();

        }
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getSupportFragmentManager();

                if (item.getItemId() == R.id.antisanaVolcan) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.contenedorVer, antisana).commit();
                }
                else if (item.getItemId() == R.id.lagunas) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.contenedorVer, lagunas).commit();
                }
                else if (item.getItemId() == R.id.observar) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.contenedorVer, observatorios).commit();
                }
                return true;
            }

        });

    }
}

