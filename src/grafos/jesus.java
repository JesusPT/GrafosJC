/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;

/**
 *
 * @author MakotoYumi
 */
public class jesus {
    
    ArrayList Abierto = new ArrayList();
    ArrayList Cerrados = new ArrayList();
    Nodo n;
    Nodo destino;
    grafo g;
    int mejorCamino = 9999;
    
    public void primeroElMejor(grafo g,Nodo d){
        this.g = g;
        destino = d;
        Abierto.add(g.inicio);
        int cuenta=0;
        n = g.inicio;
        while(Abierto.size()>0 && n.Nombre != destino.Nombre){
            n = (Nodo) Abierto.get(Abierto.size()-1);
            Abierto.remove(n);
            Cerrados.add(n);
            expandir(n);
            cuenta+=n.Heuristica;
            if(n.Nombre == destino.Nombre && mejorCamino>cuenta){
                mejorCamino = cuenta;
                cuenta=0;
            }
            
        }
        
        
    }
    
    //Expandir
    void expandir(Nodo exp){
        try{
            ArrayList<Nodo> agregar = g.estado(exp.Nombre).ListaAdy.getElementos();

            agregar = burbuja(agregar);

            for (int i = agregar.size()-1; i >= 0; i--) {
                Abierto.add(agregar.get(i));
            }
        }catch(NullPointerException e){
            System.out.println("No hay lista para " + exp.Nombre);
        }
        
        
    }
    
    ArrayList burbuja(ArrayList<Nodo> orden){
        
        Nodo aux;
        
        for (int i = 0; i < orden.size(); i++) {
            for (int j = 0; j < orden.size() - 1; j++) {
                if(orden.get(j).getHeuristica()>orden.get(j + 1).getHeuristica()){
                    aux = orden.get(j);
                    orden.set(j, orden.get(j + 1));
                    orden.set(j + 1, aux);
                }
            }
        }
        return orden;
    }
    
    
    
    //Coste del Camino
    void g(){
        
    }
    
    //Funcion heuristica
    void h(){
        
    }
    
    //Funcion de evalucacion Primero el mejor
    void f(int h){
        //f(n) = h(n) (Voraz primero el mejor)
        
        
    }
    
    void f(int h, int g){
        //f(n) = g(n)+h(n) (A*)
        
        
    }
}
