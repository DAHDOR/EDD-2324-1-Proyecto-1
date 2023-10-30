/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import EDD.List;
import EDD.Pair;
import java.util.Stack;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

/**
 *
 * @author Admin
 */
public class Utilities {
    
    public static boolean validateCharacters(String input, String validChars) {
        for (int i = 0; i < input.length(); i++) {
            if (!validChars.contains(String.valueOf(input.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
    
    public static Node reverseEdges(Node node) {
        MultiGraph multigraph = new MultiGraph("MultiGraph");
        
        for (Edge edge : node) {
            Node source = edge.getSourceNode();
            Node target = edge.getTargetNode();
            if (multigraph.getNode(source.getId()) == null) {
                multigraph.addNode(source.getId());
            }
            if (multigraph.getNode(target.getId()) == null) {
                multigraph.addNode(target.getId());
            }
            multigraph.addEdge(target.getId() + source.getId(), target.getId(), source.getId());
        }
        
        return multigraph.getNode(node.getId());
    }
    
    public static Pair <List <Node>, Stack> DFS(Node actual, Pair<List <Node>, Stack> pair) {
        if (!pair.l.contains(actual)) {
            pair.l.add(actual);
            for (Edge edge : actual) {
                if (edge.getSourceNode() == actual) {
                    pair = DFS(edge.getTargetNode(), pair);
                }
            }
            pair.s.push(actual);
        }
        return pair;
    }
    
    public static Pair <List <Node>, List <Node>> secondDFS(Node root, Pair <List <Node>, List <Node>> pair) {
        if (!pair.l.contains(root)) {
            pair.l.add(root);
            pair.s.add(root);
            for (Edge edge : root) {
                if (edge.getSourceNode() == root) {
                    pair = secondDFS(edge.getTargetNode(), pair);
                }
            }
        }
        return pair;
    }
    
    public static MultiGraph transpose(MultiGraph multigraph) {
        
        MultiGraph rMultigraph= new MultiGraph("TransposedMultiGraph");
        
        for (Node node : multigraph) {
            rMultigraph.addNode(node.getId());
        }
        
        Node source;
        Node target;
        
        for (Node node : multigraph) {
            for (Edge edge : node) {
                source = edge.getSourceNode();
                target = edge.getTargetNode();
                if (rMultigraph.getEdge(target.getId() + source.getId()) == null) {
                    rMultigraph.addEdge(target.getId() + source.getId(), target.getId(), source.getId());
                }
            }
        }
        
        return rMultigraph;
    }
    
    public static Stack pushStack(Stack stack1, Stack stack2) {
        for (int i = 0; i < stack2.size(); i++) {
            stack1.push(stack2.elementAt(i));
        }
        return stack1;
    }
    
    public static List <List <Node>> kosaraju(MultiGraph multigraph) {
        
        // Primer DFS
        Node root = null;
        List <Node> visited1 = new List();
        Stack pairStack = new Stack();
        Stack stack = new Stack();
        Pair <List <Node>, Stack> pair = new Pair(visited1, pairStack);

        while (stack.size() < multigraph.getNodeCount()) {
            for (Node node : multigraph) {
                if (!stack.contains(node)) {
                    root = node;
                    break;
                }
            }
            pair = DFS(root, pair);
            stack = pushStack(stack, pair.s);
        }
        
        // Segundo DFS (con el grafo transverso)
        multigraph = transpose(multigraph);                                         // transponer grafo
        List <List <Node>> scc = new List();                                        // lista con los componentes fuertemente conectados
        List <Node> sccList = new List();                                           // componente fuertemente conectado
        List <Node> visited2 = new List();                                          // nodos visitados a ser revertidos
        
        // Se agregan los nodos de visitados1 revertidos a visitados2
        
        Pair <List <Node>, List <Node>> listPair = new Pair(pair.l, sccList);   // tupla con la lista de visitados y el componente fuertemente conectado
        
        while (!stack.isEmpty()){
            sccList = new List();
            listPair = new Pair(listPair.l, sccList);
            root = (Node) stack.pop();
            listPair = secondDFS(root, listPair);
            scc.add(listPair.s);
        }
        
        return scc;
    }
}