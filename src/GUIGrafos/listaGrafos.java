/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIGrafos;

import grafos.grafo;
import java.util.ArrayList;

/**
 *
 * @author MakotoYumi
 */
public class listaGrafos {
    ArrayList<grafo> grafos = new ArrayList();
    
    void agregarGrafo(grafo nuevo){
        grafos.add(nuevo);
    }
}
