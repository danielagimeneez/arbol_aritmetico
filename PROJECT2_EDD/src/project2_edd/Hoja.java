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
    private String letra;  
    private Hoja derecha;
    private Hoja izquierda;
  
    public Hoja(String Letra) {  
        this.letra = letra;  
        this.izquierda = null;
        this.derecha = null; 
    } 

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
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
