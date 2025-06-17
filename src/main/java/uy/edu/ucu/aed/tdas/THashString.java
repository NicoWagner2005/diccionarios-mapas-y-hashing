/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;

/**
 *
 * @author Estudiante UCU
 * @param <String>
 */
public class THashString extends THash<String,String>{
    public THashString(int size){super(size);}
    
    public LinkedList<String> predecir(String unPrefijo){
        LinkedList<String> resultado = new LinkedList();
        
        for (HashEntry<String,String> entry : table){
            if (entry != null){
                String valor = entry.valor;
                if(valor.startsWith(unPrefijo)){
                    resultado.add(entry.valor);
                }
            }
        }
        return resultado;
    }

}
