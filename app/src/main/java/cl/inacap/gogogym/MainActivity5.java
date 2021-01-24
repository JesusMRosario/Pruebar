package cl.inacap.gogogym;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.*;
import org.json.JSONArray;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class MainActivity5 extends AppCompatActivity {

    private TextView tv15, tv16, tv17, tv18, tv19, tv20, tv21;
    private Button btneliminar;
    private ImageButton btnsalper;
    private AsyncHttpClient cliente;

    Intent j = getIntent();
    Usuario u = j.getParcelableExtra("u");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        tv15 = (TextView) findViewById(R.id.tv15);
        tv16 = (TextView) findViewById(R.id.tv16);
        tv17 = (TextView) findViewById(R.id.tv17);
        tv18 = (TextView) findViewById(R.id.tv18);
        tv19 = (TextView) findViewById(R.id.tv19);
        tv20 = (TextView) findViewById(R.id.tv20);
        tv21 = (TextView) findViewById(R.id.tv21);
        btneliminar = (Button) findViewById(R.id.btneliminar);
        btnsalper = (ImageButton) findViewById(R.id.btnsalper);

        volverPerfil();
        rellenarCampos();
        botonEliminar();
    }

    private void volverPerfil() {
        btnsalper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity5.this, MainActivity3.class);
                startActivity(i);
            }
        });
    }

    private void rellenarCampos() {


        tv15.setText(u.getNombre());
        tv16.setText("CORREO: " + u.getCorreo());
        tv17.setText("ALTURA: " + u.getAltura());
        tv18.setText("PESO  : " + u.getPeso());
        tv19.setText("PAÍS  : " + u.getPais());
        tv21.setText("SEXO  : " + u.getSexo());
        tv20.setText("PLAN  : " + u.getCuenta());

    }

    private void eliminarCuenta(Usuario u) {
        String cor = u.getCorreo();
        String url = "https://elementalherosario.000webhostapp.com/eliminar.php?Correo=" + cor;
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String respuesta = new String(responseBody);
                if (respuesta.equalsIgnoreCase("null")) {
                    Toast.makeText(MainActivity5.this, "De alguna manera no se encontró la cuenta", Toast.LENGTH_SHORT).show();
                } else {
                    Intent f = new Intent(MainActivity5.this, MainActivity.class);
                    Toast.makeText(MainActivity5.this, "Hasta luego, usuario", Toast.LENGTH_SHORT).show();
                    startActivity(f);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void botonEliminar(){
        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity5.this);
                b.setCancelable(true);
                b.setTitle("¿Está seguro?");
                b.setMessage("¿Está seguro de querer eliminar definitivamente la cuenta? Estaremos de acuerdo con su decisión aunque no nos convenga");
                b.setIcon(R.drawable.interrogante);
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                b.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        eliminarCuenta(u);
                    }
                });
            }
        });
    }

}