/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2_edd;

/**
 *
 * @author andres
 */
public class Hoja {
    private String name;  
    private Hoja derecha;
    private Hoja izquierda;
  
    public Hoja(String name) {  
        this.name= name;  
        this.izquierda = null;
        this.derecha = null; 
    } 
    public Hoja(String name, Hoja izquierda, Hoja derecha) {  
        this.name= name;  
        this.izquierda = izquierda;
        this.derecha = derecha; 
    } 

    @Override
    public String toString() {
        return "Hoja{" + "name=" + name + ", derecha=" + derecha + ", izquierda=" + izquierda + '}';
    }
    
    

    public String getLetra() {
        return name;
    }

    public void setLetra(String name) {
        this.name = name;
    }

    public Hoja getDerecha() {
        return derecha;
    }

    public void setDerecha(Hoja derecha) {
        this.derecha = derecha;
    }

    public Hoja getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Hoja izquierda) {
        this.izquierda = izquierda;
    }
    
    
    
}
