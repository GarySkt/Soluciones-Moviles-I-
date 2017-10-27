package com.example.depis01.directoriomedico.MedicoDetail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.depis01.directoriomedico.MainActivity;
import com.example.depis01.directoriomedico.R;

public class MedicoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String id = getIntent().getStringExtra(MainActivity.EXTRA_MEDICO_ID);

        MedicoDetailFragment fragment = (MedicoDetailFragment)getSupportFragmentManager().findFragmentById(R.id.medico_detail_container);

        if (fragment == null){
            fragment = MedicoDetailFragment.newInstance(id);
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.medico_detail_container,fragment).commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
