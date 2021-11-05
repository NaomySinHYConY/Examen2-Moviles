package com.example.muebleria2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolderDatos> {

    ArrayList<nota> lista;
    public AdapterData(ArrayList<nota> lista){
        this.lista = lista;
    }
    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null, false);
        return new ViewHolderDatos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.ViewHolderDatos holder, int position) {
        holder.asignarDatos(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nom, marca, precio, cantidad;
        ImageView img;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            nom = itemView.findViewById(R.id.nom);
            marca = itemView.findViewById(R.id.marca);
            precio = itemView.findViewById(R.id.precio);
            cantidad = itemView.findViewById(R.id.cantidad);
            img = itemView.findViewById(R.id.imgV);
        }

        public void asignarDatos(nota n) {
            nom.setText(n.nom);
            marca.setText(n.marca);
            precio.setText(n.costo + "");
            cantidad.setText(n.cantidad + "");
            img.setImageResource(n.foto);
        }
    }
}
