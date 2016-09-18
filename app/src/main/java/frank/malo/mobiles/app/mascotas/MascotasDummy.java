package frank.malo.mobiles.app.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotasDummy extends AppCompatActivity {
    ArrayList<Mascota> mascotasSeleccionadas;
    private RecyclerView listaMascotasSeleccionadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_dummy);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBar_activityMain);
        miActionBar.setTitle("");
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView img5Stars = (ImageView) findViewById(R.id.img5Stars);
        img5Stars.setVisibility(ImageView.GONE);

        int tamanio = getResources().getTextArray(R.array.pmascotas).length;
        mascotasSeleccionadas = new ArrayList<Mascota>();
        for (int i=0; i<tamanio; i++){
            //obtengo el objeto serializado
            mascotasSeleccionadas.add((Mascota) getIntent().getSerializableExtra(getResources().getTextArray(R.array.pmascotas)[i].toString()));
        }

        listaMascotasSeleccionadas = (RecyclerView) findViewById(R.id.rvMascotasDummi);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasSeleccionadas.setLayoutManager(llm);
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasSeleccionadas, this);
        listaMascotasSeleccionadas.setAdapter(adaptador);
    }

}
