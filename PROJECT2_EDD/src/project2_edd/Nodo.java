/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2_edd;

/**
 *
 * @author Andrea
 */
public class Nodo {
    //Atributos
    private String name;
    private char letra;
    private Nodo next;
    
    //constructores
    public Nodo(String name){
        this.name = name;
        this.letra = name.charAt(0);
        this.next = null;
    }
    public Nodo(char letra){;
        this.name = Character.toString(letra);
        this.letra = letra;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
