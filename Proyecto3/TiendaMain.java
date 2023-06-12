import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @author Emma Alicia Jimenez Sanchez
 * 
 * En esta clase podemos encontrar el main para poder ejecutar los metodos del inventario
*/

public class TiendaMain {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Inventario inv = DeserializarInv.DeserializarInven(); // Recuperando los datos que se guardaron en el archivo
                                                              // .ser
        boolean data2 = false;
        boolean exc = false;

        while (!exc) {
            // try/catch para las excepciones
            try {
                while (data2 == false) {
                    System.out.println("Introduce el número que deseas para ver el menú");
                    System.out.println("1-> Administrador");
                    System.out.println("2-> Cliente");
                    System.out.println("3-> Salir");
                    int opc = lector.nextInt();
                    // Los menús de acuerdo a que si es administrador o si es cliente
                    if (opc == 1) {
                        boolean data = false;

                        while (!data) {
                            // Menú administrador
                            System.out
                                    .println("\n¯`*•.¸,¤°´✿.｡.:*▁ ▂ ▄ ▅ ▆ ▇ █ BIENVENIDO █ ▇ ▆ ▅ ▄ ▂ ▁*:.｡.✿´°¤,¸.•*`¯");
                            System.out.println("\t1. •------»Agregar producto al stock»------•");
                            System.out.println("\t2. •------»Quitar producto del stock»------•");
                            System.out.println("\t3. •------»Actualizar producto al stock»------•");
                            System.out.println("\t4. •------»Surtir producto del stock»------•");
                            System.out.println("\t5. •------»Ver inventario»------•");
                            System.out.println("\t6. •------»Buscar producto»------•");
                            System.out.println("\t7. •------»Ver Ventas»------•");
                            System.out.println("\t8. •------»Salir»------•");
                            Scanner lector2=new Scanner(System.in);
                            try {
                                int i = lector2.nextInt();
                                switch (i) {
                                    case 1:
                                        inv.AgregarProducto();
                                        break;
                                    case 2:
                                        inv.QuitarProducto();
                                        break;
                                    case 3:
                                        inv.ActualizarProducto();
                                        break;
                                    case 4:
                                        inv.SurtirProducto();
                                        break;
                                    case 5:
                                        inv.VerInventarioAdmi();
                                        break;
                                    case 6:
                                        inv.BuscarProducto();
                                        break;
                                    case 7:
                                        inv.VerVentas();
                                        break;
                                    case 8:
                                        // Cuando se sale del menú administrador, se guarda todos los cambios que se
                                        // hicieron en el inventario
                                        //SerializarInventario.SerializarInv(inv);
                                        data = true;
                                        break;
                                    default:
                                        System.out.println("Esta opció no es posible");
                                        break;

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El dato que inscribes esta mal");
                                lector2.nextLine();
                            }
                        }
                    } else if (opc == 2) {
                        // El menú del cliente, es solamente el método para poder comprar
                        inv.Comprar();
                    } else if (opc == 3) {
                        // Para salir del menú principal
                        data2 = true;
                        exc = true;
                    } else {
                        System.out.println("No existe tal valor");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduce un valor válido");
                lector.nextLine();
            }
        }

    }

}
