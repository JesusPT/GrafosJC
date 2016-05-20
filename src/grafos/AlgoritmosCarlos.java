/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;
/**
 *
 * @author dell.dell
 */
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
    
}
