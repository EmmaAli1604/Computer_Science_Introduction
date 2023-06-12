import java.io.Serializable;
import java.util.ArrayList;

/*
 * @author Jimenez Sanchez Emma Alicia
 * 
 * En esta clase se serializa la partida para poder obtener los resultados de los ganadores en la partida
 * 
*/

public class Partida implements Serializable {
    // En el arraylist se van guardando los ganadores
    ArrayList<String> Partidas = new ArrayList<String>();

    public Partida() {
    }

    // Metodo para poder ver a los ganadores de las ultimas partidas hechas
    public void VerPartidas() {
        System.out.println("Resultado de las partidas jugadas: ");
        for (int i = 0; i < Partidas.size(); i++) {
            System.out.println((i + 1) + ".- " + Partidas.get(i));
        }
    }

    // Metodo en el cual se hace la partida
    public void ImpPartida() {
        Baraja baraja = new Baraja();
        Competidor user1 = new Competidor(baraja.Repartir());
        Computadora comp = new Computadora(baraja.Repartir());
        String ganocomp = "Ganó la computadora";
        String ganouser = "Ganó el usuario";
        System.out.println("¡VAMOS A JUGAR POKER!");
        System.out.print("Computadora: ");
        comp.mostrarUser();
        System.out.println("Usuario: ");
        user1.VerMazo();
        user1.Cambiar();
        System.out.println("Es hora de revelar las cartas");
        System.out.println("Jerarquía de la computadora: ");
        int puntosCompu = Verificar.VerficarBaraja(comp.getMazo());
        System.out.println("Jerarquía del usuario: ");
        int puntosUsuario = Verificar.VerficarBaraja(user1.getMazo());
        System.out.println("Mazo del usuario:");
        user1.VerMazo();
        System.out.println("Mazo de la computadora: ");
        comp.mostrarComp();
        if (puntosCompu > puntosUsuario) {
            System.out.println(ganocomp);
            Partidas.add(ganocomp);

        } else if (puntosCompu < puntosUsuario) {
            System.out.println(ganouser);
            Partidas.add(ganouser);
        } else {
            int aux1 = Verificar.CartaMasAlta(comp.getMazo());
            int aux2 = Verificar.CartaMasAlta(user1.getMazo());
            if (aux1 > aux2) {
                System.out.println(ganocomp);
                Partidas.add(ganocomp);
            } else {
                System.out.println(ganouser);
                Partidas.add(ganouser);
            }
        }

    }
}
