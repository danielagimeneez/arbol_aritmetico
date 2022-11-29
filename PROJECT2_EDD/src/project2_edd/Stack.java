/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2_edd;

/**
 *
 * @author andres
 */
public class Stack {
        //Atributos
    private NodoStack top;
    private NodoStack base;
    private int size;
    
    public Stack(){
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
    public String peek(){
        return top.getName();
    }
    
    public NodoStack pasarNodo(){
        return top;
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
    public void pushsencillo(String name, int numero){
        NodoStack nuevo = new NodoStack(name, numero);
        if (this.isEmpty()) {
            top = base = nuevo;
        }else{
            nuevo.setNext(top);
            top = nuevo;
        }
        size++;
    }
    
    public void push(NodoStack nodo){
        if (this.isEmpty()) {
            top = base = nodo;
        }else{
            nodo.setNext(top);
            top = nodo;
        }
        size++;
    }
    
//    public void pushArbol(Object arbol, int numero){
//        Nodo nuevo = new Nodo(arbol, numero);
//        if (this.isEmpty()) {
//            top = base = nuevo;
//        }else{
//            nuevo.setNext(top);
//            top = nuevo;
//        }
//        size++;
//    }
}
