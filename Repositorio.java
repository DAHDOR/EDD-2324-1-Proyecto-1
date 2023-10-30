/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

/**
 *
 * @author José Ignacio
 */
public class Repositorio {
    
       public void actualizarRepositorio(String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            writer.write("usuarios\n");
            for (User user : users) {
                writer.write(user.getUsername() + "\n");
            }

            writer.write("relaciones\n");
            for (User user : users) {
                for (User followed : user.getFollows()) {
                    writer.write(user.getUsername() + "," + followed.getUsername() + "\n");
                }
            }

            writer.close();
            System.out.println("Datos actualizados en el repositorio: " + path);
        } catch (IOException e) {
            System.err.println("Error al actualizar el repositorio: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Cargar datos del archivo al inicio (puedes usar el método de carga que ya tienes).

        // Realizar cambios en la estructura de datos (por ejemplo, agregar usuarios y relaciones).

        // Luego, actualiza el repositorio con los cambios.
        graph.actualizarRepositorio("archivo_de_texto.txt");
    }
}
}
