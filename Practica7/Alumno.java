import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @author Jimenez Sanchez Emma Alicia
*/

//Clase Materia
class Materia {
    // Atributos
    private String nombre;
    private int semestre;
    private int codigo;

    // Constructor por omision
    public Materia() {
    }

    // Constructor por omision
    public Materia(String nombre, int semestre, int codigo) {
        this.nombre = nombre;
        this.semestre = semestre;
        this.codigo = codigo;
    }

    // Métodos para obtener el nombre, semestre y el código de la materia
    public String getNombre() {
        return nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public int getCodigo() {
        return codigo;
    }

    // Método para ver los datos de la materia
    public void mostar() {
        System.out.println("Código: " + codigo + " | " + nombre + " | Semestre:" + semestre);
    }
}

// Clase Alumno
class Alumno {
    // Metodo enum para las carreras de los alumnos
    public enum Carrera {
        ACTUARIA,
        MATEMATICAS,
        CIENCIAS_DE_LA_COMPUTACION,
        MATEMATICAS_APLICADAS,
        BIOLOGIA,
        FISICA
    };

    // Atributos de la clase Alumno
    protected int NumCuenta;
    protected String NombreCom;
    protected ArrayList<Materia> TiraMaterias = new ArrayList<Materia>(); // Tira de Materias
    protected static ArrayList<Materia> Catalog = new ArrayList<Materia>(); // Catalogo de Materias
    protected int Semestre;
    protected Carrera carrera;
    protected int NumMateria; // Contador de Materias

    // Metodo que convierte un objeto de tipo carrera a un string
    public String isCarrera(Carrera carrera) {
        String cad = "";
        if (carrera == Carrera.ACTUARIA) {
            cad = "ACTUARIA";
        } else if (carrera == Carrera.MATEMATICAS) {
            cad = "MATEMATICAS";
        } else if (carrera == Carrera.CIENCIAS_DE_LA_COMPUTACION) {
            cad = "CIENCIAS_DE_LA_COMPUTACION";
        } else if (carrera == Carrera.MATEMATICAS_APLICADAS) {
            cad = "MATEMATICAS_APLICADAS";
        } else if (carrera == Carrera.BIOLOGIA) {
            cad = "BIOLOGIA";
        } else if (carrera == Carrera.FISICA) {
            cad = "FISICA";
        } else {
            cad = "No disponible";
        }
        return cad;
    }

    // Constructor por omision
    public Alumno() {
    }

    // Alumno de primer ingreso, donde se les asigna una materia por default
    public Alumno(int numCuenta, String nombre, Carrera carrera) {
        this.NombreCom = nombre;
        this.NumCuenta = numCuenta;
        this.carrera = carrera;
        Semestre = 1;
        String caraux = isCarrera(carrera);
        Materia materia;
        if (caraux.equals("ACTUARIA")) {
            materia = new Materia("Calculo Moderno", 1, 123);
            TiraMaterias.add(materia);
            Catalog.add(materia);
            NumMateria++;
        } else if (caraux.equals("MATEMATICAS")) {
            materia = new Materia("Geometría analítica", 1, 365);
            TiraMaterias.add(materia);
            Catalog.add(materia);
            NumMateria++;
        } else if (caraux.equals("CIENCIAS_DE_LA_COMPUTACION")) {
            materia = new Materia("Inglés", 1, 363);
            TiraMaterias.add(materia);
            Catalog.add(materia);
            NumMateria++;
        } else if (caraux.equals("MATEMATICAS_APLICADAS")) {
            materia = new Materia("Lógica", 1, 364);
            TiraMaterias.add(materia);
            Catalog.add(materia);
            NumMateria++;
        } else if (caraux.equals("BIOLOGIA")) {
            materia = new Materia("Francés", 1, 361);
            TiraMaterias.add(materia);
            Catalog.add(materia);
            NumMateria++;
        } else if (caraux.equals("FISICA")) {
            materia = new Materia("Dinámica", 1, 362);
            TiraMaterias.add(materia);
            Catalog.add(materia);
            NumMateria++;
        }
    }

    // Alumno de reinscripción, donde tiene que inscribir sus materias de acuerdo al
    // catalogo
    public Alumno(int numCuenta, String nombre, Carrera carrera, int l) {
        this.NombreCom = nombre;
        this.NumCuenta = numCuenta;
        this.carrera = carrera;
        this.Semestre = l;
    }

    // Metodos para obtener nombre, número de cuenta, semestre, carrera y tira de
    // materias
    public String getnom() {
        return NombreCom;
    }

    public int getNumCuen() {
        return NumCuenta;
    }

