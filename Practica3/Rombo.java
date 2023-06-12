import java.util.Scanner;

/**
 * Realiza un programa que lea del teclado un valor entero ‘n’ e imprima en
 * pantalla dos tipos de triángulos.
 * 
 * @author Jiménez Sánchez Emma Alicia.
 * 
 *         Para hacer el rombo lo primero que debemos hacer es imprimir un
 *         cuadradro con los asteriscos, después es indicar las programa en que
 *         posición si debe poner un asterico y cual un espacio.
 * 
 */

public class Rombo {
    public static void main(String[] args) {
        int columnas; // declaramos las varibles que vamos a ocupar, en este caso sería columnas y
                      // filas.
        int filas;

        Scanner num = new Scanner(System.in); // creación de un obejto tipo Scanner
        System.out.println("¿De qué tamaño quieres tu número?");
        int tam = num.nextInt();

        boolean intenta = true; // creación de un centinela para poder crear varios rombos dee diferentes
                                // tamaños

        while (intenta) {
            int esp = 0; // inicialización de la variable espacios

            for (filas = 1; filas <= tam; filas++) {
                /*
                 * Creamos este ciclo para que pueda repetir las filas con espacios o
                 * asteriscos,
                 * donde inicializamos las filas igual 1, significa que vamos a empezar a contar
                 * desde 1, la condición que deben
                 * cumplir es que las filas deben ser igual o menor que el tam, ya que como
                 * tenemos como medida máxima tam, las filas
                 * deden ser igual o menor, debido a que también estamos tomando en cuenta al
                 * número de tam, y cada vez que se repita
                 * el ciclo a filas se le va a sumar un uno para poder salir del ciclo.
                 */
                for (esp = tam - filas; esp > 0; esp--) {
                    System.out.print(" ");
                }
                /*
                 * Dentro del for de filas va a ir el for de los espacios, donde las esp es
                 * igual a tam menos de las filas, la condición
                 * que debe cumplir es que sea mayor a zero, y cada vez que se ejecute el ciclo
                 * a esp se le va ir quitando un uno.
                 */
                for (columnas = 1; columnas <= filas; columnas++) {
                    System.out.print("* ");
                    /*
                     * Inicializamos columnas en 1, la condición que debe cumplir es que debe ser
                     * menor o igual a filas,
                     * para poder tener la base que sería el tam, cada vez que se reíta el for a
                     * columnas se va a ir agregando un 1 para poder
                     * salirse del ciclo.
                     */

                }
                System.out.println(""); // Este println para para poder saltar a la siguiente linea, es decir a la
                                        // siguiente fila.
            }
            /*
             * Repite el mismo for porque si separamos el rombo son dos triangulos
             * reflejados, nada más la única modificación que
             * fue quitar una unidad al tam porque sino se repetiría la base que es tam, y
             * en el for de filas en lugar de ir sumando
             * tenemos que restar ya que vamos a ir quitando astericos, al mismo tiempo que
             * la condición es diferente, porque si ponemos
             * que filas es igual o menor a tam nos va a salir espacio infinitos, debido a
             * que siempre filas va a ser menor a tam, ahora filas
             * debe ser mayor a 0, porque cuando filas sea 0, va a salir del ciclo.
             * Para lo de esp y columnas es básicamente lo mismo.
             */
            for (filas = tam - 1; filas > 0; filas--) {
                for (esp = tam - filas; esp > 0; esp--) {
                    System.out.print(" ");
                }
                for (columnas = 1; columnas <= filas; columnas++) {
                    System.out.print("* ");
                }
                System.out.println("");
            }

            System.out.println("Escribe 2 para continuar o 1 para salir");
            int opc = num.nextInt();

            if (opc == 1) {
                intenta = false;
            } else {
                System.out.println("¿De qué tamaño quieres tu número?");
                tam = num.nextInt();

            }

        }
    }
}
