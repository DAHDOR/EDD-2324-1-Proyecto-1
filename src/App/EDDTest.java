/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package App;

import EDD.*;
import Functions.*;

/**
 *
 * @author Jose Ignacio
 */
public class EDDTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    Graph graph = new Graph();
    File archivo = new File("nombre_del_archivo.txt"); // Reemplaza "nombre_del_archivo.txt" con la ruta de tu archivo
    Grafo grafoCargado = FileLoader.load(archivo);

    // Ahora, copia los datos del grafo cargado al objeto 'graph'
    for (User usuario : grafoCargado.users()) {
        graph.addUser(usuario.getUsername());
        for (User seguido : usuario.getFollows()) {
            graph.addFollow(usuario, seguido);
        }
    }

    // Muestra la red social en la consola
    graph.show();
}


