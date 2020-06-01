package com.sainoxsa.loginapp.providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sainoxsa.loginapp.metodos.Usuario;

import java.util.HashMap;
import java.util.Map;

public class UsuarioProvider {
    DatabaseReference mDatabase;

    public UsuarioProvider(){
        mDatabase = FirebaseDatabase.getInstance().getReference().child("usuario");

    }

    public Task<Void> create(Usuario usuario){
        Map<String, Object> map = new HashMap<>();
        map.put("nombre",usuario.getNombre());
        map.put("direccion",usuario.getDireccion());
        map.put("email",usuario.getCorreo());

        return mDatabase.child(usuario.getId()).setValue(usuario);
    }
}
