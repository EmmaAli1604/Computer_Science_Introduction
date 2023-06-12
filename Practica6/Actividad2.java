
import java.util.Scanner;

public class Actividad2 {
    /*
     * @author Jiménez Sánchez Emma Alicia.
     * Crea la clase Canci ́on.
     * Una canci ́on tiene:
     * • Int ́erprete (String)
     * • T ́ıtulo (String)
     * • Segundos de duraci ́on (int)
     * Imagina que tienes un ipod para almacenar a lo m ́as 15 canciones, o bien a
     * lo m ́as 1000 segundos de m ́usica.
     * Implementa los siguientes m ́etodos:
     * • Guardar canci ́on (siempre y cuando no haya 15 canciones ya o la nueva no
     * exceda los 1000 segundos del
     * dispositivo).
     * • Buscar canci ́on por t ́ıtulo o int ́erprete.
     * • Borrar canci ́on por t ́ıtulo.
     * • Ver todas las canciones en el iPod.
     * • Ordenar las canciones por duraci ́on.
     * • Borrar todo el iPod.
     */

    // Metódo de Menú
    public static void Menu(int opc, UsodeIpod ipod) {
        Scanner lector = new Scanner(System.in);
        switch (opc) {
            case 1:
                if (ipod.Numcancion != 0) {
                    ipod.imprimeIpod();
                } else {
                    System.out.println("No hay canciones para mostrar. ");
                }
                break;
            case 2:
                System.out.print("  Escribe el autor de la canción: ");
                String author = lector.nextLine();
                System.out.print("Escribe el nombre de la canción: ");
                String name = lector.nextLine();
                System.out.print("Escribe cuantos minutos dura tu canción: ");
                int time = lector.nextInt();
                Cancion cancion = new Cancion(author, name, time);
                ipod.guardarCancion(cancion);
                break;
            case 3:
                ipod.borrarCancion();
                break;
            case 4:
                ipod.buscarCancion();
                break;
            case 5:
                ipod.Ordenar();
                break;
            case 6:
                ipod.borraTodo();
                break;
            default:
                System.out.println("Esta opción no es válida");
                break;

        }
    }

    // Método Main
    public static void main(String args[]) {
        boolean data = true;
        UsodeIpod ipod = new UsodeIpod();

        while (data != false) {
            Scanner lector = new Scanner(System.in);
            // Opciones que se pueden realizar en el metódo main
            System.out.println("\nIngresa el número de opción que desees realizar:");
            System.out.println("1-> Ver todas las canciones");
            System.out.println("2-> Guardar una cancion ");
            System.out.println("3-> Borrar cancion ");
            System.out.println("4-> Buscar cancion por titulo o interprete");
            System.out.println("5-> Ordenar las canciones por duracion. ");
            System.out.println("6-> Borrar todo. ");
            System.out.println("7-> Salir ");
            int opc2 = lector.nextInt();
            // SI la opción es diferente a 7 entonces no se quiere salir el usuario y
            // quiere
            // realizar otras acciones en el programa
            if (opc2 == 7) {
                System.out.println("Quieres salir?");
                System.out.println("Ingresa 1 si así lo deseas");
                System.out.println("Ingresa 2 si deseas continuar");
                int b = lector.nextInt();
                if (b == 1) {
                    data = false;
                } else {
                    data = true;
                }
            } else {
                Menu(opc2, ipod);
            }
        }

    }

}

// Clase UsodeIpod es para poder usar los métodos o acciones del ipod.
class UsodeIpod {

    // Límite de 15 caniones
    Cancion[] canciones = new Cancion[15];
    // Numcancion evaluás cuantas canciones ya llevamos
    int Numcancion = 0;
    // duracionmax evaluá cuantos minutos ya llevamos
    int duracionmax = 0;

    // Método constructor.
    UsodeIpod() {
        Numcancion = 0;
        duracionmax = 0;
    }

    // Metódo donde se imprime todas las caciones
    public void imprimeIpod() {
        for (int i = 0; i < this.canciones.length; i++) {
            // Si en el arreglo hay una canción, se va a mostrar, sino nos indica que en tal
            // posición no hay una canción
            if (this.canciones[i] != null) {
                this.canciones[i].mostrar();
            } else {
                System.out.println("Datos del arreglo: " + (i + 1) + ", sin  cancion");
            }

        }
        System.out.println();
    }

    // Método para poder agregar una cancion
    public void guardarCancion(Cancion cancion) {
        Cancion cancionAux = cancion;
        boolean sePuedeGuardar = false; // Evalua si se puede guardar una canción
        int time = this.duracionmax + cancionAux.getTime();
        // Se evaluá si el número de canciones es menor o igual a 15 para poder guardar
        // la canción y si hay tiempo para poder guardar los minutos
        if ((this.Numcancion <= 15) && (time < 1000)) {
            sePuedeGuardar = true;
        } else {
            sePuedeGuardar = false;
            System.out.println("No ha sido posible almacenar la cancion. ");
        }
        // Si se puede guardar entonces se recorre el arreglo para buscar unn lugar
        // vació donde se guarda la canción en ese lugar
        if (sePuedeGuardar == true) {
            for (int i = 0; i < 15; i++) {
                if (sePuedeGuardar) {
                    if (this.canciones[i] == null) {
                        this.canciones[i] = cancionAux;
                        this.canciones[i].mostrar();
                        System.out.println("Se guardo en la posicion: " + (i + 1));
                        this.duracionmax = this.duracionmax + cancionAux.getTime();// Se le suma el tiempo de la canción
                                                                                   // a nuestra variable clase de
                                                                                   // duaracionmax
                        this.Numcancion++; // Se indica que ya se guarda una canción, entonces a nuestra numcancion ya
                                           // va a tener 1 canción
                        break;
                    }
                }
            }

        } else {
            System.out.println("El ipod está llenó");
        }

    }

