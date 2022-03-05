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
    String recorridoNombres;

    Spinner spinnerAlmacenes;
    Spinner spinnerClientes;
    Grafo Grafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Grafo = new Grafo();
        cargarDatosAlGrafo();

        spinnerAlmacenes= findViewById(R.id.spinner);
        spinnerClientes = findViewById(R.id.spinner2);

        ArrayList<String> almacenesArrayList = new ArrayList<String>();
        almacenesArrayList.add("ALMACEN 1");
        almacenesArrayList.add("ALMACEN 2");
        almacenesArrayList.add("ALMACEN 3");
        almacenesArrayList.add("ALMACEN 4");

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
        clientesArrayList.add("Fe Ares");
        clientesArrayList.add("Fe Brasil");
        clientesArrayList.add("Fe Castro");
        clientesArrayList.add("Fe Dario");
        clientesArrayList.add("Fe Egos");
        clientesArrayList.add("Fe Fernandez");
        clientesArrayList.add("Fe Gomez");
        clientesArrayList.add("Fe Hidalgo");
        clientesArrayList.add("Fe Isuto");
        clientesArrayList.add("Fe Jimenez");
        clientesArrayList.add("Fe Konami");
        clientesArrayList.add("Fe Leon");
        clientesArrayList.add("Fe Mamore");
        clientesArrayList.add("Fe Nordelta");
        clientesArrayList.add("Fe Oruro");
        clientesArrayList.add("Fe Pando");
        clientesArrayList.add("Fe Quintana");
        clientesArrayList.add("Fe Ramirez");
        clientesArrayList.add("Fe Santa Cruz");
        clientesArrayList.add("Fe Torno");

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
            recorridoNombres = obtenerRecorridoCortoNombres(almacenElegido, clienteElegido);

            Intent siguiente = new Intent(this, SegundoActivity.class);
            siguiente.putExtra("clienteDestino", clienteElegido);
            siguiente.putExtra("datoRecorrido", recorrido);
            siguiente.putExtra("datoRecorridoNombres", recorridoNombres);
            siguiente.putExtra("almacenOrigen", almacenElegido);
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
//        Grafo.crearVertice("uno");
//        Grafo.crearVertice("dos");
//        Grafo.crearVertice("tres");
//        Grafo.crearVertice("cuatro");
//        Grafo.crearVertice("cinco");
//        Grafo.crearVertice("seis");
//        Grafo.crearVertice("siete");
//        Grafo.crearVertice("ocho");
//        Grafo.crearVertice("nueve");
//        Grafo.crearVertice("diez");
//        Grafo.crearVertice("Hospital Jesús");
//        Grafo.crearVertice("Construcción Banco FIE");
//        Grafo.crearVertice("Ferreteria CAMACHO");
//        Grafo.crearVertice("Ferreteria Las Lomas");
//        Grafo.crearVertice("Ferreteria Don Carlos");
//        Grafo.crearVertice("ALMACEN 1");
//
//        Grafo.insertarArco("uno","nueve",100);
//        Grafo.insertarArco("dos","uno",200);
//        Grafo.insertarArco("dos","siete",500);
//        Grafo.insertarArco("tres","cuatro",300);
//        Grafo.insertarArco("tres","ALMACEN 1",200);
//        Grafo.insertarArco("cuatro","cinco",200);
//        Grafo.insertarArco("cuatro","Ferreteria CAMACHO",300);
//        Grafo.insertarArco("cinco","ocho", 200);
//        Grafo.insertarArco("seis","Ferreteria Las Lomas",700);
//        Grafo.insertarArco("siete","diez",200);
//        Grafo.insertarArco("siete","Construcción Banco FIE",100);
//        Grafo.insertarArco("siete","Ferreteria Don Carlos",400);
//        Grafo.insertarArco("ocho","Ferreteria Las Lomas",900);
//        Grafo.insertarArco("nueve","seis",300);
//        Grafo.insertarArco("nueve","Hospital Jesús",900);
//        Grafo.insertarArco("diez","tres",600);
//        Grafo.insertarArco("Hospital Jesús","Ferreteria Don Carlos",700);
//        Grafo.insertarArco("Ferreteria CAMACHO","ocho",800);
//        Grafo.insertarArco("ALMACEN 1","dos",800);
//        Grafo.insertarArco("ALMACEN 1","nueve",400);
//        Grafo.insertarArco("ALMACEN 1","cinco",500);

        Grafo.crearVertice("ALMACEN 1");
        Grafo.crearVertice("ALMACEN 2");
        Grafo.crearVertice("ALMACEN 3");
        Grafo.crearVertice("ALMACEN 4");
        Grafo.crearVertice("Fe Ares");
        Grafo.crearVertice("Fe Brasil");
        Grafo.crearVertice("Fe Castro");
        Grafo.crearVertice("Fe Dario");
        Grafo.crearVertice("Fe Egos");
        Grafo.crearVertice("Fe Fernandez");
        Grafo.crearVertice("Fe Gomez");
        Grafo.crearVertice("Fe Hidalgo");
        Grafo.crearVertice("Fe Isuto");
        Grafo.crearVertice("Fe Jimenez");
        Grafo.crearVertice("Fe Konami");
        Grafo.crearVertice("Fe Leon");
        Grafo.crearVertice("Fe Mamore");
        Grafo.crearVertice("Fe Nordelta");
        Grafo.crearVertice("Fe Oruro");
        Grafo.crearVertice("Fe Pando");
        Grafo.crearVertice("Fe Quintana");
        Grafo.crearVertice("Fe Ramirez");
        Grafo.crearVertice("Fe Santa Cruz");
        Grafo.crearVertice("Fe Torno");
        Grafo.insertarArco("ALMACEN 1", "Fe Brasil", 1700);
        Grafo.insertarArco("ALMACEN 1", "Fe Castro", 2100);
        Grafo.insertarArco("ALMACEN 1", "Fe Dario", 3200);
        Grafo.insertarArco("ALMACEN 1", "Fe Hidalgo", 1400);
        Grafo.insertarArco("ALMACEN 1", "Fe Konami", 2600);
        Grafo.insertarArco("ALMACEN 1", "Fe Leon", 2800);
        Grafo.insertarArco("ALMACEN 1", "Fe Mamore", 2900);
        Grafo.insertarArco("ALMACEN 2", "Fe Egos", 1700);
        Grafo.insertarArco("ALMACEN 2", "Fe Fernandez", 600);
        Grafo.insertarArco("ALMACEN 2", "ALMACEN 3", 2400);
        Grafo.insertarArco("ALMACEN 2", "Fe Gomez", 2600);
        Grafo.insertarArco("ALMACEN 3", "ALMACEN 2", 2600);
        Grafo.insertarArco("ALMACEN 3", "Fe Quintana", 3200);
        Grafo.insertarArco("ALMACEN 3", "Fe Pando", 3200);
        Grafo.insertarArco("ALMACEN 3", "Fe Ramirez", 2900);
        Grafo.insertarArco("ALMACEN 3", "Fe Nordelta", 2200);
        Grafo.insertarArco("ALMACEN 3", "Fe Jimenez", 2400);
        Grafo.insertarArco("ALMACEN 3", "Fe Isuto", 2400);
        Grafo.insertarArco("ALMACEN 3", "Fe Dario", 3400);
        Grafo.insertarArco("ALMACEN 3", "Fe Fernandez", 2400);
        Grafo.insertarArco("ALMACEN 4", "Fe Konami", 1000);
        Grafo.insertarArco("ALMACEN 4", "Fe Jimenez", 2000);
        Grafo.insertarArco("ALMACEN 4", "Fe Nordelta", 4100);
        Grafo.insertarArco("ALMACEN 4", "Fe Oruro", 2700);
        Grafo.insertarArco("ALMACEN 4", "Fe Torno", 3200);
        Grafo.insertarArco("Fe Brasil", "Fe Ares", 2500);
        Grafo.insertarArco("Fe Castro", "Fe Ares", 1600);
        Grafo.insertarArco("Fe Castro", "Fe Brasil", 2400);
        Grafo.insertarArco("Fe Castro", "Fe Egos", 3200);
        Grafo.insertarArco("Fe Dario", "Fe Castro", 1800);
        Grafo.insertarArco("Fe Dario", "Fe Egos", 2600);
        Grafo.insertarArco("Fe Dario", "Fe Fernandez", 2200);
        Grafo.insertarArco("Fe Dario", "ALMACEN 3", 3200);
        Grafo.insertarArco("Fe Dario", "Fe Isuto", 2300);
        Grafo.insertarArco("Fe Dario", "Fe Hidalgo", 1600);
        Grafo.insertarArco("Fe Egos", "Fe Gomez", 2500);
        Grafo.insertarArco("Fe Egos", "Fe Fernandez", 2000);
        Grafo.insertarArco("Fe Egos", "Fe Castro", 3500);
        Grafo.insertarArco("Fe Fernandez", "ALMACEN 2", 600);
        Grafo.insertarArco("Fe Fernandez", "Fe Dario", 1400);
        Grafo.insertarArco("Fe Hidalgo", "ALMACEN 1", 1000);
        Grafo.insertarArco("Fe Hidalgo", "Fe Isuto", 900);
        Grafo.insertarArco("Fe Hidalgo", "Fe Konami", 2200);
        Grafo.insertarArco("Fe Isuto", "Fe Hidalgo", 900);
        Grafo.insertarArco("Fe Isuto", "Fe Dario", 2000);
        Grafo.insertarArco("Fe Isuto", "ALMACEN 3", 2300);
        Grafo.insertarArco("Fe Isuto", "Fe Jimenez", 1300);
        Grafo.insertarArco("Fe Isuto", "Fe Konami", 2300);
        Grafo.insertarArco("Fe Jimenez", "Fe Isuto", 1500);
        Grafo.insertarArco("Fe Jimenez", "ALMACEN 3", 2300);
        Grafo.insertarArco("Fe Jimenez", "Fe Nordelta", 4100);
        Grafo.insertarArco("Fe Jimenez", "Fe Konami", 1700);
        Grafo.insertarArco("Fe Konami", "Fe Leon", 1600);
        Grafo.insertarArco("Fe Konami", "ALMACEN 1", 2300);
        Grafo.insertarArco("Fe Konami", "Fe Hidalgo", 2600);
        Grafo.insertarArco("Fe Konami", "Fe Isuto", 2100);
        Grafo.insertarArco("Fe Konami", "ALMACEN 4", 2800);
        Grafo.insertarArco("Fe Leon", "Fe Mamore", 2400);
        Grafo.insertarArco("Fe Leon", "Fe Torno", 2800);
        Grafo.insertarArco("Fe Leon", "ALMACEN 4", 2600);
        Grafo.insertarArco("Fe Nordelta", "ALMACEN 3", 2000);
        Grafo.insertarArco("Fe Nordelta", "Fe Pando", 3800);
        Grafo.insertarArco("Fe Nordelta", "Fe Ramirez", 1500);
        Grafo.insertarArco("Fe Nordelta", "Fe Oruro", 3500);
        Grafo.insertarArco("Fe Nordelta", "ALMACEN 4", 2700);
        Grafo.insertarArco("Fe Oruro", "Fe Torno", 2400);
        Grafo.insertarArco("Fe Oruro", "Fe Santa Cruz", 3400);
        Grafo.insertarArco("Fe Pando", "Fe Quintana", 1500);
        Grafo.insertarArco("Fe Ramirez", "Fe Pando", 2500);
        Grafo.insertarArco("Fe Ramirez", "Fe Santa Cruz", 2700);
        Grafo.insertarArco("Fe Torno", "Fe Oruro", 2800);
    }

    public String obtenerRecorridoCorto(String origen, String destino){
        int res = Grafo.caminoMasCorto(origen, destino);
        return Integer.toString(res);
    }

    public String obtenerRecorridoCortoNombres(String origen, String destino){
        String res = Grafo.caminoMasCortoNombres(origen, destino);
        return res;
    }
}