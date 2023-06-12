import java.util.Random;

public class Actividad3 {
    /*
     * @author Jiménez Sánchez Emma Alicia.
     * Modifica el programa del ajedrez visto en clase (el del alfil) y agrega las
     * siguientes piezas:
     * • Torre.
     * • Caballo.
     * Es decir, genera una posici ́on aleatoria para cada pieza e imprime en
     * pantalla las casillas v ́alidas a donde puede
     * moverse.
     */

    public static void main(String[] args) {

        // Esta parte de declarar en que posición se encuentra el alfil, y también sus
        // posibles posiciones lo vimos con cinthia.
        Random aleatorios = new Random();

        int[][] tableroAjedrez = new int[8][8];

        for (int i = 0; i < tableroAjedrez.length; i++) {
            for (int j = 0; j < tableroAjedrez[i].length; j++) {

                if ((i + j) % 2 == 0) {
                    System.out.print("#" + " ");
                } else {
                    System.out.print("-" + " ");
                }

            }
            System.out.println();

        }

        System.out.println();
        System.out.println();

        // Posicion arbitraria del alfil
        int ren = aleatorios.nextInt(8);
        int col = aleatorios.nextInt(8);

        tableroAjedrez[ren][col] = 1;

        // Tachar posiciones válidas del alfil
        // Cuadrante 1, el del valor esquina superior izq
        int renC1 = ren - 1;
        int colC1 = col - 1;

        while (renC1 >= 0 && colC1 >= 0) {
            tableroAjedrez[renC1][colC1] = 2;
            renC1--;
            colC1--;
        }

        // Cuadrante 2
        int renC2 = ren - 1;
        int colC2 = col + 1;

        while (renC2 >= 0 && colC2 <= 7) {
            tableroAjedrez[renC2][colC2] = 2;
            renC2--;
            colC2++;
        }

        // Cuadrante 3
        int renC3 = ren + 1;
        int colC3 = col - 1;

        while (renC3 <= 7 && colC3 >= 0) {
            tableroAjedrez[renC3][colC3] = 2;
            renC3++;
            colC3--;
        }

        // cuadrante 4
        int renC4 = ren + 1;
        int colC4 = col + 1;

        while (renC4 <= 7 && colC4 <= 7) {
            tableroAjedrez[renC4][colC4] = 2;
            renC4++;
            colC4++;
        }

        System.out.println("Tablero de 1's, 0s, 2s");

        for (int i = 0; i < tableroAjedrez.length; i++) {
            for (int j = 0; j < tableroAjedrez[i].length; j++) {
                System.out.print(tableroAjedrez[i][j]);
            }
            System.out.println();

        }

        System.out.println();
        System.out.println("Posic+on aleatoria del alfil");

        for (int i = 0; i < tableroAjedrez.length; i++) {
            for (int j = 0; j < tableroAjedrez[i].length; j++) {

                if (tableroAjedrez[i][j] == 1) {
                    System.out.print("A" + " ");
                } else if (tableroAjedrez[i][j] == 2) {
                    System.out.print("*" + " ");
                } else {
                    if ((i + j) % 2 == 0) {
                        System.out.print("#" + " ");
                    } else {
                        System.out.print("-" + " ");
                    }
                }
            }
            System.out.println();

        }

        System.out.println("Posición aleatoria de la torre");
        // Se crea un nuevo tablero con las mismas dimensiones que del alfil
        int[][] tableroAjedrez2 = new int[8][8];
        // Se crea las posiciones aleatorias
        int torren = aleatorios.nextInt(8);
        int torcol = aleatorios.nextInt(8);

        // Se escoje la posición aletaoria de la torre que estara representada por un 1.
        tableroAjedrez2[torren][torcol] = 1;

        System.out.println("Tablero de 1's, 0s, 2s");

        // Primer cuadrante
        int renT1 = torren;
        int colT1 = torcol + 1; // Solo la columna van a aumentar porque es una línea horizontal

        // Va a aumentar 1 hadta que sea igual a 7 para no salirse del tablero y en los
        // casos donde vaya aumentado se debe de representar por un 2.
        while (colT1 <= 7) {
            tableroAjedrez2[renT1][colT1] = 2;
            colT1++;
        }

        // Segundo Cuadrante
        int renT2 = torren + 1; // Es una línea vertical y se utiliza el mismo algoritmo que en el primer
                                // cuadrante para poder ubicar las posibles posiciones.
        int colT2 = torcol;

        while (renT2 <= 7) {
            tableroAjedrez2[renT2][colT2] = 2;
            renT2++;
        }
        // Tercer cuadrante
        // Utiliza el mismo algoritmo que el primer cuadrante
        int renT3 = torren;
        int colT3 = torcol - 1;

        while (colT3 >= 0) {
            tableroAjedrez2[renT3][colT3] = 2;
            colT3--;
        }

        // Cuarto cuardante
        // Utiliza el mismo algortimo que el primer cuadrante
        int renT4 = torren - 1;
        int colT4 = torcol;

        while (renT4 >= 0) {
            tableroAjedrez2[renT4][colT4] = 2;
            renT4--;
        }

        // Se imprime el tablero de 0,1,y 2
        for (int i = 0; i < tableroAjedrez2.length; i++) {
            for (int j = 0; j < tableroAjedrez2[i].length; j++) {
                System.out.print(tableroAjedrez2[i][j]);
            }
            System.out.println();

        }

        // Se imprime el tablero con símbolos
        System.out.println("Tablero de con símbolos");
        for (int i = 0; i < tableroAjedrez2.length; i++) {
            for (int j = 0; j < tableroAjedrez2[i].length; j++) {

                if (tableroAjedrez2[i][j] == 1) {
                    System.out.print("T" + " ");
                } else if (tableroAjedrez2[i][j] == 2) {
                    System.out.print("*" + " ");
                } else {
                    if ((i + j) % 2 == 0) {
                        System.out.print("#" + " ");
                    } else {
                        System.out.print("-" + " ");
                    }
                }
            }
            System.out.println();

        }

        System.out.println("Posición aleatoria del caballo");
        // Se crea el mismo tipo de variables que se usuaron el la torre
        int cabren = aleatorios.nextInt(8);
        int cabcol = aleatorios.nextInt(8);
        int[][] tableroAjedrez3 = new int[8][8];

        tableroAjedrez3[cabren][cabcol] = 1;

        System.out.println("Tablero de 1's, 0s, 2s");

        // Primer cuadrante

        // Se crea dos variables para renglon y colunma ya que el caballo puede escoger
        // si ir a la derecha o izquierda, si es que primero avanza dos lugares, si
        // primero decide moverse dos lugares a la derecha e izquierda y luego subir o
        // bajra un lugar
        // En este caso es primero que va a disminuir los renglones(va a subir) y escoge
        // ir a la derecha un lugar
        // En las siguientes bariables declaradas escoge ir a la izquierda
        int renL1_1 = cabren - 2;
        int colL1_1 = cabcol + 1;
        // En este if se evaluá si es lugar en el que avanzaron las variables estan
        // dentró del límite de nuestro tablero, si es así que se represente con un dos
        // pero sino solo continua con el programa
        if (renL1_1 >= 0 && colL1_1 <= 7) {
            tableroAjedrez3[renL1_1][colL1_1] = 2;
        }

        // Variables cuando en lugar de ir a la derecha escoge ir a la
        // izquierda(Entonces se le disminuye a la columna)
        int renL1_2 = cabren - 2;
        int colL1_2 = cabcol - 1;
        if (renL1_2 >= 0 && colL1_2 >= 0) {
            tableroAjedrez3[renL1_2][colL1_2] = 2;
        }

        // Este algoritmo lo implmento en cada uno de los cuadrantes para el caballo

        // Segundo cuadrante
        int renL2_1 = cabren + 2;
        int colL2_1 = cabcol + 1;
        if (renL2_1 <= 7 && colL2_1 <= 7) {
            tableroAjedrez3[renL2_1][colL2_1] = 2;
        }

        int renL2_2 = cabren + 2;
        int colL2_2 = cabcol - 1;
        if (renL2_2 <= 7 && colL2_2 >= 0) {
            tableroAjedrez3[renL2_2][colL2_2] = 2;
        }

        // Tercer Cuadrante

        int renL3_1 = cabren - 1;
        int colL3_1 = cabcol + 2;
        if (renL3_1 >= 0 && colL3_1 <= 7) {
            tableroAjedrez3[renL3_1][colL3_1] = 2;
        }

        int renL3_2 = cabren - 1;
        int colL3_2 = cabcol - 2;
        if (renL3_2 >= 0 && colL3_2 >= 0) {
            tableroAjedrez3[renL3_2][colL3_2] = 2;
        }

        // Cuarto cuadrante
        int renL4_1 = cabren + 1;
        int colL4_1 = cabcol + 2;
        if (renL4_1 <= 7 && colL4_1 <= 7) {
            tableroAjedrez3[renL4_1][colL4_1] = 2;
        }

        int renL4_2 = cabren + 1;
        int colL4_2 = cabcol - 2;
        if (renL4_2 <= 7 && colL4_2 >= 0) {
            tableroAjedrez3[renL4_2][colL4_2] = 2;
        }

        // Se imprimer el tablero con 0,1 y 2

        for (int i = 0; i < tableroAjedrez3.length; i++) {
            for (int j = 0; j < tableroAjedrez3[i].length; j++) {
                System.out.print(tableroAjedrez3[i][j]);
            }
            System.out.println();

        }

        // Se imprime el tablero con los símbolos declarados
        System.out.println("Tablero de con símbolos");
        for (int i = 0; i < tableroAjedrez3.length; i++) {
            for (int j = 0; j < tableroAjedrez3[i].length; j++) {

                if (tableroAjedrez3[i][j] == 1) {
                    System.out.print("C" + " ");
                } else if (tableroAjedrez3[i][j] == 2) {
                    System.out.print("*" + " ");
                } else {
                    if ((i + j) % 2 == 0) {
                        System.out.print("#" + " ");
                    } else {
                        System.out.print("-" + " ");
                    }
                }
            }
            System.out.println();

        }

    }

}
