package frank.malo.mobiles.app.mascotas.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.activities.MainActivity;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;

/**
 * Created by Frank on 20/09/2016.
 */
public class MiMascotaAdaptador extends RecyclerView.Adapter<MiMascotaAdaptador.MiMascotaViewHolder> {


    ArrayList<Mascota> mascotas;
    Activity activity;
    private int idCardView;

    public MiMascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mi_mascota, parent, false);
        return new MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiMascotaViewHolder miMascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        miMascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        miMascotaViewHolder.tvRatingCV.setText(String.valueOf(mascota.getPuntaje()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoCV;
        private TextView tvRatingCV;

        public MiMascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvRatingCV = (TextView) itemView.findViewById(R.id.tvRatingCV);
        }
    }

}
