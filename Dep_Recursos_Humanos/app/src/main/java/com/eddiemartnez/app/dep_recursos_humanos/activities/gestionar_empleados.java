package com.eddiemartnez.app.dep_recursos_humanos.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.eddiemartnez.app.dep_recursos_humanos.R;
import com.eddiemartnez.app.dep_recursos_humanos.db.ToDoTable;
import com.eddiemartnez.app.dep_recursos_humanos.ToDoViewHolder;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;

import java.util.List;

public class gestionar_empleados extends AppCompatActivity {
    private RecyclerView lista;
    private static Context QuickContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestionar_empleados);
        QuickContext = this;
        FlowManager.init(this);


        lista = findViewById(R.id.lista);
        lista.setLayoutManager(new LinearLayoutManager(this));

        List<ToDoTable> info = SQLite.select().from(ToDoTable.class).queryList();
        lista.setAdapter(new ToDoAdapter(info));
    }



    public static class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {
        private final List<ToDoTable> listToDoTable;
        private final LayoutInflater inflater;

        public ToDoAdapter(List<ToDoTable> listToDoTables) {
            this.inflater = LayoutInflater.from(QuickContext);
            this.listToDoTable = listToDoTables;
        }

        @Override
        public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.activity_objeto, parent, false);
            return new ToDoViewHolder(view);
        }

        public void animateTo(List<ToDoTable> models) {
            applyAndAnimateRemovals(models);
            applyAndAnimateAdditions(models);
            applyAndAnimateMovedItems(models);
        }

        private void applyAndAnimateRemovals(List<ToDoTable> newModels) {
            for (int i = listToDoTable.size() - 1; i >= 0; i--) {
                final ToDoTable model = listToDoTable.get(i);
                if (!newModels.contains(model)) {
                    removeItem(i);
                }
            }
        }

        private void applyAndAnimateAdditions(List<ToDoTable> newModels) {
            for (int i = 0, count = newModels.size(); i < count; i++) {
                final ToDoTable model = newModels.get(i);
                if (!listToDoTable.contains(model)) {
                    addItem(i, model);
                }
            }
        }

        private void applyAndAnimateMovedItems(List<ToDoTable> newModels) {
            for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
                final ToDoTable model = newModels.get(toPosition);
                final int fromPosition = listToDoTable.indexOf(model);
                if (fromPosition >= 0 && fromPosition != toPosition) {
                    moveItem(fromPosition, toPosition);
                }
            }
        }

        public ToDoTable removeItem(int position) {
            final ToDoTable model = listToDoTable.remove(position);
            notifyItemRemoved(position);
            return model;
        }

        public void addItem(int position, ToDoTable model) {
            listToDoTable.add(position, model);
            notifyItemInserted(position);
        }

        public void moveItem(int fromPosition, int toPosition) {
            final ToDoTable model = listToDoTable.remove(fromPosition);
            listToDoTable.add(toPosition, model);
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onBindViewHolder(final ToDoViewHolder holder, final int position) {
            ToDoTable current = listToDoTable.get(position);
            holder.html.setHtml(ActividadAString(current),
                    new HtmlResImageGetter(holder.html));


        }
        private String ActividadAString(ToDoTable todo){
            String html = "<a><b>" +"Nombre: " + todo.nombreempleado+"<b>";
            html+= "<br>" +"Doc. Identidad: " +todo.docidentidad+"</a>";
            html+= "<br>" +"Cod. Empleado: " +todo.codempleado+"</a>";
            html+= "<br>" +"Departamento: "+todo.departamento+"</a>";
            html+= "<br>" +"Número Teléfono: "+todo.numtel+"</a>";
            return html;
        }


        @Override
        public int getItemCount() {
            return listToDoTable.size();
        }




    }
}
