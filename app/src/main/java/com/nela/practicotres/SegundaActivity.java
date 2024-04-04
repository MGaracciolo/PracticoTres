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

import com.nela.practicotres.databinding.SegundaActivityBinding;
import com.nela.practicotres.models.Pelicula;

public class SegundaActivity extends AppCompatActivity {
    private SegundaActivityViewModel mv;
    private SegundaActivityBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= SegundaActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(SegundaActivityViewModel.class);
        mv.getPeliculaMutable().observe(this, new Observer<Pelicula>() {
            @Override
            public void onChanged(Pelicula pelicula) {
                TextView titulo=binding.Actores;
                ImageView foto=binding.Foto;
                TextView resenia = binding.Resenia;
                TextView director = binding.Director;
                TextView actores = binding.Actores;
                titulo.setText(pelicula.getTitulo());
                foto.setImageResource(pelicula.getFoto());
                resenia.setText(pelicula.getResenia());
                director.setText(pelicula.getDirector());
                actores.setText(pelicula.getActores());
            }
        });
        mv.recuperarPeli(getIntent());

        Button bt =binding.btVolver;

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