    public int getSemestre() {
        return Semestre;
    }

    public Carrera getcarCarrera() {
        return carrera;
    }

    public void getTiradeMaterias() {
        if (TiraMaterias.isEmpty()) {
            System.out.println("No tiene  ninguna materia registrada\n");
        } else {
            System.out.println("----------------------Tira de Materias----------------------");
            for (int i = 0; i < TiraMaterias.size(); i++) {
                TiraMaterias.get(i).mostar();
            }
        }
    }

    // Metodo para mostrar los datos de un alumno
    public void mostrar() {
        System.out.println(NombreCom + " " + NumCuenta + " Carrera: " + carrera + " Semestre " + Semestre + "\n");
        getTiradeMaterias();
    }

    // Metodo para indica por codigo si una materia se encuentra en el catalog
    public boolean Encontrada(int i) {
        boolean data = false;
        for (int k = 0; k < Catalog.size(); k++) {
            if (Catalog.get(k).getCodigo() == i) {
                data = true;
                break;
            }
        }
        return data;
    }

    // Metodo que busca en el catalogo la materia por codigo y regresa la materia
    public Materia Buscar2(int i) {
        Materia aux = new Materia();
        for (int k = 0; k < Catalog.size(); k++) {
            if (Catalog.get(k).getCodigo() == i) {
                aux = Catalog.get(k);
                break;
            }
        }
        return aux;
    }

    // Metodo que te indica si una materia ya esta en la tira de materias o no
    public boolean EncontradaTira(int i) {
        boolean data = false;
        for (int j = 0; j < TiraMaterias.size(); j++) {
            if (TiraMaterias.get(j).getCodigo() == i) {
                data = true;
                break;
            }
        }
        return data;
    }

    // Metodo para buscar una materia en la tira de materias de un alumno y regresa
    // esa materia
    public Materia BuscarTira2(int i) {
        Materia aux = new Materia();
        for (int k = 0; k < TiraMaterias.size(); k++) {
            if (TiraMaterias.get(k).getCodigo() == i) {
                aux = TiraMaterias.get(k);
                break;
            }
        }
        return aux;
    }

    // Metodo para poder inscribir una materia, si es que se encuentra en el
    // catalogo, si no tiene ya inscrita la materia,si la materia es de su semestre
    // y si todavia tiene espacio para la materia
    public void InscribirMateria(int cod) {
        boolean encont = Encontrada(cod);
        if (encont == true) {
            boolean eno = EncontradaTira(cod);
            if (eno == true) {
                System.out.println("Ya inscribiste esta materia");
            } else {
                Materia aux = Buscar2(cod);
                if (aux.getSemestre() == Semestre) {
                    if (NumMateria < 5) {
                        TiraMaterias.add(aux);
                        System.out.println("Se ha agregado " + aux.getNombre() + " a la Tira de Materias");
                        NumMateria++;
                    } else {
                        System.out.println("Ya tienes suficientes materias");
                    }
                } else {
                    System.out.println("Esta materia no es de tu semestre");
                }
            }
        } else {
            System.out.println("No se encontro en el catalogo");
        }
    }

    // Metodo para obtener el codigo todas las materias en la tira y regresa el
    // codigo
    public int getCodigo() {
        int i = 0;
        for (int k = 0; k < TiraMaterias.size(); k++) {
            i = TiraMaterias.get(k).getCodigo();
        }
        return i;
    }

    // Metodo para poder quitar una materia de la tira de materias de un alumno
    public void DarBajaMateria(int cod) {
        boolean data = EncontradaTira(cod);
        if (data == true) {
            if (NumMateria > 1) {
                Materia aux = Buscar2(cod);
                TiraMaterias.remove(aux);
                System.out.println("Se ha eliminado " + aux.getNombre());
                NumMateria--;
            } else {
                System.out.println("Debes de tener por lo menos una materia");
            }
        } else {
            System.out.println("Esta materia no se enuentra en su tira de materias");
        }
    }

    // Metodo para poder dar de alta una materia en el catalogo de materias
    // disponibles
    public void DarDeAlta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la materia: ");
        String nombre = sc.nextLine();
        System.out.println();
        System.out.print("Clave: ");
        int clave = sc.nextInt();
        while (Encontrada(clave) == true) {
            if (Encontrada(clave) == true) {
                System.out.println("Ingresa otra clave, esta ya esta ocupada");
                clave = sc.nextInt();
            }
        }
        System.out.println();
        System.out.print("Semestre: ");
        int sem = sc.nextInt();
        Materia aux = new Materia(nombre, sem, clave);
        Catalog.add(aux);
        System.out.println("Se ha agregado " + aux.getNombre() + " al catalogo");
    }

