package grafos;
/**
 *
 * @author J. P. Toledo
 */
public class Grafos {
    static grafo g = new grafo("Lol");    
    
    
    /**
     * @param args the command line arguments
     * Metodo Main de la clase que contiene la ventana principal
     */
    public static void main(String[] args) {
        g.agregarEstado(new Nodo("A",1,1,"MiNodo"));
        g.agregarEstado(new Nodo("B",1,1,"MiNodo2"));
        g.agregarEstado(new Nodo("C",1,1,"MiNodo3"));
        g.agregarEstado(new Nodo("D",1,1,"MiNodo4"));
        g.agregarEstado(new Nodo("E",1,1,"MiNodo4"));
        g.agregarEstado(new Nodo("F",1,1,"MiNodo4"));
        g.agregarEstado(new Nodo("G",1,1,"MiNodo4"));
        g.agregarEstado(new Nodo("H",1,1,"MiNodo4"));
        
        g.enlace(g.estado("A"), g.estado("B"));
        g.enlace(g.estado("A"), g.estado("C"));
        g.enlace(g.estado("A"), g.estado("D"));
        g.enlace(g.estado("B"), g.estado("E"));
        g.enlace(g.estado("B"), g.estado("F"));
        g.enlace(g.estado("C"), g.estado("E"));
        g.enlace(g.estado("D"), g.estado("E"));
        g.enlace(g.estado("D"), g.estado("F"));
        g.enlace(g.estado("E"), g.estado("H"));
        g.enlace(g.estado("F"), g.estado("H"));
        g.enlace(g.estado("F"), g.estado("G"));
        
        /*System.out.println("Lista de adyacencia Nodo 1");
        g.elementosLista("Nodo1");
        System.out.println("Lista de adyacencia Nodo 2");
        g.elementosLista("Nodo2");
        
        g.inicio.ListaAdy.removerNodo("Nodo2","Nodo1");
        System.out.println("Lista de adyacencia Nodo 1");
        g.elementosLista("Nodo1");*/
        AlgoritmosCarlos obj = new AlgoritmosCarlos();
        obj.ProEnProfundidad(g,g.estado("A"), g.estado("H"));
        
    }
    
}