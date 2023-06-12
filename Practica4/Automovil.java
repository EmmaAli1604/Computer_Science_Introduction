import java.util.Scanner;
import java.util.Random;

/**
 * @author Jiménez Sánchez Emma Alicia.
 * 
 *         • compania (String)
 *         • marca (String)
 *         • color (String)
 *         • capacidad total del tanque (litros de gasolina) (double)
 *         • capacidad actual del tanque (litros de gasolina) (double)
 * 
 *         • encenderAuto()
 *         Este método establece la variable encendido a true.
 *         • apagarAuto()
 *         Este método establece la variable encendido a false.
 *         • avanzar(int kilometros)
 *         Este método recibe un entero representando el recorrido en
 *         kil´ometros de un viaje que se pretende hacer.
 *         El auto gastará 0.3 litros de gasolina por kilómetro, este
 *         combustible se irá restando a la capacidad actual del tanque.
 *         Este método deberá imprimir por cada kil´ometro del viaje los
 *         siguientes mensajes:
 *         Kilómetro i (desde i=1 hasta n)
 *         Gasolina actual del auto.
 *         Si la cantidad de gasolina se agota antes de concluir el viaje, es
 *         decir, antes del kilómetro n, deberás mostrar un mensaje que diga:
 *         Nos quedamos en el kilómetro j (1 <= j < n)
 *         No logramos completar el viaje y el auto deberá apagarse (mandar a
 *         llamar al m´etodo apagarAuto ( ) )
 *         • cargarGasolina(double dinero)
 *         Este método recibe una cantidad de dinero en pesos y aumenta el
 *         combustible del auto dependiendo de cuantos litros alcancemos a
 *         comprar.
 *         (Considera que el litro de gasolina cuesta $19.8 )
 *         En caso de que te sobre cambio, imprime el monto.
 *         • cargarTodoElTanque()
 *         Este método llena todo el tanque del auto.
 *         Dependiendo de los litros que hayan tenido que suministrar a tu auto
 *         se mostrará en pantalla la cantidad de dinero a cobrar.
 *         • carreritas(Automovil a1, Automovil a2)
 *         Este método simula una carrera entre dos autos.
 *         El auto que complete primero 10 vueltas a una pista gana
 *         Pueden ocurrir ciertos eventos o incidentes que retrasen a los autos:
 * 
 * 
 */

public class Automovil {
    Scanner lector = new Scanner(System.in);
    Random alt = new Random();
    private String compania;
    private String marca;
    private final String color;
    private final double capacidad_tanque;
    private double capacidad_tanque_act;
    private boolean encendido;

    public Automovil() {
        compania = "Honda";
        marca = "Suzuki";
        color = "rojo";
        capacidad_tanque = 30.00;
        capacidad_tanque_act = 0.00;
        encendido = true;
    }

    public Automovil(String compania, String marca, String color, double capacidad_tanque, double capacidad_tanque_act,
            boolean encendido) {
        this.compania = compania;
        this.marca = marca;
        this.color = color;
        this.capacidad_tanque = capacidad_tanque;
        this.capacidad_tanque_act = capacidad_tanque_act;
        this.encendido = encendido;
    }

    public void Mensaje() {
        System.out.println("TU COCHE ESTA ENCENDIDO\n\nEscoje que deseas realizar :");
        System.out.println("1. Llenar el tanque de gasolina");
        System.out.println("2. Llenar TODO el tanque de gasolina");
        System.out.println("3. Avanzar cierta cantidad de kilometros");
        System.out.println("4. Jugar a las carreritas");
    }

    public boolean setEncenderAuto(boolean encendido) {
        this.encendido = encendido;
        return encendido;
    }

    public boolean getApagarAuto() {
        return encendido;
    }

    public double getCantTanque() {
        double redonA = Math.round(capacidad_tanque_act * 100.00) / 100.00;
        return redonA;
    }

    public double getCapacidadTanque() {
        return capacidad_tanque;
    }

    public boolean Avanzar(int km) {
        int recorrido = km;
        System.out.println("Capacidad del tanque actual:" + capacidad_tanque_act);
        double gas_base = 0.3;
        int km_actual = 0;
        // boolean lleno = true;
        boolean enc = true;

        if (capacidad_tanque_act < .30) {
            System.out.println("No podemos avanzar porque falta gasolina");
            enc = false;
        } else {
            while (km_actual != recorrido && capacidad_tanque_act > 0.30) {
                km_actual = km_actual + 1;
                capacidad_tanque_act = capacidad_tanque_act - 0.3;
                System.out.println("Kilometro actual: " + km_actual + "->" + recorrido);
                System.out.println(
                        "Capacidad del tanque de gas actualmente:" + Math.round(capacidad_tanque_act * 100.0) / 100.0);
            }
            ;
            if (capacidad_tanque_act < 0.3 && km_actual != recorrido) {
                enc = false;
                System.out.println("Nos quedamos en el kilimetro " + km_actual + " de " + recorrido);
            } else {
                enc = true;
                System.out.println("Llegamos al kilimetro " + km_actual + " de " + recorrido);
            }
        }

        return enc;

    }

