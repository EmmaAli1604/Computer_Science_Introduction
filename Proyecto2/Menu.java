import java.util.Random;

public class Menu {

    /*
     * @author Jimenez Sanchez Emma Alicia
     */

    // Atributos de la clase menu
    private String menu; // Nombre del menu
    private String platillo1; // Primer platillo del menu
    private String platillo2; // Segundo platillo del menu
    private String bebida; // La bebida del menu
    private Adicionales adc1 = new Adicionales(); // Primera opción del adicional
    private Adicionales adc2 = new Adicionales(); // Seguna opción del adicional
    private Adicionales adc3 = new Adicionales(); // Tercera opción del adicional para la Bebida
    private int total; // Total del menu

    // Metodo Constructor
    public Menu() {
    }

    // Metódo el cual va a asiganr a nuestro objeto menú todos los platillos,
    // bebidas y extras del menú 1.
    public int Menu1(Perso p) {
        total = 60;
        // Creacion de objetos random para poder hacer la probabilidad de escoger algo
        // en el menu
        Random alet = new Random();
        int loco = alet.nextInt(2);
        int rompe = alet.nextInt(4);
        int nosiesamor = alet.nextInt(10) + 1;
        menu = "Menú 1"; // Nombre del menu
        platillo2 = "Fruta"; // Primer platillo del menu
        // Se escoje si quieren que sea verdes o rojos los chilaquiles y también dentro
        // de este se escoge la bebida
        if (loco == 1) {
            platillo1 = "Chilaquiles Verdes";
            bebida = "Café";
        } else {
            platillo1 = "Chilaquiles Rojos";
            bebida = "Jugo";
        }
        // Escoger si la fruta lleva un adicional
        if (rompe == 0) {
            adc1 = new Adicionales("Miel");
            adc2 = new Adicionales();
            total = total + adc1.getDinero(); // De acuerdo al adicional va a tener un precio y este se le suma a total
                                              // del menu
        } else if (rompe == 1) {
            adc1 = new Adicionales();
            adc2 = new Adicionales("Granola");
            total = total + adc2.getDinero();
        } else if (rompe == 2) {
            adc1 = new Adicionales("Miel");
            adc2 = new Adicionales("Granola");
            total = total + adc1.getDinero() + adc2.getDinero();
        } else {
            adc1 = new Adicionales();
            adc2 = new Adicionales();
            total = total + adc1.getDinero() + adc2.getDinero();
        }
        // Probabilidad de que una mujer pida crema batida
        if ("mujer".equals(p.getGenero()) && bebida.equals("Café")
                && nosiesamor <= 7) {
            adc3 = new Adicionales("Crema para café");
            total = total + adc3.getDinero();
        } else {
            adc3 = new Adicionales();
        }
        return total;
    }

    // Asignacion para el menú 2
    public int Menu2(Perso p) {
        menu = "Menu 2";
        platillo1 = "Molletes";
        platillo2 = "Avena";
        // Creacion de la probabilidad para que una persona pida frua y para poder
        // escoger la bebida en el menu
        Random alet = new Random();
        int nosiesamor = alet.nextInt(2);
        int loco = alet.nextInt(10) + 1;
        total = 45;
        if (nosiesamor == 1) {
            bebida = "Atole";
        } else {
            bebida = "Té";
        }
        // Condciones para que una persona pida fruta con su avena
        if (((loco < 7) && (loco > 0)) && ((p.getEdad() < 100) && (p.getEdad() > 59))) {
            adc1 = new Adicionales("Fruta");
            total = total + adc1.getDinero();
        }
        return total;
    }

    // Asignación del menú tres
    public int Menu3(Perso p) {
        total = 70;
        Random alet = new Random();
        int loco = alet.nextInt(2);
        int rompe = alet.nextInt(4);
        menu = "Menú 3";
        platillo1 = "Costillas de Res";
        platillo2 = "Papas Horneadas";
        // Escoger si la fruta lleva un adicional de acuerdo a las condiciones, donde si
        // la persona es talla XG pide todos los adicionales sino se hace un random para
        // ver si otras personas quieren con adicional o no
        if (p.getTalla().equals("XG")) {
            adc1 = new Adicionales("Cebollitas");
            adc2 = new Adicionales("Nopales");
            total = total + adc1.getDinero() + adc2.getDinero();
        } else {
            if (rompe == 0) {
                adc1 = new Adicionales("Cebollitas");
                adc2 = new Adicionales();
                total = total + adc1.getDinero();
            } else if (rompe == 1) {
                adc1 = new Adicionales();
                adc2 = new Adicionales("Nopales");
                total = total + adc2.getDinero();
            } else if (rompe == 2) {
                adc1 = new Adicionales("Cebollitas");
                adc2 = new Adicionales("Nopales");
                total = total + adc2.getDinero();
            } else {
                adc1 = new Adicionales();
                adc2 = new Adicionales();
                total = total + adc1.getDinero() + adc2.getDinero();
            }
        }
        // Escoger la bebida
        if (loco == 1) {
            bebida = "Café";
        } else {
            bebida = "Jugo";
        }
        adc3 = new Adicionales();

        return total;
    }

    // Método get para poder obtener el nombre, bebida y total de un menú
    public String getNombre() {
        return menu;
    }

    public String getBebida() {
        return bebida;
    }

    public int getTotal() {
        return total;
    }

    // Metódo para poder ver los platillos del menú
    public String toStringPlatillos() {
        String cad = "";
        cad = menu + "\n\n->Platillo 1: " + platillo1 + "\n->Platillo 2: " + platillo2
                + "\n-> Bebida: " + bebida + " M ";
        return cad;
    }

    // Metódo para poder ver los adicionales del menú
    public String AdicString() {
        String cad = "";
        // Si un adicional es null, se evaluá cual combinación es cierta para poder
        // imprimir el mensaje
        if (adc1.getNombre() == null && adc2.getNombre() == null && adc3.getNombre() == null) {
            cad = "Adicionales: No hay adicionales";
        } else if (adc1.getNombre() == null && adc2.getNombre() != null && adc3.getNombre() != null) {
            cad = "Adicionales: " + "\n->" + adc2.getNombre() + "\n->" + adc3.getNombre();
        } else if (adc2.getNombre() == null && adc1.getNombre() != null && adc3.getNombre() != null) {
            cad = "Adicionales: " + "\n->" + adc1.getNombre() + "\n->" + adc3.getNombre();
        } else if (adc3.getNombre() == null && adc1.getNombre() != null && adc2.getNombre() != null) {
            cad = "Adicionales: " + "\n->" + adc1.getNombre() + "\n->" + adc2.getNombre();
        } else if (adc1.getNombre() == null && adc2.getNombre() == null && adc3.getNombre() != null) {
            cad = "Adicionales: " + "\n->" + adc3.getNombre();
        } else if (adc1.getNombre() == null && adc3.getNombre() == null && adc2.getNombre() != null) {
            cad = "Adicionales: " + "\n->" + adc2.getNombre();
        } else if (adc2.getNombre() == null && adc3.getNombre() == null && adc1.getNombre() != null) {
            cad = "Adicionales: " + "\n->" + adc1.getNombre();
        } else {
            cad = "Adicionales: " + "\n->" + adc1.getNombre() + "\n->" + adc2.getNombre() + "\n->" + adc3.getNombre();
        }
        return cad;
    }

}
