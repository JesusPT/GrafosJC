package grafos;


/**
 *
 * @author J. P. Toledo
 */
public class Grafos {
    static grafo g = new grafo();    
    
    
    /**
     * @param args the command line arguments
     * Metodo Main de la clase que contiene la ventana principal
     */
    public static void main(String[] args) {
        
        
        
        g.agregarEstado(new Nodo("Nodo1",1,1,"MiNodo"));
        g.agregarEstado(new Nodo("Nodo2",1,1,"MiNodo2"));
        g.agregarEstado(new Nodo("Nodo3",1,1,"MiNodo3"));
        g.agregarEstado(new Nodo("Nodo4",1,1,"MiNodo4"));
        
        g.enlace(g.estado("Nodo1"), g.estado("Nodo2"));
        g.enlace(g.estado("Nodo1"), g.estado("Nodo3"));
        g.enlace(g.estado("Nodo1"), g.estado("Nodo4"));
        g.enlace(g.estado("Nodo2"), g.estado("Nodo3"));
        
        System.out.println("Lista de adyacencia Nodo 1");
        g.elementosLista("Nodo1");
        System.out.println("Lista de adyacencia Nodo 2");
        g.elementosLista("Nodo2");
        
        
    }
    
}
