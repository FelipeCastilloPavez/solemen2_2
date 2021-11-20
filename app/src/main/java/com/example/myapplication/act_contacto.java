package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class act_contacto extends AppCompatActivity {
    private ImageButton llamada;
    private ImageButton ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_info);

        llamada=findViewById(R.id.ib_llamada);
        ubicacion=findViewById(R.id.ib_ubicacion);
    }

    public void llamar(View view){
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+"+99123456"));
        startActivity(i);
    }
}