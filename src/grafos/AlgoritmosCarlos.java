/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*Un nodo de una lista de adyascencia, no tiene lista de adyascencia, por lo que se tiene que obtener del nodo original del grafo*/
package grafos;
/**
 *
 * @author dell.dell
 */
import java.util.Stack;
import java.util.ArrayList;
public class AlgoritmosCarlos {
    
    public void Dijkstra(grafo g,Nodo origen){
        /*creamos una cola de prioridad Q
3      agregamos origen a la cola de prioridad Q
4      mientras Q no este vacío:
5          sacamos un elemento de la cola Q llamado u
6          si u ya fue visitado continuo sacando elementos de Q    
7          marcamos como visitado u
8          para cada vértice v adyacente a u en el Grafo:
9              sea w el peso entre vértices ( u , v )  
10             si v no ah sido visitado:
11                Relajacion( u , v , w )

1  método Relajacion( actual , adyacente , peso ):
2      si distancia[ actual ] + peso < distancia[ adyacente ]
3         distancia[ adyacente ] = distancia[ actual ] + peso
4         agregamos adyacente a la cola de prioridad Q*/
    }
   public void ProEnProfundidad(grafo grafo, Nodo inicio, Nodo fin){
       Stack<Nodo> EstadoAbierto = new Stack<Nodo>();
       Stack<Nodo> EstadoCerrado = new Stack<Nodo>();
       Nodo actual;
       ArrayList<Nodo> hijos;
       //try{
        EstadoAbierto.push(inicio);
        actual=EstadoAbierto.firstElement();
        while(fin!=actual&&!EstadoAbierto.empty()){
        EstadoAbierto.remove(EstadoAbierto.firstElement());
        EstadoCerrado.push(actual);
        hijos=grafo.estado(actual.Nombre).ListaAdy.getElementos();
        hijos=TratarRepetidos(hijos,EstadoAbierto,EstadoCerrado);
        //Insertar los hijos en el estado abierto
            for (int i = 0; i < hijos.size(); i++) {
                EstadoAbierto.push(hijos.get(i));
            }
        actual=EstadoAbierto.firstElement();
        }
        System.out.println("Estado cerrado:");
        while(!EstadoCerrado.empty()){
         System.out.println(""+(EstadoCerrado.pop()).Nombre);
        }    
       /*}
       catch(Exception e){
           System.out.println("Error: "+e.toString());
       }*/
       
   }
   
   public void ProEnAnchura(){
       
   }
   public ArrayList TratarRepetidos(ArrayList hijos, Stack EstadoAbierto, Stack EstadoCerrado){
       Nodo hijo;
       for (int i = 0; i < hijos.size(); i++) {
         hijo=(Nodo)hijos.get(i);
         if(EstadoAbierto.contains(hijo)){
             hijos.remove(hijo);
         }
         if(EstadoCerrado.contains(hijo)){
             hijos.remove(hijo);
         }
       }
    return hijos;   
   }
}