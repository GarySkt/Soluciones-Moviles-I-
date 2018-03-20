package com.example.gary.actividad1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarpalabras (View view){
        Intent intent = new Intent(this,palabrasalazar.class);
        Bundle extras = new Bundle();                                       //Creamos un conjunto de extras
        EditText txtnumero = (EditText)findViewById(R.id.txtNumero);        //Obtenemos el numero
        EditText txtparrafo = (EditText)findViewById(R.id.txtParrafo);      //Obtenemos el parrafo completo

        String numero = txtnumero.getText().toString();                 //Obtenemos numero
        String parrafo = txtparrafo.getText().toString();               //Obtenemos el parrafo

        StringTokenizer st = new StringTokenizer(parrafo," ");          //Enumeramos las palabras

        if(st.countTokens() >= Integer.parseInt(numero)) {              //Creamos condicion para evitar desbordamiento
            List<String> azar = new ArrayList<String>();                //Creamos una lista vacia

            while (st.hasMoreTokens()) {                                //Creamos condicion de llenado
                azar.add(st.nextToken());                               //Agregamos las palabras a la lista
            }

            Collections.shuffle(azar);                                  //Desordenamos la lista
            String textoAzar = "";                                      //Creamos un string que sera nuestra cadena al azar

            for (int i = 0; i < Integer.parseInt(numero); i++) {        //Creamos condicion if y casteamos a entero
                if ((Integer.parseInt(numero) - 1) == i) {              //Comparamos para crear la cadena sin un espacio al final
                    textoAzar = textoAzar + azar.get(i);                //Llenamos el String con las palabras desordenadas
                } else {
                    textoAzar = textoAzar + azar.get(i) + " ";          //Mismo metodo de llenado
                }
            }

            extras.putString("textoAzar", textoAzar);                    //Agregamos al bundle el texto
            extras.putString("numero", numero);                          //Agregamos al bundle el numero
            intent.putExtras(extras);                                    //Enviamos el conjunto entero
            startActivity(intent);
        }else
        {
            Toast.makeText(this,"El numero ingresado debe ser menor o igual a la cantidad de palabras que ingreso.",Toast.LENGTH_LONG).show();
        }
    }
}
