/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;

/**
 *
 * @author J. P. Toledo
 */
public class listAdy {
    public Nodo Inicio;
    public Nodo Fin;
    
    void nuevo(Nodo nuevo){
        Nodo aux = new Nodo(nuevo.Dato,nuevo.GUINodo,nuevo.c,nuevo.Heuristica,nuevo.Peso, nuevo.Nombre);
        //Nodo aux = nuevo;
        if(Inicio == null){
           Inicio = aux;
           Fin = aux;
        }else{
            Fin.SiguiList = aux;
            Fin = aux;
        }
        
    }
    
    public boolean existe(String Nombre){
        Nodo aux = Inicio;
        while(aux != null){
            if(aux.Nombre.equals(Nombre)){
                return true;
            }
            aux = aux.SiguiList;
        }
        return false;
    }
    
    public Nodo getNodo(String Nombre){
        Nodo aux = Inicio;
        while(aux != null){
            if(aux.Nombre.equals(Nombre)){
                return aux;
            }
            aux = aux.SiguiList;
        }
        return null;
    }
    
    public void removerNodo(String Eliminando){
        Nodo puntero = Inicio;
        Nodo anterior = Inicio;
        if(Inicio.Nombre.equals(Eliminando)){
            Inicio=puntero.SiguiList;
            puntero=null;
        }
        else{
            while(puntero != null){
                if(puntero.Nombre.equals(Eliminando)){
                    System.out.println("Enontrado"+puntero.getNombre());
                    if(Fin.Nombre.equals(puntero.Nombre)){
                        Fin=anterior;
                        Fin.SiguiList=null;
                        puntero=null;
                    }
                    else
                    {
                      anterior.SiguiList=puntero.SiguiList; 
                      puntero=null;
                    }
                }
                else{
                 anterior=puntero;
                 puntero=puntero.SiguiList;   
                }
            }
        }
    }
    
    void elementos(){
        Nodo aux = Inicio;
        while(aux != null){
            System.out.println(aux.Nombre);
            aux = aux.SiguiList;
        }
    }
    
    ArrayList getElementos(){
        ArrayList<Nodo> elementos = new ArrayList();
        Nodo aux = Inicio;
        while(aux != null){
            elementos.add(aux);
            aux = aux.SiguiList;
        }
        return elementos;
    }
}
