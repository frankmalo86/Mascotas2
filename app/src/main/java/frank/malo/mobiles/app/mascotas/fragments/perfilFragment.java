package frank.malo.mobiles.app.mascotas.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.adaptadores.MascotaAdaptador;
import frank.malo.mobiles.app.mascotas.adaptadores.MiMascotaAdaptador;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;
import frank.malo.mobiles.app.mascotas.tools.RatingAleatorio;

/**
 * A simple {@link Fragment} subclass.
 */
public class perfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMiMascota;

    public perfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);

        rvMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvMiMascota.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.p1, "Negro", RatingAleatorio.generarAleatorio(0,50)));
        mascotas.add(new Mascota(R.drawable.p2, "Negro", RatingAleatorio.generarAleatorio(0,50)));
        mascotas.add(new Mascota(R.drawable.p3, "Negro", RatingAleatorio.generarAleatorio(0,50)));
        mascotas.add(new Mascota(R.drawable.p4, "Negro", RatingAleatorio.generarAleatorio(0,50)));
        mascotas.add(new Mascota(R.drawable.p5, "Negro", RatingAleatorio.generarAleatorio(0,50)));
        mascotas.add(new Mascota(R.drawable.p6, "Negro", RatingAleatorio.generarAleatorio(0,50)));
        mascotas.add(new Mascota(R.drawable.p7, "Negro", RatingAleatorio.generarAleatorio(0,50)));
        mascotas.add(new Mascota(R.drawable.p8, "Negro", RatingAleatorio.generarAleatorio(0,50)));
        mascotas.add(new Mascota(R.drawable.p9, "Negro", RatingAleatorio.generarAleatorio(0,50)));
        mascotas.add(new Mascota(R.drawable.p10, "Negro", RatingAleatorio.generarAleatorio(0,50)));
        mascotas.add(new Mascota(R.drawable.p11, "Negro", RatingAleatorio.generarAleatorio(0,50)));

    }

    public void inicializarAdaptador(){
        MiMascotaAdaptador adaptador = new MiMascotaAdaptador(mascotas, getActivity());
        rvMiMascota.setAdapter(adaptador);
    }

}
