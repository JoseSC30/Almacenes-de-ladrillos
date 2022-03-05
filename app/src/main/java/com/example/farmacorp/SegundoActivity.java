package com.example.farmacorp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {
    ConstraintLayout layout;
    Button buttonConfirmar;
    TextView textoRecorrido;

    String cliente = "";
    String almacen = "";
    String rec = "";
    String recNombres = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        layout = (ConstraintLayout)findViewById(R.id.pantalla2);
        buttonConfirmar = (Button) findViewById(R.id.button5);
        textoRecorrido = (TextView) findViewById(R.id.textView2);

        cliente = getIntent().getStringExtra("clienteDestino");
        almacen = getIntent().getStringExtra("almacenOrigen");
        rec = getIntent().getStringExtra("datoRecorrido");
        recNombres = getIntent().getStringExtra("datoRecorridoNombres");
    }

    //Metodo boton Confirmar.
    public void Confirmar(View view) {
        mostrarMapa();
        mostrarRecorrido(view);
        buttonConfirmar.setVisibility(View.GONE);
    }

    public void mostrarMapa(){
        if(almacen.equals("ALMACEN 1")) {
            mostrarMapaAlmacen1();
        }
        if(almacen.equals("ALMACEN 2")) {
            mostrarMapaAlmacen2();
        }
        if(almacen.equals("ALMACEN 3")) {
            mostrarMapaAlmacen3();
        }
        if(almacen.equals("ALMACEN 4")) {
            mostrarMapaAlmacen4();
        }
    }
    @SuppressLint("SetTextI18n")
    public void mostrarRecorrido(View view){
        textoRecorrido.setText("El recorrido desde " + almacen +" hacia " + cliente + " es de " + rec + " metros y pasa por" +
                " " + recNombres);
    }

    public void mostrarMapaAlmacen1(){
        if(cliente.equals("Fe Ares")) {
            layout.setBackgroundResource(R.drawable.a1_c1);
        }
        if(cliente.equals("Fe Brasil")) {
            layout.setBackgroundResource(R.drawable.a1_c2);
        }
        if(cliente.equals("Fe Castro")) {
            layout.setBackgroundResource(R.drawable.a1_c3);
        }
        if(cliente.equals("Fe Dario")) {
            layout.setBackgroundResource(R.drawable.a1_c4);
        }
        if(cliente.equals("Fe Egos")) {
            layout.setBackgroundResource(R.drawable.a1_c5);
        }
        if(cliente.equals("Fe Fernandez")) {
            layout.setBackgroundResource(R.drawable.a1_c6);
        }
        if(cliente.equals("Fe Gomez")) {
            layout.setBackgroundResource(R.drawable.a1_c7);
        }
        if(cliente.equals("Fe Hidalgo")) {
            layout.setBackgroundResource(R.drawable.a1_c8);
        }
        if(cliente.equals("Fe Isuto")) {
            layout.setBackgroundResource(R.drawable.a1_c9);
        }
        if(cliente.equals("Fe Jimenez")) {
            layout.setBackgroundResource(R.drawable.a1_c10);
        }
    }
    public void mostrarMapaAlmacen2(){
        if(cliente.equals("Fe Ares")) {
            layout.setBackgroundResource(R.drawable.a2_c1);
        }
        if(cliente.equals("Fe Brasil")) {
            layout.setBackgroundResource(R.drawable.a2_c2);
        }
        if(cliente.equals("Fe Castro")) {
            layout.setBackgroundResource(R.drawable.a2_c3);
        }
        if(cliente.equals("Fe Dario")) {
            layout.setBackgroundResource(R.drawable.a2_c4);
        }
        if(cliente.equals("Fe Egos")) {
            layout.setBackgroundResource(R.drawable.a2_c5);
        }
        if(cliente.equals("Fe Fernandez")) {
            layout.setBackgroundResource(R.drawable.a2_c6);
        }
        if(cliente.equals("Fe Gomez")) {
            layout.setBackgroundResource(R.drawable.a2_c7);
        }
        if(cliente.equals("Fe Hidalgo")) {
            layout.setBackgroundResource(R.drawable.a2_c8);
        }
        if(cliente.equals("Fe Isuto")) {
            layout.setBackgroundResource(R.drawable.a2_c9);
        }
        if(cliente.equals("Fe Jimenez")) {
            layout.setBackgroundResource(R.drawable.a2_c10);
        }
    }
    public void mostrarMapaAlmacen3(){
        if(cliente.equals("Fe Ares")) {
            layout.setBackgroundResource(R.drawable.a3_c1);
        }
        if(cliente.equals("Fe Brasil")) {
            layout.setBackgroundResource(R.drawable.a3_c2);
        }
        if(cliente.equals("Fe Castro")) {
            layout.setBackgroundResource(R.drawable.a3_c3);
        }
        if(cliente.equals("Fe Dario")) {
            layout.setBackgroundResource(R.drawable.a3_c4);
        }
        if(cliente.equals("Fe Egos")) {
            layout.setBackgroundResource(R.drawable.a3_c5);
        }
        if(cliente.equals("Fe Fernandez")) {
            layout.setBackgroundResource(R.drawable.a3_c6);
        }
        if(cliente.equals("Fe Gomez")) {
            layout.setBackgroundResource(R.drawable.a3_c7);
        }
        if(cliente.equals("Fe Hidalgo")) {
            layout.setBackgroundResource(R.drawable.a3_c8);
        }
        if(cliente.equals("Fe Isuto")) {
            layout.setBackgroundResource(R.drawable.a3_c9);
        }
        if(cliente.equals("Fe Jimenez")) {
            layout.setBackgroundResource(R.drawable.a3_c10);
        }
    }
    public void mostrarMapaAlmacen4(){
        if(cliente.equals("Fe Ares")) {
            layout.setBackgroundResource(R.drawable.a4_c1);
        }
        if(cliente.equals("Fe Brasil")) {
            layout.setBackgroundResource(R.drawable.a4_c2);
        }
        if(cliente.equals("Fe Castro")) {
            layout.setBackgroundResource(R.drawable.a4_c3);
        }
        if(cliente.equals("Fe Dario")) {
            layout.setBackgroundResource(R.drawable.a4_c4);
        }
        if(cliente.equals("Fe Egos")) {
            layout.setBackgroundResource(R.drawable.a4_c5);
        }
        if(cliente.equals("Fe Fernandez")) {
            layout.setBackgroundResource(R.drawable.a4_c6);
        }
        if(cliente.equals("Fe Gomez")) {
            layout.setBackgroundResource(R.drawable.a4_c7);
        }
        if(cliente.equals("Fe Hidalgo")) {
            layout.setBackgroundResource(R.drawable.a4_c8);
        }
        if(cliente.equals("Fe Isuto")) {
            layout.setBackgroundResource(R.drawable.a4_c9);
        }
        if(cliente.equals("Fe Jimenez")) {
            layout.setBackgroundResource(R.drawable.a4_c10);
        }
    }

}