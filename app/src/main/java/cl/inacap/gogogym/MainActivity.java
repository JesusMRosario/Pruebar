package cl.inacap.gogogym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.loopj.android.http.*;
import org.json.JSONArray;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Button btnmenu1, btnmenu2;
    private ImageButton btnmenu3, btnmenu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnmenu1 = (Button) findViewById(R.id.btnmenu1);
        btnmenu2 = (Button) findViewById(R.id.btnmenu2);
        btnmenu3 = (ImageButton) findViewById(R.id.btnmenu3);
        btnmenu4 = (ImageButton) findViewById(R.id.btnmenu4);

        botonLogin();
        botonSigin();
        botonSalir();
        botonOpciones();
    } //Cierra el onCreate

    private void botonLogin(){
        btnmenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(i);
            }
        });
    } // Iniciar Sesión

    private void botonSigin(){
        btnmenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    } // Registrarse

    private void botonSalir(){
        btnmenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
    }

    private void botonOpciones(){
        btnmenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Esta opcion esta en desarrollo", Toast.LENGTH_SHORT).show();

            }
        });
    }


} //Cierra la clase