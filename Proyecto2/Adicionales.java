public class Adicionales {
    /*
     * @author Jimenez Sanchez Emma Alicia
     */
    // En esta clase creamos los adicionales (en esta clase se podía generar tanto
    // como los platillos como las bebidas)
    private String nombre; // Atributo del nombre del platillo o bebida
    private String tam; // Tamaño de la bebida
    private int dinero; // Cuanto cuesta cada cosa
    // Método constructor por omisión

    public Adicionales() {
    }

    // Platillos
    // En este metódo constructor se crean los platillos y dependiendo de que
    // platillo sea se le asigan un precio, también si solo se introduce el nombre
    // de una bebida este metódo le va a asignar el precio y el tamaño por omisión
    // que sería mediano.
    public Adicionales(String nombre) {
        this.nombre = nombre;
        if (this.nombre.equals("Sandwich sencillo")) {
            dinero = 33;
        } else if (nombre.equals("Par de quesadillas")) {
            this.dinero = 20;
        } else if (this.nombre.equals("Pieza de pan dulce")) {
            this.dinero = 17;
        } else if (this.nombre.equals("Crema para café")) {
            this.dinero = 3;
        } else if (this.nombre.equals("Miel")) {
            this.dinero = 5;
        } else if (this.nombre.equals("Granola")) {
            this.dinero = 5;
        } else if (this.nombre.equals("Cebollitas")) {
            this.dinero = 5;
        } else if (this.nombre.equals("Nopales")) {
            this.dinero = 5;
        } else if (this.nombre.equals("Fruta")) {
            this.dinero = 10;
        } else if (this.nombre.equals("Café")) {
            this.tam = "M";
            this.dinero = 22;
        } else if (this.nombre.equals("Té")) {
            this.tam = "M";
            this.dinero = 11;
        } else if (this.nombre.equals("Atole")) {
            this.tam = "M";
            this.dinero = 25;
        } else {
            this.nombre = "null";
        }
    }

    // Bebidas adicionales
    // En este metódo se crean las bebidas ya que para crear una bebida se neceista
    // el nombre y el tamaño ya después se evaluá el tamaño que es la bebida,
    // dependiendo del tamaño y del tipo de la bebida se asigan un precio.
    public Adicionales(String nombre, String tam) {
        this.nombre = nombre;
        this.tam = tam;
        if (this.nombre.equals("Café")) {
            if (this.tam.equals("CH")) {
                this.dinero = 15;
            } else if (this.tam.equals("M")) {
                this.dinero = 22;
            } else if (this.tam.equals("G")) {
                this.dinero = 27;
            }
        } else if (this.nombre.equals("Té")) {
            if (this.tam.equals("CH")) {
                this.dinero = 10;
            } else if (this.tam.equals("M")) {
                this.dinero = 11;
            } else if (this.tam.equals("G")) {
                this.dinero = 12;
            }
            this.dinero = 11;
        } else if (this.nombre.equals("Atole")) {
            if (this.tam.equals("CH")) {
                this.dinero = 20;
            } else if (this.tam.equals("M")) {
                this.dinero = 25;
            } else if (this.tam.equals("G")) {
                this.dinero = 30;
            }
        }
    }

    // Metódos get de las Bebidas, que sería para obtener el nombre, tamaño y el
    // dinero.

    public String getNombre() {
        return nombre;
    }

    public String getTam() {
        return tam;
    }

    public int getDinero() {
        return dinero;
    }

    // Método para poder mostrar los extras de acuerdo si el tamaño es diferente a
    // null se muestra el tamaño, si es igual a null se esta dando a entender que es
    // un platillo y solo se muestra el nombre y el dinero.

    public String mostrar() {
        String cad = "";
        if (tam != null) {
            cad = nombre + " de $" + dinero + " " + tam;
        } else {
            cad = nombre + " de $" + dinero;
        }
        return cad;
    }
}
