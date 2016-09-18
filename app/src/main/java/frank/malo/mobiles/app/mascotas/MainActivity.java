package frank.malo.mobiles.app.mascotas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBar_activityMain);
        miActionBar.setTitle("");
        //miActionBar.setTextAlignment(Toolbar.TEXT_ALIGNMENT_CENTER);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        ImageView img5Stars = (ImageView) findViewById(R.id.img5Stars);
        img5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ordeno el arraylist utilizando el método sort de la interfaz Collections para poder tener las mascotas con mayor puntaje
                //en los primeros indices del objeto.
                ordenarMascotas();
                //envio los datos valiendome de un array en el archivo string.xml
                enviarDatos();
            }
        });

        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public void enviarDatos(){
        Intent intent = new Intent(this, MascotasDummy.class);
        int tamanio = getResources().getTextArray(R.array.pmascotas).length;
        for (int i=0; i<tamanio; i++){
            //todo: validar que no se sobrepase el tamaño de la cantidad de mascotas en el arrayList
            intent.putExtra(getResources().getTextArray(R.array.pmascotas)[i].toString(), mascotas.get(i));
        }
        startActivity(intent);
    }

    public void ordenarMascotas(){
        Collections.sort(mascotas, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota m1, Mascota m2) {
                if (m1.getPuntaje() > m2.getPuntaje())  return -1;
                else if (m1.getPuntaje() == m2.getPuntaje())  return 0;
                else return 1;
            }
        });
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro1, "Lucky"));
        mascotas.add(new Mascota(R.drawable.gato1, "bola de nieve"));
        mascotas.add(new Mascota(R.drawable.perro2, "Firulo"));
        mascotas.add(new Mascota(R.drawable.gato2, "Silvestre"));
        mascotas.add(new Mascota(R.drawable.perro3, "Toba"));
        mascotas.add(new Mascota(R.drawable.gato3, "Nikita"));
        mascotas.add(new Mascota(R.drawable.perro4, "Lycan"));
        mascotas.add(new Mascota(R.drawable.gato4, "Sombra"));
        mascotas.add(new Mascota(R.drawable.perro5, "Sultán"));
        mascotas.add(new Mascota(R.drawable.perro6, "Spencer"));

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

}
