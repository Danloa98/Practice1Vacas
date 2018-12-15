package practica1ipc;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author DANIEL
 */
public class Practica1Ipc {

    Random r1 = new Random();//Objeto Random para la sala1
    Random r2 = new Random();//Objeto Random para la sala2...
    Random r3 = new Random();
    Random r4 = new Random();
    Random r5 = new Random();
    String sala1[] = new String[10];//Arreglos que posteriormente me servirán para el reporte ya que almacenarán cada peliculas que se vaya pasando en dicha sala
    String sala2[] = new String[10];
    String sala3[] = new String[10];
    String sala4[] = new String[10];
    String sala5[] = new String[10];
    String peliculas[][] = new String[4][100];//4 filas 100 columnas. Lo maxio de peliculas es 100 Validar eso
    
    String asientosSala1[][] ={{"a1","a2","a3","a4","a5"},{"b1","b2","b3","b4","b5"},{"c1","c2","c3","c4","c5"},{"d1","d2","d3","d4","d5"},{"e1","e2","e3","e4","e5"},{"f1","f2","f3","f4","f5"},{"g1","g2","g3","g4","g5"},{"h1","h2","h3","h4","h5"}};
    //String asientosSala1[][] = new String[8][5];//Matriz para visualizar los asientos disponibles en las salas
    String asientosSala2[][] = new String[8][5];
    String asientosSala3[][] = new String[8][5];
    String asientosSala4[][] = new String[8][5];
    String asientosSala5[][] = new String[8][5];
    String asientosSala6[][] = new String[8][5];
    int contPeliIngresada = 0;//Contador para que incremente cada que ingreso una pelicula individual
    int sizeSala1 = 0;//Guardará la longitud de las salas, sirve para saber si ya se le asignó una pelicula. (ASIGNACION MANUAL) 
    int sizeSala2 = 0;
    int sizeSala3 = 0;
    int sizeSala4 = 0;
    int sizeSala5 = 0;  
    int cantAsientosSala1 = 0;//Variables que llevaran el conteo de la cantidad de asientos que se vendieron en cada sala para el reporte final
    int totalCantAsientosSala1=0;//Contador total de la cant de asientos en sala1
    int total1;//Total general de la sala1
    int totalSala1=0;//Para que me muestre el total de gasto hehe
    int cantAsientosSala2 = 0;
    int cantAsientosSala3 = 0;
    int cantAsientosSala4 = 0;
    int cantAsientosSala5 = 0;
    int gananciaPelicula1=0;
    int gananciaPelicula2=0;
    int gananciaPelicula3=0;

    int hora = 13;//Hora de inicion del sistema
    String peliculasDisponibles[] = new String[5];// arreglo temporal de peliculas disponibles en cada horario, se borrará después de cada simulación
    int contPeliDisponible = 0;

    String nombreUsuario;
    int password;
    int opc;
    Scanner s = new Scanner(System.in);//Variable que leera las entradas
    Scanner s2 = new Scanner(System.in);

