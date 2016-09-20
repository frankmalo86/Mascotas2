package frank.malo.mobiles.app.mascotas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import frank.malo.mobiles.app.mascotas.R;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.toolbar_principal);
        miActionBar.setTitle("");
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView img5Stars = (ImageView) findViewById(R.id.img5Stars);
        img5Stars.setVisibility(ImageView.GONE);
    }
}
