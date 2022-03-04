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
    String rec = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        layout = (ConstraintLayout)findViewById(R.id.pantalla2);
        buttonConfirmar = (Button) findViewById(R.id.button5);
        textoRecorrido = (TextView) findViewById(R.id.textView2);

        cliente = getIntent().getStringExtra("clienteDestino");
        rec = getIntent().getStringExtra("datoRecorrido");
    }

    //Metodo boton atras.
    public void Atras(View view) {
        Intent atras = new Intent(this, MainActivity.class);
        startActivity(atras);
    }
    //Metodo boton Confirmar.
    public void Confirmar(View view) {
        mostrarMapa();
        mostrarRecorrido(view);
        buttonConfirmar.setVisibility(View.GONE);
    }

    public void mostrarMapa(){
        if(cliente.equals("Hospital Jesús")) {
            layout.setBackgroundResource(R.drawable.mapa002);
            layout.setMaxHeight(1800);
        }
        if(cliente.equals("Construcción Banco FIE")) {
            layout.setBackgroundResource(R.drawable.mapa001);
            layout.setMaxHeight(1800);
        }
        //NOTA: faltan mas mapas por mostrar.
    }
    @SuppressLint("SetTextI18n")
    public void mostrarRecorrido(View view){
        textoRecorrido.setText("El recorrido hacia " + cliente + " es de " + rec + " metros.");
    }

}