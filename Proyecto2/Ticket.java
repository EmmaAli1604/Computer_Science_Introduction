import java.util.Random;

public class Ticket {
    // Atributos para podedr crear un ticket
    private Perso p; // El ticket se le va asignar a una persona y dependiendo del rasgo de la
                     // persona se le va asignar diferentes menus
    private Menu menu = new Menu(); // El contenido del ticket consta de un menu
    private int NumAdic; // Una cantidad de adicionales aparte del menu
    private Adicionales[] adic = new Adicionales[8]; // Un apartado donde se guardan adicionales
    private int total; // El total del ticket

    // Metódo constructor del ticket donde su principal parametro es la persona
    public Ticket(Perso p) {
        this.p = p;
        this.menu = new Menu();
    }

    // //Metódo p
    // public Perso getPersona()
    // return p;
    // }

    // Método get para poder ver el nombre
    public String getNomMenu() {
        String i = "";
        i = menu.getNombre();
        return i;
    }

    // Metódo get para poder obtener el menu
    // public Menu getMenu() {
    // return menu;
    // }

    // Método que imprime los adicionales que se van guardando en el arreglo
    public void imprimeAdic() {
        if (NumAdic != 0) {
            for (int i = 0; i < NumAdic; i++) {
                System.out.println(adic[i].mostrar());
            }
        } else {
            System.out.println("No se pidió extras");
        }
        System.out.println();
    }

    // Metódo que busca su hay un café adicional en el arreglo
    public boolean Cafe() {
        boolean data = false;
        for (int i = 0; i < adic.length; i++) {
            if (adic[i] != null) {
                String nom = adic[i].getNombre();
                if (nom.equals("Café")) {
                    data = true;
                }
                break;
            } else {
                data = false;
            }
        }
        return data;
    }

    // Obtener el total del los adicionales guardados en el array
    public int getAdicPrecio() {
        int result = 0;
        // el numadic se necesita para no evaluar casillas que sean null y solo las que
        // esten ocupadas y esto va a ser determinado por el NumAdic
        for (int i = 0; i < NumAdic; i++) {
            result = result + adic[i].getDinero();
        }

        return result;
    }

    // Obtener el total del ticket, aquí se suma el total del menú y el de los
    // adicionales
    public int getTotal() {
        this.total = this.menu.getTotal() + getAdicPrecio();
        return total;
    }

    // Para poder asignar el menú
    public Menu setMenu(Menu menu) {
        this.menu = menu;
        return menu;
    }

    // Para poder guardar adicionales en nuestro arreglo de tipo platillos
    // especialmente
    public void setAdic(String k) {
        Adicionales adicAux = new Adicionales(k);
        for (int i = 0; i < adic.length; i++) {
            if (adic[i] == null) {
                adic[i] = adicAux;
                NumAdic++;
                break;
            }
        }
    }

    // Para poder guardaar bebidas en nuestro arreglo de tipo bebidas especialmente
    public void setAdic(String k, String l) {
        Adicionales adicAux = new Adicionales(k, l);
        for (int i = 0; i < adic.length; i++) {
            if (adic[i] == null) {
                adic[i] = adicAux;
                NumAdic++;
                break;
            }
        }

    }

    // Metódo para poder asignar un menú random
    public Menu MenuRandom() {
        Random alet = new Random();
        int random = alet.nextInt(3) + 1;
        Menu menuaux = new Menu();
        if (random == 1) {
            menuaux.Menu1(p);
        } else if (random == 2) {
            menuaux.Menu2(p);
        } else if (random == 3) {
            menuaux.Menu3(p);
        }
        return menuaux;
    }

    // Metódo para asiganr una bebida random
    public String BebRandom() {
        Random alet = new Random();
        int random = alet.nextInt(3) + 1;
        String cad;
        if (random == 1) {
            cad = "Café";
        } else if (random == 2) {
            cad = "Té";
        } else {
            cad = "Atole";
        }
        return cad;
    }

    // Metódo para poder asignar un tamaño random
    public String TamRandom() {
        Random alet = new Random();
        int random = alet.nextInt(4) + 1;
        String cad;
        if (random == 1) {
            cad = "CH";
        } else if (random == 2) {
            cad = "M";
        } else if (random == 3) {
            cad = "G";
        } else {
            cad = "M";
        }
        return cad;
    }

