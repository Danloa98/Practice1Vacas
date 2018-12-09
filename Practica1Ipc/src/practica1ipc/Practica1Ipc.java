package practica1ipc;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author DANIEL
 */
public class Practica1Ipc {

    String nombreUsuario;
    int password;
    int opc;
    Scanner s = new Scanner(System.in);//Variable que leera las entradas
    Scanner s2 = new Scanner(System.in);

    //:::::::::::::::::::::::::::::::::ENTRADA AL SISTEMA::::::::::::::::::::::::::::::::::::::::::: 
    public void entradaSistema() {
        System.out.println("Bienvenido");
        System.out.println("");

        System.out.println("Ingrese su nobre de usuario: ");
        nombreUsuario = s.nextLine();

        System.out.println("Ingrese su contraseña: ");
        password = s2.nextInt();

        try {

            if (nombreUsuario.equalsIgnoreCase("Vendedor") && password == 201700390) {//Verificar la validacion para el tipo de dato de password
                nombreUsuario = null;
                sistemaVendedor();

            } else if (nombreUsuario.equalsIgnoreCase("Admin") && password == 201700390) {

                sistemaAdmin();

            } else {

                if (nombreUsuario.equalsIgnoreCase("")) {
                    System.out.println("¡No puede dejar espacios en blanco, intende de nuevo!");

                    System.out.println("*******************************************************");

                } else {
                    System.out.println("****¡ERROR!Usuario/Contraseña mal ingresada, intente de nuevo****");
                    System.out.println("");
                    System.out.println("");
                }
            }

        } catch (Exception e) {
            System.out.println("Usuario/Contraseña mal ingresada, intente de nuevo");

        } finally {
            entradaSistema();
        }

    }
    //............................................................................................................  .

    //:::::::::::::::::::::::::::::::::::MENÚ DEL VEDEDOR:::::::::::::::::::::::::::::::::::::::::::::::
    public void sistemaVendedor() {
        System.out.println("");
        System.out.println("...............");
        System.out.println("MODO VENDEDOR");
        System.out.println("...............");

        System.out.println("");
        System.out.println("Elija una de las siguientes opciones: ");
        System.out.println("1. Vender Asientos");
        System.out.println("2. Regresar");
        System.out.println("3. Salir");

        opc = s.nextInt();

        switch (opc) {
            case 1:

                venderAsientos();
                break;

            case 2:
                nombreUsuario = null;
                password = 0;
                entradaSistema();
                break;

            case 3:
                System.exit(0);
                break;
        }

    }

    //......................................Vender Asientos..............................................   
    public void venderAsientos() {

    }

    //::::::::::::::::::::::::::::::::::::::MENÚ ADMINISTRADOR::::::::::::::::::::::::::::::::::::::::::::::::::
    public void sistemaAdmin() {
        int opc;
        System.out.println("");
        System.out.println("*******************");
        System.out.println("MODO ADMINISTRADOR");
        System.out.println("********************");

        System.out.println("Elaja una de las siguientes opciones del menú: ");
        System.out.println("1. Ingresar películas");
        System.out.println("2. Asignación de Películas a la sala");
        System.out.println("3. Simulación de películas");
        System.out.println("4. Reportes");
        System.out.println("5. Regresar");
        System.out.println("6. Salir del sistema");

        opc = s.nextInt();

        switch (opc) {
            case 1:
                ingresarPeliculas();
                break;

            case 2:
                asignarPeliculas();
                break;

            case 3:
                simulacionPeliculas();
                break;

            case 4:
                reportes();
                break;

            case 5:
                entradaSistema();
                break;

            case 6:
                System.exit(0);
                break;
        }

    }

    public void ingresarPeliculas() {

        try {

            int opc;//Variable para almacenar la opción que se elija del menú
            System.out.println("");
            System.out.println("**********************");
            System.out.println("Ingreso de Películas");
            System.out.println("***********************");
            System.out.println("1. Ingresar individual ");
            System.out.println("2. Ingresar por grupo");
            System.out.println("3. Regresar");

        } catch (Exception e) {

        }

    }

    public void asignarPeliculas() {//Método para asignar películas a las salas

    }

    public void simulacionPeliculas() {

    }

    public void reportes() {

    }

    public static void main(String[] args) {

        Practica1Ipc objeto = new Practica1Ipc();
        objeto.entradaSistema();

    }

}
