package uy.edu.ucu.aed.tdas;

import java.io.Serializable;
import java.util.LinkedList;

public class TArbolTrie implements Serializable {
    private TNodoTrie raiz;

    public void insertar(String palabra) {
        if (raiz == null) {
        raiz = new TNodoTrie();
    }
    raiz.insertar(palabra);
    }

    public LinkedList<String> predecir(String unPrefijo){
        if (raiz == null){
            return null;
        }
        else {
            LinkedList<String> lista = new LinkedList<String>();
            raiz.predecir(unPrefijo, lista);
            return lista;
        }
    }

    public boolean buscar(String palabra) {
        if (raiz == null) {
            return false;
        }
        return raiz.buscarPalabra(palabra);
    }

    public TNodoTrie buscarPrefijo(String unPrefijo) {
        if (raiz == null) {
            return null;
        }
        return raiz.buscarPrefijo(unPrefijo);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    public boolean esVacio() {
        return raiz == null;
    }
}