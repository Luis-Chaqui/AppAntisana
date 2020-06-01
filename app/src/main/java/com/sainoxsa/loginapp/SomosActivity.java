package com.sainoxsa.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sainoxsa.loginapp.metodos.MyToollbar;

public class SomosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somos);

        MyToollbar.show(this,"Quienes Somos ",true);
    }
}
