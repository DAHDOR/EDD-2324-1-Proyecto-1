/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package App;

import static App.Utilities.pushStack;
import EDD.Graph;
import EDD.User;
import EDD.List;
import EDD.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import static App.Utilities.DFS;
import static App.Utilities.kosaraju;
import static App.Utilities.transpose;
import EDD.Nodo;
import org.graphstream.graph.Edge;

/**
 *
 * @author Admin
 */
public class test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Graph graph = new Graph();
            File file = new File("C:\\Users\\Adminç\\Documents\\Universidad\\Estructuras de datos\\test.txt");
            graph.load(file);
            System.out.println(graph.multigraph().getNode("@nooo"));
        } catch (IOException ex) {
            Logger.getLogger(test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
