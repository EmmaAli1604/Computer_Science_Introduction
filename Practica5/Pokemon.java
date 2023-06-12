import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Jiménez Sánchez Emma Alicia.
 * 
 *         Crea la clase Pokem ́on
 *         Un pokemón tiene:
 *         • nombre
 *         • tipo
 *         • estado de salud (normal, veneno, quemado, congelado)
 *         • HP
 *         • bolsita
 *         Dentro de la bolsita un pokem ́on puede encontrar:
 *         • 1 oranberry (suma 30 puntos al HP de un pokem ́on)
 *         • 1 Full Heal (cura el estado de un pokem ́on envenenado, quemado o
 *         congelado a normal)
 * 
 *         Un pokemon puede agotar sus ́ıtems dentro de la bolsita, sin
 *         posibilidad de comprar nuevos artículos.
 *         Además de los setters y getters, un pokem ́on debe tener las
 *         siguientes funcionalidades:
 *         • void probabilidadEnfermarse(Pokemon p): Un Pokem ́on tiene 20 % de
 *         probabilidades de adquirir el estado
 *         envenenado, 30 % de probabilidad de quemarse, 15 % de probabilidad de
 *         congelarse y 35 % de que no le ocurra
 *         nada.
 *         • void comparaPokemones(Pokemon p): método que regresa qué pokemón es
 *         más vulnerable de acuerdo a su
 *         tipo.
 *         Ejemplo:
 *         pikachu.comparaPokemones(pidgey) regresaría: Pidgey es vulnerable
 *         ante Pikachu
 *         • void caerse(Pokemon p): método que resta energía a un pokemón
 *         debido a que se cae y sufre da ̃no, resta el
 *         3 % de su HP actual.
 */

public class Pokemon {
    // Aquí los atributos del pokemon.
    private String nombre;
    private String tipo;
    private String salud;
    private int HPMAX; // Este atributo marca el HP máximo que un pokemon puede tener
    private int HP;
    private int[] bolsita = { 30, 1 };

    // Método constructor por omisión
    public Pokemon() {
        nombre = "Bulbasaur";
        tipo = "planta";
        salud = "Normal";
        HPMAX = 100;
        HP = 100;
        bolsita[0] = 30;
        bolsita[1] = 1;
    }

