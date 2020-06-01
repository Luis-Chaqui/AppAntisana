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
import com.google.firebase.auth.FirebaseUser;
import com.sainoxsa.loginapp.MainActivity;
import com.sainoxsa.loginapp.R;
import com.sainoxsa.loginapp.actividades.RegistroActivity;
import com.sainoxsa.loginapp.metodos.MyToollbar;

import dmax.dialog.SpotsDialog;


public class LoginActivity extends AppCompatActivity {

    private TextInputEditText edEmail, edPass;
    private Button loginBtn;
    private TextView sinconexion;
    private Button tvRegistrate;

    AlertDialog mDialog;

    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MyToollbar.show(this,"Ingreso del Usuario", false);

        mDialog = new SpotsDialog.Builder().setContext(LoginActivity.this).setMessage("Espere un momento").build();

        //OBTENER LA REFERNCIA DE LOS CONTROLES
        edEmail = findViewById(R.id.email);
        edPass = findViewById(R.id.pass);
        sinconexion = findViewById(R.id.conexion);

        loginBtn = findViewById(R.id.loginBtn);


        tvRegistrate = findViewById(R.id.tvegistrate);

        //OBTENER INSTANCIA DE AUTENTIFICACIÓN DE FIREBASE
        mAuth = FirebaseAuth.getInstance();

        //VALIDAR SIN CONTRASEÑA




        //CLICK DEL BOTON(TEXTVIEW) PARA REGISTRAR E IR A LA ACTIVIDAD DE REGISTRO
        tvRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));

            }
        });


        //VALIDAR AL USUARIO
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edEmail.getText().toString();
                String password = edPass.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()){
                    if (password.length()>=6){
                        mDialog.show();
                        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(getApplicationContext(), "Tenemos un problema", Toast.LENGTH_SHORT).show();
                                }
                                mDialog.dismiss();
                            }
                        });

                    }else {
                        Toast.makeText(LoginActivity.this,"La contraseña debe contener mas de 6 caracteres",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(LoginActivity.this,"Coloque los datos en todos los campos",Toast.LENGTH_LONG).show();
                }
            }
        });


        //Ingreso sin necesidad de tener conexion a Internet
        sinconexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Usted a ingresado sin Internet",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);

                startActivity(intent);
            }
        });
    }



}