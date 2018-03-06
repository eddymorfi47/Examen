package com.eddiemartnez.app.dep_recursos_humanos.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Eddie Martínez on 5/2/2018.
 */

@Database(name = ToDoDatabase.NAME, version = ToDoDatabase.VERSION)
public class ToDoDatabase {

    public static final String NAME = "ToDoDatabase";

    public static final int VERSION = 1;
}