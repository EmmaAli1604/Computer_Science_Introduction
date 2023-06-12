import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

/*
 * @author Emma Alicia Jimenez Sanchez
 * En esta clase es en donde tenemos todos los metódos para poder ocupar en el menú administrador y cliente(Aunque cliente es solamente el metódo de comprar)
 * Esta clase se puede serializar
*/

public class Inventario implements Serializable {
    ArrayList<Producto> inventario = new ArrayList<Producto>(); // En este arraylist es para poder guardar los productos
                                                                // del inventario
    static ArrayList<Double> ventas = new ArrayList<Double>();// En este arraylista es para poder guardar las ventas que
                                                              // se vayan haciendo
    ArrayList<Producto> compra = new ArrayList<Producto>(); // En este arraylist temporal es para poder guardar los
                                                            // productos que el cliente vaya comprando

    // El metódo constructor donde ya tenemos estos productos agregados en el
    // inventario
    public Inventario() {
        Producto prod = new Producto("GDHDH22", "Pizza congelada", 10, 50);
        Producto prod2 = new Producto("JAHAA88", "Pasta dental", 24, 14.5);
        Producto prod3 = new Producto("ADFBN17", "Refresco de limón", 15, 22);
        Producto prod4 = new Producto("BHUWQ94", "Galletas de chocolate", 100, 12);
        Producto prod5 = new Producto("ALUTG71", "Bolsa de papas", 40, 17.5);
        inventario.add(prod);
        inventario.add(prod2);
        inventario.add(prod3);
        inventario.add(prod4);
        inventario.add(prod5);

    }

    // Metodo para poder buscar un producto de acuerdo con su código de barras
    public Producto getCodigos(String i) {
        Producto aux = new Producto();
        for (int k = 0; k < inventario.size(); k++) {
            if (inventario.get(k).getCodigo().equals(i)) {
                aux = inventario.get(k);
                break;
            }
        }
        return aux;
    }

    // Las excepciones que pueden aparecer cuando se introduce un código de barras
    // Si al querer agregar un producto se registra con un código ya existente, se
    // va a arrojar una excepción
    public void CodigoYaRegistradoException(String i) throws TiendaException {
        boolean data = false;
        for (int j = 0; j < inventario.size(); j++) {
            if (inventario.get(j).getCodigo().equals(i)) {
                data = true;
                break;
            }
        }
        if (data) {
            throw new TiendaException("ESTE CÓDIGO YA ESTA REGISTRADO");
        }
    }

    // Si al ingresar el código esta mal formado va a arrojar una excepción
    public void CodigoMalFormadoException(String i) throws TiendaException {
        String mayus = "ABVDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String num = "1234567890";
        int nu = 0;
        int ma = 0;
        for (int a = 0; a < i.length(); a++) {
            for (int b = 0; b < mayus.length(); b++) {
                if (i.charAt(a) == mayus.charAt(b)) {
                    ma++;
                    break;
                }
            }

            for (int b = 0; b < num.length(); b++) {
                if (i.charAt(a) == num.charAt(b)) {
                    nu++;
                    break;
                }
            }
        }

        if (nu != 2 && ma != 5 || i.length() != 7) {
            throw new TiendaException("EL CÓDIGO DE BARRAS ESTA MAL FORMADO");
        }

    }

    // Cuando se ingresa un código para poder buscar un producto, si el código no
    // existe en el inventario va a arrojar una excepción
    public void CodigoNoExistenteException(String i) throws TiendaException {
        boolean flag = false;
        for (int g = 0; g < inventario.size(); g++) {
            if (i.equals(inventario.get(g).getCodigo())) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new TiendaException("ESTE CÓDIGO NO EXISTE");
        }
    }

