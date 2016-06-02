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
import javax.swing.JOptionPane;
public class AlgoritmosCarlos {
    public void Dijkstra(grafo g,Nodo origen){
        
    }
   
    public String RecorridoGuiado(grafo g,Nodo inicio, Nodo fin){
        ArrayList<Nodo> hijos;
        ArrayList<String> recorrido= new ArrayList();
        Nodo actual;
        actual=inicio;
        String nomhijos;
        boolean ban=false;
        recorrido.add(actual.getNombre());
        while(!fin.getNombre().equals(actual.getNombre())){
            nomhijos="";
            if(g.estado(actual.Nombre).ListaAdy!=null){
            hijos=g.estado(actual.Nombre).ListaAdy.getElementos();
                for (int i = 0; i < hijos.size(); i++) {
                    //System.out.println(""+g.estado(hijos.get(i).Nombre).getNombre());
                    nomhijos=nomhijos+"   "+g.estado(hijos.get(i).Nombre).getNombre();
                    if(g.estado(hijos.get(i).Nombre).getNombre().equals(fin.getNombre())){
                        //System.out.println(""+g.estado(hijos.get(i).Nombre).getNombre());
                        ban=true;
                        break;
                    }
                }
                if(!ban){
                actual=g.estado(JOptionPane.showInputDialog("Ingrese el nodo por el que quiere irse \n"+nomhijos));
                recorrido.add(actual.getNombre());
                }
                else{
                    actual=fin;
                }
            }
            else{
                //System.out.println("Fin del recorrido");
                fin=actual;
            }    
        }
        recorrido.add(fin.getNombre());
        nomhijos="";
        for (int i = 0; i < recorrido.size(); i++) {
        nomhijos=nomhijos+" "+recorrido.get(i);    
        }
        return nomhijos;
    }
   public void ProEnProfundidad(grafo grafo, Nodo inicio, Nodo fin){
          Stack<Nodo> EstadoAbierto = new Stack<Nodo>();
       Stack<Nodo> EstadoCerrado = new Stack<Nodo>();
       Stack<Nodo> padres = new Stack<Nodo>();
       String[][] resultado;
       Nodo actual,papa;
       ArrayList<Nodo> hijos;
       try{
        EstadoAbierto.push(inicio);
        papa=actual=EstadoAbierto.firstElement();
        padres.push(actual);
        while(!fin.getNombre().equals(actual.getNombre())&&!EstadoAbierto.empty()){
        EstadoAbierto.remove(EstadoAbierto.firstElement());
        EstadoCerrado.push(actual);
        padres.push(papa);
        if(grafo.estado(actual.Nombre).ListaAdy!=null){
        hijos=grafo.estado(actual.Nombre).ListaAdy.getElementos();
        hijos=TratarRepetidos(hijos,EstadoAbierto,EstadoCerrado);
        if(hijos.size()>0){
            papa=actual;
        }
        //Insertar los hijos en el estado abierto
        for (int i = hijos.size()-1; i >=0 ; i--) {
              EstadoAbierto.push(hijos.get(i));
           }
        }
        actual=EstadoAbierto.peek();
        }
        EstadoCerrado.push(actual);
        padres.push(papa);
        resultado= new String[EstadoCerrado.size()][2];
        int x=0;
        while(!EstadoCerrado.empty()){
         resultado[x][0]=(EstadoCerrado.pop()).Nombre;
         resultado[x][1]=(padres.pop()).Nombre;
         System.out.println(""+resultado[x][0]+" Padre: "+resultado[x][1]);
         x++;
        }
        System.out.println("Resultado: "+GetResultado(resultado));
        
       }
       catch(Exception e){
           System.out.println("Error: "+e.toString());
       }
       
   }
   
