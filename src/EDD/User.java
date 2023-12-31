/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Diego Hernández
 */
public class User {
    protected String username;
    protected List <User> follows;

    public User(String username) {
        this.username = username;
        follows = new List();
    }
    
    public boolean follows(User user) {
        return follows.contains(user);
    }
    
    public boolean follows(String username) {
        for (Nodo <User> pAux = follows.first(); pAux != null ; pAux = pAux.pNext) {
            if (pAux.tInfo.username.equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    public String username() {
        return username;
    }
}