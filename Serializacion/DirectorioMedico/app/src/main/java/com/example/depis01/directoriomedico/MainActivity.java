package com.example.depis01.directoriomedico;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.depis01.directoriomedico.datos.Medicos;
import com.example.depis01.directoriomedico.fragmentos.MedicosFragment;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MEDICO_ID = "medicoId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//coger el contendor y parcearlo con ...
        MedicosFragment medicosFragment = (MedicosFragment)
                getSupportFragmentManager().findFragmentById(R.id.medicos_container);
        if(medicosFragment == null){
            medicosFragment = MedicosFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.medicos_container,medicosFragment)
                    .addToBackStack(null)
                    .commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //cambio el icono del "fab"
        fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_account_circle));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
//glide jala las imagenes mediante un patron de sigleton(no se si esta bien escrito)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
