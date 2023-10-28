/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphui;

import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author tomasaraujo
 */
public class GraphUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        public void print(){
            if(!isEmpty()){
                System.setProperty("org.graphstream.ui", "swing");
                MultiGraph graph = new MultiGraph("Nuevo Grafo");
                String attributes = "text-size: 25px; text-color: blue; size: 50px; ";
                attributes += "stroke-color: black; fill-color: white; stroke-mode: plain; ";
            
                for (Nodo<User> auxNode = users.first() ;  auxNode != null ; auxNode = auxNode.next()) {
                    Node node =graph.addNode(auxNode.tInfo.username);
                    node.setAttribute("ui.label", auxNode.tInfo.username);
                    node.setAttribute("ui.style", attributes);
                }
            
                for (Nodo<User> auxNode = users.first() ;  auxNode != null ; auxNode = auxNode.next()) {
                    for (Nodo<User>  node = auxNode.tInfo.follows.first(); node != null ; node = node.next()) {
                        String nameA = auxNode.tInfo.username;
                        String nameB = node.tInfo.username;
                        graph.addEdge(nameA + nameB, nameA, nameB, true);
                    }
                }
            
                Viewer viewer = graph.display();
                viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
            }
        }
    }
    
} 