    // Metódo que va a evaluar ciertas condiciones para que se asigne un menu a una
    // persona de acuerdo a sus características y también para poder agregar
    // adicionales
    public void condiciones() {
        Random alet = new Random();
        Menu menuaux = new Menu(); // Menu auxiliar para poder asignar un menu
        int random = alet.nextInt(100) + 1; // variables random creadas para poder asignar una probabilidad
        int random2 = alet.nextInt(100) + 1;
        // Si la persona tiene entre 5 y 17 años entonces...
        if ((p.getEdad() >= 5) && (p.getEdad() <= 17)) {
            // Hay una probabilidad de 40 por ciento de que escoja el menu 1
            if (random <= 40) {
                menuaux.Menu1(p);
                setMenu(menuaux);
            } else if (random > 40 && random <= 45) {
                // Si la probabilidad es del 5% escoje el menu 3
                menuaux.Menu3(p);
                setMenu(menuaux);
            } else if (random > 45 && random <= 100) {
                // Si la probabilidad es del 55% escoje el menu 2
                menuaux.Menu2(p);
                setMenu(menuaux);
            }
            // Si hay una probabilidad menor o igual al 80% entonces va a pedir una bebida
            // siempre y cuando sea grande
            if (random2 <= 80) {
                String k = TamRandom();
                if (k.equals("G")) {
                    setAdic(BebRandom(), k);
                }
            }
        }
        // Si la persona es de talla XG escoje el menu 3 y siempre pide un té adicional
        // sin importar el tamaño
        if (p.getTalla().equals("XG")) {
            menuaux.Menu3(p);
            setMenu(menuaux);
            setAdic("Té", TamRandom());
            // Tiene un 90% de probabilidad de pedir un sandwich sencillo y un 70% de pedir
            // unas quesadillas
            if (random <= 90) {
                setAdic("Sandwich sencillo");
                if (random2 <= 70) {
                    setAdic("Par de quesadillas");
                }
            }
        }
        // Si la persona estaba en un rango de 60 y 99, era de talla CH y tenía una
        // probabilidad del 75% de escoger el menu 2 sino se le asigna un menu random
        if ((p.getEdad() >= 60) && (p.getEdad() <= 99) && p.getTalla().equals("CH")) {
            if (random <= 75) {
                menuaux.Menu2(p);
                setMenu(menuaux);
            } else {
                menuaux = MenuRandom();
                setMenu(menuaux);
            }
        }
        // Si la persona es un hombre, entre 30 y 40 años, y es talla G entonces va a
        // escojer el menú 3, si en el menú 3 pide un café entonces va a pedir 2 cremas
        // de cafe adicionales y 3 piezas de pan adicionales, si es que tiene una
        // probabilidad del 90%
        if (p.getGenero().equals("hombre") && (p.getEdad() >= 30) && (p.getEdad() <= 40)
                && p.getTalla().equals("G")) {
            menuaux.Menu3(p);
            setMenu(menuaux);
            String bed = menu.getBebida();
            if (bed.equals("Café")) {
                if (random2 <= 90) {
                    setAdic("Pieza de pan dulce");
                    setAdic("Pieza de pan dulce");
                    setAdic("Pieza de pan dulce");
                    setAdic("Crema para café");
                    setAdic("Crema para café");
                }
            }
        }
        // Si hay una probabilidad del 36% se va a pedir un café adicional
        if (random <= 36) {
            setAdic("Café", TamRandom());
        }
        // Si en los adicionales hay un cafe entonces se agrega una pieza de pan dulce
        if (Cafe() == true) {
            menuaux = MenuRandom();
            setMenu(menuaux);
            setAdic("Pieza de pan dulce");
        } else {
            // Si ninguna de las condiciones anteriores se cumple se crea un menu random
            menuaux = MenuRandom();
            setMenu(menuaux);
        }

    }

    // Metódo para poder imprimir el ticket
    public void ticketString(int i) {
        System.out.println("\n\n-------------------Ticket " + i + "-------------------");
        System.out.println("\t\t" + p.toString());
        System.out.println("------------------------------------------------");
        System.out.println("\t\t      " + menu.toStringPlatillos());
        System.out.println(menu.AdicString());
        System.out.println("\t\t Total del Menú: $" + menu.getTotal());
        System.out.println("------------------------------------------------");
        imprimeAdic();
        System.out.println("------------------------------------------------");
        System.out.println("\t\tTotal del ticket: $" + getTotal() + "\n");

    }
}
