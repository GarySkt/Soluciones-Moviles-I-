package com.example.gary.actividades_comunicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
public final static String EXTRA_MESSAGE = "com.example.gary.actividades_comunicacion.MESSAGE";
    public void enviarSaludo(View view){
        Intent intent = new Intent(this,MostrarSaludoActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_nombre);
        String mensaje = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,mensaje);
        startActivity(intent);;
    }
}