    // Para poder borrar la canción
    public void borrarCancion() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Escribe el título de la cancion que quieres borrar");
        String titulo = lector.nextLine();
        // Se indica que canción se quiere borrar
        boolean encontrado = false;

        // Se recorre todo el arreglo en busca de la canción
        for (int i = 0; i < canciones.length; i++) {
            int duracionCancion;
            if (canciones[i] != null) {
                String tituloActual = canciones[i].getTitulo();
                // si los títulos coinciden entonces en esa posicion se elimina la canción y se
                // declara como null
                if (tituloActual.equals(titulo)) {
                    duracionCancion = canciones[i].getTime();
                    canciones[i] = null;
                    canciones[i] = canciones[i + 1]; // Se recorre el espacio null para no tener espacios vacíos entre
                                                     // canciones
                    System.out.println("Canción encontrada y eliminada");
                    encontrado = true;
                    // Se debe de restar a Numcancion menos 1 y restar a duracionmax el tiempo de la
                    // canción que se borró
                    Numcancion--;
                    this.duracionmax = duracionmax - duracionCancion;
                    break;
                }
            }
        }

        if (encontrado == false) {
            System.out.println("La canción que intentas borrar no esta en el ipod");
        }

    }

    // Método para buscar una canción
    public void buscarCancion() {

        Scanner lector = new Scanner(System.in);
        System.out.println("Escribe el título de la canción que estás buscando");
        String name = lector.nextLine();
        System.out.println("Escribe el autor de la canción que estás buscando");
        String author = lector.nextLine();
        boolean encontrado = false;
        // Entran los parametros de nombre de la canción y su autor para buscar la
        // canción en el arreglo donde las posiciones no sean null
        for (int i = 0; i < canciones.length; i++) {
            if (canciones[i] != null) {
                String tituloActual = canciones[i].getTitulo();
                String authorAct = canciones[i].getName();
                // Se compara los nombres de las canciones y el nombre del autor, con el nombre
                // y autor ingresado para ver si existe la canción en el ipod, si por lo menos
                // uno de los parametros coinciden entonces se mostrará la canción que buscaba
                // sino la cancipon no esta en el ipod.
                if (tituloActual.equals(name) || authorAct.equals(author)) {
                    System.out.println("Canción encontrado");
                    canciones[i].mostrar();
                    encontrado = true;
                    break;
                }
            }
        }

        if (encontrado == false) {
            System.out.println("Ese la canción no está en el ipod");
        }

    }

    // Método que declara que en todas las posiciones va a ser null
    public void borraTodo() {

        for (int i = 0; i < canciones.length; i++) {
            canciones[i] = null;
        }

        System.out.println("Se borraron todos las canciones");

    }

    // Método ordenar
    public void Ordenar() {
        int k, i, j;
        Cancion cancion; // es una varible auxiliar que nos va a servir para poder hacer los cambios
        for (k = 0; k < Numcancion; k++) { // Se realiza dos ciclos para poder ir comparando los valores
            // Utilizamos nuestro contador como condición ya que en este no se estará
            // contando los valores null que se tiene en el arreglo
            for (i = 0; i < Numcancion; i++) {
                cancion = canciones[i + 1];
                j = (i + 1);
                if (j < Numcancion) {
                    // Se compara que número es mayor para que se vaya asignando
                    if (canciones[i].getTime() > canciones[j].getTime()) {
                        cancion = canciones[i]; // En la variable auxiliar se guarda el valor de cancion cuando su
                                                // duración es mayor a cancion[j]
                        canciones[i] = canciones[j]; // En la variable cancion[i] se guarda la varaible con la cual la
                                                     // estoy comparando
                        canciones[j] = cancion; // La cancion j su valor a ser igual al de la variable auxiliar.
                    }
                }
            }
        }

        // Se imprime las canciones de acuerdo al contador que tenemos porque si
        // tratamos de ordenar un objeto que es nulo nos va a lanzar una excepción
        for (int l = 0; l < Numcancion; l++) {
            canciones[l].mostrar();
        }
    }
}
// Clase canción

class Cancion {
    // Atrinutos o Propiedades
    private String interprete;
    private String titulo;
    private int duracion;

    // Método Constructor
    public Cancion(String interprete, String nombre, int duracion) {
        this.interprete = interprete;
        this.titulo = nombre;
        this.duracion = duracion;
    }

    // Método get para obtener el título
    public String getTitulo() {
        return titulo;
    }

    // Método get para obetener el nombre del interprete
    public String getName() {
        return interprete;
    }

    // Método get para obtener el tiempo
    public int getTime() {
        return duracion;
    }

    // Metodo que nos muestra los datos de la canción
    public void mostrar() {
        System.out.println("Título: " + titulo + " de " + interprete + " de duración " + duracion + " minutos");
    }
}
