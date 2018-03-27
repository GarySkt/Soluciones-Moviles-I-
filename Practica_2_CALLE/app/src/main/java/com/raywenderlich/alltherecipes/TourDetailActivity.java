package com.raywenderlich.alltherecipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TourDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);


        String title = this.getIntent().getExtras().getString("title");
        String imagen = this.getIntent().getExtras().getString("imagen");
        String descripcion = this.getIntent().getExtras().getString("descripcion");
        String dias = this.getIntent().getExtras().getString("dias");
        String persona = this.getIntent().getExtras().getString("persona");
        String precio = this.getIntent().getExtras().getString("precio");

        TextView txtTitulo = (TextView)findViewById(R.id.LblTitulo);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        TextView txtParrafo = (TextView)findViewById(R.id.LblParrafo);
        TextView txtDias = (TextView)findViewById(R.id.txtDias);
        TextView txtPersona = (TextView)findViewById(R.id.txtPersona);
        TextView txtPrecio = (TextView)findViewById(R.id.txtPrecio);


        txtTitulo.setText(title);
        Picasso.with(this).load(imagen).placeholder(R.mipmap.ic_launcher).into(imageView);
        txtParrafo.setText(descripcion);
        txtPrecio.setText("Precio unico: "+precio);
        txtDias.setText("Estadía :\n"+dias +" días");
        txtPersona.setText("Personas :\n"+persona);
    }
}
