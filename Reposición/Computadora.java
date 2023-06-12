public class Computadora {
    /*
     * @author Jimenez Sanchez Emma Alicia
     */
    Tarjeta2[] mazo = new Tarjeta2[5];

    // Cuando se crea el objeto computadora se le debe de asignar un mazo
    public Computadora(Tarjeta2[] i) {
        this.mazo = i;
    }

    // Para obtener el mazo de la computadora
    public Tarjeta2[] getMazo() {
        Tarjeta2[] aux = new Tarjeta2[5];
        for (int i = 0; i < mazo.length; i++) {
            aux[i] = mazo[i];
        }
        return aux;
    }

    // Metodo para mostrar cartas al usuario durante la partida
    public void mostrarUser() {
        char secreto = '\u2680';
        for (int i = 0; i < mazo.length; i++) {
            System.out.print(secreto);
        }
        System.out.println();
    }

    // Metodo para poder mostrar las cartas al final de la partida
    public void mostrarComp() {
        for (int i = 0; i < mazo.length; i++) {
            System.out.print((i + 1) + "-> ");
            mazo[i].mostrar();
        }
        System.out.println();
    }

}
