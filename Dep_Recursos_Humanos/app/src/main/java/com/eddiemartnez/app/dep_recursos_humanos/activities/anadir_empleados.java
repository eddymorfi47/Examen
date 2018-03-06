package com.eddiemartnez.app.dep_recursos_humanos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eddiemartnez.app.dep_recursos_humanos.R;
import com.eddiemartnez.app.dep_recursos_humanos.db.ToDoTable;
import com.raizlabs.android.dbflow.config.FlowManager;

public class anadir_empleados extends AppCompatActivity {

    private EditText txtNombreEmpleado;
    private EditText txtDocIdentidad;
    private EditText txtCodEmpleado;
    private EditText txtDepartamento;
    private EditText txtNumTel;
    //private Button btnanadir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anadir_empleados);
        FlowManager.init(this);
        txtNombreEmpleado = findViewById(R.id.nombreempleado);
        txtDocIdentidad = findViewById(R.id.docidentidad);
        txtCodEmpleado = findViewById(R.id.codempleado);
        txtDepartamento = findViewById(R.id.departamento);
        txtNumTel = findViewById(R.id.numtel);
        //btnanadir = findViewById(R.id.btnanadir);
        //btnanadir.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
         //       anadir();
         //   }
        //});
    }


    private boolean validación (){
        boolean send =true;
        if (txtNombreEmpleado.getText().toString().isEmpty()){
            return send;
        }
        if (txtDocIdentidad.getText().toString().isEmpty()){
            send = false;
        }
        if (txtCodEmpleado.getText().toString().isEmpty()){
            send = false;
        }
        if (txtDepartamento.getText().toString().isEmpty()){
            send = false;
        }
        if (txtNumTel.getText().toString().isEmpty()){
            send = false;
        }

        return  send;
    }

    private void anadir(){
        if (validación()){
            ToDoTable registro = new ToDoTable();
            registro.nombreempleado = txtNombreEmpleado.getText().toString();
            registro.docidentidad = txtDocIdentidad.getText().toString();
            registro.codempleado = txtCodEmpleado.getText().toString();
            registro.departamento = txtDepartamento.getText().toString();
            registro.numtel = txtNumTel.getText().toString();

            registro.save();
            finish();
        }
        else{
            Toast.makeText(this,"Se produjo un error.",Toast.LENGTH_LONG).show();
        }
    }


    public void onClick(View view) {
        anadir();
    }
}