    //:::::::::::::::::::::::::::::::::ENTRADA AL SISTEMA::::::::::::::::::::::::::::::::::::::::::: 
    public void entradaSistema() {
        Scanner aa = new Scanner(System.in);
        Scanner bb = new Scanner(System.in);
        System.out.println("______________________________");
        System.out.println("   Bienvenido a FILM WORLD");
        System.out.println("______________________________");
        System.out.println("");

        System.out.println("Ingrese su nombre de usuario: ");
        nombreUsuario = aa.nextLine();

        System.out.println("");
        System.out.println("");

        System.out.println("Ingrese su contraseña: ");
        password = bb.nextInt();

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
        System.out.println("HORA: " + hora + ":00");

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
        //Primero me sercioro de que hayan peliculas disponibles para ver
        //si los siguienes contadores estan vacios luego de recorrer la matriz entonces no hay pelis disponibles

        Scanner xx = new Scanner(System.in);
        Scanner yy = new Scanner(System.in);
        Scanner zz= new Scanner(System.in);
        Scanner aa=new Scanner(System.in);
        int eleccion;
        String eleccionCadena;
        int cantidadDeAsientos;
        String asientoElecto;
        int dineroPago;//Billete con el que pagará el cliente
        int auxAsientos = 0;

        int aux = 0;//Variable que me permitirá determinar si hay peliculas disponibles o no, dependiendo de si es igual a cero luego de recorrer la matriz de peliculas disponibles

        for (int i = 0; i < peliculasDisponibles.length; i++) {
            if (peliculasDisponibles[i] != null) {
                aux++;
            }
        }

        if (aux == 0) {

            System.out.println("No existen películas disponibles en las salas en este momento, consulte al administrador");
            sistemaVendedor();
        } else {

            System.out.println("______________________");
            System.out.println("  VENTA DE ASIENTOS");
            System.out.println("______________________");
            System.out.println("");
            System.out.println("Peliculas Disponibles: ");
            for (int i = 0; i < peliculasDisponibles.length; i++) {
                System.out.println(((i + 1) + ".") + peliculasDisponibles[i] + " En horario de " + hora + ":00");
            }
            System.out.println("");

            System.out.println("Elija la película que desea ver: ");
            eleccionCadena = xx.nextLine();
            System.out.println("Cantidad de asientos: ");
            cantidadDeAsientos = yy.nextInt();

            //Colocar Try catch aquí??   
            
            
            
            //______________________________Para sala 1________________________________________________________________
            
            
            if ((eleccionCadena.equalsIgnoreCase(peliculasDisponibles[0])) || eleccionCadena.equalsIgnoreCase("1")) {//Creo que sí funcionaria esta sentencia ya que lñas peliculas random al final se ingresan en el mismo orden que se muestran en la ventana del vendedor (Eso espero :0)
                //Imprimir asientos sala 1
                //Aumentar el contador de asientos vendidos de la sala 1
//                for (int i = 0; i < 8; i++) {
//                    for (int j = 0; j < 5; j++) {
//                        if (asientosSala1[i][j] != null) {
//                            auxAsientos++;
//                        }
//                    }
//                }

//                if (auxAsientos == 0) {
//                    printSala1();
//                } else {
//
//                }
                    printSala1();

                if (cantidadDeAsientos > 1) {//Si la cantidad de asientos es mayor a uno, solo podré ingresar rangos
                    boolean flag=false;
                    boolean flag2=false;
                    String rangoAsientos;
                    Scanner hh=new Scanner(System.in);
                    Scanner ll=new Scanner(System.in);
                    int money;
                    System.out.println("");
                    System.out.println("");
                    
                    
//         for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(asientosSala1[i][j] + " ");
//            }
//            System.out.println(" ");
//
//        }
                    System.out.println(" ");
                    System.out.println("Introduzca el rango de asientos deseado: ");
                    rangoAsientos=hh.nextLine();
                             String rango[];
                             rango = rangoAsientos.split("-");
                              for (int i = 0; i < rango.length; i++) {
                                  System.out.println(rango[i]);
                                 }
                              
                              for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {

                if ((asientosSala1[i][j].equals(rango[1]))) {
                    flag = true;
                }
                asientosSala1[i][j]=" * ";

                if (flag == true) {
                    break;
                }
                

            }
            if (flag == true) {
                break;

            } else {

            }
        }
        


        
        
    String codigoAsiento[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    
        for (int i = 0; i < 8; i++) {
            
            for (int j = 0; j < 5; j++) {
                
                asientosSala1[i][j] = (codigoAsiento[i] + (j + 1));
                if(asientosSala1[i][j].equals(rango[0])){
                    flag2=true;
                    asientosSala1[i][j]=" * ";
                }
                 
                
                if(flag2==true){
                    break;
                }
                
            }if(flag2==true){
                break;
            }else{
                
            }
        }
        
        
       
                              
                    System.out.println("Ingrese la cantidad de dinero con la cual pagará: ");
                    money=ll.nextInt();
                    
                    
                    
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(asientosSala1[i][j] + " ");
            }
            System.out.println(" ");
        }
                    
                    
      int total=cantidadDeAsientos*30;
                    System.out.println("___________________________________________");
                    System.out.println("           Nombre de la Película: "+ peliculasDisponibles[0]);
                    System.out.println("                  Sala:   1  ");
                    System.out.println("                 Asiento: "+ rangoAsientos);
                    System.out.println("                  Total: "+(total));
                    System.out.println("                  Cambio: "+ (money-(total)));
                    System.out.println("_______________________________________________");
                              
                              
                              
                    
       //______________________________________Solo un Asiento____________________________             
                    

                } else {
                    System.out.println("Ingrese el numero del asiento");
                    asientoElecto = zz.nextLine();
                    System.out.println("");
                    
                    System.out.println("Ingrese la cantidad de dinero con la cual pagará: ");
                    dineroPago=aa.nextInt();

                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (asientosSala1[i][j].equals(asientoElecto)) {
                                asientosSala1[i][j] = "*";
                                cantAsientosSala1+=cantidadDeAsientos;
                            }
                        }
                    }
                    System.out.println("");
                    
