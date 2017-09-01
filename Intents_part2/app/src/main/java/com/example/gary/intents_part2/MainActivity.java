package com.example.gary.intents_part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_msj;
    Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_msj = (EditText) findViewById(R.id.edt_msj);
        btn_enviar = (Button) findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,edt_msj.getText().toString());
                sendIntent.setType("text/plain");

                if (null != sendIntent.resolveActivity(
                        getPackageManager())){
                    startActivity(Intent.createChooser(sendIntent,getResources().getText(R.string.send_to)));
                }
            }
        });
    }

    private void manipularTexto(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null){
            Toast.makeText(MainActivity.this,sharedText,Toast.LENGTH_SHORT).show();
        }
    }
}
