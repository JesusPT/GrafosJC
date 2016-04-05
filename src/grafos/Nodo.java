/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.awt.Color;
import java.awt.geom.Ellipse2D;



/**
 *
 * @author J. P. Toledo
 */
public class Nodo {
    
    public Ellipse2D GUINodo = new Ellipse2D.Float(50f, 50f, 50f, 50f);
    public Color c;
    public listAdy ListaAdy;
    
    public Nodo Sigui;
    public Nodo SiguiList;
    
    String Dato;
    String Nombre;
    
    int Peso = 0;
    int Heuristica = 0;
  
    public Nodo(String Info){
        Dato = Info;
    }
    
    public Nodo(String Info,int peso,int heu,String Nom){
        Dato = Info;
        Peso = peso;
        Heuristica = heu;
        Nombre = Nom;
    }

    public Nodo(String Info,int peso,int heu,String Nom, Color color) {
        Dato = Info;
        Peso = peso;
        Heuristica = heu;
        Nombre = Nom;
        c = color;
        
    }

    Nodo(String Dato, Ellipse2D GUINodo, Color c, int Heuristica, int Peso, String Nombre) {
        this.Dato = Dato;
        this.GUINodo = GUINodo;
        this.c = c;
        this.Nombre = Nombre;
        this.Heuristica = Heuristica;
        this.Peso = Peso;
    }
    
    
    public String getNombre(){
        return Nombre;
    }
    
    public int getHeuristica(){
        return Heuristica;
    }
    
    public int getPeso(){
        return Peso;
    }
    
    public String getInfo(){
        return Dato;
    }
    
    public Color getColor(){
       return c;
   }

    //public Nodo() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
   
   public void setColor(Color co){
       c = co;
   }
   
   public void setPeso(int Peso){
       this.Peso = Peso;
   }
   
   public void setHeuristica(int Heuristica){
       this.Heuristica = Heuristica;
   }
   
   public void setInfo(String Dato){
       this.Dato = Dato;
   }
   
   
    
}
