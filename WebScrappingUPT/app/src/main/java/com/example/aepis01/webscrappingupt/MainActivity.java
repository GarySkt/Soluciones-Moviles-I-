package com.example.aepis01.webscrappingupt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.resultado);
        button = (Button)findViewById(R.id.buttonurl);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerupt();
            }
        });
    }

    private void obtenerupt() {


        new Thread(new Runnable() {
            @Override
            public void run() {

                final StringBuilder builder = new StringBuilder();

                try{
                    Document doc = Jsoup.connect("http://www.upt.edu.pe").get();


                    Elements links = doc.select("col-md-12");

                    for (Element link: links){
                        builder.append("Text: ").append(link.text());
                    }
                }catch (IOException e){
                    builder.append("Error: ").append(e.getMessage()).append("\n");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(builder.toString());
                    }
                });
            }
        }).start();



    }
}
