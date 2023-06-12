import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @author Jimenez Sanchez Emma Alicia
*/

//Clase de la excepcion personalizada
class JarraException extends RuntimeException {
    public JarraException(String mensaje) {
        super(mensaje);
    }
}

// Clase Jarra de Agua
class JarradeAgua {
    // Atributos
    private final int MaxLitros;
    private int vasos;

    // Constructor por omision
    public JarradeAgua() {
        MaxLitros = 3;
        vasos = 0;
    }

    // Constructor por parametros
    public JarradeAgua(int Max, int act) {
        MaxLitros = Max;
        vasos = act;
    }

    // Metodo para obtener los maximos de litros de una jarra
    public int getMax() {
        return MaxLitros;
    }

    // Metodo para obetner los vasos actuales de la jarra
    public int getAct() {
        return vasos;
    }

    // Metodo mostrar, para ver la información o datos de la jarra
    public void mostrar() {
        if (vasos != 3) {
            System.out.println("♒*Tu jarra tiene " + vasos + " ml de " + MaxLitros + " litros*♒");
        } else {
            System.out.println("♒*Tu jarra tiene " + vasos + " L. de " + MaxLitros + " litros*♒");
        }
    }

    // Método para poder validar que no se pase de litros con excepciones o que no
    // de un valor incorrecto como valores negativos
    public void Validas(int i) throws JarraException {
        if (i > 3000) {
            throw new JarraException("♒‘(T∩T)’♒->Pasa el límite de los vasos<-♒‘(T∩T)’♒");
        } else if (i < 0) {
            throw new JarraException("♒‘(T∩T)’♒->Esta medida no existe<-♒‘(T∩T)’♒");
        }
    }

    // Metodo para poder validar que los vasos no sean valores negativos
    public void Validar(int i) throws JarraException {
        if (i < 0) {
            throw new JarraException("♒‘(T∩T)’♒->Esta medida no existe<-♒‘(T∩T)’♒");
        }
    }

    // Metodo para poder depositar el agua
    public int DepositarAgua(int numeroVasos) {
        // try y catch para cachar la excepcion
        try {
            Validas(numeroVasos);
            this.vasos = this.vasos + numeroVasos;
            Validas(vasos);
        } catch (JarraException e) {
            System.out.println("No se puede porque: " + e.getMessage());
            // Si entra a la excepión entonces solo se van a tomar los 10 vasos límite
            if (numeroVasos > 3000) {
                vasos = 3;
            } else if (vasos < 0) {
                vasos = 0;
            }
        }
        return vasos;
    }

    // Metodo parav poder retirar agua
    public int RetirarAgua(int numeroVasos) {
        // Cachar la excepcion cuando de valores negativos
        try {
            Validar(numeroVasos);
            this.vasos = this.vasos - numeroVasos;
            Validar(vasos);
        } catch (JarraException e) {
            System.out.println("no se puede por: " + e.getMessage());
            if (numeroVasos > 3000) {
                vasos = 0;
            } else if (vasos < 0) {
                vasos = 0;
            }
        }
        return vasos;
    }

    // Método main

    public static void main(String[] args) {
        // Aquí se encuentra el menu para poder implmentar los métodos de retirar agua,
        // depositar agua, ver los datos de la jarra y salir
        // Aquí tenemos un try and catch para poder cachar la excepcion
        // inputmismatchexception
        Scanner lector = new Scanner(System.in);
        Scanner lector2 = new Scanner(System.in);
        Scanner lector3 = new Scanner(System.in);
        JarradeAgua jarra1 = new JarradeAgua();
        boolean data = true;
        System.out.println("Menú de la Jarra de Agua");
        while (data != false) {
            try {
                System.out.println("¿Qué opción deseas realizar?");
                System.out.println("1. Ver los litros de la jarra");
                System.out.println("2. Depositar agua");
                System.out.println("3. Retirar agua");
                System.out.println("4. Salir");
                int opc = lector.nextInt();
                switch (opc) {
                    case 1:
                        jarra1.mostrar();
                        break;
                    case 2:
                        try {
                            System.out.println("¿Cuantos vasos quieres depositar?");
                            int opc2 = lector2.nextInt();
                            int result = opc2 * 300;
                            jarra1.DepositarAgua(result);

                        } catch (InputMismatchException e) {
                            System.out.println("Este no es un valor númerico ಥ_ಥ\nDa un valor númerico (•̀o•́)ง");
                            String opc2 = lector2.nextLine();
                        }
                        break;

                    case 3:
                        System.out.println("¿Cuántos vasos quieres retirar?");
                        try {
                            int opc3 = lector3.nextInt();
                            int result = opc3 * 300;
                            jarra1.RetirarAgua(result);

                        } catch (InputMismatchException e) {
                            System.out.println("Este no es un valor númerico ಥ_ಥ\nDa un valor númerico ←(ಠ_ಠ)→");
                            String opc3 = lector.nextLine();
                        }
                        break;
                    case 4:
                        data = false;
                        break;
                    default:
                        System.out.println("Opción no válida ლ(ಠ_ಠლ)");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Da un valor válido ಠ_ಠ");
                String opc = lector.nextLine();
            }

        }
    }
}