    // Para poder el inventario como un administrador
    public void VerInventarioAdmi() {
        System.out.println("Inventario: ");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(inventario.get(i).mostrarAdmi());
        }
    }

    // Para poder ver el inventario como un cliente
    public void VerInventarioCliente() {
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + "-> " + inventario.get(i).mostrarCliente());
        }
    }

    // Metodo para poder agregar un producto nuevo al inventario
    public void AgregarProducto() {
        Scanner lector = new Scanner(System.in);
        Scanner lector2 = new Scanner(System.in);
        Scanner lector3 = new Scanner(System.in);
        Producto p;
        boolean data = false;
        while (data == false) {
            try {
                System.out.println("¿Código de barras del producto?");
                String cod = lector.nextLine();
                CodigoYaRegistradoException(cod);
                CodigoMalFormadoException(cod);
                System.out.println("¿Cuál es el nombre del producto?");
                String nom = lector.nextLine();
                System.out.println("¿Cuántas unidades tienes?");
                int uni = lector2.nextInt();
                System.out.println("¿Cuál es el precio por unidad?");
                double pre = lector3.nextDouble();
                p = new Producto(cod.toUpperCase(), nom, uni, pre);
                inventario.add(p);
                data = true;

            } catch (TiendaException e) {
                System.out.println("Ingresaste mal el código de barras, por " + e);
                System.out.println("Ingresa un valor válido");
            }
        }

    }

    // Metodo para poder cambiar de nombre a un producto del inventario
    public void CambiarNombre(String i) {
        Scanner lector = new Scanner(System.in);
        Producto aux = getCodigos(i);
        System.out.println("¿A que nombre lo quieres actualizar?");
        String nombre = lector.nextLine();
        for (int k = 0; k < inventario.size(); k++) {
            if (inventario.get(k).getCodigo().equals(aux.getCodigo())) {
                inventario.get(k).setNombre(nombre);
                break;
            }
        }

    }

    // Metodo para poder cambiar el precio de un producto en el inventario
    public void CambiarPrecio(String i) {
        Scanner lector = new Scanner(System.in);
        Producto aux = getCodigos(i);
        System.out.println("¿Qué precio lo quieres actualizar?");
        double precio = lector.nextDouble();
        for (int k = 0; k < inventario.size(); k++) {
            if (inventario.get(k).getCodigo().equals(aux.getCodigo())) {
                inventario.get(k).setPrecio(precio);
                break;
            }
        }
    }

    // Metodo para poder actualizar los datos de un producto, aquí se mandan a
    // llamar los metodos de cambiarnombre y cambiarprecio
    public void ActualizarProducto() {
        Scanner lector = new Scanner(System.in);
        Scanner lector2 = new Scanner(System.in);
        boolean data = false;
        while (!data) {
            try {
                System.out.println("¿Cuál es el código del producto a cambiar?");
                String cod = lector.next();
                CodigoMalFormadoException(cod);
                CodigoNoExistenteException(cod);
                System.out.println("Escoge una de las opciones");
                System.out.println("1-> Cambiar el nombre");
                System.out.println("2-> Cambiar el precio");
                int opc = lector2.nextInt();
                if (opc == 1) {
                    CambiarNombre(cod);
                    data = true;
                } else {
                    CambiarPrecio(cod);
                    data = true;
                }

            } catch (TiendaException e) {
                System.out.println("El código de barras esta mal por: " + e + "\nIntroduce un valor válido");
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un valor válido de opciones");
            }
        }
    }

    // Metodo para poder quitar del inventario un producto
    public void QuitarProducto() {
        Scanner lector = new Scanner(System.in);
        boolean data = false;
        while (!data) {
            try {
                System.out.println("¿Qué producto quieres eliminar? Introduce el código de barras");
                String cod = lector.next();
                CodigoMalFormadoException(cod);
                CodigoNoExistenteException(cod);
                for (int i = 0; i < inventario.size(); i++) {
                    if (cod.equals(inventario.get(i).getCodigo())) {
                        inventario.remove(inventario.get(i));
                        System.out.println("Se ha quitado el producto");
                        break;
                    }
                }

                data = true;

            } catch (TiendaException e) {
                System.out.println("Ingresaste mal el código de barras: " + e);
            }
        }
    }

    // Metodo para poder buscar un producto de acuerdo a una palabra o frase
    public void BuscarProducto() {
        Scanner lector = new Scanner(System.in);
        ArrayList<Producto> Encontrados = new ArrayList<Producto>();
        String aux;
        System.out.println("Introduce la palabra del producto a buscar");
        String i = lector.nextLine();
        // Aqui se evalua en que productos contienen la palabra o frase
        for (int k = 0; k < inventario.size(); k++) {
            aux = inventario.get(k).getNombre();
            if (aux.contains(i)) {
                Encontrados.add(inventario.get(k));
            }
        }
        if (Encontrados.isEmpty()) {
            System.out.println("No se encontro ningún producto");
        } else {
            System.out.println("Productos Encontrados: ");
            for (int j = 0; j < Encontrados.size(); j++) {
                System.out.println(Encontrados.get(j).mostrarAdmi());
            }
        }

    }

    // En este metodo podemos agregar unidades al producto se que le indique
    public void SurtirProducto() {
        Scanner lector = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        boolean data = false;
        String cod;
        while (!data) {
            try {
                System.out.println("Ingresa el código de barras del producto a surtir");
                cod = lector.nextLine();
                CodigoMalFormadoException(cod);
                CodigoNoExistenteException(cod);
                System.out.println("¿Cuánto quieres surtir el producto?");
                int surtir = in.nextInt();
                for (int i = 0; i < inventario.size(); i++) {
                    if (inventario.get(i).getCodigo().equals(cod)) {
                        int aux = inventario.get(i).getUnidades();
                        aux = inventario.get(i).getUnidades() + surtir;
                        inventario.get(i).setUnid(aux);
                        System.out.println(inventario.get(i).mostrarAdmi());
                        break;
                    }
                }
                data = true;
            } catch (TiendaException e) {
                System.out.println("Introduce un valor válido: " + e);
            }
        }
    }

    // Metodo para poder visualizar la compra del cliente
    public void VerCompra() {
        System.out.println("•☆•☆•☆••☆•☆•☆•☜ TICKET ☞•☆•☆•☆••☆•☆•☆•");
        for (int i = 0; i < compra.size(); i++) {
            System.out.println(compra.get(i).mostrarCliente());
        }
        System.out.println("•☆•☆•☆••☆•☆•☆••☆•☆•☆••☆•☆•☆••☆•☆•☆•");
    }

    // Metodo para poder comprar
    public void Comprar() {
        Scanner lector = new Scanner(System.in);
        double total = 0;
        boolean comprar = true;
        boolean exc = false;
        while (comprar) {
            while (!exc) {
                try {
                    double precioaux = 0;
                    System.out.println("¿Qué producto quieres comprar?");
                    VerInventarioCliente();
                    System.out.println("-1.- Salir");
                    System.out.println("Ingresa el número de la lista del producto a comprar");
                    int lista = lector.nextInt();
                    if (lista != -1) {
                        System.out.println("¿Cuántas unidades serán?");
                        int unid = lector.nextInt();
                        Producto aux = inventario.get(lista - 1); // Se crea un producto auxiliar
                        // Si la unidades que el cliente excede las del inventario no se agrega el
                        // producto
                        if (unid <= aux.getUnidades()) {
                            int uni = aux.getUnidades() - unid;
                            inventario.get(lista - 1).setUnid(uni); // Aqui se actuliza las unidades del producto del
                                                                    // inventario
                            precioaux = aux.getPrecio() * unid; // El precio que se muestra en el ticket
                            String nom = inventario.get(lista - 1).getNombre();
                            String cod = inventario.get(lista - 1).getCodigo();
                            aux = new Producto(cod, nom, unid, precioaux);// Se actualiza el producto para poder
                                                                          // agregarlo al ticket sin afectar el
                                                                          // inventario
                            compra.add(aux); // Aquí se agrega al arraylist de compra para poder generar al final el
                                             // ticket
                        } else {
                            System.out.println("Las unidades que quieres exceden las que hay en el inventario");
                        }
                        total = total + aux.getPrecio(); // El precio total del ticket
                    } else if ((lista > inventario.size())) {
                        System.out.println("Opción no válida");
                    } else if (lista == -1) {
                        // Cuando ya no se quiere seguir comprando se sale del menú de comprar
                        comprar = false;
                        exc = true;
                    }
                    // Posibles excepciones que puedan ocurrir en el tiempo de ejecución
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Te equivocaste en: " + e);
                    System.out.println("Ingresa un valor válido");
                    lector.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Te equivocaste en: " + e);
                    System.out.println("Ingresa un valor válido");
                    lector.nextLine();
                } catch (Exception e) {
                    System.out.println("Te equivocaste en: " + e);
                    System.out.println("Ingresa un valor válido");
                    lector.nextLine();
                }
            }
        }
        // Cuando el cliente ya no quiere seguir comprando se le muestra su ticket
        VerCompra();
        System.out.println("Total del ticket: " + total); // Se muestra su total
        ventas.add(total); // El total se agrega al arraylist ventas
        System.out.println("•☆.•*´¨`*•♥•☆.•*´¨`*•♥•☆.•*´¨`*•♥•☆.•*´¨`*•♥•☆.•*´¨`*•♥");
        compra.clear(); // Se borra el ticket que se generó para que cuando un cliente nuevo quiera
                        // comprar no aparezca lo de la anterior compra y se le agregue a su total
    }

    // Metodo para poder ver las ventas
    public void VerVentas() {
        // Si el arraylist de ventas esta vació se pone que no se ha hecho ninguna
        // venta, si por el contrario esta llenoo se muestra las ventas que hay
        if (ventas.isEmpty()) {
            System.out.println("No se ha hecho ninguna venta");
        } else {
            System.out.println("Ventas: ");
            for (int i = 0; i < ventas.size(); i++) {
                System.out.println((i + 1) + ".- " + ventas.get(i));
            }
        }
    }
}
