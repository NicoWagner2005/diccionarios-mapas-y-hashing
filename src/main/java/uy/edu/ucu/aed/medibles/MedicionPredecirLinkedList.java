/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.ucu.aed.medibles;

import uy.edu.ucu.aed.tdas.LinkedListString;

/**
 *
 * @author Estudiante UCU
 */
public class MedicionPredecirLinkedList extends Medible{
    // Atributo que almacena la LinkedList sobre la cual se realizarán las búsquedas
    private LinkedListString linkedList;

    /**
     * Constructor de la clase MedicionBuscarLinkedList.
     * Inicializa la LinkedList sobre la cual se realizarán las búsquedas.
     *
     * @param linkedList LinkedList que se utilizará para las búsquedas.
     */
    public MedicionPredecirLinkedList(LinkedListString linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public void ejecutar(Object... params) {
        // La operación a medir es la búsqueda de elementos en la LinkedList.
        // Se espera que params contenga dos elementos: el número de repeticiones y un arreglo de palabras a buscar.
        
        if (params.length != 2 || !(params[0] instanceof Integer) || !(params[1] instanceof String[])) {
            throw new IllegalArgumentException("Parámetros inválidos. Se esperan: (int repeticion, String[] palabras)");
        }
        
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras) {
                linkedList.predecir("cas");
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        // El objeto cuyo tamaño en memoria se medirá es la LinkedList utilizada para las búsquedas.
        return this.linkedList;
    }
}
