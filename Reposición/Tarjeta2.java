/*
 * @author Jimenz Sanchez Emma Alicia
 * 
 * En esta clase tenemos a las tarjetas que van a conformar a la baraja
*/

public class Tarjeta2 {
    int num; // Todas las tarejtas tienen un número, símbolo, y color
    char simbolo;
    final String color;
    final String reset; // Este string es para poder resetear los colores de las tarjetas

    // Tarjeta por omision
    public Tarjeta2() {
        num = 0;
        simbolo = 'N';
        color = "N";
        reset = "N";
    }

    // Para crear una tarjeta
    public Tarjeta2(int i, char sim, String n, String r) {
        this.num = i;
        this.simbolo = sim;
        this.color = n;
        this.reset = r;
    }

    // Metodo get de las tarejtas
    public int getNum() {
        return num;
    }

    public char getSim() {
        return simbolo;
    }

    public String getColor() {
        return color;
    }

    // Metódos set de las tarjetas
    public int setNum(int i) {
        this.num = i;
        return num;
    }

    public char setSimbolo(char i) {
        this.simbolo = i;
        return simbolo;
    }

    // Metodo para mostrar las tarjetas
    public void mostrar() {
        if (num == 1) {
            System.out.println(color + "A " + simbolo + reset);
        } else if (num == 11) {
            System.out.println(color + "J " + simbolo + reset);
        } else if (num == 12) {
            System.out.println(color + "Q " + simbolo + reset);
        } else if (num == 13) {
            System.out.println(color + "K " + simbolo + reset);
        } else {
            System.out.println(color + num + " " + simbolo + reset);
        }
    }
}
