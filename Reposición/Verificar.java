
/*
 * @author Jimenez Sanchez Emma Alicia
 * 
*/

//En esta clase se encuentra el metodo para poder ordenar el mazo
class Ordenar {
    public static Tarjeta2[] OrdenarMazo(Tarjeta2[] n) {
        Tarjeta2[] aux = n;
        Tarjeta2 b = new Tarjeta2();
        int j, k = 0;
        for (k = 0; k < aux.length; k++) {
            for (int i = 0; i < aux.length; i++) {
                j = i + 1;
                if (j < aux.length) {
                    if (aux[i].getNum() > aux[j].getNum()) {
                        b = aux[i];
                        aux[i] = aux[j];
                        aux[j] = b;
                    }
                }
            }
        }
        return aux;
    }
}

// En esta clase se encuentra los metodos para poder verificar quien gana en la
// una partida
public class Verificar {
    static final String ANSI_PURPLE = "\u001B[45m";
    static final String ANSI_RED = "\u001B[41m";

    // Metodo para podr verificar si hay una sucesion en el mazo de un competidor ,
    // si es cierto regresa true
    public static boolean VerificarSucesion(Tarjeta2[] mazo) {
        boolean sies = false;
        Tarjeta2[] aux = new Tarjeta2[5];
        aux = Ordenar.OrdenarMazo(mazo);
        for (int i = 0; i + 1 < aux.length; i++) {
            int q = aux[i].getNum(); // Este es el menor y el primero de la sucesion
            int w = aux[i + 1].getNum(); // Este es el mayor y el segundo de la sucesion
            if ((q + 1) == w) {
                sies = true;
            }
        }
        return sies;
    }

    // Metodo que verifica si el mazo es una escalera real
    public static boolean VerificarEscReal(Tarjeta2[] mazo) {
        boolean sihay = false;
        Tarjeta2[] aux = new Tarjeta2[5];
        aux = Ordenar.OrdenarMazo(mazo);
        if (aux[0].getNum() == 1 && aux[1].getNum() == 10 && aux[2].getNum() == 11 && aux[3].getNum() == 12
                && aux[4].getNum() == 13) {
            sihay = true;
        }
        return sihay;
    }

    // Metodo que verifica el color
    public static boolean VerificarColor(Tarjeta2[] mazo) {
        boolean igual = false;
        Tarjeta2[] aux = new Tarjeta2[5];
        aux = Ordenar.OrdenarMazo(mazo);
        String red = "\u001B[41m";
        String purple = "\u001B[45m";
        int contmor = 0;
        int contred = 0;
        for (int i = 1; i < aux.length; i++) {
            if (aux[i].getColor().equals(purple)) {
                contmor++;
            } else if (aux[i].getColor().equals(red)) {
                contred++;
            }
        }

        if (contmor == 5) {
            igual = true;
        }

        if (contred == 5) {
            igual = true;
        }
        return igual;
    }

    // Metodo que verificar si hay un par de cartas en el mazo
    public static boolean VerificarPar(Tarjeta2[] mazo) {
        boolean sihay = false;
        Tarjeta2[] aux = new Tarjeta2[5];
        aux = Ordenar.OrdenarMazo(mazo);
        for (int i = 0; i + 1 < aux.length; i++) {
            int q = aux[i].getNum();
            int w = aux[i + 1].getNum();
            if (q == w) {
                sihay = true;
            }

        }
        return sihay;
    }

    // Metodo que verifica si hay un doble par en el mazo
    public static boolean VerificarDoublePar(Tarjeta2[] mazo) {
        boolean sihay = false;
        Tarjeta2[] aux = new Tarjeta2[5];
        aux = Ordenar.OrdenarMazo(mazo);
        int doble = 0;
        for (int i = 0; i + 1 < aux.length; i++) {
            int q = aux[i].getNum();
            int w = aux[i + 1].getNum();
            if (q == w) {
                doble++;
            }
        }

        if (doble == 3) {
            sihay = true;
        }
        return sihay;
    }

    // Metodo que verifica si hay una tercia
    public static boolean VerificarTercia(Tarjeta2[] mazo) {
        boolean sihay = false;
        Tarjeta2[] aux = new Tarjeta2[5];
        aux = Ordenar.OrdenarMazo(mazo);
        for (int i = 0; i + 2 < aux.length; i++) {
            int q = aux[i].getNum();
            int w = aux[i + 1].getNum();
            int e = aux[i + 2].getNum();
            if (q == w && w == e) {
                sihay = true;
            }

        }
        return sihay;
    }

    // Metodo que verifica si hay un poker en el mazo
    public static boolean VerificarPoker(Tarjeta2[] mazo) {
        boolean sihay = false;
        Tarjeta2[] aux = new Tarjeta2[5];
        aux = Ordenar.OrdenarMazo(mazo);
        for (int i = 0; i + 3 < aux.length; i++) {
            int q = aux[i].getNum();
            int w = aux[i + 1].getNum();
            int e = aux[i + 2].getNum();
            int r = aux[i + 3].getNum();
            if (q == w && w == e && e == r) {
                sihay = true;
            }

        }
        return sihay;
    }

    // Metodo para poder sacar la carta mas alta del mazo
    public static int CartaMasAlta(Tarjeta2[] mazo) {
        Tarjeta2[] mazoaux = Ordenar.OrdenarMazo(mazo);
        int aux = mazoaux[4].getNum();
        return aux;
    }

    // Dependiendo de que condicion cumpla al valor se le va asignar un puntaje que
    // luego se va a comparar en la partida para saber quien gano, esto va de
    // acuerdo a la jerarquía
    public static int VerficarBaraja(Tarjeta2[] mazo) {
        int valor = 0;
        // Si es Escalera Real de Color
        // Que sea una sucesion y que el color sea el mismo
        if (VerificarEscReal(mazo) == true) {
            valor = 100;
            System.out.println("Escalera real");
        }
        // Escalera de Color
        else if (VerificarSucesion(mazo) == true
                && VerificarColor(mazo) == true) {
            valor = 90;
            System.out.println("Escalera de Color");
        }
        // Poker
        else if (VerificarPoker(mazo) == true) {
            valor = 80;
            System.out.println("Poker");
        }
        // Full
        else if (VerificarTercia(mazo) == true && VerificarPar(mazo) == true) {
            valor = 70;
            System.out.println("Full");
        }
        // Color
        else if (VerificarColor(mazo) == true) {
            valor = 60;
            System.out.println("Color");
        }
        // Escalera
        else if (VerificarSucesion(mazo) == true) {
            valor = 50;
            System.out.println("Escalera");
        }
        // Trío
        else if (VerificarTercia(mazo) == true) {
            valor = 40;
            System.out.println("Trío");
        }
        // Doble pareja
        else if (VerificarDoublePar(mazo) == true) {
            valor = 30;
            System.out.println("Doble par");
        }
        // Pareja
        else if (VerificarPar(mazo) == true) {
            valor = 20;
            System.out.println("Par");
        }
        // Carta Más Alta
        else {
            valor = CartaMasAlta(mazo);
            System.out.println("Carta más alta");
        }
        return valor;
    }
}
