package com.eddiemartnez.app.dep_recursos_humanos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.eddiemartnez.app.dep_recursos_humanos.R;
import com.raizlabs.android.dbflow.config.FlowManager;

public class Login_Admin extends AppCompatActivity {
    private EditText user;
    private EditText pw;
    private int permiso = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login__admin);
        user = (EditText) findViewById(R.id.usadmin);
        pw = (EditText) findViewById(R.id.pwadmin);
        FlowManager.init(this);


    }

    //LOS EMPLEADOS PUEDEN INGRESAR CON CUALQUIER USUARIO MIENTRAS USEN LA CONTRASEÑA QUE LES BRINDA LA EMPRESA.   ((A001))  LOS MISMOS SOLO PUEDEN GESTIONAR LA BASE DE DATOS.
    //LOS ADMINISTRADORES ENTRAN CON EL USUARIO ((ADMIN)) Y LA CONTRASEÑA ((ADMIN123))   ESTE PUEDE AÑADIR EMPLEADOS E IGUAL GESTIONAR LA BASE DE DATOS.



    public void ingresar(View view) {

        if (pw.getText().toString().equals("A001")){

           Intent sele = new Intent(Login_Admin.this,sel2.class);
           startActivity(sele);

        }
        else{
           Toast.makeText (Login_Admin.this ,"Usuario o contraseña incorrecta.", Toast.LENGTH_LONG).show();
        }
    }

    public void ingresaradmin(View view) {
        if (user.getText().toString().equals("ADMIN") && pw.getText().toString().equals("ADMIN123")){

            Intent i = new Intent(Login_Admin.this,seleccion.class);
            startActivity(i);
        }
    }
}
