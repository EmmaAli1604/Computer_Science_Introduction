import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;

/*
 * @author Emma Alicia Jimenez Sanchez
 * 
 * En esta clase podemos encontrar el metódo para poder deserializar nuestro objeto inventario
 * Con este metódo podemos recuperar los datos y guardados en el archivo .ser que se creo
 * 
*/

public class DeserializarInv {
    public static Inventario DeserializarInven() {
        Inventario aux = new Inventario();
        try {
            FileInputStream fis = new FileInputStream("Inventario.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            aux = (Inventario) ois.readObject();
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