    public void cargarGasolina(double dinero) {
        double result = capacidad_tanque * 19.8;

        System.out.println("Por culpa de la inflación la gasolina esta en $19.8");
        if (dinero > result) {
            System.out.print("No nos mientas, sabemos que no tienes esa cantidad de dinero");
        } else if (dinero <= result) {
            System.out.println("Podemos recargar una parte del tanque");
            capacidad_tanque_act = (dinero / 19.8);
            System.out.println(
                    "El tanque se llenó con " + Math.round(capacidad_tanque_act * 100.00) / 100.00
                            + " litros de gasolina");
            double result2 = capacidad_tanque - capacidad_tanque_act;
            System.out.println("Nos faltó " + Math.round(result2 * 100.00) / 100.00 + " para que se llenará el tanque");
        }
    }

    public void cargarTodoElTanque(double dinero) {
        double result = capacidad_tanque * 19.8;
        double dinerorest = 0;
        if (dinero >= result) {
            dinerorest = dinero - result;
            capacidad_tanque_act = capacidad_tanque;
            System.out.println("El tanque esta totalmente llenó con " + capacidad_tanque_act + " litros de gasolina");
            System.out.println("Nos queda de cambio $" + dinerorest);
            System.out.println("Puedes regresar a casa");
        }
    }

    public String toString() {
        String torrino = "";
        torrino = "Mi auto es de la marca: " + marca + "\nDe la compañía: " + compania
                + "\nCon una capacidad de tanque hasta " + capacidad_tanque +
                " litros,\nActualmente tiene " + capacidad_tanque
                + "\nSi esta en false esta APAGADO, si esta en true esta ENCENDIDO: " + encendido;
        return torrino;
    }

    public void carreritas(Automovil a1, Automovil a2) {
        System.out.println("Inicio la carrera!!!");
        int cont1 = 0;
        int cont2 = 0;
        while (cont1 < 10 || cont2 < 10) {
            int probabilidad = alt.nextInt(10) + 1;
            if (probabilidad < 4) {
                System.out.println("El auto " + a1.compania + " color " + a1.color + " ha completado " + cont1);
                System.out
                        .println("El auto " + a2.compania + " color " + a2.color + " ha completado " + cont2);
                System.out.println("************************************************************************");
                cont1++;
                cont2++;
            } else if (3 <= probabilidad && probabilidad <= 7) {
                int alet = alt.nextInt(3);
                if (alet == 0) {
                    System.out.println("El auto " + a1.compania + " color " + a1.color + " ha completado " + cont2);
                    System.out.println("El auto " + a2.compania + " color " + a2.color + " ha completado " + cont1);
                    System.out.println("************************************************************************");
                    cont1++;
                    cont2++;
                } else if (alet == 1) {
                    System.out.println("El auto " + a1.compania + " color " + a1.color
                            + " ha entrado en confusión, así que se detiene");
                    System.out.println("El auto " + a2.compania + " color " + a2.color + " ha completado " + cont2);
                    System.out.println("************************************************************************");
                    cont2++;
                } else if (alet == 2) {
                    System.out.println("El auto " + a1.compania + " color " + a1.color
                            + " ha completado " + cont1);
                    System.out.println("El auto " + a2.compania + " color " + a2.color
                            + " ha entrado en confusión, así que se detiene");
                    System.out.println("************************************************************************");
                    cont1++;
                }

            } else if (7 < probabilidad && probabilidad <= 10) {
                int okchicas = alt.nextInt(2) + 1;
                if (okchicas == 1) {
                    System.out.println("El auto " + a1.compania + " color " + a1.color
                            + " ha entrado en confusión, así que se detiene");
                    System.out.println("El auto " + a2.compania + " color " + a2.color + " ha completado " + cont2);
                    System.out.println("************************************************************************");
                    cont2++;
                } else if (okchicas == 2) {
                    System.out.println("El auto " + a1.compania + " color " + a1.color
                            + " ha completado " + cont1);
                    System.out.println("El auto " + a2.compania + " color " + a2.color
                            + " ha entrado en confusión, así que se detiene");
                    System.out.println("************************************************************************");
                    cont1++;
                }
            }
        }
        if (cont1 == cont2) {
            System.out.println("\nAmbos coches ganaron!!!!\nHubo un empate");
        } else if (cont1 > cont2) {
            System.out.println("\nGanó el coche " + a1.compania);
        } else if (cont2 > cont1) {
            System.out.println("\nGanó el coche " + a2.compania);
        }
    }

