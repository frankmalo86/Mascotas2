package frank.malo.mobiles.app.mascotas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.mail.SendMail;

public class ContactoActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etEmail;
    EditText etMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etNombre = (EditText) findViewById(R.id.etNombreCompleto);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etMensaje = (EditText) findViewById(R.id.etMensaje);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.toolbar_principal);
        miActionBar.setTitle("");
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView img5Stars = (ImageView) findViewById(R.id.img5Stars);
        img5Stars.setVisibility(ImageView.GONE);

    }

    public void enviarComentario(View v){

        if (etMensaje.getText().toString().equals("") || etNombre.getText().toString().equals("") || etEmail.getText().toString().equals("")){
            Toast.makeText(this, getResources().getString(R.string.error_validacion_mail), Toast.LENGTH_LONG).show();
        }else{
            String mensaje = etMensaje.getText().toString() + "\nUsuario: " + etNombre.getText().toString();
            SendMail sm = new SendMail(this, etEmail.getText().toString(), getResources().getString(R.string.titulo_mail),mensaje);
            sm.execute();
        }
    }
}
