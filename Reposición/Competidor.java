import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @author Jimenez Sanchez Emma Alicia
 * 
 * En esta clase se crea al competidor
*/
public class Competidor {
    // Cada competidor debe de tener 5 tarjetas de la baraja
    Tarjeta2[] mazo = new Tarjeta2[5];

    // Cuando se crea un competidor se le debe de aisgnar un mazo de tarjetas
    public Competidor(Tarjeta2[] i) {
        this.mazo = i;
    }

    // Metodo para obtener el mazo del competidor
    public Tarjeta2[] getMazo() {
        Tarjeta2[] aux = new Tarjeta2[5];
        for (int i = 0; i < mazo.length; i++) {
            aux[i] = mazo[i];
        }
        return aux;
    }

    // Metodo para ver el mazo
    public void VerMazo() {
        for (int i = 0; i < mazo.length; i++) {
            System.out.print((i + 1) + "-> ");
            mazo[i].mostrar();
        }
    }

    // Metodo para poder quitar tarjetas del mazo
    public void Quitar(int i) {
        for (int j = 0; j < mazo.length; j++) {
            if (j == i) {
                // Primero se pone que el lugar es nulo y después en ese lugar se le asigan otra
                // tarjeta
                mazo[j] = null;
                mazo[j] = Baraja.Agregar();
            }
        }
    }

    // Para poder validas el cambio de tarjetas, si selecciona un valor que no sea
    // menor a 5 y que no sea mayor a cero lanza una excpecion
    public void ValidarCambio(int i) throws IndexOutOfBoundsException {
        if (i > 5 && i <= 0) {
            throw new IndexOutOfBoundsException("No tienes este número de cartas");
        }
    }

    // Metodo para validar la opcion del menú , si la entrada es mayor a 2 , esa
    // opcion del menu no estará
    public void ValidarMenuCam(int i) throws IndexOutOfBoundsException {
        if (i > 2) {
            throw new IndexOutOfBoundsException("Este número no esta en el menú");
        }
    }

    // Metodo para poder cambiar las cartas
    public void Cambiar() {
        Scanner lector = new Scanner(System.in);
        boolean data2 = false;
        boolean data3 = false;
        int opc = 0;
        System.out.println("¿Quieres cambiar de carta?");
        System.out.println("Ingresa 1 si deseas cambiar tus cartas");
        System.out.println("Ingresa 2 si las quieres conservar");
        // Aquí primero se atrapan los posibles errores que puedan haber en la entrada
        // del menú para cambiar
        while (data2 == false) {
            try {
                opc = lector.nextInt();
                ValidarMenuCam(opc);
                data2 = true;
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Ingresa un valor válido");
                String opc2 = lector.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e);
                System.out.println("Ingresa un valor válido");
            }
        }

        // Si la opcion es un 1 se cambia, sino el usuario se quedo con sus cartas
        if (opc == 1) {
            // Atrapar los posibles errores
            while (data3 == false) {
                try {
                    boolean data = false;
                    int cont = 0;
                    // Mientras que el usuario quiera seguir cambiando de cartas y mientras haya
                    // realizado menos de 5 cambios, puede seguir cambiando cartas
                    while (data == false && cont < 5) {
                        System.out.println("Ingresa el número de la carta a quitar");
                        VerMazo();
                        System.out.println("-1 -> Ya no quiero cambiar de cartas");
                        int opc2 = lector.nextInt();
                        ValidarCambio(opc2);
                        if (opc2 != -1 && cont < 5) {
                            cont++;
                            Quitar(opc2 - 1);
                        } else if (opc2 == -1) {
                            data = true;
                            data3 = true;
                        } else {
                            data = true;
                            data3 = true;
                        }
                    }
                    System.out.println("Ya cambiaste todas tus cartas");
                    data3 = true;

                } catch (InputMismatchException e) {
                    System.out.println(e);
                    System.out.println("Ingresa un valor válido");
                    String opc3 = lector.nextLine();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e);
                    System.out.println("Ingresa un valor válido");
                }

            }
        } else {
            System.out.println("Te quedaste con las mismas cartas");
        }

    }

}
