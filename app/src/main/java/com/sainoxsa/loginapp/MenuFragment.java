package com.sainoxsa.loginapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MenuFragment extends Fragment {
    CardView button,button1,button2,btnSomos,actividad,restaurantes;

    public MenuFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inicializamos las IF
        View view= inflater.inflate(R.layout.fragment_menu, container, false);
        button          =view.findViewById(R.id.Lugares);
        button2         =view.findViewById(R.id.Alojamineto);
        button1         = view.findViewById(R.id.Biodiversidad);
        btnSomos        = view.findViewById(R.id.Somos);
        actividad       =view.findViewById(R.id.Actividades2);
        restaurantes    =view.findViewById(R.id.Restaurante);

        //Direccionamos a los botones

        actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent   = new Intent(getContext(), ActividadesPermitidasActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),HospedajesActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LugaresTuristicosActivity.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(),BiodiversidadActivity.class);
                startActivity(intent);
            }
        });

        btnSomos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(),SomosActivity.class);
                startActivity(intent);
            }
        });
        restaurantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),RestaurantActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
