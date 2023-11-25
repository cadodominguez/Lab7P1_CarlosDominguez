//Fila 3, asiento 5
package lab7p1_carlosdominguez;
import java.util.Scanner;
import java.util.Random;
public class Lab7P1_CarlosDominguez {
    
    static Scanner sc = new Scanner (System.in);
    static Random rm = new Random ();
    
    public static void main(String[] args) {
        boolean finalw = true;
        while (finalw == true){
            System.out.println("1. Tres en raya");
            System.out.println("2. Puntos de silla");
            System.out.println("3. Salir");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1 : {
                    char resp = 's';
                    while (resp == 's' || resp == 'S'){
                        int filas = 3;
                        int columnas = 3;
                        System.out.println("---------Bienvenido al tres en Raya------");
                        char [][] tablero = llenadovacioinicial (filas,columnas);
                        System.out.println("Tablero Actual : ");
                        generartablero (tablero);
                        boolean verificar = false;
                        int contv = 0;
                        while (verificar == false){
                            System.out.println("Es el turno de X :");
                            System.out.println("Ingrese la fila (0,1,2) :");
                            filas = sc.nextInt();
                            System.out.println("Ingrese la columna (0,1,2) :");
                            columnas = sc.nextInt();
                            System.out.println("El usuario elegio la posicion : ("+filas+","+columnas+")" );
                            boolean verf = verificarposicionvalida(tablero,filas,columnas);
                            if (verf == false){
                                System.out.println("La posicion ya esta ocupada o no esta dentro del rango");
                            }else{
                                contv +=1;
                                tablero[filas][columnas]= 'X';
                            }
                            generartablero(tablero);
                            //turno X

                            System.out.println("Es el turno de O :");
                            filas = rm.nextInt((2-0)+1);
                            System.out.println("Ingrese la columna (0,1,2) :");
                            columnas = rm.nextInt((2-0)+1);
                            System.out.println("La maquina elegio la posicion : ("+filas+","+columnas+")" );
                            verf = verificarposicionvalida(tablero,filas,columnas);
                            if (verf == false){
                                System.out.println("La posicion ya esta ocupada o no esta dentro del rango");
                            }else{
                                contv +=1;
                                tablero[filas][columnas]= '0';
                            }
                            generartablero(tablero);
                            if (verificarVictoriaO(tablero) == false && verificarVictoriaX (tablero) ==true){
                            System.out.println("Gano X");
                            System.out.println("Gano el usuario");
                            verificar = true;
                            }else if (verificarVictoriaO(tablero) == true && verificarVictoriaX (tablero) ==false){
                            System.out.println("Gano O");
                            System.out.println("Gano la maquina");
                            verificar = true;
                            }
                            if (contv==9){
                            System.out.println("Es un Empate :");
                            verificar = true;
                        }
                    }
                    System.out.println("Desea volver a jugar (S/N) :");
                    resp = sc.next().charAt(0);
                    }
                    break;
                }
                case 2 : {
                    System.out.println("Ingrese numero de filas :");
                    int filas = sc.nextInt();
                    System.out.println("Ingrese la cantidad de columnas");
                    int columnas = sc.nextInt();
                    int [] [] arreglo = generarIntMatrizAleatoria(filas,columnas);
                    imprimirmat(arreglo);
                    encontrarPuntosSilla(arreglo,columnas,filas);
                    break;
                }
                case 3 : {
                    System.out.println("Saliendo.....");
                    finalw = false;
                    break;
                }
                default : {
                    System.out.println("Ingrese una opcion valida");
                    break;
                }
            }
        }            
    }
    public static void generartablero (char [][] arreglo1){
        for (int i = 0;i<arreglo1.length;i++){
            for(int j = 0;j<arreglo1[i].length;j++){
                switch (j) {
                    case 0:
                        System.out.print("["+ arreglo1[i][j]+" ,");
                        break;
                    case 2:
                        System.out.print(arreglo1[i][j]+"]");
                        break;
                    default:
                        System.out.print(arreglo1[i][j]+",");
                        break;
                }
            }
            System.out.println("");
        }     
    }
    //imprime matrizes del tablero
    public static void imprimirmat (int[][] arreglo){
        System.out.println("Matriz generada:");
        for (int i = 0;i<arreglo.length;i++){
            for(int j = 0;j<arreglo[i].length;j++){
                System.out.print("["+arreglo[i][j]+"]");
            }
            System.out.println("");
        }     
    }
    //imprime matriz
    
    public static int[][] generarIntMatrizAleatoria (int filas , int columnas){
        int temporal [][] = new int [filas][columnas];
        for (int i = 0;i<temporal.length; i++){
            for (int j = 0;j<temporal[i].length;j++){
                temporal[i][j] = rm.nextInt((99-1)+1)+1;
            }    
        }
        return temporal;
    }
    // llena con random
    
    public static char [][] llenadovacioinicial (int filas, int columnas){
        char temporal [][] = new char [filas][columnas];
        for (int i = 0;i<temporal.length; i++){
            for (int j = 0; j<temporal.length;j++){
            temporal[i][j] = ' ';    
            }    
        }
        return temporal;
    }
    // es la base de todo cuando esta vacio
    
    public static boolean verificarposicionvalida (char [] [] tablero,int filas,int columnas){
        boolean flag = false;
        if(filas <3 && columnas <3 && tablero[filas][columnas] == ' '){
            flag = true;
        }
        return flag;
    }
    // verifica si el lugar esta disponible
    
    public static void generartablerov (char [][] arreglo1, boolean [][] verf){
        for (int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                switch (j) {
                    case 0:
                        System.out.print("["+ arreglo1[i][j]+" ,");
                        break;
                    case 2:
                        System.out.print(arreglo1[i][j]+"]");
                        break;
                    default:
                        System.out.print(arreglo1[i][j]+",");
                        break;
                }
            }
            System.out.println("");
        }  
    }
    //imprime matrizes del tablero
    
    public static boolean verificarVictoriaX (char [] [] tablero){
        boolean temporal = false;
        for (int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(tablero[0][0]=='X' && tablero[0][1]=='X' && tablero[0][2]=='X'){
                    temporal = true;
                }else if(tablero[1][0]=='X' && tablero[1][1]=='X' && tablero[1][2]=='X'){
                    temporal = true;
                }else if(tablero[2][0]=='X' && tablero[2][1]=='X' && tablero[2][2]=='X'){
                    temporal = true;
                }else if(tablero[0][0]=='X' && tablero[1][1]=='X' && tablero[2][0]=='X'){
                    temporal = true;
                }else if(tablero[0][1]=='X' && tablero[1][1]=='X' && tablero[2][1]=='X'){
                    temporal = true;
                }else if(tablero[0][2]=='X' && tablero[1][2]=='X' && tablero[2][2]=='X'){
                    temporal = true;    
                }else if(tablero[0][0]=='X' && tablero[1][1]=='X' && tablero[2][2]=='X'){
                    temporal = true;    
                }else if(tablero[0][2]=='X' && tablero[1][1]=='X' && tablero[2][0]=='X'){
                    temporal = true;
                }    
            }
        }
        return temporal;
    }   
    //verifica la victoria del usuario
    
    public static boolean verificarVictoriaO (char [] [] tablero){
        boolean temporal = false;
        for (int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(tablero[0][0]=='0' && tablero[0][1]=='0' && tablero[0][2]=='0'){
                    temporal = true;
                }else if(tablero[1][0]=='0' && tablero[1][1]=='0' && tablero[1][2]=='0'){
                    temporal = true;
                }else if(tablero[2][0]=='0' && tablero[2][1]=='0' && tablero[2][2]=='0'){
                    temporal = true;
                }else if(tablero[0][0]=='0' && tablero[1][1]=='0' && tablero[2][0]=='0'){
                    temporal = true;
                }else if(tablero[0][1]=='0' && tablero[1][1]=='0' && tablero[2][1]=='0'){
                    temporal = true;
                }else if(tablero[0][2]=='0' && tablero[1][2]=='0' && tablero[2][2]=='0'){
                    temporal = true;    
                }else if(tablero[0][0]=='0' && tablero[1][1]=='0' && tablero[2][2]=='0'){
                    temporal = true;    
                }else if(tablero[0][2]=='0' && tablero[1][1]=='0' && tablero[2][0]=='0'){
                    temporal = true;
                }
            }
        }
        return temporal;
    } 
    //verifica la victoria de la maquina
    
    public static void encontrarPuntosSilla(int [] [] arreglo,int columnas,int filas){
        for(int i = 0;i<arreglo.length;i++){
            for(int j = 0;j<arreglo[0].length;j++){
                int puntosilla = arreglo [i][j];
                boolean max;
                boolean min;
                max = esmaximo(arreglo,columnas,puntosilla);
                min = esminimo (arreglo,filas,puntosilla);
                if (max==true && min==true){
                    System.out.println("Punto de Silla en Matriz :" + "["+i+","+j+"]"+ ": " + puntosilla);
                }else{
                    System.out.println("No hay puntos sillas en la matriz");
                }
            }
        }
    }
    
    public static boolean esmaximo (int[][] arreglo, int columnas,int puntosilla){
        boolean temporal = false;
         for (int i = 0;i <arreglo.length;i++){
             System.out.println(columnas);
            if (arreglo[i][columnas]>puntosilla ){
                temporal = false;
            }else{
                temporal = true;
            }     
        }
        return temporal;
    }
    public static boolean esminimo (int[][] arreglo, int filas,int puntosilla){
        boolean temporal = false;
        for (int i = 0;i <arreglo.length;i++){
            if (arreglo[filas][i]<puntosilla ){
                temporal = false;
            }else{
                temporal = true;
            }     
        }
        return temporal;
    }
}
