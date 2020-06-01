package com.sainoxsa.loginapp;

import android.icu.text.CaseMap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapaFragment extends Fragment implements OnMapReadyCallback {

   GoogleMap map;
   MapView mapView;
   View view;


    public MapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_galeria, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //INICIALIZAMOS LAS ID
        mapView=view.findViewById(R.id.mapView);
        if (mapView !=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        map=googleMap;

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        //OPCION DE LOCALIZAR PUNTO Y ASIGNAR UN MARCADOR

        googleMap.addMarker(new MarkerOptions().position(new LatLng(-0.551594, -78.156446)).title("Reserva Ecologica Antisana").snippet("Reserva Antisana"));

        //OPCION DE COLOCAR LA DISTANCIA DEL MAPA
        CameraPosition Antisana= CameraPosition.builder().target(new LatLng(-0.551594, -78.156446)).zoom(10).bearing(0).tilt(35).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Antisana));

        googleMap.addMarker(new MarkerOptions().position(new LatLng(-0.456145, -78.331912)).title("Hosteria Jose Maria").snippet("Alojamiento"));

        googleMap.addMarker(new MarkerOptions().position(new LatLng(-0.460790, -78.309678)).title("Hosteria Guaytara").snippet("Alojamiento"));

        googleMap.addMarker(new MarkerOptions().position(new LatLng(-0.542003, -78.210515)).title("Laguna Mica").snippet("Atractivo"));

        googleMap.addMarker(new MarkerOptions().position(new LatLng(-0.419593, -78.268698)).title("Laguna de Muertepungo").snippet("Atractivo"));

        googleMap.addMarker(new MarkerOptions().position(new LatLng(-0.447283, -78.328205)).title("Laguna de Secas").snippet("Atractivo"));

        googleMap.addMarker(new MarkerOptions().position(new LatLng(-0.453806, -78.318205)).title("Peñon del Isco").snippet("Atractivo"));

        googleMap.addMarker(new MarkerOptions().position(new LatLng(-0.447551, -78.336788)).title("Laguna Tipopugro").snippet("Atractivo"));





    }


}
