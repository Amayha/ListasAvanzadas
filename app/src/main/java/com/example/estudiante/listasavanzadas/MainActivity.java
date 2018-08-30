package com.example.estudiante.listasavanzadas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv_noticias;
    NoticiaAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_noticias= findViewById(R.id.lv_noticias);
        customAdapter = new NoticiaAdapter(this);

        lv_noticias.setAdapter(customAdapter);

        Noticia noticia1 = new Noticia("Se cambia el logo de HED", "Van a hacer un cambiazo en ese logo", "30/08/2018");

        customAdapter.agregarNoticia(noticia1);

        lv_noticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {// con ctrl click sale lo que debe ir en ()
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Noticia noticia_click = (Noticia) customAdapter.getItem(position);// se debe castear porque get item devuelve un object
                Toast.makeText(MainActivity.this, noticia_click.getTitulo(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
