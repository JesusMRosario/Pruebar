package cl.inacap.gogogym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class MainActivity4 extends AppCompatActivity {

    private EditText txtlogcor;
    private EditText txtlogcon;
    private Button btnlogin;
    private Button btngooglog;
    private ImageButton btnlogback;
    private AsyncHttpClient cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txtlogcor = (EditText) findViewById(R.id.txtlogcor);
        txtlogcon = (EditText) findViewById(R.id.txtlogcon);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btngooglog = (Button) findViewById(R.id.btngooglog);
        btnlogback = (ImageButton) findViewById(R.id.btnlogback);

        botonLogin();
        salirLogin();
        botonGoogle();
    }

    private void botonLogin(){
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtlogcor.getText().toString().isEmpty() || txtlogcon.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity4.this, "Debe colocar ambos campos", Toast.LENGTH_SHORT).show();
                    txtlogcor.setText("");
                    txtlogcon.setText("");
                }else{
                    String cor = txtlogcor.getText().toString().replace(" ","%20");
                    String pas = txtlogcon.getText().toString().replace(" ","%20");
                    String url = "https://elementalherosario.000webhostapp.com/comprobarUsuario.php?Correo="+cor+"&Contrasena="+pas;
                    cliente.post(url, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            String respuesta = new String(responseBody);
                            if (respuesta.equalsIgnoreCase("null")){
                                Toast.makeText(MainActivity4.this, "Error de usuario y/o contraseña", Toast.LENGTH_SHORT).show();
                                txtlogcor.setText("");
                                txtlogcon.setText("");
                            }else{
                                try {
                                    JSONObject jsonObj = new JSONObject(respuesta);
                                    Usuario u = new Usuario();
                                    u.setNombre(jsonObj.getString("nom_usu"));
                                    u.setCorreo(jsonObj.getString("cor_usu"));
                                    u.setContrasena(jsonObj.getString("con_usu"));
                                    u.setAltura(jsonObj.getInt("alt_usu"));
                                    u.setPeso(jsonObj.getInt("pes_usu"));
                                    u.setSexo(jsonObj.getInt("id_sex"));
                                    u.setPais(jsonObj.getString("pai_usu"));
                                    u.setCuenta(jsonObj.getInt("id_cue"));

                                    Intent i = new Intent(MainActivity4.this,MainActivity3.class);
                                    i.putExtra("u",u);
                                    startActivity(i);

                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                        }
                    });
                }
            }
        });
    }

    private  void salirLogin(){
        btnlogback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity4.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void botonGoogle() {
        btngooglog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity4.this, "Lamentablemente, Google casi nos compra al querer entablar servicios con ellos", Toast.LENGTH_SHORT).show();
            }
        });
    }

}