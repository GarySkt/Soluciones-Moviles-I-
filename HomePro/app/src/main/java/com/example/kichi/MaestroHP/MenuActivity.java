package com.example.kichi.MaestroHP;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kichi and Gary on 10/09/2017.
 */

public class MenuActivity extends AppCompatActivity{
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
        setContentView(R.layout.activity_menu);


        Intent intent = getIntent();                                            //Obtenemos el intent
        Bundle extras = intent.getExtras();                                     //Obtenemos el conjunto de extras

        String email = extras.getString("Email");                             //Obtenemos el extra numero
        String nombre = extras.getString("Nombre");                             //Obtenemos el extra numero
        String apellido = extras.getString("Apellido");                         //Obtenemos el extra textoAzar
        String foto = extras.getString("Foto");

        byte[] decodedString = Base64.decode(foto,Base64.DEFAULT);
        Bitmap decodedBitmap = BitmapFactory.decodeByteArray(decodedString,0,decodedString.length);

        TextView TxtEmailUsuario = (TextView)findViewById(R.id.TxtEmail);                //Buscamos el TextView por id del la caja de texto al azar
        TextView TxtNombreUsuario = (TextView)findViewById(R.id.TxtNombre);            //Buscamos el TextView por id de la caja de texto de numero
        ImageView IVFotoUsuario = (ImageView)findViewById(R.id.imgFotoPerfil);

        TxtEmailUsuario.setText(email);                                              //Seteamos el numero
        TxtNombreUsuario.setText(nombre+ " " + apellido);                                             //Seteamos el texto al azar
        IVFotoUsuario.setImageBitmap(decodedBitmap);
    }
}