    // Metodo para poder obtener las materias disponibles en el catalogo
    public static void getcatalogo() {
        if (Catalog.isEmpty()) {
            System.out.println("No tiene  ninguna materia registrada\n");
        } else {
            System.out.println("----------------------Catalogo de Materias----------------------");
            for (int i = 0; i < Catalog.size(); i++) {
                Catalog.get(i).mostar();
            }
        }
    }

    // Metodo para poder comparar si dos alumnos comparten una clase
    public void Buscar(Alumno a1, Alumno a2) {
        Alumno aux = new Alumno();
        Alumno aux2 = new Alumno();
        if (a1.TiraMaterias.size() <= a2.TiraMaterias.size()) {
            aux = a1;
            aux2 = a2;
        } else if (a1.TiraMaterias.size() > a2.TiraMaterias.size()) {
            aux = a2;
            aux2 = a1;
        }
        for (int i = 0; i < aux.TiraMaterias.size(); i++) {
            for (int k = 0; k < aux2.TiraMaterias.size(); k++) {
                int s = aux.TiraMaterias.get(i).getCodigo();
                int j = aux2.TiraMaterias.get(i).getCodigo();
                if (s == j) {
                    System.out.println("Materias que comparten: ");
                    TiraMaterias.get(i).mostar();
                    break;
                } else {
                    System.out.println("No comparten materias");
                    break;
                }
            }
        }
    }

    // Metodo que muestra el menu
    public static void Menu() {
        System.out.println("¯`*•.¸,¤°´✿.｡.:*▁ ▂ ▄ ▅ ▆ ▇ █ BIENVENIDO █ ▇ ▆ ▅ ▄ ▂ ▁*:.｡.✿´°¤,¸.•*`¯");
        System.out.println("\t1. •------»       Datos del Alumno       »------•");
        System.out.println("\t2. •------»     Inscribir una materia    »------•");
        System.out.println("\t3. •------»      Buscar compañeros       »------•");
        System.out.println("\t4. •------»   Imprimir tira de Materias  »------•");
        System.out.println("\t5. •------»   Dar de alta una materia    »------•");
        System.out.println("\t6. •------»    Dar de baja una materia   »------•");
        System.out.println("\t7. •------»         Agregar Alumno       »------•");
        System.out.println("\t8. •------»        Agregar Ayudante      »------•");
        System.out.println("\t9. •------»     Ver lista de Ayudantes   »------•");
        System.out.println("\t10. •------»      Ver lista de Alumnos   »------•");
        System.out.println("\t11. •------»   Ver Catálogo de Materias  »------•");
        System.out.println("\t12. •------»      Materias Populares     »------•");
        System.out.println("\t13. •------»            Salir            »------•");
    }

}

// Clase AlumnoAyudante que hereda de la clase ALumno
class AlumnoAyudante extends Alumno {
    // Atributos de la clase AlumnoAyudante
    private String clase;

    // Constructor por omision
    public AlumnoAyudante() {
    }

    // Constrcutor por parametros
    public AlumnoAyudante(int i, String nom, Carrera carrera, int sem, String k) {
        // Constructor que hereda del constructor de la clase Alumno
        super(i, nom, carrera, sem);
        this.clase = k;
    }

    // Metodo para obtener la clase de un ayudante
    public String getClase() {
        return clase;
    }

    public void mostarAyud() {
        System.out.println(
                NombreCom + " " + NumCuenta + " Carrera: " + carrera + " Semestre " + Semestre + " Clase: " + clase);
        getTiradeMaterias();
    }
}

// Clase Main donde se ejecuta e implementa la mayoría de los metódos
class Main {
    static ArrayList<Alumno> Alumnos = new ArrayList<Alumno>(); // ArrayList para poder guardar a los alumnos
    static ArrayList<AlumnoAyudante> AlumnosAyud = new ArrayList<AlumnoAyudante>(); // ArrayList para poder guardar a
                                                                                    // los ayudantes
    static ArrayList<Materia> Populares = new ArrayList<Materia>(); // ArrayList para poder guardar a la materias
                                                                    // populares entre los alumnos

    // Metodo para poder agregar a la lista populares las materias que tengan más
    // alumnos inscritos
    public static void addPopulares() {
        for (int i = 0; i < Alumnos.size(); i++) {
            for (int k = 0; k < Alumnos.size(); k++) {
                if (Alumnos.get(i).getCodigo() == Alumnos.get(k).getCodigo()) {
                    int g = Alumnos.get(i).getCodigo();
                    Materia aux = Alumnos.get(i).Buscar2(g);
                    Populares.add(aux);
                    break;
                }
                ;
            }
        }
    }

