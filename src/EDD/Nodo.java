/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Admin
 * @param <T>
 */
public class Nodo <T> {
    protected T tInfo;
    protected Nodo <T> pNext;
    
    public Nodo(T elem) {
        tInfo = elem;
        pNext = null;
    }
    
    public Nodo <T> next() {
        return pNext;
    }
    
    public T info() {
        return tInfo;
    }
}
