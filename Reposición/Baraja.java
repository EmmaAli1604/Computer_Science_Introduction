import java.util.Random;

/*
 * @author Jimenez Sanchez Emma Alicia
 * En esta clase se crea la baraja
*/

public class Baraja {
    // La baraja es conformada por una matriz
    static Tarjeta2[][] baraja = new Tarjeta2[4][13];
    final String ANSI_RESET = "\u001B[0m"; // Para resetear los colores
    final String ANSI_PURPLE = "\u001B[45m"; // Para asignar el color morado a las tarjetas que tengan el simbolo de
                                             // trebol y diamantes a falta del negro
    final String ANSI_RED = "\u001B[41m"; // Para asignar el color rojo

    public Baraja() {
        // Asignar los simbolos
        char cora = '\u2661';
        char esp = '\u2664';
        char treb = '\u2667';
        char diam = '\u2662';

        // Creación de la baraja y su llenado
        for (int i = 0; i < baraja.length; i++) {
            for (int j = 0; j < baraja[i].length; j++) {
                if (i == 0) {
                    baraja[i][j] = new Tarjeta2(j, cora, ANSI_RED, ANSI_RESET);
                } else if (i == 1) {
                    baraja[i][j] = new Tarjeta2(j, esp, ANSI_PURPLE, ANSI_RESET);
                } else if (i == 2) {
                    baraja[i][j] = new Tarjeta2(j, treb, ANSI_PURPLE, ANSI_RESET);
                } else if (i == 3) {
                    baraja[i][j] = new Tarjeta2(j, diam, ANSI_RED, ANSI_RESET);
                }
            }
        }

    }

    // Metodo para poder repartir a los competidores
    public Tarjeta2[] Repartir() {
        Random alet = new Random();
        Tarjeta2[] jugada = new Tarjeta2[5];
        Tarjeta2 aux = new Tarjeta2();

        for (int i = 0; i < jugada.length; i++) {
            int fila = alet.nextInt(4);
            int columna = alet.nextInt(13);
            while (baraja[fila][columna].getNum() == 0) {
                fila = alet.nextInt(4);
                columna = alet.nextInt(13);
            }
            if (baraja[fila][columna].getNum() != 0) {
                jugada[i] = baraja[fila][columna];
                baraja[fila][columna] = aux;
            }
        }

        return jugada;
    }

    // Metodo donde regresa una carta para agregar a la baraja del jugador cuando
    // quiere cambiar una de sus cartas
    public static Tarjeta2 Agregar() {
        Random alet = new Random();
        int fila = alet.nextInt(4);
        int columna = alet.nextInt(13);
        Tarjeta2 aux = new Tarjeta2();
        boolean data = false;
        while (data == false) {
            fila = alet.nextInt(4);
            columna = alet.nextInt(13);
            if (baraja[fila][columna].getNum() != 0) {
                aux = baraja[fila][columna];
                data = true;
            }
        }
        return aux;
    }

}