    public static void main(String[] args) {
        Automovil automovil = new Automovil();
        Automovil auto1 = new Automovil("AlfaRomero", "M1234-2", "Azul", 30.00, 0.00, true);
        Automovil auto2 = new Automovil("Jetta", "M1124-2", "Verde", 30.00, 0.00, true);
        Scanner lector = new Scanner(System.in);
        System.out.println("Tu coches tiene las siguientes características ->\n\n" + automovil.toString());
        System.out.println("\nTo coche ya esta encendido " + automovil.getApagarAuto());

        while (automovil.getApagarAuto() == true) {
            System.out.println("El coche esta encendido " + automovil.getApagarAuto());
            if (automovil.getApagarAuto() == true) {
                automovil.Mensaje();
                System.out.println("¿Qué deseas realizar?");
                int caso = lector.nextInt();
                switch (caso) {
                    case 1:// Llenar el tanque
                        automovil.getCantTanque();
                        if (automovil.getCantTanque() < automovil.getCapacidadTanque()) {
                            System.out.println("¿Cuánto dinero tienes para recargar?");
                            int caso4 = lector.nextInt();
                            automovil.cargarGasolina(caso4);
                        } else if (automovil.getCantTanque() == automovil.getCantTanque()) {
                            System.out.println("YA TIENES EL TANQUE LLENO\n");
                        }
                        break;
                    case 2: // Llenar totalmente el tanque
                        automovil.getCantTanque();
                        if (automovil.getCantTanque() < automovil.getCapacidadTanque()) {
                            System.out.println("¿Cuánto dinero tienes para recargar?");
                            int caso5 = lector.nextInt();
                            automovil.cargarTodoElTanque(caso5);
                            System.out.println(
                                    "El auto esta totalmente recargado " + automovil.getCantTanque() + " litros");
                        } else if (automovil.getCantTanque() == automovil.getCantTanque()) {
                            System.out.println("YA TIENES EL TANQUE LLENO\n");
                        }
                        break;
                    case 3: // Avanzar n kilometros
                        System.out.println("¿Cuántos km deseas avanzar?");
                        int km = lector.nextInt();
                        automovil.Avanzar(km);
                        if (automovil.Avanzar(km) == false) {
                            automovil.setEncenderAuto(false);
                            System.out.println("\nSE NOS APAGO EL AUTO " + automovil.getApagarAuto()
                                    + "\nYA NO TENEMOS GASOLINA!!!!\nDEBEMOS RECARGAR EL TANQUE\n");
                            System.out.println("¿Tienes dinero?\nIngresa 1 si es así, 2 si no es así");
                            int caso2 = lector.nextInt();
                            if (caso2 == 1) {
                                System.out.println("Hay una gasolinera cerca, empujá el coche para poder llegar");
                                System.out.println("LLEGAMOS!\n¿Cuánto dinero tienes?");
                                int caso3 = lector.nextInt();
                                if (caso3 < 594) {
                                    automovil.cargarGasolina(caso3);
                                } else if (caso3 >= 594) {
                                    automovil.cargarTodoElTanque(caso3);
                                }
                            } else if (caso2 == 2) {
                                System.out.println(
                                        "Lo siento mi chavo te quedaste sin coche, espera a una alma bondadosa que te de un rai");
                                automovil.setEncenderAuto(false);
                                break;
                            }

                        }
                        break;
                    case 4: // Carreritas
                        automovil.carreritas(auto1, auto2);
                        break;

                }
            }
            // Para apagar el auto
            if (automovil.getApagarAuto() == true) {
                System.out.println("¿Quieres apagar el coche?");
                System.out.println("Escribe true en para seguir ocupando el coche");
                System.out.println("Escribe false en para apagar la máquina");
                boolean encendido = lector.nextBoolean();
                automovil.setEncenderAuto(encendido);
            } else if (automovil.getApagarAuto() == false) {
                automovil.setEncenderAuto(false);
            }

        }
        System.out.println("\nEl coche permanece apagado " + automovil.getApagarAuto());

    }

}