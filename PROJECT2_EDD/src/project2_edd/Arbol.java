/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2_edd;

/**
 *
 * @author andres
 */
public class Arbol {
    private Hoja raiz;

    public Arbol() {
        this.raiz = null;
    }
    public Arbol(Hoja raiz) {
        this.raiz = raiz;
    }

    
    public Hoja getRaiz() {
        return raiz;
    }
    public void setRaiz(Hoja raiz) {
        this.raiz = raiz;
    }
    
    
}
