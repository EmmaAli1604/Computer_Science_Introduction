public class Perso {

    /*
     * @Jimenez Sanchez Emma Alicia
     */

    // Los atributos de las personas son que deben de tener edad, un genero y una
    // talla, ya sea CH, M, G o XG
    private int edad;
    private String genero;
    private String talla;

    // Metódo por omisión
    public Perso() {
    }

    // Metódo con los parametros de edad, genero y talla para poder crear a una
    // persona
    public Perso(int edad, String genero, String talla) {
        this.edad = edad;
        this.genero = genero;
        this.talla = talla;
    }

    // Metodos Get para obtener la edad, genero y talla de una persona
    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getTalla() {
        return talla;
    }

    // Metodos Set
    public int setEdad(int edad) {
        this.edad = edad;
        return edad;
    }

    public String setGenero(String i) {
        this.genero = i;
        return i;
    }

    public String setTalla(String i) {
        this.talla = i;
        return i;
    }

    // Método ToString para poder ver los datos de la persona creada
    public String toString() {
        String cad = "";
        cad = genero + ", " + edad + " años, " + talla;
        return cad;
    }

}
