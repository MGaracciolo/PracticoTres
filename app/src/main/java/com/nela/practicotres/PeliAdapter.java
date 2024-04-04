package com.nela.practicotres;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.nela.practicotres.models.Pelicula;

import java.util.List;

public class PeliAdapter extends RecyclerView.Adapter<PeliAdapter.ViewHolder> {
    private List<Pelicula> cartelera;
    private Context context;
    private LayoutInflater li;

    private int itemAMostrar;
    public PeliAdapter(@NonNull Context context, int card, @NonNull List<Pelicula> listadoPelis, LayoutInflater li) {
        this.cartelera=listadoPelis;
        this.context=context;
        this.li=li;
        this.itemAMostrar=card;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(itemAMostrar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pelicula pelicula=cartelera.get(position);
        holder.tvTitulo.setText(pelicula.getTitulo());
        holder.tvResenia.setText(pelicula.getResenia());
        holder.ivFoto.setImageResource(pelicula.getFoto());
    holder.btDetalle.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,SegundaActivity.class);
            intent.putExtra("pelicula", pelicula);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    });

    }

    @Override
    public int getItemCount() {
        return cartelera.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvResenia;
        private TextView tvTitulo;
        private ImageView ivFoto;
        private Button btDetalle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvResenia=itemView.findViewById(R.id.tvResenia);
            tvTitulo=itemView.findViewById(R.id.tvTitulo);
            ivFoto=itemView.findViewById(R.id.ivFoto);
            btDetalle=itemView.findViewById(R.id.btDetalle);
        }
    }
    public int getCount(){
        return cartelera.size();
    }
}


