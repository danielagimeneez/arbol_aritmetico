/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2_edd;

/**
 *
 * @author andres
 */
public class NodoStack<T> {
        //Atributos
    private String name;
    private NodoStack next;
    private T valorH;
    
    //constructores
    public  NodoStack(String name, T valorH){
        this.name = name;
        this.valorH = valorH;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public  NodoStack getNext() {
        return next;
    }

    public void setNext( NodoStack next) {
        this.next = next;
    }

    public T getValorH() {
        return valorH;
    }

    public void setValorH(T valorH) {
        this.valorH = valorH;
    }
}
