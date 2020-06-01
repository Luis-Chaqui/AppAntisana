package com.sainoxsa.loginapp;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.sainoxsa.loginapp.metodos.MyToollbar;

public class ActividadesPermitidasActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);


        MyToollbar.show(this,"Actividades Permitidas",true);


    }
}
