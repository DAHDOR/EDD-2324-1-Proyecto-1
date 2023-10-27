/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import EDD.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author José Ignacio
 */

public class FileLoader {
    private Grafo grafo;
    private Map<String, User> usuarios;

    public FileLoader() {
        grafo = new Grafo();
        usuarios = new HashMap<>();
    }

    public Grafo load(File archivo) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            boolean leyendoUsuarios = false;

            while ((linea = lector.readLine()) != null) {
                if (linea.equals("usuarios")) {
                    leyendoUsuarios = true;
                } else if (linea.equals("relaciones")) {
                    leyendoUsuarios = false;
                } else {
                    if (leyendoUsuarios) {
                        String nombreUsuario = linea.trim();
                        User usuario = new User(nombreUsuario);
                        usuarios.put(nombreUsuario, usuario);
                    } else {
                        String[] partes = linea.split(",");
                        if (partes.length == 2) {
                            String nombreUsuario1 = partes[0].trim();
                            String nombreUsuario2 = partes[1].trim();
                            User usuario1 = usuarios.get(nombreUsuario1);
                            User usuario2 = usuarios.get(nombreUsuario2);
                            if (usuario1 != null && usuario2 != null) {
                                grafo.agregarArista(usuario1, usuario2);
                            }
                        }
                    }
                }
            }

            lector.close();
            System.out.println("Archivo cargado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }
        return grafo;
    }

    public boolean verificarFuerteConectividad(Grafo grafo) {
        return grafo.hayFuerteConectividad();
    }

    public static void main(String[] args) {
        FileLoader loader = new FileLoader();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la ruta del archivo a cargar: ");
        String rutaArchivo = scanner.nextLine();
        File archivo = new File(rutaArchivo);

        Grafo grafoCargado = loader.load(archivo);
        boolean esFuertementeConectado = loader.verificarFuerteConectividad(grafoCargado);

        if (esFuertementeConectado) {
            System.out.println("La red social es fuertemente conectada.");
        } else {
            System.out.println("La red social no es fuertemente conectada.");
        }
    }
}
