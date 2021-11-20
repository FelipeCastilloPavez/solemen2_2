package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import OBJETOS.Usuarios;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, contraseña;
    private TextView mensaje;
    private ProgressBar barra;
    private Button boton;

    Usuarios u1 = new Usuarios();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.et_usuario);
        contraseña = findViewById(R.id.et_contrasena);
        mensaje = findViewById(R.id.tv_mensaje);
        boton = findViewById(R.id.btn);
        barra = findViewById(R.id.pb);


        barra.setVisibility(View.INVISIBLE);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //corre mi tarea asincrona

                new Task().execute();
            }
        });


    }


    class Task extends AsyncTask<String, Void, String> {
        //donde podemos dar la configuracion inicial a mi tarea.
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        //es el encargado de procesar en segundo plano la tarea pesada
        @Override
        protected String doInBackground(String... strings) {

            try {
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(500); //duerme un proceso por 2 seg
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;

        }

        // es donde finaliza mi tarea asincrona.
        @Override
        // aqui va la validación
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            String user = usuario.getText().toString().trim();
            String pass = contraseña.getText().toString().trim();

            String Userus = u1.getUser().trim();
            String Passus = u1.getPass().trim();
            switch (user) {
                case "Felipe":
                    if (pass.equals(Passus ) && Userus.equals(user)) {
                        //inicia sesion
                        Intent i = new Intent(getBaseContext(), home_act.class);
                        startActivity(i);
                    }
                    break;
                case "":
                    if (pass.equals("")) {

                        //campos vacios
                        mensaje.setText("Los campos están vacíos");
                        barra.setVisibility(View.INVISIBLE);
                    }
                    break;

                default:
                    if (!user.equals(Userus) && !contraseña.equals(Passus)) {
                        //campos incorretos
                        mensaje.setText("Los campos son incorrectos. Intente nuevamente");
                        barra.setVisibility(View.INVISIBLE);
                    }
                    break;
            }


        }
    }


}