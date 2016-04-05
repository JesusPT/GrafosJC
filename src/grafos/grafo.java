/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author J. P. Toledo
 */
public class grafo {
   public Nodo inicio;
   Nodo ulti;
   boolean Tipo;
   public void agregarEstado(Nodo nuevo){
       if(inicio == null){
           inicio = nuevo;
           ulti = nuevo;
       }else{
           ulti.Sigui = nuevo;
           ulti = nuevo;
       }
   }
   
   public void enlace(Nodo Origen, Nodo Destino){
       if(Origen.ListaAdy == null){
           Origen.ListaAdy = new listAdy();
           Origen.ListaAdy.nuevo(Destino);
       }else{
           Origen.ListaAdy.nuevo(Destino);
       }
       
       
   }
   
   public void elementosLista(String Dato){
       Nodo Estado = inicio;
       while(Estado != null){
           if(Estado.Dato.equals(Dato)){
               Estado.ListaAdy.elementos();
           }
           Estado = Estado.Sigui;
       }
       
   }
   
   public Nodo estado(String nom){
       Nodo Estado = inicio;
       while(Estado != null){
           if(Estado.Nombre.equals(nom)){
               return Estado;
           }
           Estado = Estado.Sigui;
       }
       return null;
   }
   
   //aqui voy a hacer el metodo para eliminar
   
}
