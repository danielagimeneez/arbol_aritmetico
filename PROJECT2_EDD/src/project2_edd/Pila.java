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
public class Pila {
//Atributos
    private Nodo top;
    private Nodo base;
    private int size;
    
    public Pila(){
        this.top = this.base = null;
        this.size = 0;
    }

   
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    public boolean isEmpty(){
        return top == null;
    }
    //vaciar
    public void empty(){
        this.top = this.base = null;
        this.size = 0;
    }
    
    //peek: elemento top de nuestro stack (sin retirarlo)
    public char peek(){
        return top.getLetra();
    }
    
    //Te retira el ultimo
    public void pop(){
        if (this.isEmpty()) {
            System.out.println("La pila esta vacia.");
        }else if(size == 1){
            this.empty();
        }else{
            top = top.getNext();
            size--;
        }
    }
    
    //Te crea el nodo y te lo apila
    public void push(char letra){
        Nodo nuevo = new Nodo(letra);
        if (this.isEmpty()) {
            top = base = nuevo;
        }else{
            nuevo.setNext(top);
            top = nuevo;
        }
        size++;
    }
}
