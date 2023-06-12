import java.util.Scanner;

public class Actividad1 {
    /*
     * @author Jiménez Sánchez Emma Alicia.
     * 
     * Modifica el programa de los conjuntos vistos mediante el uso de arreglos e
     * implementa las operaciones:
     * • diferencia(arr[] A, arr[] B) = A - B
     * • diferenciaSimetrica(arr[] A, arr[] B) = A △ B
     * • complemento(arr[] A) = A’
     * Nota: Considera que el Universo son todos los enteros de 0 a 100.
     */
    // Método el cual busca duplicados en dos arreglos
    public static int[] duplicados(int[] a, int[] b) {
        int duplicados = 0;
        // Recorre los dos arreglos para saber cuantos duplicados tiene
        for (int m = 0; m < a.length; m++) {
            for (int n = 0; n < b.length; n++) {
                if (a[m] == b[n]) {
                    duplicados++;
                }

            }
        }

        // Se crea un arreglo nuevo con el tamaño del primer arreglo menos los elementos
        // que esten duplicados.
        int[] arregloNuevo = new int[a.length - duplicados];

        int indiceResultado2 = 0;

        boolean repetido = false;

        // Se recorre los dos arreglos para ir bajando a los elementos
        for (int m = 0; m < a.length; m++) {
            // Mientras nuestro repretido sea falso, nos va a indicar que los elementos son
            // diferentes, si se convierte en verdadero entonces los elemtnos son iguales.
            repetido = false;

            for (int n = 0; n < b.length; n++) {

                if (a[m] == b[n]) {
                    repetido = true;
                }
            }

            // Si repetido es falso entonces se guarda en un nuevo arreglo y las
            // indiceResulatdo se le suma indicando que se agrega un elemento.
            if (repetido == false) {
                arregloNuevo[indiceResultado2] = a[m];
                indiceResultado2++;
            }

        }

        System.out.print("Tu conjunto es: ");
        for (int i = 0; i < arregloNuevo.length; i++) {
            System.out.print(arregloNuevo[i] + " / ");
        }

        // Al final regresa un nuevo arreglo
        System.out.println();
        return arregloNuevo;

    }

    // Método intersección
    public static int[] interseccion(int[] a, int[] b) {
        int contadorInterseccion = 0;

        // Se recorre los dos arreglos para saber cuantos elementos son iguales
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    contadorInterseccion++;
                }

            }

        }

        // Se crea un nuevo arreglo donde vamos a ir recorriendo los dos arreglos y si
        // los elementos se repiten entonces se guardan en el nuevo arreglo
        int[] interseccion = new int[contadorInterseccion];
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    interseccion[k] = a[i];
                    k++;
                }
            }
        }
        // Devuelve un arreglo con los valores ya guardados
        return interseccion;
    }
    // En el método unió crea un nuevo arreglo el cual va a guardar los valores de
    // los dos arreglos que se le introduzcan en uno solo, y se implemneta el
    // algoritmo de duplicados para eliminar a los elementos repretidos del arreglo
    // nuevo, se regresa un arreglo nuevo.

    public static int[] union(int[] a, int[] b) {

        int[] conjuntoUnion = new int[a.length + b.length];
        int indiceResultado = 0;
        int i = 0;

        while (i < a.length) {
            conjuntoUnion[indiceResultado] = a[i];
            indiceResultado++;
            i++;
        }

        int j = 0;
        while (j < b.length) {
            conjuntoUnion[indiceResultado] = b[j];
            indiceResultado++;
            j++;
        }

        int duplicados = 0;
        for (int m = 0; m < conjuntoUnion.length; m++) {
            for (int n = m + 1; n < conjuntoUnion.length; n++) {
                if (conjuntoUnion[m] == conjuntoUnion[n]) {
                    duplicados++;
                }

            }
        }

        int[] arregloNuevo = new int[conjuntoUnion.length - duplicados];

        int indiceResultado2 = 0;

        boolean repetido = false;

        for (int m = 0; m < conjuntoUnion.length; m++) {

            repetido = false;

            for (int n = m + 1; n < conjuntoUnion.length; n++) {

                if (conjuntoUnion[m] == conjuntoUnion[n]) {
                    repetido = true;
                }
            }

            if (repetido == false) {
                arregloNuevo[indiceResultado2] = conjuntoUnion[m];
                indiceResultado2++;
            }

        }
        return arregloNuevo;
    }

    public static int[] diferencia(int[] a, int[] b) {
        // En el método diferencia se utiliza la unión y después se hace una elimincaión
        // de duplicados, para que sola mente queden los elementos del primer arreglo
        // que se introduzca.
        int[] aux = union(a, b);
        int[] result = duplicados(aux, b);
        return result;

    }

    public static int[] diferenciaSimetrica(int[] a, int[] b) {
        // En la diferencia simétrica primero el resultado de la unión se guarda en un
        // arreglo auxiliar y los mismo hacemos con la interscción de los arreglos
        // Después se elimina los elementos duplicados y nos regresa una nueva lista sin
        // la intersección.
        int[] aux = union(a, b);
        int[] aux2 = interseccion(a, b);
        int[] result = duplicados(aux, aux2);
        return result;
    }

    public static int[] complemento(int[] a) {
        int[] sucesion = new int[100];
        for (int i = 0; i < 100; i++) {
            sucesion[i] = (i + 1);
        }
        int[] result = duplicados(sucesion, a);
        return result;
    }

    // Método Main
    public static void main(String[] args) {
        boolean data = true;
        Scanner lector = new Scanner(System.in);
        // Declaración de nuestros arreglos que vamos a ocupar.
        int[] A = { 1, 2, 7, 5 };
        int[] B = { 3, 4, 5, 8, 9, 10 };
        int[] C = { 1, 3, 4, 5, 8, 9, 10, 89, 70, 56, 24, 67 };

        while (data == true) {
            System.out.println("\nConjunto A: ");
            for (int i = 0; i < A.length; i++) {
                System.out.print(A[i] + "/ ");
            }
            System.out.println("");
            System.out.println("Conjunto B: ");
            for (int i = 0; i < B.length; i++) {
                System.out.print(B[i] + "/ ");
            }
            System.out.println("");
            System.out.println("Conjunto B: ");
            for (int i = 0; i < C.length; i++) {
                System.out.print(C[i] + "/ ");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("1-> Diferencia de conjuntos ");
            System.out.println("2-> Diferencia Simética de Conjuntos");
            System.out.println("3-> Complemento de un conjunto");
            System.out.println("4-> Salir");
            int opc = lector.nextInt();
            switch (opc) {
                case 1:
                    diferencia(A, B);
                    break;
                case 2:
                    diferenciaSimetrica(A, B);
                    break;
                case 3:
                    complemento(C);
                    break;
                case 4:
                    // En caso de que el usuario se quiera salir
                    System.out.println("Quieres salir?");
                    System.out.println("Ingresa 1 si así lo deseas");
                    System.out.println("Ingresa 2 si deseas continuar");
                    int b = lector.nextInt();
                    if (b == 1) {
                        data = false;
                    } else {
                        data = true;
                    }
                    break;
                default:
                    System.out.println("Esta opción no es válida, ingresa una opción válida");
                    data = true;
                    break;
            }
        }
        lector.close();
    }

}
