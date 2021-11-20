package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import OBJETOS.lista_precios;

public class home_act extends AppCompatActivity {
    lista_precios lista = new lista_precios();
    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vv=findViewById(R.id.videoView);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);

        vv.setVideoURI(uri);

        //controles del video.

        MediaController media = new MediaController(this);
        vv.setMediaController(media);

    }


        public void precios(View view){

            Intent i = new Intent(this,act_listaprecios.class);
            Bundle bun = new Bundle();
            bun.putStringArray("lista", lista.getCortes());
            i.putExtras(bun);
            startActivity(i);

        }

        public void info(View view){

            Intent i = new Intent(this, act_contacto.class);
            startActivity(i);
        }
}

