package practica1ipc;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author DANIEL
 */
public class Practica1Ipc {
    
    String sala1[]=new String[10];//Arreglos que posteriormente me servirán para el reporte ya que almacenarán cada peliculas que se vaya pasando en dicha sala
    String sala2[]=new String[10];
    String sala3[]=new String[10];
    String sala4[]=new String[10];
    String sala5[]=new String[10];
    String peliculas[][]=new String[4][100];//4 filas 100 columnas. Lo maxio de peliculas es 100 Validar eso
    String asientosSala1[][]= new String[8][5];//Matriz para visualizar los asientos disponibles en las salas
    String asientosSala2[][]= new String[8][5];
    String asientosSala3[][]= new String[8][5];
    String asientosSala4[][]= new String[8][5];
    String asientosSala5[][]= new String[8][5];
    String asientosSala6[][]= new String[8][5];
    int contPeliIngresada=0;//Contador para que incremente cada que ingreso una pelicula individual
    
    
    String nombreUsuario;
    int password;
    int opc;
    Scanner s = new Scanner(System.in);//Variable que leera las entradas
    Scanner s2 = new Scanner(System.in);

    //:::::::::::::::::::::::::::::::::ENTRADA AL SISTEMA::::::::::::::::::::::::::::::::::::::::::: 
    public void entradaSistema() {
        System.out.println("Bienvenido");
        System.out.println("");

        System.out.println("Ingrese su nombre de usuario: ");
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

        try {
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
            System.out.println("7. Mostrar Peliculas Ingresadas");

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
                    
                case 7:
                    mostrarPeliculas();
                    break;
                    
                default:
                    System.out.println("Opcion incorrecta, debe ingresar un número entre 1-");
                    System.out.println("");
                    sistemaAdmin();
                    break;
            }

        } catch (Exception e) {

        }

    }
//----------------------------------------------- Menú para Ingreso de películas--------------------------------------

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
            opc = s.nextInt();

            switch (opc) {

                case 1:
                    ingresarIndividual();
                    break;

                case 2:
                    ingresarPorGrupo();
                    break;

                case 3:
                    sistemaAdmin();
                    break;

                default:
                    System.out.println("Opción mal seleccionada, intente nuevamente");
                    ingresarPeliculas();
                    break;

            }

        } catch (Exception e) {
            System.out.println("Opción mal ingresada, intenta nuevamente");

        } finally {
            ingresarPeliculas();
        }

    }

    //-----------------------------------------Ingreso de películas Individual-------------------------------------------
    public void ingresarIndividual() {
        Scanner v=new Scanner(System.in);
        Scanner v2=new Scanner(System.in);
        String nombrePelicula;
        int tiempoDuracion;
        String productor;
        String lenguaje;
        int opc;
        
        try{
            
        System.out.println("************");
        System.out.println("Ingreso Individual");
        System.out.println("**************");
        
        System.out.println("Ingrese nombre de la película: ");
            System.out.println("");
            System.out.println("");   
        nombrePelicula=v.nextLine();
        
        System.out.println("Ingrese el tiempo de duración");
        tiempoDuracion=v.nextInt();
            System.out.println("");
            System.out.println("");
            
        System.out.println("Ingrese nombre del productor: ");
        productor=v2.nextLine();
            System.out.println("");
            System.out.println("");
        System.out.println("Ingrese lenguaje de la película: ");
        lenguaje=v2.nextLine();
        
        peliculas[0][contPeliIngresada]=nombrePelicula;
        peliculas[1][contPeliIngresada]=Integer.toString(tiempoDuracion);
        peliculas[2][contPeliIngresada]=productor;
        peliculas[3][contPeliIngresada]=lenguaje;
        
        contPeliIngresada++;
        //Momento de guardar estos datos en una matriz!! Recordar castear el numero entero
        
        System.out.println("Película Ingresada...\n \n");
        System.out.println("Presione 0 para regresar ó  1 para ingresar otra película...");
        opc=s.nextInt();
        switch(opc){
            case 0:
                ingresarPeliculas();
                break;
                
                
            case 1:
                ingresarIndividual();
                break;
                
            default:
                System.out.println("¡Opción incorrecta!");
                ingresarPeliculas();
                break;
        }
            
        }catch(Exception e){
            System.out.println("Opcion mal ingresada intente de nuevo");
        }

        

    }
    
    public void mostrarPeliculas(){
        int ingresar;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 100; j++) {
                if(peliculas[i][j]==null){
                    peliculas[i][j]="  ";
                }
                
            }
            
        }
        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
                for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(" | " +peliculas[i][j]+"  |  ");
                
            }
            System.out.println("");
            
        }
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
                
                System.out.println("");
                System.out.println("PRESIONE 0 PARA REGRESAR AL MENU");
                ingresar=s.nextInt();
                if(ingresar==0){
                    sistemaAdmin();
                }else{
                    System.out.println("OPCION INCORRECTA, SERÁ ENVIADO AL INICIO");
                    sistemaAdmin();
                }
                
                
    }

    //-------------------------------------------------------------------------------------------------------------------
//--------------------------------------------Ingreso de películas por grupo---------------------------------------------
    public void ingresarPorGrupo() {
        Scanner h= new Scanner(System.in);
        String cadena;
        System.out.println("*********************************");
        System.out.println("Ingrese de películas por grupos");
        System.out.println("**********************************");
        
        System.out.println("Ingrese la cadena para cargar las películas al sistema");
        cadena=h.nextLine();
        
        
        String datos[]=cadena.split(";");
        String datosSeparados[]=null;
        if(contPeliIngresada>0){
              for (int i =0; i < datos.length; i++) {
            datosSeparados=datos[i].split(",");
            peliculas[0][contPeliIngresada]=datosSeparados[0];
            peliculas[1][contPeliIngresada]=datosSeparados[1];
            peliculas[2][contPeliIngresada]=datosSeparados[2];
            peliculas[3][contPeliIngresada]=datosSeparados[3];
            contPeliIngresada++;
        }
            
        }else{
                    for (int i = 0; i < datos.length; i++) {
            datosSeparados=datos[i].split(",");
            peliculas[0][i]=datosSeparados[0];
            peliculas[1][i]=datosSeparados[1];
            peliculas[2][i]=datosSeparados[2];
            peliculas[3][i]=datosSeparados[3];
            
        }
            
        }
        

    }

    //--------------------------------------------------------------------------------------------------------------------
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
