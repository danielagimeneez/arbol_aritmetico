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
    
    
    public Arbol conversionArbol(String polinomio_PI){
        Stack stack = new Stack();
        
        while(polinomio_PI != ""){
            String c = String.valueOf(polinomio_PI.charAt(0));
            polinomio_PI = polinomio_PI.substring(0);
            
            if (isNumeric(c) == true) {
                Hoja hoja = new Hoja(c);
                NodoStack nodo = new NodoStack(c, hoja);
                stack.push(nodo);
            }else if (c.charAt(0) == 'x' || c.charAt(0) == 'y') {
                Hoja hoja = new Hoja(c);
                NodoStack nodo = new NodoStack(c, hoja);
                stack.push(nodo);
            }else if (c.charAt(0) == '+' || c.charAt(0) == '-' || c.charAt(0) == '*' || c.charAt(0) == '/' || c.charAt(0) == '^' ) {
                if (stack.getSize() < 2) {
                    //error = true;
                    System.out.println("Se detecto un erroooor");
                }else{
                    Hoja h2 = (Hoja) stack.pasarNodo().getValorH();
                    stack.pop();
                    Hoja h1 = (Hoja) stack.pasarNodo().getValorH();
                    stack.pop();
                    Hoja hoja = new Hoja(c, h1, h2);
                    NodoStack nodo = new NodoStack(c, hoja);
                    stack.push(nodo);
                }
            }
        }
        
        Hoja arbol = (Hoja) stack.pasarNodo().getValorH();
        stack.pop();
        Arbol Arbolito = new Arbol(arbol);
        
        return Arbolito;
    }
    
    /*public Arbol conversionArbol(String polinomio_PI){
        Arbol arbol = new Arbol();
        Arbol elArbol = new Arbol();
        Pila stack = new Pila();
        System.out.println("hola");
        boolean error = false;
        int contador = polinomio_PI.length();
        
        while(polinomio_PI.length() > 0 && error==false){
            System.out.println(polinomio_PI.length());
            String e = String.valueOf(polinomio_PI.charAt(0));
            //removefirstChar(polinomio_PI);
            polinomio_PI = polinomio_PI.substring(1);
            System.out.println(polinomio_PI);
            System.out.println(e);
            String operadores = "+-/*^";
            if (isNumeric(e) == true) {
                stack.push(e.charAt(0), contador);
                System.out.println("un numero");
            }else if (e.charAt(0) == 'x' || e.charAt(0) == 'y') {
                stack.push(e.charAt(0), contador);
                System.out.println("una variable");
            }else if (e.getClass().getSimpleName() == "Arbol") {
                //que acepte un arbol
                stack.pushArbol(e, contador);
                stack.push(e.charAt(0), contador);
                System.out.println("un arbol");
            }else if (e == "(") {
                error = true;
                System.out.println("Se detecto un error");
            //}else if (operadores.contains(e)) {
            }else if (e.charAt(0) == '+' || e.charAt(0) == '-' || e.charAt(0) == '*' || e.charAt(0) == '/' || e.charAt(0) == '^' ) {
                if (stack.getSize() < 2) {
                    error = true;
                    System.out.println("Se detecto un erroooor");
                }else{
                    String a2 = String.valueOf(stack.peek());
                    stack.pop();
                    String a1 = String.valueOf(stack.peek());
                    stack.pop();
                    Hoja hoja = new Hoja(e);

                    Hoja hojaDerecha = new Hoja(a2);
                    hoja.setDerecha(hojaDerecha);
                    Hoja hojaIzquierda = new Hoja(a1);
                    hoja.setIzquierda(hojaIzquierda);
                    System.out.println(hoja.toString());
                    Arbol miniArbol = new Arbol(hoja);
                    //Insertar el arbol en la pila
                    stack.pushArbol(miniArbol, contador);
                }
            }else{
                System.out.println("no me aplica ninguno");
            }
            System.out.println(stack.getSize());
        }
        contador--;
        System.out.println("salio");
        
        if (stack.isEmpty() == true || stack.getSize() > 1) {
            error = true;
            System.out.println("Se detecto un error");
        }else{
            String e = String.valueOf(stack.peek());
            stack.pop();
            if (e.getClass().getSimpleName() != "Arbol") {
                Hoja hoja = new Hoja(e);
                Arbol miniArbol = new Arbol(hoja);
            }
            //El resultado del algoritmo (el arbol de salida) es E
        }
        
        if (error == true){
            stack.empty();
        }
        
        return null;
    }*/
    
    void preorden(Hoja n) {   
        if (n != null) {   
            System.out.println(n.toString());   
            preorden(n.getIzquierda());   
            preorden(n.getDerecha());   
        }   
    }   
    
    //Te dice si es numerico o no
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static String removefirstChar(String str){
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(1);
    }
}