               System.out.println("----Asiento Vendido---");                
               printSala1();
                       int total=cantidadDeAsientos*30;
                    System.out.println("___________________________________________");
                    System.out.println("           Nombre de la Película: "+ peliculasDisponibles[0]);
                    System.out.println("                  Sala:   1  ");
                    System.out.println("                 Asiento: "+ asientoElecto);
                    System.out.println("                  Total: "+(total));
                    System.out.println("                  Cambio: "+ (dineroPago-(total)));
                    System.out.println("_______________________________________________");
                    
                    
                }
                

            
                
                
                sistemaVendedor();
                
                

            }

            if ((eleccionCadena.equalsIgnoreCase(peliculasDisponibles[1])) || eleccionCadena.equalsIgnoreCase("2")) {

            }

            if ((eleccionCadena.equalsIgnoreCase(peliculasDisponibles[2])) || eleccionCadena.equalsIgnoreCase("3")) {

            }

            if ((eleccionCadena.equalsIgnoreCase(peliculasDisponibles[3])) || eleccionCadena.equalsIgnoreCase("4")) {

            }

            if ((eleccionCadena.equalsIgnoreCase(peliculasDisponibles[4])) || eleccionCadena.equalsIgnoreCase("5")) {

            }

        }

    }
        
    
    
    public void iniciarSala1(){
        
        
        String codigoAsiento[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                asientosSala1[i][j] = codigoAsiento[i] + (j + 1) + " ";
            }
        }
        
    }
    public void printSala1() {

//        String codigoAsiento[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 5; j++) {
//                asientosSala1[i][j] = codigoAsiento[i] + (j + 1) + " ";
//            }
//        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(asientosSala1[i][j]+" ");
            }
            System.out.println(" ");
        }
        //Después de esto ya solo me encargo de manejar el arreglo general/global

    }

    public void printSala2() {

        String codigoAsiento[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                asientosSala2[i][j] = codigoAsiento[i] + (j + 1) + " ";
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(asientosSala2[i][j]);
            }
            System.out.println(" ");
        }

    }

    public void printSala3() {

        String codigoAsiento[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                asientosSala3[i][j] = codigoAsiento[i] + (j + 1) + " ";
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(asientosSala3[i][j]);
            }
            System.out.println(" ");
        }

    }

    public void printSala4() {

        String codigoAsiento[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                asientosSala4[i][j] = codigoAsiento[i] + (j + 1) + " ";
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(asientosSala4[i][j]);
            }
            System.out.println(" ");
        }

    }

    public void printSala5() {

        String codigoAsiento[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                asientosSala5[i][j] = codigoAsiento[i] + (j + 1) + " ";
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(asientosSala5[i][j]);
            }
            System.out.println(" ");
        }

    }

    //::::::::::::::::::::::::::::::::::::::MENÚ ADMINISTRADOR::::::::::::::::::::::::::::::::::::::::::::::::::
    public void sistemaAdmin() {

        try {
            int opc;
            System.out.println("");
            System.out.println("*******************");
            System.out.println("MODO ADMINISTRADOR");
            System.out.println("********************");

            System.out.println("HORA: " + hora + ":00");

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
        Scanner v = new Scanner(System.in);
        Scanner v2 = new Scanner(System.in);
        String nombrePelicula;
        int tiempoDuracion;
        String productor;
        String lenguaje;
        int opc;

        try {

            System.out.println("************");
            System.out.println("Ingreso Individual");
            System.out.println("**************");

            System.out.println("Ingrese nombre de la película: ");
            System.out.println("");
            System.out.println("");
            nombrePelicula = v.nextLine();

            System.out.println("Ingrese el tiempo de duración");
            tiempoDuracion = v.nextInt();
            System.out.println("");
            System.out.println("");

            System.out.println("Ingrese nombre del productor: ");
            productor = v2.nextLine();
            System.out.println("");
            System.out.println("");
            System.out.println("Ingrese lenguaje de la película: ");
            lenguaje = v2.nextLine();

            peliculas[0][contPeliIngresada] = nombrePelicula;
//            peliculasDisponibles[contPeliDisponible]=nombrePelicula;
//            contPeliDisponible++;
            peliculas[1][contPeliIngresada] = Integer.toString(tiempoDuracion);
            peliculas[2][contPeliIngresada] = productor;
            peliculas[3][contPeliIngresada] = lenguaje;

            contPeliIngresada++;
            //Momento de guardar estos datos en una matriz!! Recordar castear el numero entero

            System.out.println("Película Ingresada...\n \n");
            System.out.println("Presione 0 para regresar ó  1 para ingresar otra película...");
            opc = s.nextInt();
            switch (opc) {
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

        } catch (Exception e) {
            System.out.println("Opcion mal ingresada intente de nuevo");
        }

    }

    public void mostrarPeliculas() {
        int ingresar;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 100; j++) {
                if (peliculas[i][j] == null) {
                    peliculas[i][j] = "  ";
                }

            }

        }
        System.out.println("_____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(" | " + peliculas[i][j] + "  |  ");

            }
            System.out.println("");

        }
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");

        System.out.println("");
        System.out.println("##############");
        System.out.println(contPeliIngresada);
        System.out.println("PRESIONE 0 PARA REGRESAR AL MENU");
        ingresar = s.nextInt();
        if (ingresar == 0) {
            sistemaAdmin();
        } else {
            System.out.println("OPCION INCORRECTA, SERÁ ENVIADO AL INICIO");
            sistemaAdmin();
        }

    }

    //-------------------------------------------------------------------------------------------------------------------
