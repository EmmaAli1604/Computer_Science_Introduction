/*
 * @author Emma Alicia Jimenez Sanchez
 * 
 * En esta clase es para poder generar las excepciones personalizadas
*/

public class TiendaException extends RuntimeException {
    public TiendaException() {
    }

    public TiendaException(String mensaje) {
        super(mensaje);
    }
}
