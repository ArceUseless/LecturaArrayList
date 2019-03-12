import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 * Este programa leerá un documento .txt llamado "ArrayList.txt" y guardará su contenido en un ArrayList
 * 
 * Después se mostrará un menú en el que el usuario puede elegir entre:
 *  1. Mostrar el contenido del ArrayList
 *  2. Modificar alguno de los elementos del ArrayList
 *  3. Actualizar el documento con el nuevo contenido del ArrayList
 *  4. Salir del programa
 * @author Rafael Jesús Nieto
 *
 */
public class LecturaArrayList {
  public static void main(String[] args) {
    
    //Se invoca scanner para escribir por teclado
    Scanner scanner = new Scanner( System.in );   
    //Definición de ArrayList
    ArrayList<String> arrayF = new ArrayList<String>();
    //Definición de variables
    int opcion;
    int elemento;
    boolean error = false;
    //Try/catch para controlar excepciones
    try {
      //Instanciamos BufferedReader para leer el documento
      BufferedReader br = new BufferedReader(new FileReader("ArrayList.txt"));
      
      String linea = "";
      
      //Bucle while para recorrer el documento hasta que se llegue a <EOF>
      while(linea != null) {
        //Se introduce en "linea" una línea del documento
        linea = br.readLine();
        //Si linea no es nula (<EOF>) se añade la línea al ArrayList
        if(linea != null) {
          arrayF.add(linea);
        }      
      }
      //Se cierra la lectura del documento
      br.close();
      
      //Menú
      do {
        System.out.println("Elija una opción:");
        System.out.println("1. Mostrar ArrayList");
        System.out.println("2. Modificar elemento");
        System.out.println("3. Actualizar documento");
        System.out.println("4. Salir");
        opcion = scanner.nextInt();
        //Estructura switch para controlar las opciones del menú
        switch(opcion) {
          //Mostrar ArrayList
          case 1:
            //Bucle for para recorrer el ArrayList e imprimir cada elemento
            for(int i = 0; i<arrayF.size();i++) {
              System.out.println(arrayF.get(i));
            }
            break;
          //Modificar elemento
          case 2:
            //Mientras el índice introducido sea erróneo, se repite el bloque que pide un elemento del ArrayList y lo modifica
            do {
              //Estructura if para enviar un mensaje si se introduce un índice erróneo
              if(error) {
                System.out.println("Elemento no existente");
              }
              System.out.println("Inserte el elemento que desea modificar:");
              elemento = scanner.nextInt();
            }while(error = elemento <0 || elemento >arrayF.size());
            
            System.out.println("¿Qué desea introducir?");
            linea = scanner.nextLine();
            linea = scanner.nextLine();
            arrayF.set(elemento, linea);
            break;
          //Actualizar documento
          case 3:
            //try/catch para controlar excepciones
            try {
              //Instanciamos BufferedWriter para escribir en el documento
              BufferedWriter bw = new BufferedWriter(new FileWriter("ArrayList.txt"));
              //Bucle for para escribir todos los elementos del ArrayList en el documento
              for(int i = 0; i < arrayF.size(); i++) {
                bw.write(arrayF.get(i));
                bw.newLine();
              }
              //Se cierra el archivo
              bw.close();
              
            }catch(IOException io) {
              System.out.println("Error en la escritura del fichero.");
            }
            System.out.println("Documento actualizado");
            break;
        }
      }while(opcion > 0 && opcion <4);
      
      System.out.println("¡Adiós!");
   
    }catch(FileNotFoundException fnfe) {
      System.out.println("No se ha encontrado el archivo.");
    }catch(IOException io) {
      System.out.println("Error en la lectura del fichero.");
    }
    
  }

}
