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
public class List <T> {
    private Nodo <T> pFirst;
    private Nodo <T> pLast;
    private int size;
    
    // Constructor
    public List() {
        pFirst = null;
        pLast = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return pFirst == null;
    }
    
    public Nodo first() {
        return pFirst;
    }
    
    public Nodo last() {
        return pLast;
    }
    
    public T read(Nodo <T> pValue) {
        return pValue.tInfo;
    }
    
    public Nodo <T> next(Nodo <T> pValue) {
        if (pValue != null) {
            return pValue.pNext;
        } else {
            return null;
        }
    }
    
    public void add(T elem) {
        Nodo <T> pNew = new Nodo(elem);
        if (pFirst == null) {
            pFirst = pNew;
            pLast = pNew;
        } else {
            pLast.pNext = pNew;
            pLast = pNew;
        }
        size++;
    }
    public void delete(T elem) {
        Nodo <T> pCurr = pFirst;
        Nodo <T> pPrev = null;
        boolean found = false;
        while ((pCurr != null) && (!found)) {
            found = (pCurr.tInfo == elem);
            if (!found) {
                pPrev = pCurr;
                pCurr = pCurr.pNext;
            }
        }
        if (pCurr != null) {
            if (pCurr == pFirst) {
                pFirst = pCurr.pNext;
            } else {
                pPrev.pNext = pCurr.pNext;
            }
        }
    }
    
    public void clear() {
        while (pFirst != null) {
            pFirst = pFirst.pNext;
        }
    }
    
    public boolean contains(T elem) {
        for (Nodo <T> pAux = pFirst; pAux != null; pAux = pAux.pNext) {
            if (elem == pAux.tInfo) {
                return true;
            }
        }
        return false;
    }
    
    public void show() {
        Nodo <T> pValue = first();
        while (pValue != null) {
            System.out.println(pValue.tInfo);
            pValue = pValue.pNext;
        }
    }
}
