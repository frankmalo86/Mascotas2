package frank.malo.mobiles.app.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Frank on 14/09/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //el holder
    @Override
    public MascotaAdaptador.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    //el bind
    @Override
    public void onBindViewHolder(final MascotaAdaptador.MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRatingCV.setText(String.valueOf(mascota.getPuntaje()));

        //valido que el evento del activado de la imagen para el puntaje solo esté disponible para la actividad principal
        if (MainActivity.class == activity.getClass()) {
            mascotaViewHolder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    //aumento en uno el valor que tiene la mascota.
                    int cantidad = mascota.getPuntaje();
                    mascota.setPuntaje(++cantidad);
                    mascotaViewHolder.tvRatingCV.setText(String.valueOf(mascota.getPuntaje()));
                }
            });
        }
    }

    //el count
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private ImageView imgHuesoBlanco;
        private TextView tvRatingCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            imgHuesoBlanco = (ImageView) itemView.findViewById(R.id.imgHuesoBlanco);
            tvRatingCV = (TextView) itemView.findViewById(R.id.tvRatingCV);
        }
    }
}
