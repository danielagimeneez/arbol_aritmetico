/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2_edd;

import javax.swing.JOptionPane;

/**
 *
 * @author andres
 */
public class funciones {
    
    public String tipoOperacion(String operacion){
        String primero = String.valueOf(operacion.charAt(0));
        String ultimo = String.valueOf(operacion.charAt(operacion.length()-1));
        String tipoDeOperacion = "No";
        if (primero == "/") {
            JOptionPane.showMessageDialog(null, "Polaca");
            tipoDeOperacion = "Polaca";
            return tipoDeOperacion;
        }else if(ultimo == "/"){
            JOptionPane.showMessageDialog(null, "Polaca inversa");
            tipoDeOperacion = "Polaca inversa";
            return tipoDeOperacion;
        }else if (primero == "(" && ultimo == ")"){
            JOptionPane.showMessageDialog(null, "Infija");
            tipoDeOperacion = "Infija";
            return tipoDeOperacion;
        }
        return tipoDeOperacion;
    }
    
    public String coincidir(String tipoDeAnotacion, String polinomio_txt){
        String tipoOperacion = tipoOperacion(polinomio_txt);
        if (tipoDeAnotacion != polinomio_txt && tipoDeAnotacion != "Desconocida") {
            if (tipoDeAnotacion == "Polaca Inversa") {
                JOptionPane.showMessageDialog(null, "Esta operación no es Polaca inversa");
            }else if (tipoDeAnotacion == "Polaca") {
                JOptionPane.showMessageDialog(null, "Esta operación no es Polaca");
            }else if (tipoDeAnotacion == "Infija") {
                JOptionPane.showMessageDialog(null, "Esta operación no es Infija");
            }else{
                JOptionPane.showMessageDialog(null, "Esto no es una operación matematica");
            }
            return "falso";
        }else{
            String polinomio_PI = "";
            if (tipoDeAnotacion == "Polaca Inversa") {
                polinomio_PI = polinomio_txt;
            }else if (tipoDeAnotacion == "Polaca") {
                polinomio_PI = transformarPaPI(polinomio_txt);
            }else if (tipoDeAnotacion == "Infija") {
                polinomio_PI = transformarIaPI(polinomio_txt);
            }else{
                if (tipoDeAnotacion == "Polaca Inversa") {
                    polinomio_PI = polinomio_txt;
                }else if (tipoDeAnotacion == "Polaca") {
                    polinomio_PI = transformarPaPI(polinomio_txt);
                }else if (tipoDeAnotacion == "Infija") {
                    polinomio_PI = transformarIaPI(polinomio_txt);
                }
            }
            return polinomio_PI;
        }
        
    }
    
    public String transformarPaPI(String polinomio_txt){
       String polinomio_PI = "";
       return polinomio_PI;
    }

    public String transformarIaPI(String polinomio_txt){
        String polinomio_PI;
       return polinomio_PI = "";
    }

    
}
