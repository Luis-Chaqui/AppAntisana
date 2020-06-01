package com.sainoxsa.loginapp.lugares;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.sainoxsa.loginapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LagunasFragment extends Fragment {

    public LagunasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_lagunas, container, false);

        return view;
    }
}
