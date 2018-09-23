package com.ucab.tesis.imac;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaParquesPrincipalAdapter extends ArrayAdapter<ListaParquesPrincipal> {

    private Context lista_context;
    private int lista_layoutResourceID;
    private ListaParquesPrincipal lista_data[] = null;

    public ListaParquesPrincipalAdapter(Context context, int layoutResourceID, ListaParquesPrincipal[] data) {
        super(context, layoutResourceID, data);

        this.lista_context = context;
        this.lista_layoutResourceID = layoutResourceID;
        this.lista_data = data;


    }

    public View getView(int posicion, View convertView, ViewGroup parent){
        View row = convertView;
        ListaParquePrincipalHolder holder = null;

        if (row == null){
            LayoutInflater inflater = ((Activity)lista_context).getLayoutInflater();
            row = inflater.inflate(lista_layoutResourceID,parent,false);

            holder = new ListaParquePrincipalHolder();
            holder.imagen = row.findViewById(R.id.imageItem1);
            holder.texto = row.findViewById(R.id.item1_principal);

            row.setTag(holder);
        }else{
            holder = (ListaParquePrincipalHolder)row.getTag();
        }

        ListaParquesPrincipal listaParquesPrincipal = lista_data[posicion];
        holder.texto.setText(listaParquesPrincipal.title);
        holder.imagen.setImageResource(listaParquesPrincipal.icon);


        return row;

    }

    static class ListaParquePrincipalHolder{
        ImageView imagen;
        TextView texto;
    }

}