package cl.inacap.gogogym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.loopj.android.http.*;
import org.json.JSONArray;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class MainActivity2 extends AppCompatActivity {

    private EditText txtregnom, txtregcor, txtregcon, txtregalt, txtregpes;
    private ToggleButton btnregsex;
    private Spinner spiregpai;
    private Button btnregistrar;
    private AsyncHttpClient cliente;
    private ImageButton btnsalreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtregnom = (EditText) findViewById(R.id.txtregnom);
        txtregcor = (EditText) findViewById(R.id.txtregcor);
        txtregcon = (EditText) findViewById(R.id.txtregcon);
        txtregalt = (EditText) findViewById(R.id.txtregalt);
        txtregpes = (EditText) findViewById(R.id.txtregpes);
        btnregsex = (ToggleButton) findViewById(R.id.btnregsex);
        btnsalreg = (ImageButton) findViewById(R.id.btnsalreg);
        spiregpai = (Spinner) findViewById(R.id.spiregpai);

        limpiarCampos();
        botonRegistrar();
        salirRegistro();
    }

    private void limpiarCampos(){
        txtregnom.setText("");
        txtregcor.setText("");
        txtregcon.setText("");
        txtregalt.setText("");
        txtregpes.setText("");
        btnregsex.isChecked();

    }

    private void botonRegistrar(){
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtregcor.getText().toString().trim().isEmpty() || txtregnom.getText().toString().trim().isEmpty() || txtregcon.getText().toString().trim().isEmpty() || txtregalt.getText().toString().trim().isEmpty() || txtregpes.getText().toString().trim().isEmpty()){ // Correo
                    Toast.makeText(MainActivity2.this, "Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
                }else{
                    Usuario u = new Usuario();
                    u.setNombre(txtregnom.getText().toString().replaceAll(" ","%20"));
                    u.setCorreo(txtregcor.getText().toString());
                    u.setContrasena(txtregcon.getText().toString());
                    u.setAltura(Integer.parseInt(txtregalt.getText().toString()));
                    u.setPeso(Integer.parseInt(txtregpes.getText().toString()));
                    if (btnregsex.isChecked()){
                        u.setSexo(1);
                    }else{
                        u.setSexo(2);
                    }
                    u.setPais(spiregpai.getSelectedItem().toString());
                    u.setCuenta(1);
                    agregarUsuario(u);
                    try {
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                } //Correo
            }
        });
    } //Void

    private void agregarUsuario(Usuario u){
        String url = "https://elementalherosario.000webhostapp.com/agregar.php?";
        String parametros = "Nombre="+u.getNombre()+"&Correo="+u.getCorreo()+"&Contrasena="+u.getContrasena()+"&Altura="+u.getAltura()+"&Peso="+u.getPeso()+"&Sexo="+u.getSexo()+"&Pais="+u.getPais()+"&Cuenta="+u.getCuenta();
        cliente.post(url + parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200){
                    Toast.makeText(MainActivity2.this, "Cuenta registrada correctamente, inicie sesión", Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });


    } // Void

    private void salirRegistro(){
        btnsalreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = null;
                i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}