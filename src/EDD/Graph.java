/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

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
        User user = new User("@" + username);
        users.add(user);
        size++;
    }
    
    public void deleteUser(User user) {
        for (Node <User> pUser = users.first(); pUser != null; pUser = pUser.pNext) {
            for (Node <User> pFollow = pUser.tInfo.follows.first(); pFollow != null; pFollow = pFollow.pNext) {
                if (pFollow.tInfo == user) {
                    pUser.tInfo.follows.delete(user);
                }
            }
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
    
    public void show() {
        for (Node <User> pUser = users.first(); pUser != null; pUser = pUser.pNext) {
            System.out.println(pUser.tInfo.username + " sigue a:");
            for (Node <User> pFollow = pUser.tInfo.follows.first(); pFollow != null; pFollow = pFollow.pNext) {
                System.out.println("- " + pFollow.tInfo.username);
            }
        }
    }
}