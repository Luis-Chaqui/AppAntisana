package com.sainoxsa.loginapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sainoxsa.loginapp.actividades.RegistroActivity;


public class PromocionesFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Opcion que se tiene para la asignacion del boton registro para  dirigirse a la activity iniciar sesion

        View view= inflater.inflate(R.layout.fragment_promociones,container,false);
        return view;
          }

}
