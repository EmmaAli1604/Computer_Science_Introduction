import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/*
 * @author Emma Alicia Jimenez Sanchez
 * 
 * En esta clase podemos encontrar el metódo para poder serializar nuestro objeto inventario
 * Con este metódo se va a guardar los datos del inventario
*/

public class SerializarInventario {
    public static void SerializarInv(Inventario aux) {
        try {
            FileOutputStream fos = new FileOutputStream("Inventario.ser");
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
