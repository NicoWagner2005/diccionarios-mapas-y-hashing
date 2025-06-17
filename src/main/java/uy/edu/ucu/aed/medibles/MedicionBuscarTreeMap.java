/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.ucu.aed.medibles;

import java.util.TreeMap;

/**
 *
 * @author Estudiante UCU
 */
public class MedicionBuscarTreeMap extends Medible {
    private TreeMap<String, String> treeMap;
    
    public MedicionBuscarTreeMap(TreeMap<String, String> treeMap) {
        this.treeMap = treeMap;
    }
    
    @Override
    public void ejecutar(Object... params){
        
        if (params.length != 2 || !(params[0] instanceof Integer) || !(params[1] instanceof String[])) {
            throw new IllegalArgumentException("Parámetros inválidos. Se esperan: (int repeticion, String[] palabras)");
        }
        
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for (int i = 0; i < repeticion; i++){
            for (String palabra : palabras){
                treeMap.get(palabra);

            }
        }
    }
    
    @Override
    public Object getObjetoAMedirMemoria(){
        return this.treeMap;
    }
}
    


