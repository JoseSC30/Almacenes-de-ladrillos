package com.example.farmacorp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Grafo
{
    private Lista LVertices;

    public Grafo() {
        LVertices = new Lista();
    }

    public void crearVertice(String nomV){
        LVertices.insertarUlt(new Vertice(nomV));
    }

    public Vertice buscarVertice(String nomV)//Busca al vertice por su NOMBRE.
    {
        Vertice vertice;
        int i=0;
        while (i<LVertices.dim())
        {
            vertice =(Vertice)LVertices.getElem(i);
            if (vertice.getNombre().equals(nomV))
                return vertice;
            i++;
        }
        return null;
    }

    public void insertarArco(String X,String Y, float co)//X = Vertice Origen.
    {                                                    //Y = Vertice Destino.
        Vertice vo = buscarVertice(X);                   //co = Costo del viaje.
        Vertice vd = buscarVertice(Y);
        vo.insertarArco(new Arco(vd, co));
    }

//    public void imprimir(JTextArea jta){
//        int i = 0; Vertice v; Arco a;
//        while (i < LVertices.dim())
//        {
//            v = (Vertice)LVertices.getElem(i);//Toma un VERTICE de la lista de vertices.
//            int j=0;
//            while (j<v.LArcos.dim())//Recorre cada uno de los ARCOS del VERTICE i.
//            {
//                jta.append(v.getNombre());
//                jta.append("-->");
//                a = (Arco)v.LArcos.getElem(j); //Muestra el arco donde apunto
//                jta.append(a.getNombreVertD() + "  " + a.getCosto());
//                jta.append("\n");
//                j++;
//            }
//            i++;
//        }
//    }

    public float peso()//SUMA DE TODOS LOS COSTOS.
    {
        int i = 0;
        Vertice v; float s = 0;
        while (i < LVertices.dim())
        {
            v = (Vertice)LVertices.getElem(i);
            int j=0; Arco a;
            while(j < v.LArcos.dim())
            {
                a=(Arco)v.LArcos.getElem(j);
                s = s + a.getCosto();
                j++;
            }
            i++;
        }
        return s;
    }



    public void desmarcarTodos()
    {
        for(int i=0;i<this.LVertices.dim();i++){
            Vertice v=(Vertice)this.LVertices.getElem(i);
            v.marcado=false;
        }
    }

    public void ordenarVerticesAlf() {
        Vertice aux; Vertice v1; Vertice v2;
        for(int i=0;i<LVertices.dim();i++){
            for(int j=0;j<LVertices.dim()-1;j++){
                v1=(Vertice)LVertices.getElem(j);
                v2=(Vertice)LVertices.getElem(j+1);
                if(v1.getNombre().compareTo(v2.getNombre())>0){
                    aux=(Vertice)LVertices.getElem(j);
                    LVertices.setElem(v2, j);
                    LVertices.setElem(aux, j+1);
                }
            }
        }
        for(int i=0;i<LVertices.dim();i++){
            Vertice v=(Vertice)LVertices.getElem(i);
            v.ordenarArcosAlf();
        }
    }

//    public void DFS(String A, JTextArea jta){
//        jta.append("DFS: ");
//        desmarcarTodos();
//        ordenarVerticesAlf();
//        Vertice v = buscarVertice(A);
//        dfs(v,  jta);
//        jta.append("\n");
//    }
//
//    private void dfs(Vertice v, JTextArea jta){
//        jta.append(v.getNombre() + " ");
//        v.marcado=true;
//        Arco a;
//        for (int i = 0; i < v.LArcos.dim(); i++) {
//            a = (Arco) v.LArcos.getElem(i);
//            Vertice w = buscarVertice(a.getNombreVertD());
//            if(!w.marcado)
//                dfs(w, jta);
//        }
//    }



//    public void BFS(String s,JTextArea jta)
//    {
//        desmarcarTodos();
//        ordenarVerticesAlf();
//        Arco a;
//        Vertice v = buscarVertice(s), w;
//        LinkedList <Vertice> C;
//        C=new LinkedList<Vertice>();
//        C.add(v);
//        v.marcado=true;
//        jta.append("BFS: ");
//        do{
//            v = C.pop();
//            jta.append(v.getNombre() + " ");
//            for (int i = 0; i < v.LArcos.dim(); i++) {
//                a = (Arco) v.LArcos.getElem(i);
//                w = buscarVertice(a.getNombreVertD());
//                if (!w.marcado) {
//                    C.add(w);
//                    w.marcado=true;
//                }
//            }
//        }while (!C.isEmpty());
//        jta.append("\n");
//    }

    public boolean existeCamino(String x, String y) {
        desmarcarTodos();
        Vertice v = buscarVertice(x);
        return existeCamino(v, y);
    }

    private boolean existeCamino(Vertice v, String y) {
        v.marcado = true;
        Arco a;
        for (int i = 0; i < v.LArcos.dim(); i++) {
            a = (Arco) v.LArcos.getElem(i);
            Vertice v2 = buscarVertice(a.getNombreVertD());
            if(!v2.marcado) {
                if(v2.getNombre().equals(y)) {
                    return true;
                } else {
                    if(existeCamino(v2, y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public HashMap<String,Integer> dijkstra(String vo){
        HashMap<String, Integer> dist = new HashMap<>();
        PriorityQueue<String> cola = new PriorityQueue<>();

        Vertice vertice;
        int i=0;
        while (i<LVertices.dim()) {
            vertice =(Vertice)LVertices.getElem(i);
            dist.put(vertice.getNombre(),Integer.MAX_VALUE);
            i++;
        }

        dist.put(vo,0);
        cola.add(vo);
        while(!cola.isEmpty()){
            String ac = cola.poll();

            Lista vecinos = buscarVertice(ac).LArcos;
            if (vecinos!=null){
                Arco n;
                int e = 0;
                while (e < vecinos.dim()) {
                    n = (Arco)vecinos.getElem(e);
                    String verticeSiguiente = n.getNombreVertD();
                    int costo = (int) n.getCosto();
                    if (dist.get(ac)+costo < dist.get(verticeSiguiente)){
                        dist.put(verticeSiguiente, dist.get(ac) + costo);
                        cola.offer(verticeSiguiente);
                    }
                    e++;
                }
            }
        }
        return dist;
    }

    public int caminoMasCorto(String vo, String vd){
        int sum = 0;
        HashMap<String,Integer> mapa = this.dijkstra(vo);
        sum = mapa.get(vd);
        return sum;
    }

//Hacer cantidad de caminos.
//    public int cantidadCaminos( String x, String y) {
//        if(buscarVertice(x) != null && buscarVertice(y) == null) {
//            desmarcarTodos();
//            Vertice v = buscarVertice(x);
//            return cantidadCaminos(v,y);
//        } else {
//            return -1;
//        }
//    }

//    private int cantidadCaminos(Vertice v, String y) {
//        v.marcado = true;
//        Arco a;
//        for(int i = 0; i < v.LArcos.dim(); i++) {
//            a = (Arco) v.LArcos.getElem(i);
//            Vertice v2 = buscarVertice(a.getNombreVertD());
//            if(!v2.marcado) {
//                if(v2.getNombre().equals(y)) {
//                    c = c +1;
//                } else {
//                    c = c + cantidadCaminos(v2,y);
//                    v2.marcado
//                }
//            }
//        }
//    }
//
//    public boolean conexo() {
//        int i = 0;
//        while(i < this.LVertices.dim()) {
//            int j = 0;
//            Vertice vd = (VerticeLVertices);
//        }
//    }
//
//    public iguales(){
//
//    }

}  //end class
