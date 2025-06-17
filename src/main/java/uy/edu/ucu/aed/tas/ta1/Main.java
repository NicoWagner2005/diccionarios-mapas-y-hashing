/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ucu.aed.tas.ta1;

import uy.edu.ucu.aed.tdas.THash;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

/**
 *
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        

        THash<String, String> tablaHash = new THash<>(1);

        String[] clavesInsertar = ManejadorArchivosGenerico.leerArchivo("claves_insertar.txt");
        for (String clave : clavesInsertar) {
            tablaHash.insertar(clave.trim(), clave.trim()); 
        }

        String[] clavesBuscar = ManejadorArchivosGenerico.leerArchivo("claves_buscar.txt");
        String[] resultados = new String[clavesBuscar.length];
        int i = 0;
        for (String clave : clavesBuscar) {
            String resultado = tablaHash.buscar(clave.trim()); 
            if (resultado != null) {
                resultados[i] = "Clave: " + clave + " - Encontrada";
            } else {
                resultados[i] = "Clave: " + clave + " - No encontrada";
            }
            i++;
        }

        ManejadorArchivosGenerico.escribirArchivo("resultados_busqueda.txt", resultados);
    }
}