    // Metodo que muestra las materias populares o las más inscritas
    public static void getpopulares() {
        if (Populares.isEmpty()) {
            System.out.println("No tiene  ninguna materia registrada");
        } else {
            System.out.println("๑۞๑,¸¸,ø¤º°`°๑۩ MATERIAS POPULARES ๑۩ ,¸¸,ø¤º°`°๑۞๑");
            for (int i = 0; i < Populares.size(); i++) {
                System.out.print((i + 1) + ".-");
                Populares.get(i).mostar();
                System.out.println();
            }
        }
    }

    // Metodo para poder ver los alumnos inscritos
    public static void getAlumno() {
        if (Alumnos.isEmpty()) {
            System.out.println("No tiene  ningun alumno registrada");
        } else {
            System.out.println("๑۞๑,¸¸,ø¤º°`°๑۩ ALUMNOS ۩๑°`°º¤ø,¸¸,๑۞๑");
            for (int i = 0; i < Alumnos.size(); i++) {
                System.out.print((i + 1) + ". ");
                Alumnos.get(i).mostrar();
                System.out.println();
            }
        }
    }

    // Metodo para poder ver los ayudantes inscritos
    public static void getAlumnoAyuc() {
        if (AlumnosAyud.isEmpty()) {
            System.out.println("No tiene  ningun ayudante registrado");
        } else {
            System.out.println("๑۞๑,¸¸,ø¤º°`°๑۩ AYUDANTES ۩๑°`°º¤ø,¸¸,๑۞๑");
            for (int i = 0; i < AlumnosAyud.size(); i++) {
                System.out.print((i + 1) + ". ");
                AlumnosAyud.get(i).mostarAyud();
                System.out.println();
            }
        }
    }

    // Metodo Main
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        Scanner ln = new Scanner(System.in);
        boolean data = false; // Centinela para poder saber si quiere salir del meni
        Alumno alum = new Alumno(); // Creacion del objeto Alumno
        // Inscripcion y declaración del Alumno
        boolean excep = false; // Booleano para la excepción
        // Mientras que exp sea falso significa que no esta introduciendo un dato
        // correctamente y sale un excepcion,cuando introduzca los datos correctamente
        // puede pasar al menu

        while (excep == false) {
            try {
                System.out.println("¿Cuál es tu nombre completo?");
                String nombre = ln.nextLine();
                System.out.println("¿Cuál es tu número de cuenta?");
                int cuenta = sr.nextInt();
                System.out.println("¿Cuál es tu carrera?");
                System.out.println(
                        "Escribe tu carrera de esta manera: ACTUARIA,MATEMATICAS,CIENCIAS_DE_LA_COMPUTACION,MATEMATICAS_APLICADAS,BIOLOGIA,FISICA");
                System.out.println("Escribelo en MAYÚSUCLAS y en lugar de los espacios poner '_'(guión bajó)");
                String carrera = ln.nextLine();
                System.out.println("¿Cuál es tu semestre?");
                int sem = sr.nextInt();
                if (sem == 1) {
                    alum = new Alumno(cuenta, nombre, Alumno.Carrera.valueOf(carrera));
                    Alumnos.add(alum);
                } else {
                    alum = new Alumno(cuenta, nombre, Alumno.Carrera.valueOf(carrera), sem);
                    Alumnos.add(alum);
                }
                excep = true;
            } catch (InputMismatchException e) {
                System.out.println("Da un valor válido ಠ_ಠ");
                String opc = sr.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("No escribiste la carrera como se pide ಠ_ಠ");
                String opc = sr.nextLine();
            }
        }

