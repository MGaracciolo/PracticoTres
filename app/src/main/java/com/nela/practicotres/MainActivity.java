package com.nela.practicotres;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.nela.practicotres.databinding.ActivityMainBinding;
import com.nela.practicotres.models.Pelicula;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel mv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getPeliculaMutable().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                PeliAdapter pa=new PeliAdapter(MainActivity.this,R.layout.card,peliculas,getLayoutInflater());
                RecyclerView rv= binding.vista;
                GridLayoutManager glm=new GridLayoutManager(MainActivity.this,2,GridLayoutManager.VERTICAL,false);
                rv.setLayoutManager(glm);
                rv.setAdapter(pa);
            }
        });

        mv.crearLista();
    }
}