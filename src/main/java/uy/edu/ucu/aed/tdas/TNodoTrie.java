package uy.edu.ucu.aed.tdas;
import java.io.Serializable;
import java.util.LinkedList;

public class TNodoTrie implements Serializable {
    protected static final int CANT_CHR_ABECEDARIO = 26;
    protected TNodoTrie[] hijos;
    protected boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            char letra = unaPalabra.charAt(c);
            int indice = indiceLetra(letra);
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    public boolean buscarPalabra(String palabra){
        if (palabra == null){
            return false;
        }
        if (palabra.isEmpty()){
            return esPalabra;
        }
        Character primeraLetra = palabra.charAt(0);
        int posicionLetra = indiceLetra(primeraLetra);
        TNodoTrie siguienteHijo = hijos[posicionLetra];
        if (siguienteHijo == null){
            return false;
        } else {
            palabra = palabra.substring(1);
            return siguienteHijo.buscarPalabra(palabra);
        }
    }

    public int indiceLetra(char letra){
        return (int)letra - (int)'a';
    }


    public TNodoTrie buscarPrefijo(String unPrefijo){
        if (unPrefijo == null){
            return null;
        }
        if (unPrefijo.isEmpty()){
            return this;
        }
        else {
            char letra = unPrefijo.charAt(0);
            int indice = indiceLetra(letra);
            TNodoTrie siguienteHijo = hijos[indice];
            if (siguienteHijo == null){
                return null;
            }
            else{
                unPrefijo = unPrefijo.substring(1);
                return siguienteHijo.buscarPrefijo(unPrefijo);
            }
        }
    }

    public void predecir (String unPrefijo, LinkedList<String> unaLista){
    TNodoTrie nodoResultado = this.buscarPrefijo(unPrefijo);
        if (nodoResultado != null) {
            StringBuilder current = new StringBuilder(unPrefijo);
            nodoResultado.completar(current, unaLista);
        }
    }

    private void completar(StringBuilder current, LinkedList<String> resultado) {
        if (esPalabra) {
            resultado.add(current.toString());
        }
    
        for (char c = 'a'; c <= 'z'; c++) {
            int i = c - 'a';
            if (hijos[i] != null) {
                current.append(c);
                hijos[i].completar(current, resultado);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    private void imprimir(String s, TNodoTrie nodo){
        if (nodo != null) {
        if (nodo.esPalabra) {
            System.out.println(s);
        }
        for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
            if (nodo.hijos[c] != null) {
            imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
            }
        }
    }
    }
    public void imprimir() {
        imprimir(""
        , this);
    }

}
