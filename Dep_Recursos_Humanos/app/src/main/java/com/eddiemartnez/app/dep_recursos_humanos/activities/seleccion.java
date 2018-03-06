package com.eddiemartnez.app.dep_recursos_humanos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eddiemartnez.app.dep_recursos_humanos.R;
import com.raizlabs.android.dbflow.config.FlowManager;

public class seleccion extends AppCompatActivity {
    public Button anadiranadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion);
        FlowManager.init(this);
        anadiranadir = findViewById(R.id.btnselecanadir);

    }




    public void gesem(View view) {
        Intent i = new Intent(seleccion.this,gestionar_empleados.class);
        startActivity(i);
    }

    public void anaem(View view) {
        Intent i = new Intent(seleccion.this,anadir_empleados.class);
        startActivity(i);
    }
}
