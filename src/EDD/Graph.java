/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import static App.Utilities.kosaraju;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author José Ignacio
 */

public class Graph {
    private int size;
    private List <User> users;
    private MultiGraph multigraph;
    
    public Graph() {
        System.setProperty("org.graphstream.ui", "swing");
        size = 0;
        users = new List();
        multigraph = new MultiGraph("MultiGraph");
    }
    
    public List <User> users() {
        return users;
    }
    
    public MultiGraph multigraph() {
        return multigraph;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void addUser(String username) {
        User user;
        Node node;
        if (username.contains("@")) {
            user = new User(username);
            node = multigraph.addNode(username);
            node.setAttribute("ui.label", username);
        } else {
            user = new User("@" + username);
            node = multigraph.addNode("@" + username);
            node.setAttribute("ui.label", "@" + username);
        }
        node.setAttribute("ui.style", "text-size: 15px; text-color: blue; size: 40px; stroke-color: black; fill-color: white; stroke-mode: plain; ");
        users.add(user);
        size++;
    }
    
    
    public void deleteUser(User user) {
        for (Nodo <User> pUser = users.first(); pUser != null; pUser = pUser.pNext) {
            pUser.tInfo.follows.delete(user);
        }
        multigraph.removeNode(user.username);
        users.delete(user);
        size--;
    }
    
    public void addFollow(User follower, User followed) {
        follower.follows.add(followed);
        multigraph.addEdge(follower.username + followed.username, follower.username, followed.username, true);
    }
    
    public void deleteFollow(User follower, User followed) {
        follower.follows.delete(followed);
        multigraph.removeEdge(follower.username + followed.username);
    }
    
    public void clear() {
        size = 0;
        users.clear();
    }
    
    public void load(File file) throws FileNotFoundException, IOException {
        clear();
        BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            boolean readingUsers = false;
            while ((line = reader.readLine()) != null) {
            switch (line) {
                case "usuarios" -> readingUsers = true;
                case "relaciones" -> readingUsers = false;
                default -> {
                    if (readingUsers) {
                        String username = line.trim();
                        addUser(username);
                    } else {
                        String[] parts = line.split(",");
                        User follower = getUser(parts[0].trim());
                        User followed = getUser(parts[1].trim());
                        addFollow(follower, followed);
                    }
                }
            }
        }
    }
    
    public User getUser(String username) {
        if (username.charAt(0) == "@".charAt(0)) {
            for (Nodo <User> pUser = users.first(); pUser != null; pUser = pUser.pNext) {
                if (pUser.tInfo.username.equals(username)) {
                    return pUser.tInfo;
                }
            }
        } else {
            for (Nodo <User> pUser = users.first(); pUser != null; pUser = pUser.pNext) {
                if (pUser.tInfo.username.equals("@" + username)) {
                    return pUser.tInfo;
                }
            }
        }
        return null;
    }
    
    public void transpose() {
        multigraph = App.Utilities.transpose(multigraph);
    }
    
    public void loadMultiGraph(){
        for (Nodo <User> auxNode = users.first() ;  auxNode != null ; auxNode = auxNode.next()) {
            Node node = multigraph.addNode(auxNode.tInfo.username);
            node.setAttribute("ui.label", auxNode.tInfo.username);
            node.setAttribute("ui.style", "text-size: 20px; text-color: blue; size: 40px; stroke-color: black; fill-color: white; stroke-mode: plain; ");
        }
        for (Nodo<User> auxNode = users.first() ;  auxNode != null ; auxNode = auxNode.next()) {
            for (Nodo<User>  node = auxNode.tInfo.follows.first(); node != null ; node = node.next()) {
                String nameA = auxNode.tInfo.username;
                String nameB = node.tInfo.username;
                multigraph.addEdge(nameA + nameB, nameA, nameB, true);
            }
        }
    }
    
    public void SCC() {
        String source;
        String target;
        
        List <List <String>> scc = kosaraju(multigraph);
        for (Nodo <List <String>> lAux = scc.first(); lAux != null; lAux = lAux.next()) {
            for (Nodo <String> pAux = lAux.info().first(); pAux != null; pAux = pAux.next()) {
                for (Edge edge : multigraph.getNode(pAux.info())) {
                    source = edge.getSourceNode().getId();
                    target = edge.getTargetNode().getId();
                    if ((lAux.info().contains(source)) && (lAux.info().contains(target))) {
                        edge.setAttribute("ui.style", "fill-color: red; stroke-color: red;");
                    }
                }
            }
        }
    }
    
    public void show() {
        for (Nodo <User> pUser = users.first(); pUser != null; pUser = pUser.pNext) {
            System.out.println(pUser.tInfo.username + " sigue a:");
            for (Nodo <User> pFollow = pUser.tInfo.follows.first(); pFollow != null; pFollow = pFollow.pNext) {
                System.out.println("- " + pFollow.tInfo.username);
            }
        }
    }
}