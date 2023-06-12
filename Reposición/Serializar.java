import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/*
 * @author Emma Alicia Jimenez Sanchez
 * En esta clase es para poder serializar a nuestro objeto partida y que se vaya guardando las partidas , 
 * ya sea ganadas o perdidas.
 *
*/

public class Serializar {
    public static void SerializarPartida(Partida aux) {
        try {
            FileOutputStream fos = new FileOutputStream("PartidasGanadas.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(aux);
            oos.close();
            fos.close();
            System.out.println("Se ha guardado el inventario (✿◠‿◠)");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
