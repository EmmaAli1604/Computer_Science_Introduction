import java.util.Scanner;

/*
 * @author Jimenez Sanchez Emma Alicia
 * 
 * En esta clase esta en el metodo main para poder ejecutar el juego de poker y ver el resultado de las partidas pasadas
*/

public class Main2 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        boolean data = false;
        Partida partida = Deserializar.DeserializarInven();
        while (data == false) {
            System.out.println("Menú");
            System.out.println("1-> Jugar poker");
            System.out.println("2-> Ver resultado de partidas anteriores");
            System.out.println("3-> Salir");
            int opc = lector.nextInt();
            if (opc == 1) {
                partida.ImpPartida();
                Serializar.SerializarPartida(partida);
            } else if (opc == 2) {
                partida.VerPartidas();
            } else {
                data = true;
            }
        }
    }
}
