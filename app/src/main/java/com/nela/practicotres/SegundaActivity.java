package com.nela.practicotres;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.nela.practicotres.models.Pelicula;

public class SegundaActivity extends AppCompatActivity {
    private SegundaActivityViewModel mv;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(SegundaActivityViewModel.class);
        mv.getPeliculaMutable().observe(this, new Observer<Pelicula>() {
            @Override
            public void onChanged(Pelicula pelicula) {
                TextView titulo = findViewById(R.id.tvTitulo);
                ImageView foto = findViewById(R.id.ivFoto);
                TextView resenia = findViewById(R.id.tvResenia);
                TextView director = findViewById(R.id.Director);
                TextView actores = findViewById(R.id.Actores);
                titulo.setText(pelicula.getTitulo());
                foto.setImageResource(pelicula.getFoto());
                resenia.setText(pelicula.getResenia());
                director.setText(pelicula.getDirector());
                actores.setText(pelicula.getActores());
            }
        });
        mv.recuperarPeli(getIntent());
        Button bt = findViewById(R.id.btVolver);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
