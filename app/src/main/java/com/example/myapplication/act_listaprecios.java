package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import OBJETOS.lista_precios;

public class act_listaprecios extends AppCompatActivity {
    private Spinner lista_precios;
    private TextView resultado;
    private RatingBar rb;
    private lista_precios lp = new lista_precios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_listaprecios);

        lista_precios = findViewById(R.id.spn_cortes);
        resultado = findViewById(R.id.tv_calculo);
        rb=findViewById(R.id.rb_cortes);


        //recibo el bundle
        Bundle bun = getIntent().getExtras();
        String[] listado = bun.getStringArray("lista");

        ArrayAdapter adaptCortes = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listado);
        lista_precios.setAdapter(adaptCortes);
    }


    public void calculo(View view)
    {
        int result=0;

       String opcion = lista_precios.getSelectedItem().toString();

       for (int i = 0; i< opcion.length(); i++)
       {
           if (opcion.equals(lp.getCortes()[i]))
               result = lp.getPrecios()[i];
           rb.setRating(i);
               break;

       }
        resultado.setText("LA OPCION ES: " + opcion + "\n SU PRECIO ES: $" + result);
    }

}