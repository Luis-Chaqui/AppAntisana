package com.sainoxsa.loginapp.lugares;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sainoxsa.loginapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BiodiversidadFragment extends Fragment {

    public BiodiversidadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biodiversidad, container, false);
    }
}
