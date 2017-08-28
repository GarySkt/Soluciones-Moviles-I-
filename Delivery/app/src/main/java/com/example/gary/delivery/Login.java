package com.example.gary.delivery;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class Login extends ActionBarActivity implements View.OnClickListener {

    Button btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //oculta el actionbar de la activity
        getSupportActionBar().hide();

        btn_registrar = (Button) findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(this);


    }
    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.btn_ingresar:
                break;
            case R.id.btn_registrar:
                Intent intent = new Intent(this,Registrar.class);
                startActivity(intent);
                break;
        }

    }

}
