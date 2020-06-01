package com.sainoxsa.loginapp.actividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sainoxsa.loginapp.MainActivity;
import com.sainoxsa.loginapp.R;
import com.sainoxsa.loginapp.metodos.MyToollbar;
import com.sainoxsa.loginapp.metodos.Usuario;
import com.sainoxsa.loginapp.providers.AuthProvider;
import com.sainoxsa.loginapp.providers.UsuarioProvider;

import java.util.HashMap;
import java.util.Map;

import dmax.dialog.SpotsDialog;

public class RegistroActivity extends AppCompatActivity {
    TextInputEditText tvNombre, tvEmail, tvPassword, tvDireccion;
    Button btnRegistrar;
    TextView volver;

    AlertDialog mDialog;


    //PARA LLAMAR A NUESTRA BASE DE DATOS DE FIREBASE, Y ASU VEZ LA AUTENTIFICACIÓN
    FirebaseAuth mAuth;
    DatabaseReference mReference;

    AuthProvider authProvider;
    UsuarioProvider mUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mDialog = new SpotsDialog.Builder().setContext(RegistroActivity.this).setMessage("Espere un momento").build();



        authProvider = new AuthProvider();
        mUsuario = new UsuarioProvider();

        MyToollbar.show(this,"Registro del Usuario", true);

            //Referenciamos los ID
        volver=findViewById(R.id.LoginNowTv);
        tvNombre=findViewById(R.id.tvNombre);
        tvEmail=findViewById(R.id.tvEmail);
        tvPassword=findViewById(R.id.tvPassword);
        tvDireccion = findViewById(R.id.tvDireccion);
        btnRegistrar=findViewById(R.id.btnRegistrar);

        //INSTANCIAMOS FIREBASE
        mAuth=FirebaseAuth.getInstance();
        mReference=FirebaseDatabase.getInstance().getReference();


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mNombre = tvNombre.getText().toString();
                String mDireccion = tvDireccion.getText().toString();
                String email = tvEmail.getText().toString();
                String password = tvPassword.getText().toString();

                if (!mNombre.isEmpty() && !mDireccion.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    if (password.length()>=6){
                        mDialog.show();
                        register(mNombre,mDireccion,email,password);
                    }else{
                        Toast.makeText(RegistroActivity.this,"La contraseña debe tener al menos 6 caracteres",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(RegistroActivity.this,"Coloque los datos en todos los campos",Toast.LENGTH_LONG).show();
                }
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void register(final String mNombre, final String mDireccion, final String email, final String password) {
        authProvider.register(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                mDialog.hide();
                if (task.isSuccessful()){
                    String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    Usuario usuario = new Usuario(mNombre,mDireccion,email,id);
                    create(usuario);
                }
                else {
                    Toast.makeText(RegistroActivity.this,"No se pudo crear el usuario",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void create(Usuario usuario) {
       mUsuario.create(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
           @Override
           public void onComplete(@NonNull Task<Void> task) {
               if (task.isSuccessful()){
                   Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                   startActivity(intent);
                   finish();
               }else{
                   Toast.makeText(RegistroActivity.this,"No se pudo crear el usuario",Toast.LENGTH_LONG).show();
               }

           }
       }) ;
    }

}
