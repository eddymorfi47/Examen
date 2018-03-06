package com.eddiemartnez.app.dep_recursos_humanos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.eddiemartnez.app.dep_recursos_humanos.R;

public class sel2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sel2);
    }

    public void ges (View view) {
        Intent i = new Intent(sel2.this , gestionar_empleados.class);
        startActivity(i);
    }
}
