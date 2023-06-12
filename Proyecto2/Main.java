import java.util.Random;

public class Main{

    public static void main(String[] args) {
        Random alet = new Random();
        Perso p = new Perso(); // Creación del objeto persona
        int edad = alet.nextInt(99 - 5) + 5; // Rango de edad para la persona
        // Contadores
        int mujer = 0; // Para saber cuantas mujeres compraron
        int hombre = 0; // Para saber cuantos hombres compraron
        // Para saber cuantos menu's de cada uno se vendió
        int menu1 = 0;
        int menu2 = 0;
        int menu3 = 0;
        int total = 0; // Total de todos los tickets
        // Generar Personas aleatorias.
        for (int i = 0; i < 15; i++) {
            edad = alet.nextInt(99 - 5) + 5;
            int opc = alet.nextInt(2);
            int opc2 = alet.nextInt(4);
            if (opc == 1) {
                p.setGenero("hombre");
            } else {
                p.setGenero("mujer");
            }
            if (opc2 == 0) {
                p.setTalla("S");
            } else if (opc2 == 1) {
                p.setTalla("M");
            } else if (opc2 == 2) {
                p.setTalla("G");
            } else {
                p.setTalla("XG");
            }
            p.setEdad(edad);
            // Se creá el ticket para poder asignar a la persona un menu y adicionales
            Ticket tick = new Ticket(p);
            // Al ticket se le aplican las condiciones
            tick.condiciones();
            // Se imrpime el ticket
            // El parametro que entra en este metódo es para saber el número de ticket
            tick.ticketString((i + 1));
            total = total + tick.getTotal();
            System.out.println("***************************************************");
            // Se evalua la información de los ticket para poder aumentar a las contadores.
            if (p.getGenero().equals("mujer")) {
                mujer++;
            } else if (p.getGenero().equals("hombre")) {
                hombre++;
            }

            if (tick.getNomMenu().equals("Menú 1")) {
                menu1++;
            } else if (tick.getNomMenu().equals("Menu 2")) {
                menu2++;
            } else if (tick.getNomMenu().equals("Menú 3")) {
                menu3++;
            }
        }

        // Al final de todos los tickets se imprimer toda la información recolectada
        System.out.println("\nTotal de dinero de los tickets-> " + total);
        System.out.println("\nTotal de Menús vendidos->");
        System.out.println("Menú 1: " + menu1);
        System.out.println("Menú 2: " + menu2);
        System.out.println("Menú 3: " + menu3);
        System.out.println("\nTotal de Clientes atentidos:");
        System.out.println("Mujeres: " + mujer);
        System.out.println("Hombres: " + hombre);

    }
}
