/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2_edd;

import java.util.Stack;
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
        if ("/".equals(primero)) {
            tipoDeOperacion = "Polaca";
            return tipoDeOperacion;
        }else if("/".equals(ultimo)){
            tipoDeOperacion = "Polaca inversa";
            return tipoDeOperacion;
        }
        //else if ("(".equals(primero) && ")".equals(ultimo)){
        else{
            tipoDeOperacion = "Infija";
            return tipoDeOperacion;
        }
        //return tipoDeOperacion;
    }
    
    public String coincidir(String tipoDeAnotacion, String polinomio_txt){
        String tipoOperacion = tipoOperacion(polinomio_txt);
        if (tipoDeAnotacion != tipoOperacion && tipoDeAnotacion != "Desconocida") {
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
                System.out.println("Inicio");
                polinomio_PI = transformarIaPI(polinomio_txt);
                System.out.println( polinomio_PI);
                System.out.println("fin");
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
    
    public String transformarPaPI(String polinomio_tx){
        String polinomio_PI = "";
        
        return polinomio_PI;
    }

    //Transforma notacion infija en polaca inversa
    public String transformarIaPI(String polinomio_txt){
        String polinomio_PI = "";
        //Stack<Character> stack = new Stack<>();
        Pila stack = new Pila();
        
        //recorrer cada caracter del polinomio
        for (int i = 0; i < polinomio_txt.length(); i++) {
            //declaras el caracter en una variable
            char car = polinomio_txt.charAt(i);
            
            //ve si el caracter es un operador o un operando
            if(jerarquia(car) > 0){
                //peek: elemento top de nuestro stack (sin retirarlo)
                while(stack.isEmpty() == false && jerarquia(stack.peek()) >= jerarquia(car)){
                    polinomio_PI += stack.peek();
                    stack.pop();
                }
                stack.push(car);
            }else if(car == ')'){
                char aux = stack.peek();
                stack.pop();
                while(aux != '('){
                    polinomio_PI += aux;
                    aux = stack.peek();
                    stack.pop();
                }
            }else if(car == '('){
                stack.push(car);
            }else{
                polinomio_PI += car;
            }
            
        }
        for (int i = 0; i < stack.getSize(); i++) {
            polinomio_PI += stack.peek();
            stack.pop();
        }
       
        return polinomio_PI;
    }
    public int jerarquia(char car){
        switch(car){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    
}
