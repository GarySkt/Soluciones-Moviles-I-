package com.example.kichi.MaestroHP;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kichi.MaestroHP.pkgEntidad.ClsEntidadPersona;
import com.example.kichi.MaestroHP.pkgNegociosParticulares.ClsEncriptacion;
import com.example.kichi.MaestroHP.pkgNegociosParticulares.ClsLogin;

import java.sql.SQLException;

// PRIMERA SUBIDA DE PRUEBA
//respuesta
// Respuesta a respuesta
// ESTA VIIVOOO ESTA VIIIVOOO - exclamo el cientifico loco

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtUsuario,txtPassword;
    Button btnLogin,btnRegistro;
    public ClsEntidadPersona entidadPersona;
    public ClsLogin login;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Quitar Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Quitar Action Bar
        // Agregar Efecto de entrada
        overridePendingTransition(R.transition.fade_in, R.transition.fade_out);
        // Agregar Efecto de entrada
        setContentView(R.layout.activity_login);

        // Registrar permiso de acceso de la aplicacion
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        // Registrar permiso de acceso de la aplicacion


        txtUsuario = (EditText)findViewById(R.id.TxtUsuario);
        txtPassword = (EditText)findViewById(R.id.TxtPassword);

        btnLogin = (Button)findViewById(R.id.BtnLogin);
        btnLogin.setOnClickListener(this);

        btnRegistro = (Button)findViewById(R.id.BtnConfirmarRegistro);
        btnRegistro.setOnClickListener(this);


    }
    @Override
    protected void onPause(){
        overridePendingTransition(R.transition.fade_in, R.transition.fade_out);
        super.onPause();
    }

    @Override
    public void onClick(View view) {
        ClsEncriptacion encriptacion = new ClsEncriptacion();
        switch (view.getId()){
            case R.id.BtnLogin:
                    try {
                        MtdLogin(txtUsuario.getText().toString(),encriptacion.MD5(txtPassword.getText().toString()));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                break;
            case R.id.BtnConfirmarRegistro:
                intent = new Intent(this,RegistroActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void MtdLogin(String email_persona, String contrasena_persona) throws SQLException {
        login = new ClsLogin();
        entidadPersona = login.verificarLogin(email_persona,contrasena_persona);

        if(entidadPersona.getEmail_persona()!=null){
            Toast toast =  Toast.makeText(this,"Bienvenido\n"+entidadPersona.getNombre_persona() + " " + entidadPersona.getApellido_persona(),Toast.LENGTH_LONG);
            //Mostrar Toast centrado
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            if( v != null) v.setGravity(Gravity.CENTER);
            toast.show();

            intent = new Intent(this,Menu2Activity.class);
            bundle = new Bundle();
            bundle.putString("Nombre",entidadPersona.getNombre_persona());
            bundle.putString("Apellido",entidadPersona.getApellido_persona());
            bundle.putString("Email",entidadPersona.getEmail_persona());
            bundle.putString("Foto",entidadPersona.getFoto_persona());
            intent.putExtras(bundle);
            startActivity(intent);

        }else{
            Toast.makeText(this,"Error de inicio de sesión",Toast.LENGTH_LONG).show();
        }
    }
}