//--------------------------------------------Ingreso de películas por grupo---------------------------------------------
    public void ingresarPorGrupo() {
        Scanner h = new Scanner(System.in);
        String cadena;
        System.out.println("*********************************");
        System.out.println("Ingrese de películas por grupos");
        System.out.println("**********************************");

        System.out.println("Ingrese la cadena para cargar las películas al sistema");
        cadena = h.nextLine();

        String datos[] = cadena.split(";");
        String datosSeparados[] = null;
        if (contPeliIngresada > 0) {
            for (int i = 0; i < datos.length; i++) {
                datosSeparados = datos[i].split(",");//Esta es la línea clave para la carga masiva
                peliculas[0][contPeliIngresada] = datosSeparados[0];
                peliculas[1][contPeliIngresada] = datosSeparados[1];
                peliculas[2][contPeliIngresada] = datosSeparados[2];
                peliculas[3][contPeliIngresada] = datosSeparados[3];
                contPeliIngresada++;
            }

        } else {
            for (int i = 0; i < datos.length; i++) {
                datosSeparados = datos[i].split(",");
                peliculas[0][i] = datosSeparados[0];
                peliculas[1][i] = datosSeparados[1];
                peliculas[2][i] = datosSeparados[2];
                peliculas[3][i] = datosSeparados[3];
                contPeliIngresada++;

            }

        }

    }

    //--------------------------------------------------------------------------------------------------------------------
    public void asignarPeliculas() {//Método para asignar películas a las salas
        int opc;
        System.out.println("*************************************");
        System.out.println("Asignación de Películas a las salas");
        System.out.println("**************************************");
        System.out.println("");
        System.out.println("Elija una de las opciones");
        System.out.println("");
        System.out.println("1. Asignación Manual");
        System.out.println("2. Asignación atomática");
        System.out.println("3. Ver películas asignadas");
        System.out.println("4. Regresar");
        opc = s.nextInt();
        switch (opc) {
            case 1:
                asignacionManual();
                break;

            case 2:
                asignacionAutomatica();
                break;

            case 3:
                verPeliculasAsignadas();
                break;

            case 4:
                sistemaAdmin();
                break;

            default:
                System.out.println("¡ERROR! Elija una opción correcta...");
                asignarPeliculas();
                break;

        }
    }

    public void asignacionManual() {
        //VERIFICAR scanners
        Scanner k = new Scanner(System.in);
        int posicionPelicula;
        int salaElecta;//Sala que el admin elije para asignarle la película
        int opcionSalida;//Para salir de esta opcion o signar nuevamente una película...
        System.out.println("_______________________");
        System.out.println("ASIGNACIÓN MANUAL");
        System.out.println("_______________________");
        System.out.println("");

        if (contPeliIngresada == 0) {
            System.out.println("****AÚN NO HAY PELÍCULAS DISPONIBLES, INTENTE INGRESAR ALGUNAS...****");
            sistemaAdmin();
        } else {
            System.out.println("A continuacón, se muestran las películas dispoblibles");

            for (int i = 0; i < contPeliIngresada; i++) {
                System.out.println((i + 1) + "." + peliculas[0][i]);

            }
            System.out.println("");
            System.out.println("Salas Disponibles ");//Opcion que sirve ya que si asigno una peli a la sala 5, esta ya no estará disponible :

            if (sizeSala1 == 0) {
                System.out.println("Sala 1");
            }
            if (sizeSala2 == 0) {
                System.out.println("Sala 2");
            }
            if (sizeSala3 == 0) {
                System.out.println("Sala 3");
            }
            if (sizeSala4 == 0) {
                System.out.println("Sala 4");
            }
            if (sizeSala5 == 0) {
                System.out.println("Sala 5");
            } else {
                System.out.println("No hay salas disponibles, intente de nuevo más tarde...");
                sistemaAdmin();
            }

            System.out.println("Ingrese el número de película que dese asignar...");
            posicionPelicula = (s.nextInt());
            //Asignarselo a la sala

            System.out.println("Elija la Sala a la que desea asignar dicha película (1-5)");
            salaElecta = s.nextInt();
            if (salaElecta == 1) {
                sala1[sizeSala1] = peliculas[0][posicionPelicula - 1];//Aquí ya le asignó la película electa a la sala elegida
                //peliculas[0][posicionPelicula-1]=null;
                sizeSala1++;
                peliculasDisponibles[contPeliDisponible] = peliculas[0][posicionPelicula - 1];
                contPeliDisponible++;
            } else if (salaElecta == 2) {
                sala2[sizeSala2] = peliculas[0][posicionPelicula - 1];
                //peliculas[0][posicionPelicula-1]=null;
                sizeSala2++;

                peliculasDisponibles[contPeliDisponible] = peliculas[0][posicionPelicula - 1];
                contPeliDisponible++;
            } else if (salaElecta == 3) {
                sala3[sizeSala3] = peliculas[0][posicionPelicula - 1];
                //peliculas[0][posicionPelicula-1]=null;
                sizeSala3++;

                peliculasDisponibles[contPeliDisponible] = peliculas[0][posicionPelicula - 1];
                contPeliDisponible++;
            } else if (salaElecta == 4) {
                sala4[sizeSala4] = peliculas[0][posicionPelicula - 1];
                //peliculas[0][posicionPelicula-1]=null;
                sizeSala4++;

                peliculasDisponibles[contPeliDisponible] = peliculas[0][posicionPelicula - 1];
                contPeliDisponible++;

            } else if (salaElecta == 5) {
                sala5[sizeSala5] = peliculas[0][posicionPelicula - 1];
                //Apeliculas[0][posicionPelicula-1]=null;
                sizeSala5++;

                peliculasDisponibles[contPeliDisponible] = peliculas[0][posicionPelicula - 1];
                contPeliDisponible++;
            }

            System.out.println("");

            System.out.println("Película: " + peliculas[0][posicionPelicula - 1] + " asignada a Sala" + salaElecta);
            peliculas[0][posicionPelicula - 1] = null;
            System.out.println("");
            System.out.println("Presione 0 para salir o 1 para asignar nuevamente una película...");
            opcionSalida = k.nextInt();
            if (opcionSalida == 0) {
                asignarPeliculas();
            } else if (opcionSalida == 1) {
                asignacionManual();
            } else {
                System.out.println("Opción incorrecta...Saliendo del sistema...");
                sistemaAdmin();
            }

        }

    }

    public void asignacionAutomatica() {
        //int i=0;//Iterador para recorrer la matriz

        //Mientras no esté vacía esa posicion puedo asignarsela a las salas
        //********************************************************************************
//        sala1[sizeSala1] = peliculas[0][r1.nextInt(contPeliIngresada)];//probar el random con 100...
//        sizeSala1++;
//        sala2[sizeSala2] = peliculas[0][r2.nextInt(contPeliIngresada)];
//        sizeSala2++;
//        sala3[sizeSala3] = peliculas[0][r3.nextInt(contPeliIngresada)];
//        sizeSala3++;
//        sala4[sizeSala4] = peliculas[0][r4.nextInt(contPeliIngresada)];
//        sizeSala4++;
//        sala5[sizeSala5] = peliculas[0][r5.nextInt(contPeliIngresada)];
//        sizeSala5++;
//
//        for (int i = 0; i < contPeliIngresada; i++) {
//
//        }
//
//        System.out.println("----Asignacion automatica realizada----");
//        asignarPeliculas();
//        System.out.println("");
//**********************************************************************************
        int x;//Numero aleatorio para la sala 1
        x = r1.nextInt(contPeliIngresada);
        sala1[sizeSala1] = peliculas[0][x];
        sizeSala1++;
        peliculasDisponibles[contPeliDisponible] = peliculas[0][x];
        contPeliDisponible++;
        peliculas[0][x] = null;

        int x2;//Numero Aleatorio para la sala 2
        x2 = r2.nextInt(contPeliIngresada);
        while (x2 == x) {
            x2 = r2.nextInt(contPeliIngresada);//Esta parte de código evita el nuevo random sea igual al anterior
        }
        sala2[sizeSala2] = peliculas[0][x2];
        sizeSala2++;
        peliculasDisponibles[contPeliDisponible] = peliculas[0][x2];
        contPeliDisponible++;
        peliculas[0][x2] = null;

        int x3;
        x3 = r3.nextInt(contPeliIngresada);
        while ((x3 == x) || (x3 == x2)) {
            x3 = r3.nextInt(contPeliIngresada);
        }
        sala3[sizeSala3] = peliculas[0][x3];
        sizeSala3++;
        peliculasDisponibles[contPeliDisponible] = peliculas[0][x3];
        contPeliDisponible++;
        peliculas[0][x3] = null;

        int x4;
        x4 = r4.nextInt(contPeliIngresada);
        while ((x4 == x) || (x4 == x2) || (x4 == x3)) {
            x4 = r4.nextInt(contPeliIngresada);
        }
        sala4[sizeSala4] = peliculas[0][x4];
        //peliculas[0][x4]=null;
        sizeSala4++;
        peliculasDisponibles[contPeliDisponible] = peliculas[0][x4];
        contPeliDisponible++;
        peliculas[0][x4] = null;

        int x5;
        x5 = r5.nextInt(contPeliIngresada);
        while ((x5 == x) || (x5 == x2) || (x5 == x3) || (x5 == x4)) {
            x5 = r5.nextInt(contPeliIngresada);
        }
        sala5[sizeSala5] = peliculas[0][x5];
        //peliculas[0][x5]=null;
        sizeSala5++;
        peliculasDisponibles[contPeliDisponible] = peliculas[0][x5];
        contPeliDisponible++;
        peliculas[0][x5] = null;

        System.out.println("----Asignacion automatica realizada----");
        asignarPeliculas();
        System.out.println("");

//        if((peliculas[0][x]!=null) || (peliculas[0][x]!=" ")){
//        sala1[sizeSala1] = peliculas[0][x];
//        peliculas[0][x]=null;
//        }
    }

    public void verPeliculasAsignadas() {
        System.out.println("___________");
        System.out.println("  SALA 1 ");
        System.out.println("____________");

        if (sizeSala1 == 0) {
            System.out.println("Aún sin películas asignadas...");
        } else {
            for (int i = 0; i < sizeSala1; i++) {
                System.out.println((i + 1) + "." + sala1[i]);
            }
        }
        System.out.println("");
        System.out.println("");

        System.out.println("___________");
        System.out.println("  SALA 2");
        System.out.println("____________");
        if (sizeSala2 == 0) {
            System.out.println("Aún sin películas asignadas...");
        } else {
            for (int i = 0; i < sizeSala2; i++) {
                System.out.println((i + 1) + "." + sala2[i]);
            }
        }

        System.out.println("");
        System.out.println("");

        System.out.println("___________");
        System.out.println("  SALA 3");
        System.out.println("____________");
        if (sizeSala3 == 0) {
            System.out.println("Aún sin películas asignadas...");
        } else {
            for (int i = 0; i < sizeSala3; i++) {
                System.out.println((i + 1) + "." + sala3[i]);
            }
        }
        System.out.println("");
        System.out.println("");

        System.out.println("___________");
        System.out.println("  SALA 4");
        System.out.println("____________");
        if (sizeSala4 == 0) {
            System.out.println("Aún sin películas asignadas...");
        } else {
            for (int i = 0; i < sizeSala4; i++) {
                System.out.println((i + 1) + "." + sala4[i]);
            }
        }
        System.out.println("");
        System.out.println("");

        System.out.println("___________");
        System.out.println("  SALA 5");
        System.out.println("____________");
        if (sizeSala5 == 0) {
            System.out.println("Aún sin películas asignadas...");
        } else {
            for (int i = 0; i < sizeSala5; i++) {
                System.out.println((i + 1) + "." + sala5[i]);
            }
        }

    }

    public void simulacionPeliculas() {

        if (hora >= 13 && hora <= 25) {

            int h = 0;//contador que verifica si hay películas dispobibles...
            for (int i = 0; i < 4; i++) {

                for (int j = 0; j < 100; j++) {
                    if ((peliculas[i][j] != null) || (peliculas[i][j] != "")) {
                        h++;
                    }

                }
            }

            if (h == 0) {
                System.out.println("AÚN NO HAY PELÍCULAS DISPONIBLES, INTENTE NUEVAMENTE");
                System.out.println("");
                sistemaAdmin();
            } else {
                System.out.println("");
                System.out.println("_____________________________________________");
                System.out.println("------------SIMULACIÓN EN PROCESO----------");
                System.out.println("_____________________________________________");
                hora++;
                hora++;
                sistemaAdmin();

            }

        } else {

            System.out.println("Fuera de horario, intente más Tarde...");
            hora++;
            hora++;
            sistemaAdmin();

        }

    }

    public void reportes() {
        
        
        System.out.println("_____________________________________________");
        System.out.println("        Película con más ganancias");
        System.out.println("_____________________________________________");
        
        if(gananciaPelicula1>gananciaPelicula2 && gananciaPelicula1>gananciaPelicula3){
            
        }
        System.out.println("---------------------------------------------");
        
        
        
        
        System.out.println("_______________________________________________");
        System.out.println("      Salas con más Asientos Vendidos");
        System.out.println("________________________________________________");
        
        //Debería guardar la cantidad de asientos vendidos en una matriz y mandarla a llamar con un booble sort?
         System.out.println("Sala 1 : "+cantAsientosSala1);
         System.out.println("Sala 2 : "+cantAsientosSala2);
         System.out.println("Sala 3 : "+cantAsientosSala3);
         System.out.println("Sala 4 : "+cantAsientosSala4);
         System.out.println("Sala 5 : "+cantAsientosSala5);
        
        
       
        
        
        System.out.println("------------------------------------------------");
        
        
        
        
        System.out.println("________________________________________________");
        System.out.println("        Películas pasadas en cada Sala ");
        System.out.println("_______________________________________________");
        
        
        System.out.println("Sala 2: ");
        for (int i = 0; i < sala1.length; i++) {
            System.out.println(sala1[i]);
                
            }
        
        System.out.println("");
        System.out.println("SALA 2");
        for (int i = 0; i < sala2.length; i++) {
            System.out.println(sala2[i]);
        }
        System.out.println("");
        
        System.out.println("SALA 3");
        for (int i = 0; i < sala3.length; i++) {
            System.out.println(sala3[i]);
        }
        
        System.out.println("");
        System.out.println("SALA 4");
        for (int i = 0; i < sala4.length; i++) {
            System.out.println(sala4[i]);
        }
        
        System.out.println("");
        System.out.println("SALA 5");
        for (int i = 0; i < sala5.length; i++) {
            System.out.println(sala5[i]);
        }
        
    
        }
    

    public static void main(String[] args) {

        Practica1Ipc objeto = new Practica1Ipc();
        objeto.entradaSistema();

    }

}
