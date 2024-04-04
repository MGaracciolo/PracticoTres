package com.nela.practicotres;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nela.practicotres.models.Pelicula;

import java.util.List;

public class SegundaActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Pelicula> peliculaMutable;
    public SegundaActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<Pelicula> getPeliculaMutable(){
        if(peliculaMutable==null){
            this.peliculaMutable=new MutableLiveData<>();
        }
        return peliculaMutable;
    }

    public void recuperarPeli(Intent intent){
        Pelicula pelicula= (Pelicula)intent.getSerializableExtra("pelicula");
        if (pelicula!=null){
            peliculaMutable.setValue(pelicula);
        }
    }
}
