package com.eddiemartnez.app.dep_recursos_humanos.db;

import com.eddiemartnez.app.dep_recursos_humanos.db.ToDoDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Eddie Martínez on 5/2/2018.
 */
@Table(database = ToDoDatabase.class)
public class ToDoTable extends BaseModel{
    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String nombreempleado;

    @Column
    public String docidentidad;

    @Column
    public String codempleado;

    @Column
    public String departamento;

    @Column
    public String numtel;

    @Column
    public int estado;


}