        while (data == false) {
            // Atrapar posibles excepciones
            try {
                alum.Menu(); // Se imprime el menu
                int opc = sr.nextInt();
                switch (opc) {
                    case 1:
                        // Para poder mostrar los datos
                        alum.mostrar();
                        break;
                    case 2:
                        // Para poder inscribir una materia a un estudiante inscrito
                        System.out.println("¿A que alumno se le va agregar una materia?");
                        System.out.println("Introduce el número de la izquierda al nombre");
                        getAlumno();
                        int mero = sr.nextInt();
                        Alumno aux = Alumnos.get(mero - 1);
                        System.out.println("¿Cuál es la clave de la materia que quieres inscribir?");
                        alum.getcatalogo();
                        int i = sr.nextInt();
                        aux.InscribirMateria(i);
                        break;
                    case 3:
                        // Metodo para poder comparar un alumno con otro, para ver si tienen las mismas
                        // materias o si comparten
                        if (Alumnos.size() < 1) {
                            System.out.println("No se puede comparar solo tienes un alumno");
                        } else {
                            System.out.println(
                                    "¿Cuál alumno quieres comparar? Escribe el número de lado izquierdo al nombre del alumno");
                            getAlumno();
                            int num = sr.nextInt();
                            System.out.println(
                                    "¿Con quién lo quieres comparar? Escribe el número de lado izquierdo al nombre del alumno");
                            int num2 = sr.nextInt();
                            alum.Buscar(Alumnos.get(num - 1), Alumnos.get(num2 - 1));
                        }
                        break;
                    case 4:
                        // Para ver la Tira de Materias del alumno al cual inscribimos
                        alum.getTiradeMaterias();
                        break;
                    case 5:
                        // Para poder dar de alta una materia
                        alum.DarDeAlta();
                        break;
                    case 6:
                        // Para poder dar de baja una materia, primero hay que introducir el alumno al
                        // cual se le quiere quitar la materia y ya despues el codigo para poder
                        // quitarlas
                        System.out.println("¿A que alumno se le va quitar una materia?");
                        System.out.println("Introduce el número de la izquierda al nombre");
                        getAlumno();
                        mero = sr.nextInt();
                        Alumno aux1 = new Alumno();
                        aux1 = Alumnos.get(mero - 1);
                        System.out.println("¿Cuál es la clave de la materia que quieres dar de baja?");
                        int g = sr.nextInt();
                        aux1.DarBajaMateria(g);
                        break;
                    case 7:
                        // En esta parte es para poder inscribir a otro alumno
                        System.out.println("¿Cuál es tu nombre completo?");
                        String nombre2 = ln.nextLine();
                        System.out.println("¿Cuál es tu número de cuenta?");
                        int cuenta2 = sr.nextInt();
                        System.out.println("¿Cuál es tu carrera?");
                        System.out.println(
                                "Escribe tu carrera de esta manera: ACTUARIA,MATEMATICAS,CIENCIAS_DE_LA_COMPUTACION,MATEMATICAS_APLICADAS,BIOLOGIA,FISICA");
                        System.out.println(
                                "Escribelo en MAYÚSUCLAS y en lugar de los espacios poner '_'(guión bajó)");
                        String carrera2 = ln.nextLine();
                        System.out.println("¿Cuál es tu semestre?");
                        int sem2 = sr.nextInt();
                        if (sem2 == 1) {
                            Alumno alum2Alumno = new Alumno(cuenta2, nombre2, Alumno.Carrera.valueOf(carrera2));
                            Alumnos.add(alum2Alumno);
                        } else {
                            Alumno alum2Alumno = new Alumno(cuenta2, nombre2, Alumno.Carrera.valueOf(carrera2),
                                    sem2);
                            Alumnos.add(alum2Alumno);
                        }
                        break;
                    case 8:
                        // Para poder inscribir a un ayudante
                        System.out.println("¿Cuál su nombre completo?");
                        String nomAyu = ln.nextLine();
                        System.out.println("¿Cuál su número de cuenta?");
                        int cuenAyu = sr.nextInt();
                        System.out.println("¿Cuál su carrera?");
                        System.out.println(
                                "Escribe tu carrera de esta manera: ACTUARIA,MATEMATICAS,CIENCIAS_DE_LA_COMPUTACION,MATEMATICAS_APLICADAS,BIOLOGIA,FISICA");
                        String carAyu = ln.nextLine();
                        System.out.println("¿Cuál su semestre?");
                        int semAyu = sr.nextInt();
                        System.out.println("¿Qué clase imparte?");
                        String clasAyu = ln.nextLine();
                        AlumnoAyudante alumayu = new AlumnoAyudante(cuenAyu, nomAyu, Alumno.Carrera.valueOf(carAyu),
                                semAyu,
                                clasAyu);
                        AlumnosAyud.add(alumayu);
                        break;
                    case 9:
                        // Para ver la lista de ayudantes
                        getAlumnoAyuc();
                        break;
                    case 10:
                        // Para ver la lista de alumnos
                        getAlumno();
                        break;
                    case 11:
                        // Para ver el catalogo de materias
                        alum.getcatalogo();
                        break;
                    case 12:
                        // para poder ver las materias más inscritas
                        addPopulares();
                        getpopulares();
                        break;
                    case 13:
                        // Para poder salir
                        data = true;
                        break;
                    default:
                        System.out.println("Opción no válida ლ(ಠ_ಠლ)");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Da un valor válido ಠ_ಠ");
                String opc = sr.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Da un valor válido ಠ_ಠ");
                String opc = sr.nextLine();
            }
        }
    }
}
