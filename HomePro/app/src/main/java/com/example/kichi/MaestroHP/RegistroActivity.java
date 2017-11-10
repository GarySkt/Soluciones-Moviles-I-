package com.example.kichi.MaestroHP;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.kichi.MaestroHP.pkgEntidad.ClsEntidadPersona;
import com.example.kichi.MaestroHP.pkgNegocios.ClsNegocioPersona;
import com.example.kichi.MaestroHP.pkgNegociosParticulares.ClsConexion;
import com.example.kichi.MaestroHP.pkgNegociosParticulares.ClsEncriptacion;

import java.io.ByteArrayOutputStream;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    ClsConexion db;
    ClsEncriptacion encriptacion;

    public ClsEntidadPersona entidadPersona;
    public ClsNegocioPersona negocioPersona;
    private static final int CAMERA_PIC_REQUEST = 1;


    EditText txtEmail,txtNombre,txtApellido,txtTelefono,txtDireccion,txtNuevoUsuario,txtNuevaPassword;
    Button btnConfirmarRegistro;
    ImageButton btnCamara;

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
        setContentView(R.layout.activity_registro);

        btnConfirmarRegistro = (Button)findViewById(R.id.BtnConfirmarRegistro);
        btnConfirmarRegistro.setOnClickListener(this);

        btnCamara = (ImageButton)findViewById(R.id.BtnFoto);
        btnCamara.setOnClickListener(this);
    }

    @Override
    protected void onPause(){
        overridePendingTransition(R.transition.fade_in, R.transition.fade_out);
        super.onPause();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.BtnConfirmarRegistro:
                txtEmail = (EditText)findViewById(R.id.TxtEmail);
                txtNombre = (EditText)findViewById(R.id.TxtNombre);
                txtApellido = (EditText)findViewById(R.id.TxtApellido);
                txtTelefono = (EditText)findViewById(R.id.TxtTelefono);
                txtDireccion = (EditText)findViewById(R.id.TxtDireccion);
                txtNuevoUsuario = (EditText)findViewById(R.id.TxtUsuario);
                txtNuevaPassword = (EditText)findViewById(R.id.TxtNuevaPassword);
                MtdRegistrarUsuario();
                break;
            case R.id.BtnFoto:
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                startActivityForResult(cameraIntent,CAMERA_PIC_REQUEST);
                break;
        }
    }

    private void MtdRegistrarUsuario() {

        AsignarDatosClase();
        negocioPersona = new ClsNegocioPersona(this);
        negocioPersona.AgregarPersona(entidadPersona);


    }

    String encodedImage;
    private void AsignarDatosClase() {
        encriptacion = new ClsEncriptacion();
        entidadPersona = new ClsEntidadPersona();
        entidadPersona.setEmail_persona(txtEmail.getText().toString());
        entidadPersona.setNombre_persona(txtNombre.getText().toString());
        entidadPersona.setApellido_persona(txtApellido.getText().toString());
        entidadPersona.setTelefono_persona(txtTelefono.getText().toString());
        entidadPersona.setDireccion_persona(txtDireccion.getText().toString());
        entidadPersona.setPassword_persona(encriptacion.MD5(txtNuevaPassword.getText().toString()));
        entidadPersona.setFoto_persona(encodedImage);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap thumbnail = null;
        if (requestCode == CAMERA_PIC_REQUEST) {
            thumbnail = (Bitmap) data.getExtras().get("data");
            btnCamara.setImageBitmap(thumbnail);
        }
        //Convertir bitmap en Base64 para enviarlo a BD
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG,100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        encodedImage = Base64.encodeToString(byteArray,Base64.DEFAULT);
    }
}
