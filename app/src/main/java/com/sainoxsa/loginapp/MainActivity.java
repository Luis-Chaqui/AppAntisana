package com.sainoxsa.loginapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.sainoxsa.loginapp.actividades.LoginActivity;
import com.sainoxsa.loginapp.metodos.MyToollbar;
import com.sainoxsa.loginapp.providers.AuthProvider;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    FirebaseAuth mAuth;
    private AuthProvider mAuthProvider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.bottomNavigationView);

        mAuthProvider = new AuthProvider();

        MyToollbar.show(this,"Reserva Ecologica Antisana",false);

        final Fragment inicio       = new MenuFragment();
        final Fragment promociones  = new PromocionesFragment();
        final Fragment mapa         = new MapaFragment();

        if (savedInstanceState == null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contenedor, inicio).commit();

        }
      navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              FragmentManager fragmentManager = getSupportFragmentManager();

              if (item.getItemId() == R.id.inicio) {
                  FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                  fragmentTransaction.replace(R.id.contenedor, inicio).commit();
              }
              else if (item.getItemId() == R.id.oferta) {
                  FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                  fragmentTransaction.replace(R.id.contenedor, promociones).commit();
              }
              else if (item.getItemId() == R.id.galeria) {
                  FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                  fragmentTransaction.replace(R.id.contenedor, mapa).commit();
              }
              return true;
          }

      });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.salir) {
            logout();

        }
                return super.onOptionsItemSelected(item);


    }
    void logout() {
        //Cerrar la Sesion
        mAuthProvider.logout();
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);

        finish();

    }

}


