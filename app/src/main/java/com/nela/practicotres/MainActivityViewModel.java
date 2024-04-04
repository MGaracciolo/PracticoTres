package com.nela.practicotres;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nela.practicotres.databinding.ActivityMainBinding;
import com.nela.practicotres.models.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<List<Pelicula>> peliculasMutable;
    private ActivityMainBinding binding;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<List<Pelicula>> getPeliculaMutable(){
        if(peliculasMutable==null){
            this.peliculasMutable=new MutableLiveData<>();
        }
        return peliculasMutable;
    }
    public void setBinding(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public void crearLista(){
        ArrayList<Pelicula> lista=new ArrayList<>();
        lista.add(new Pelicula(R.drawable.peli1,"Harry Potter y la piedra filosofal","El día de su cumpleaños, Harry Potter descubre que es hijo de dos conocidos hechiceros, de los que ha heredado poderes mágicos. Debe asistir a una famosa escuela de magia y hechicería, donde entabla una amistad con dos jóvenes que se convertirán en sus compañeros de aventura. Durante su primer año en Hogwarts, descubre que un malévolo y poderoso mago llamado Voldemort está en busca de una piedra filosofal que alarga la vida de quien la posee.", "Chris Columbus","Daniel Radcliffe, Emma Watson, Rupert Grint" ));
        lista.add(new Pelicula(R.drawable.peli2,"Ciudad de Dios","Después de formar una pandilla en Río de Janeiro, un joven y su mejor amigo pasan de los robos, al narcotráfico y a los asesinatos.","Fernando Meirelles","Alexandre Rodrigues, Alice Braga"));
        lista.add(new Pelicula(R.drawable.peli3,"El pianista","Un judío polaco, pianista profesional, lucha por la supervivencia en Varsovia frente a la invasión nazi. Después de, gracias a unos amigos, haber evitado la deportación, el pianista debe vivir oculto y constantemente expuesto al peligro.", " Roman Polanski", "Adrien Brody, Thomas Kretschman" ));
        lista.add(new Pelicula(R.drawable.peli4,"Shrek","Un ogro llamado Shrek vive en su pantano, pero su preciada soledad se ve súbitamente interrumpida por la invasión de los ruidosos personajes de los cuentos de hadas. Todos fueron expulsados de sus reinos por el malvado Lord Farquaad. Decidido a salvar su hogar, Shrek hace un trato con Farquaad y se prepara para rescatar a la princesa Fiona, quien será la esposa de Farquaad.", "Andrew Adamson", "John Lithgow, Cameron Diaz, Mike Myers" ));

        peliculasMutable.setValue(lista);

    }
}
