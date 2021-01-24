package cl.inacap.gogogym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MainActivity3 extends AppCompatActivity {

    private ImageButton btnperfil, btnentrenar, btneditar, btnlogros, btnplaylist, btnajustes;
    private Button btncerrar;
    private TextView tv11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnperfil = (ImageButton) findViewById(R.id.btnperfil);
        btnentrenar = (ImageButton) findViewById(R.id.btnentrenar);
        btneditar = (ImageButton) findViewById(R.id.btnajustes);
        btnlogros = (ImageButton) findViewById(R.id.btnlogros);
        btnplaylist = (ImageButton) findViewById(R.id.btnplaylist);
        btnajustes = (ImageButton) findViewById(R.id.btnajustes);
        btncerrar = (Button) findViewById(R.id.btncerrar);
        tv11 = (TextView) findViewById(R.id.tv11);

        botonPerfil();
        botonEntrenar();
        botonEditar();
        botonLogros();
        botonPlaylist();
        botonAjustes();
        cerrarSesion();
        mensajeBienvenida();
    }

    private void botonPerfil(){
        btnperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                Usuario u = i.getParcelableExtra("u");

                Intent j = new Intent(MainActivity3.this,MainActivity5.class);
                j.putExtra("u",u);
                startActivity(j);
            }
        });
    }

    private void botonEntrenar(){
        btnentrenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "La opción de rutinas no está disponible aún", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void botonEditar(){
        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "La opción de editar rutinas no está disponible aún", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void botonLogros(){
        btnlogros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "La opción de ver logros no está disponible aún", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void botonPlaylist(){
        btnplaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "La opción de playlists no está disponible aún", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void botonAjustes(){
        btnajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "a opción de cambiar ajustes no está disponible aún", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cerrarSesion(){
        btncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void mensajeBienvenida(){
        Intent i = getIntent();
        Usuario u = i.getParcelableExtra("u");

        tv11.setText("BIENVENIDO " + u.getNombre());
    }

}