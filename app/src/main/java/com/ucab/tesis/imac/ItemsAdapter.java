package com.ucab.tesis.imac;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolderDatos> {

    ArrayList<Items> l_datos;

    public ItemsAdapter(ArrayList<Items> l_datos) {
        this.l_datos = l_datos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_lista,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
           holder.dato1.setText(l_datos.get(position).getObjeto2());
           holder.dato2.setImageResource(l_datos.get(position).getObjeto1());
    }

    @Override
    public int getItemCount() {
        return l_datos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView dato1;
        ImageView dato2;

        public ViewHolderDatos(View itemView) {

            super(itemView);

            dato1=itemView.findViewById(R.id.lista1);
            dato2=itemView.findViewById(R.id.imageItem);

        }

    }
}
