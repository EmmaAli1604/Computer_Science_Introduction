import java.io.Serializable;

/*
 * @author Emma Alicia Jimenez Sanchez 
 * En esta clase tenemos el objeto producto
*/

public class Producto implements Serializable {
    // Atributos del objeto producto
    private String codigo;
    private String nombre;
    private int unidades;
    private double precio;

    // Constructor por omision
    public Producto() {
    }

    // Constructor por parametros
    public Producto(int unidades, double precio) {
        this.unidades = unidades;
        this.precio = precio;
    }

    // Constructor por parametros
    public Producto(String codigo, String nombre, int unidades, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;
    }

    // Metódos get de la clase producto
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getUnidades() {
        return unidades;
    }

    public double getPrecio() {
        return precio;
    }

    // Metódos set de la clase producto
    public String setNombre(String nombre) {
        this.nombre = nombre;
        return nombre;
    }

    public int setUnid(int unidades) {
        this.unidades = unidades;
        return unidades;
    }

    public double setPrecio(double i) {
        this.precio = i;
        return precio;
    }

    // Metódos para poder mostrar los datos del producto de acuerdo si es cliente o
    // si es administrador
    public String mostrarAdmi() {
        String cad = "";
        cad = (codigo + "-" + nombre + ", " + unidades + " unidades $" + precio + " c/u");
        return cad;
    }

    public String mostrarCliente() {
        String cad = "";
        cad = (nombre + ", " + unidades + " unidades $" + precio + " c/u");
        return cad;
    }

}
