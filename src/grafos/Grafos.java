package grafos;

import java.awt.Color;
import java.util.Random;


/**
 *
 * @author J. P. Toledo
 */
public class Grafos {
    static grafo g = new grafo("Lol");    
    static Random rand = new Random();
    static jesus j = new jesus();
    
    /**
     * @param args the command line arguments
     * Metodo Main de la clase que contiene la ventana principal
     */
    public static void main(String[] args) {
        int i = 1;
        g.agregarEstado(new Nodo("A", 0, 0, "Nodo"+i,new Color(rand.nextInt(255)+1, rand.nextInt(255)+1, rand.nextInt(255)+1)));
        i++;
        g.agregarEstado(new Nodo("B", 0, 0, "Nodo"+i,new Color(rand.nextInt(255)+1, rand.nextInt(255)+1, rand.nextInt(255)+1)));
        i++;
        g.agregarEstado(new Nodo("C", 0, 0, "Nodo"+i,new Color(rand.nextInt(255)+1, rand.nextInt(255)+1, rand.nextInt(255)+1)));
        i++;
        g.agregarEstado(new Nodo("D", 0, 0, "Nodo"+i,new Color(rand.nextInt(255)+1, rand.nextInt(255)+1, rand.nextInt(255)+1)));
        i++;
        g.agregarEstado(new Nodo("E", 0, 0, "Nodo"+i,new Color(rand.nextInt(255)+1, rand.nextInt(255)+1, rand.nextInt(255)+1)));
        i++;
        
        
        g.enlace(g.estado("Nodo1"), g.estado("Nodo2"));
        g.enlace(g.estado("Nodo1"), g.estado("Nodo3"));
        g.enlace(g.estado("Nodo1"), g.estado("Nodo4"));
        g.enlace(g.estado("Nodo2"), g.estado("Nodo5"));
        g.enlace(g.estado("Nodo3"), g.estado("Nodo5"));
        g.enlace(g.estado("Nodo4"), g.estado("Nodo5"));
        
        g.estado("Nodo1").ListaAdy.getNodo("Nodo2").setHeuristica(3);
        g.estado("Nodo1").ListaAdy.getNodo("Nodo3").setHeuristica(8);
        g.estado("Nodo1").ListaAdy.getNodo("Nodo4").setHeuristica(1);
        
        g.estado("Nodo2").ListaAdy.getNodo("Nodo5").setHeuristica(7);
        g.estado("Nodo3").ListaAdy.getNodo("Nodo5").setHeuristica(8);
        g.estado("Nodo4").ListaAdy.getNodo("Nodo5").setHeuristica(3);
        
        System.out.println("Lista de adyacencia Nodo 1");
        g.elementosLista("Nodo1");
        System.out.println("Lista de adyacencia Nodo 2");
        g.elementosLista("Nodo2");
        
        j.primeroElMejor(g, g.estado("Nodo5"));
        
        /*g.inicio.ListaAdy.removerNodo("Nodo2","Nodo1");
        System.out.println("Lista de adyacencia Nodo 1");
        g.elementosLista("Nodo1");*/
    }
    
}