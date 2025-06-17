package uy.edu.ucu.aed.tdas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class THash<K, V> implements IHash<K, V>, Serializable {

    // Implementación de la tabla hash
    // Aquí se pueden definir los atributos necesarios, como un array de buckets, etc.
    protected HashEntry<K,V>[] table;
    
    protected class HashEntry<K,V> implements Serializable{
        protected K clave;
        protected V valor;
        
        protected HashEntry(K unaClave, V unValor){
            this.clave = unaClave;
            this.valor = unValor;
        }
    }
    
    public THash(int size){
        this.table = new HashEntry[size];
    }
    

    @Override
    public V buscar(K unaClave) {
        int index = funcionHashing(unaClave);
        int indiceActual = index;
        int comparacionesRealizadas = 0;
        while (table[indiceActual] != null && comparacionesRealizadas < table.length){
            if (table[indiceActual].clave.equals(unaClave)){
                return (V) table[indiceActual];
            } else{
                indiceActual = (indiceActual + 1) % table.length;
            }
            comparacionesRealizadas++;
        }
        return null;
        
    }

    @Override
    public boolean insertar(K unaClave, V unValor) {
        HashEntry<K,V> entry = new HashEntry<>(unaClave, unValor);
        int index = funcionHashing(unaClave);
        int indiceActual = index;
        int comparacionesRealizadas = 0;
        while (comparacionesRealizadas < table.length){
            if (table[indiceActual] == null){
                table[indiceActual] = entry;
                return true;
            } else{
                indiceActual = (indiceActual + 1) % table.length;
            }
        }
        return false;
    }
    
    /**
     * Función de hashing que convierte una clave en un índice de la tabla hash.
     * 
     * @param unaClave la clave a convertir en índice.
     * @return el índice correspondiente a la clave.
    */
    protected int funcionHashing(K unaClave) {
        // Implementar una función de hashing adecuada para las claves
        // Por ejemplo, se puede usar el método hashCode() de la clave y aplicar un módulo con el tamaño de la tabla
        return Math.abs(unaClave.hashCode() % table.length);
    }
}