   public void ProEnAnchura(grafo grafo, Nodo inicio, Nodo fin){
       Stack<Nodo> EstadoAbierto = new Stack<Nodo>();
       Stack<Nodo> EstadoCerrado = new Stack<Nodo>();
       Stack<Nodo> padres = new Stack<Nodo>();
       String[][] resultado;
       Nodo actual,papa;
       ArrayList<Nodo> hijos;
       try{
        EstadoAbierto.push(inicio);
        papa=actual=EstadoAbierto.firstElement();
        padres.push(actual);
        while(!fin.getNombre().equals(actual.getNombre())&&!EstadoAbierto.empty()){
        EstadoAbierto.remove(EstadoAbierto.firstElement());
        EstadoCerrado.push(actual);
        padres.push(papa);
        if(grafo.estado(actual.Nombre).ListaAdy!=null){
        hijos=grafo.estado(actual.Nombre).ListaAdy.getElementos();
        hijos=TratarRepetidos(hijos,EstadoAbierto,EstadoCerrado);
        if(hijos.size()>0){
            papa=actual;
        }
        //Insertar los hijos en el estado abierto
        for (int i = 0; i < hijos.size(); i++) {
              EstadoAbierto.push(hijos.get(i));
              
           }
        }
        actual=EstadoAbierto.firstElement();
        }
        EstadoCerrado.push(actual);
        resultado= new String[EstadoCerrado.size()][2];
        int x=0;
        while(!EstadoCerrado.empty()){
         resultado[x][0]=(EstadoCerrado.pop()).Nombre;
         resultado[x][1]=(padres.pop()).Nombre;
         System.out.println(""+resultado[x][0]+" Padre: "+resultado[x][1]);
         x++;
        }
        System.out.println("Resultado: "+GetResultado(resultado));
        
       }
       catch(Exception e){
           System.out.println("Error: "+e.toString());
       }
   }
   public String GetResultado(String[][] valores){
       Stack<String> res = new Stack();
       String resultado="";
       String fin=valores[valores.length-1][1];
       String inicio=valores[0][1];
       res.push(valores[0][0]);
       while(!fin.equals(inicio)){
           for(int i=0;i<valores.length;i++){
               if(inicio.equals(valores[i][0])){
                   res.push(inicio);
                   inicio = valores[i][1];
               }
           }
       }
       while(!res.empty()){
           resultado=resultado+res.pop();
       }
       return resultado;
   }
   public ArrayList TratarRepetidos(ArrayList hijos, Stack EstadoAbierto, Stack EstadoCerrado){
       Nodo hijo;
       Nodo fueraEA[]= new Nodo[EstadoAbierto.size()];
       Nodo fueraEC[]= new Nodo[EstadoCerrado.size()];
       int a=0,c;
       c=hijos.size();
       //Vaciar elementos de estados a arreglos para poderlos comparar:
       while(!EstadoAbierto.empty()){
            fueraEA[a]=(Nodo)EstadoAbierto.pop();
            a++;
       }
       a=0;
       while(!EstadoCerrado.empty()){
            fueraEC[a]=(Nodo)EstadoCerrado.pop();
            a++;
       }
       //Comparar cada hijo con los elementos de los estados
       for (int i = 0; i < c; i++) {
         if(c!=hijos.size()){
             c=c-1;
             i=i-1;
         }
         hijo=(Nodo)hijos.get(i);
         for(int j=0;j<fueraEA.length;j++){
         if(fueraEA[j].getNombre().equals(hijo.getNombre())){
                hijos.remove(hijo);
            }    
         }
         for(int j=0;j<fueraEC.length;j++){
         if(fueraEC[j].getNombre().equals(hijo.getNombre())){
                hijos.remove(hijo);
            }    
         }
        }
       //Volver a meter los elementos  a EstadoAbierto:
       int i;
         for(i=fueraEA.length-1;i>=0;i--){ 
             EstadoAbierto.push(fueraEA[i]);
         }
       //Volver a meter los elementos  a EstadoCerrado:
         for(i=fueraEC.length-1;i>=0;i--){ 
             EstadoCerrado.push(fueraEC[i]);
         }
    return hijos;   
   }
}