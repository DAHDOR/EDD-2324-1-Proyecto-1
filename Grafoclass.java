/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.redes.sociales;

/**
 *
 * @author José Ignacio
 */
public class Grafoclass {
    
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GrafoUsuariosGUI extends JFrame {
    private Map<String, Point> nodos;

    public GrafoUsuariosGUI() {
        nodos = new HashMap<>();
        setTitle("Grafo de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Agrega nodos (usuarios) al grafo
        nodos.put("Usuario1", new Point(100, 100));
        nodos.put("Usuario2", new Point(200, 100));
        nodos.put("Usuario3", new Point(100, 200));
        nodos.put("Usuario4", new Point(200, 200));

        // Agrega conexiones entre nodos (por ejemplo, aristas)
        // En este ejemplo, no se dibujan las aristas, pero puedes hacerlo.
        
        // Crea un panel personalizado para mostrar los usuarios
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Map.Entry<String, Point> entry : nodos.entrySet()) {
                    String usuario = entry.getKey();
                    Point ubicacion = entry.getValue();
                    g.setColor(Color.BLUE);
                    g.fillOval(ubicacion.x, ubicacion.y, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawString(usuario, ubicacion.x + 5, ubicacion.y - 5);
                }
            }
        };
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GrafoUsuariosGUI grafoUsuarios = new GrafoUsuariosGUI();
            grafoUsuarios.setVisible(true);
        });
    }
}

}
