package com.eddiemartnez.app.dep_recursos_humanos;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.sufficientlysecure.htmltextview.HtmlTextView;

/**
 * Created by Eddie Martínez on 26/2/2018.
 */

public class ToDoViewHolder extends RecyclerView.ViewHolder {

    public HtmlTextView html;

    public ToDoViewHolder(View itemView){
        super(itemView);
        html=itemView.findViewById(R.id.html_text);


    }
}
