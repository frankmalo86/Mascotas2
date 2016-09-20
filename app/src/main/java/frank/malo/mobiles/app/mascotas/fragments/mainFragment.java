package frank.malo.mobiles.app.mascotas.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.activities.MascotasDummy;
import frank.malo.mobiles.app.mascotas.adaptadores.MascotaAdaptador;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class mainFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    public mainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        ImageView img5Stars = (ImageView) getActivity().findViewById(R.id.img5Stars);
        img5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarMascotas();
                enviarDatos();
            }
        });
        return v;
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
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
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

    public void enviarDatos(){
        Intent intent = new Intent(getActivity(), MascotasDummy.class);
        int tamanio = getResources().getTextArray(R.array.pmascotas).length;
        for (int i=0; i<tamanio; i++){
            //todo: validar que no se sobrepase el tamaño de la cantidad de mascotas en el arrayList
            intent.putExtra(getResources().getTextArray(R.array.pmascotas)[i].toString(), mascotas.get(i));
        }
        startActivity(intent);
    }
}
