package com.example.farmacorp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Grafo2
{
    private HashMap<String, ArrayList<Nodo>> grafo;
    private boolean dirigido;
    public Grafo2(boolean dir){
        grafo = new HashMap<String,ArrayList<Nodo>>();
        dirigido=dir;
    }

    public void agregarArista(String orig, String dest, int costo){
        crearArista(orig,dest,costo);
        if(!dirigido){
            crearArista(dest,orig,costo);
        }
    }

    private void crearArista(String orig, String dest, int costo){
        if(!grafo.containsKey(orig)){
            grafo.put(orig,new ArrayList<Nodo>());
        }
        grafo.get(orig).add(new Nodo(dest,costo));
    }

    public void eliminarArista(String ori, String dest){
        elimArista(ori,dest);
        if(!dirigido){
            elimArista(dest,ori);
        }
    }

    public void elimArista(String ori, String dest){
        ArrayList<Nodo>lista = grafo.get(ori);
        boolean bb = false;
        if( lista!=null){
            for (int i=0; i<lista.size()&&bb;i++){
                Nodo ac= lista.get(i);
                if(ac.getVertice().equals(dest)){
                    lista.remove(i);
                    bb=true;
                }
            }
        }
    }

    public void agregarVertice(String v){
        grafo.put(v,new ArrayList<Nodo>());
    }
    public void eliminarVertice(String v){
        ArrayList<Nodo> lista = grafo.get(v);
        ArrayList<String> destinos = new ArrayList<>();
        for(Nodo n: lista){
            destinos.add(n.getVertice());
        }
        grafo.remove(v);
        for(String s:destinos){
            elimArista(s ,v);
        }
    }

    public HashMap<String,Integer>dijkstra(String vo){
        HashMap<String, Integer> dist = new HashMap<>();
        PriorityQueue<String> cola = new PriorityQueue<>();
        for(String k:grafo.keySet()){
            dist.put(k,Integer.MAX_VALUE);
        }
        dist.put(vo,0);
        cola.add(vo);
        while(!cola.isEmpty()){
            String ac = cola.poll();
            ArrayList<Nodo> vecinos = grafo.get(ac);
            if (vecinos!=null){
                for(Nodo n: vecinos){
                    String vertSig=n.getVertice();
                    int costo = n.getCosto();
                    if (dist.get(ac)+costo<dist.get(vertSig)){
                        dist.put(vertSig,dist.get(ac)+costo);
                        cola.offer(vertSig);
                    }
                }
            }
        }
        return dist;
    }
    public int caminoMasCorto(String vo, String vd){
        int sum=0;
        HashMap<String,Integer> mapa = this.dijkstra(vo);
        sum = mapa.get(vd);
        return sum;
    }
}
