
package practica1ipc;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author DANIEL
 */
public class Practica1Ipc {
private String nombreUsuario;
    private String password;
    Scanner s= new Scanner(System.in);//Variable que leera las entradas
    
    
    public void entradaSistema(){
        System.out.println("Bienvenido");
        System.out.println("");
        
        System.out.println("Ingrese su nobre de usuarrio: ");
        nombreUsuario=s.nextLine();
        
        System.out.println("Ingrese su contraseña: ");
        password=s.nextLine();
        
        
        if(nombreUsuario.equalsIgnoreCase("Vendedor"));
        
        
        
    }
    

  
    public static void main(String[] args) {
        
           Practica1Ipc objeto=new Practica1Ipc();
        objeto.entradaSistema();
        
     
    }
    
}