    // Método constructor con parámetros
    public Pokemon(String nombre, String tipo, String salud, int HPMAX, int HP, int bayas, int Fullheal) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.salud = salud;
        this.HPMAX = HPMAX;
        this.HP = HP;
        this.bolsita[0] = bayas;
        this.bolsita[1] = Fullheal;

    }

    // Método de get bolista
    public void getBolsita() {
        int i = bolsita[0];
        int j = bolsita[1];
        Scanner lector = new Scanner(System.in);
        System.out.println("Bolsita: Cranberry=" + i + " Fullheal= " + j);
        if (bolsita[0] == 0 && bolsita[1] == 0) {
            System.out.println("Ya no tienes elementos en la bolsita");
        }
    }

    // Método para establecer la cantidad de Cranberry que tiene un pokemon en su
    // bolsita
    public void setCranberry(int i) {
        bolsita[0] = i;
    }

    // Método para establecer cuantas Fullheal tiene un pokemon en su bolsita
    public void setFullheal(int i) {
        bolsita[1] = i;
    }

    // Método para poder usar la Cranberry
    public void usoCranberry() {
        setCranberry(0);
        int kmax = getHPMAX();
        int j = getHP();
        int result = j + 30;
        if (result > kmax) {
            setHP(HPMAX);
        } else {
            setHP(result);
        }
        System.out.println("\nHP: " + getHP());
    }

    // Método para usar el fullheal
    public void usoFullHeal() {
        setFullheal(0);
        setSalud("Normal");
        System.out.println("\nEstado de salud: " + getSalud() + "\n");
    }

    // Método get pra obtener el nombre de un pokemon
    public String getNombre() {
        return nombre;
    }

    // Método get pra obtener el tipo de un pokemon
    public String getTipo() {
        return tipo;
    }

    // Método get para obtener el salud de un pokemon
    public String getSalud() {
        return salud;
    }

    // Método get para obtener el HPMAX de un pokemon
    public int getHPMAX() {
        return HPMAX;
    }

    // Método get para obtener el HP de un pokemon
    public int getHP() {
        return HP;
    }

    // Método set para establecer el nombre de un pokemon
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método set para establecer el tipo de un pokemon

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método set para establecer la salud de un pokemon
    public void setSalud(String salud) {
        this.salud = salud;
    }

    // Método set para establecer el HP de un pokemon
    public void setHP(int HP) {
        this.HP = HP;
    }

    // Método set para establecer el HPMAX de un pokemon
    public void setHPMAX(int HPMAX) {
        this.HPMAX = HPMAX;
    }

    // Método toString que muestra la información de un pokemon
    public String toString() {
        String mensaje = "El pokemon " + nombre + " de tipo " + tipo + " , su estado de salud es " + salud + " con "
                + HPMAX + " HPMAX y " + HP + " de HP";
        return mensaje;
    }

    // Método de un pokemon donde tiene la probabailidad de enfermarse, dependiendo
    // de lo que salga en el random será
    // ña probabilidad de enefermarse
    public void probabilidadEnfermarse(Pokemon p) {
        Random alet = new Random();
        int aleto;
        aleto = alet.nextInt(100) + 1;
        if (1 <= aleto && aleto <= 35) {
            System.out.println("Tu pokemon " + p.getNombre() + " no le ocurrío nada");
            p.setSalud("Normal");
        } else if (36 <= aleto && aleto <= 55) {
            System.out.println("Tu pokemon " + p.getNombre() + " se envenenó");
            p.setSalud("Envenedado");
        } else if (56 <= aleto && aleto <= 85) {
            System.out.println("Tu pokemon " + p.getNombre() + " se quemó");
            p.setSalud("Quemado");
        } else if (86 <= aleto && aleto <= 100) {
            System.out.println("Tu pokemon " + p.getNombre() + " se congeló");
            p.setSalud("Congelado");
        }

    }

    public void comparaPokemones(Pokemon p) {
        /*
         * método que regresa qué pokemón es m ́as vulnerable de acuerdo a su tipo.
         * Ejemplo:
         * pikachu.comparaPokemones(pidgey)
         * regresaría: Pidgey es vulnerable ante Pikachu
         */

        String t = this.tipo;
        String l = p.tipo;

        // En este método dependiendo de que tipo sea el pokemon de instancia se va a
        // comparar con el pokemon que esta entrando en
        // el método. Cada if hace una comparación con cada tipo para ver si es
        // vulnerable o no.

        if ((t == "acero" && l == "lucha") || (t == "acero" && l == "fuego") || (t == "acero" && l == "Tierra")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "agua" && l == "planta") || (t == "agua" && l == "electrico")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "bicho" && l == "volador") || (t == "bicho" && l == "Fuego")
                || (t == "bicho" && l == "Roca")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "dragon" && l == "hada") || (t == "dragon" && l == "hielo")
                || (t == "dragon" && l == "dragon")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if (t == "electrico" && l == "tierra") {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "fantasma" && l == "fantasma") || (t == "fantasma" && l == "siniestro")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "fuego" && l == "tierra") || (t == "fuego" && l == "agua") || (t == "fuego" && l == "roca")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "hada" && l == "acero") || (t == "hada" && l == "veneno")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "hielo" && l == "lucha") || (t == "hielo" && l == "acero") || (t == "hielo" && l == "fuego")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "lucha" && l == "psiquico") || (t == "lucha" && l == "volador")
                || (t == "lucha" && l == "hielo")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "normal" && l == "lucha")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "planta" && l == "volador") || (t == "planta" && l == "bicho")
                || (t == "planta" && l == "hielo") || (t == "planta" && l == "fuego")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "psiquico" && l == "bicho") || (t == "psiquico" && l == "fantasma")
                || (t == "psiquico" && l == "siniestro")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "roca" && l == "lucha") || (t == "roca" && l == "tierra") || (t == "roca" && l == "agua")
                || (t == "roca" && l == "planta")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "siniestro" && l == "lucha") || (t == "siniestro" && l == "hada")
                || (t == "siniestro" && l == "bicho")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "tierra" && l == "agua") || (t == "tierra" && l == "planta")
                || (t == "tierra" && l == "hielo")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "veneno" && l == "psiquico") || (t == "veneno" && l == "tierra")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else if ((t == "volador" && l == "roca") || (t == "volador" && l == "electrico")
                || (t == "volador" && l == "hielo")) {
            System.out.println(this.nombre + " es vulnerable a este pokemon " + p.nombre);
        } else {
            System.out.println(this.nombre + " no es vulnerable " + p.nombre);
        }

    }

    // Método donde un pokemon se cae y se resta un 3% a su HP
    public void caerse(Pokemon p) {
        int total = p.getHPMAX();
        int energía = p.getHP();
        double desc = energía * 0.03;
        int desc1 = (int) desc;
        HP = energía - desc1;
        System.out.println("Tu pokemon se cayó, tiene de HP " + HP + " de " + total);
        p.setHP(HP);
    }
    // Método Main

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Pokemon pokemon1 = new Pokemon();
        Pokemon referencia = new Pokemon();
        Pokemon pokemon2 = new Pokemon("Gardevoir", "hielo", "Normal", 150, 150, 30, 1);
        // Probando métodos get y set de la clase pokemon
        System.out.println("\nTu pokemon por omisión es: " + pokemon1.toString());
        System.out.println("¿Quieres cambiarlo?");
        System.out.println("Presiona 1 si deseas cambiarlo");
        System.out.println("Presiona 2 si deseas continuar con el pokemon");
        int s = lector.nextInt();
        if (s == 1) {
            System.out.print("Nombre del pokemon: ");
            String nombre1 = lector.next();
            pokemon1.setNombre(nombre1);
            System.out.print("Tipo: ");
            System.out.println(
                    "\nExisten estos tipos de pokemons:acero, lucha,fuego, tierra, agua, planta, eléctrico, bicho, volador, roca, hada, hielo, dragon, fantasma, siniestro, veneno, psiquico, normal");
            System.out.println("Escoje cual tipo será tu pokemon y escribeló");
            String tipo = lector.next();
            pokemon1.setTipo(tipo);
            System.out.print("HPMAX: ");
            int hpmax = lector.nextInt();
            pokemon1.setHPMAX(hpmax);
            System.out.print("HP: ");
            int hp = lector.nextInt();
            while (hp > pokemon1.getHPMAX()) {
                if (hp > pokemon1.getHPMAX()) {
                    System.out.println("Tu HP no puede ser más alta que tu HPMAX\nIngresa un valor válido");
                    hp = lector.nextInt();
                }
            }
            pokemon1.setHP(hp);
            System.out.println("\nTu pokemon es: " + pokemon1.toString());
        } else {
            System.out.println("Te quedas con este pokemon\n");
        }
        // Cuando se enferma el pokemon
        referencia.probabilidadEnfermarse(pokemon1);
        // Usar la bolsita
        System.out.println("¿Deseas usar la bolsita? ingresa 1 si es así y sino ingresa 2");
        int opc = lector.nextInt();
        if (opc == 1) {
            pokemon1.getBolsita();
            System.out.println("¿Qué deseas seleccionar?");
            System.out.println("1.Cranberry");
            System.out.println("2.Fullheal");
            int opc2 = lector.nextInt();
            switch (opc2) {
                case 1:
                    if (pokemon1.getHP() == pokemon1.getHPMAX()) {
                        System.out.println("Ya esta al máximo");
                    } else {
                        pokemon1.usoCranberry();
                    }
                    break;
                case 2:
                    if (pokemon1.getSalud() == "Normal") {
                        System.out.println("Tu pokemon tiene la salud " + pokemon1.getSalud());
                    } else {
                        pokemon1.usoFullHeal();
                    }
                    break;
                default:
                    System.out.println("No esta esa opción");
                    break;

            }
            pokemon1.getBolsita();
        }

        // System.out.println("La salud de tu pokemon esta " + pokemon1.getSalud());
        // Debilidad de un pokemon
        System.out.println("\n");
        System.out.println("Tu pokemon a comparar es: " + pokemon1.getNombre() + " de tipo " + pokemon1.getTipo());
        System.out.println("Se compara con: " + pokemon2.getNombre() + " de tipo " + pokemon2.getTipo());
        System.out.print("El resultado : ");
        pokemon1.comparaPokemones(pokemon2);
        System.out.println("\n");
        // Cuando se cae un pokemon
        referencia.caerse(pokemon1);
        System.out.println("\n");
        pokemon1.getBolsita();
        System.out.println("¿Qué deseas seleccionar?");
        System.out.println("1.Cranberry");
        System.out.println("2.Fullheal");
        int opc2 = lector.nextInt();
        switch (opc2) {
            case 1:
                if (pokemon1.getHP() == pokemon1.getHPMAX()) {
                    System.out.println("Ya esta al máximo");
                } else {
                    pokemon1.usoCranberry();
                }
                break;
            case 2:
                if (pokemon1.getSalud() == "Normal") {
                    System.out.println("Tu pokemon tiene la salud " + pokemon1.getSalud());
                } else {
                    pokemon1.usoFullHeal();
                }
                break;
            default:
                System.out.println("No esta esa opción");
                break;

        }

    }

}
