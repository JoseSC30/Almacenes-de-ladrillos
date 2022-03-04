package com.example.farmacorp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String clienteElegido;
    String almacenElegido;
    String recorrido;

    Spinner spinnerAlmacenes;
    Spinner spinnerClientes;
    Grafo2 Grafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Grafo = new Grafo2(true);
        cargarDatosAlGrafo();

        spinnerAlmacenes= findViewById(R.id.spinner);
        spinnerClientes = findViewById(R.id.spinner2);

        ArrayList<String> almacenesArrayList = new ArrayList<String>();
        almacenesArrayList.add("ALMACEN 1");
        almacenesArrayList.add("ALMACEN 2");
        almacenesArrayList.add("ALMACEN 3");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,almacenesArrayList);
        spinnerAlmacenes.setAdapter(adapter);
        spinnerAlmacenes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                llenarSpinnerClientes();
                almacenElegido = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    private void llenarSpinnerClientes(){

        ArrayList<String> clientesArrayList = new ArrayList<String>();
        clientesArrayList.add("Hospital Jesús");
        clientesArrayList.add("Construcción Banco FIE");
        clientesArrayList.add("Ferreteria CAMACHO");
        clientesArrayList.add("Ferreteria Las Lomas");
        clientesArrayList.add("Ferreteria Don Carlos");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,clientesArrayList);
        spinnerClientes.setAdapter(adapter2);
        spinnerClientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                clienteElegido = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    public void Siguiente(View view) {
            recorrido = obtenerRecorridoCorto(almacenElegido, clienteElegido);
            Intent siguiente = new Intent(this, SegundoActivity.class);
            siguiente.putExtra("clienteDestino", clienteElegido);
            siguiente.putExtra("datoRecorrido", recorrido);
            startActivity(siguiente);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea cerrar la aplicación?")
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });
            builder.show();
                    return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void cargarDatosAlGrafo() {
        Grafo.agregarVertice("uno");
        Grafo.agregarVertice("dos");
        Grafo.agregarVertice("tres");
        Grafo.agregarVertice("cuatro");
        Grafo.agregarVertice("cinco");
        Grafo.agregarVertice("seis");
        Grafo.agregarVertice("siete");
        Grafo.agregarVertice("ocho");
        Grafo.agregarVertice("nueve");
        Grafo.agregarVertice("diez");
        Grafo.agregarVertice("Hospital Jesús");
        Grafo.agregarVertice("Construcción Banco FIE");
        Grafo.agregarVertice("Ferreteria CAMACHO");
        Grafo.agregarVertice("Ferreteria Las Lomas");
        Grafo.agregarVertice("Ferreteria Don Carlos");
        Grafo.agregarVertice("ALMACEN 1");

        Grafo.agregarArista("uno","nueve",100);
        Grafo.agregarArista("dos","uno",200);
        Grafo.agregarArista("dos","siete",500);
        Grafo.agregarArista("tres","cuatro",300);
        Grafo.agregarArista("tres","ALMACEN 1",200);
        Grafo.agregarArista("cuatro","cinco",200);
        Grafo.agregarArista("cuatro","Ferreteria CAMACHO",300);
        Grafo.agregarArista("cinco","ocho", 200);
        Grafo.agregarArista("seis","Ferreteria Las Lomas",700);
        Grafo.agregarArista("siete","diez",200);
        Grafo.agregarArista("siete","Construcción Banco FIE",100);
        Grafo.agregarArista("siete","Ferreteria Don Carlos",400);
        Grafo.agregarArista("ocho","Ferreteria Las Lomas",900);
        Grafo.agregarArista("nueve","seis",300);
        Grafo.agregarArista("nueve","Hospital Jesús",900);
        Grafo.agregarArista("diez","tres",600);
        Grafo.agregarArista("Hospital Jesús","Ferreteria Don Carlos",700);
        Grafo.agregarArista("Ferreteria CAMACHO","ocho",800);
        Grafo.agregarArista("ALMACEN 1","dos",800);
        Grafo.agregarArista("ALMACEN 1","nueve",400);
        Grafo.agregarArista("ALMACEN 1","cinco",500);
    }

    public String obtenerRecorridoCorto(String origen, String destino){
        int res = Grafo.caminoMasCorto(origen, destino);
        return Integer.toString(res);
    }
}