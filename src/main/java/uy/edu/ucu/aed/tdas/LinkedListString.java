/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Estudiante UCU
 */
public class LinkedListString extends LinkedList<String>{
    
    public LinkedList predecir(String unPrefijo){
        LinkedList<String> resultado = new LinkedList();
        
        for (String palabra : this){
            if(palabra.startsWith(unPrefijo)){
                resultado.add(palabra);
            }
        }
        
        return resultado;
    }
}
