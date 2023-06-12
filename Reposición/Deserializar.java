import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;

/*
 * @author Emma Alicia Jimenez Sanchez
 * En esta clase es para poder deserializar el nuestro objeto guardado y poder ver que se almaceno
 * 
*/

public class Deserializar {
    public static Partida DeserializarInven() {
        Partida aux = new Partida();
        try {
            FileInputStream fis = new FileInputStream("PartidasGanadas.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            aux = (Partida) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("La clase no ha sido encontrada");
            e.printStackTrace();
        }
        return aux;
    }
}
