/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author José Ignacio
 */

public class Graph {
    private int size;
    private List <User> users;
    
    public Graph() {
        size = 0;
        users = new List();
    }
    
    public List <User> users() {
        return users;
    }
    
    public void addUser(String username) {
        User user;
        if (username.contains("@")) {
            user = new User(username);
        } else {
            user = new User("@" + username);
        }
        users.add(user);
        size++;
    }
    
    public void deleteUser(User user) {
        for (Node <User> pUser = users.first(); pUser != null; pUser = pUser.pNext) {
            pUser.tInfo.follows.delete(user);
        }
        users.delete(user);
        size--;
    }
    
    public void addFollow(User follower, User followed) {
        follower.follows.add(followed);
    }
    
    public void deleteFollow(User follower, User followed) {
        follower.follows.delete(followed);
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
        for (Node <User> pUser = users.first(); pUser != null; pUser = pUser.pNext) {
            if (pUser.tInfo.username.equals(username)) {
                return pUser.tInfo;
            }
        }
        return null;
    }
    
    public void show() {
        for (Node <User> pUser = users.first(); pUser != null; pUser = pUser.pNext) {
            System.out.println(pUser.tInfo.username + " sigue a:");
            for (Node <User> pFollow = pUser.tInfo.follows.first(); pFollow != null; pFollow = pFollow.pNext) {
                System.out.println("- " + pFollow.tInfo.username);
            }
        }
    }
}