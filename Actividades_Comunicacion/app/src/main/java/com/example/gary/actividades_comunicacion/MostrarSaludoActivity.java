package com.example.gary.actividades_comunicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class MostrarSaludoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        Intent intent = getIntent();
        String mensaje = intent.getStringExtra(FirstActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(mensaje);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_);
        layout.addView(textView);

    }
}
