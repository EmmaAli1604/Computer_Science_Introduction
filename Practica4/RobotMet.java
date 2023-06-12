import java.util.Random;
import java.util.Scanner;

/**
 * @author Jiménez Sánchez Emma Alicia.
 * 
 *         Imagina que el director de una escuela primaria te solicita que
 *         desarrolles un robot que ayude a los niños a realizar operaciones
 *         aritméticas, tu robot debe tener los siguientes métodos:
 *         • Encender
 *         • Apagar
 *         • Generar operaciones b´asicas
 *         • Generar operaciones intermedias
 *         • Generar operaciones avanzadas
 * 
 */

public class RobotMet {
    // Atributos
    Scanner lector = new Scanner(System.in);
    Random alt = new Random();
    private boolean encendida;

    // El robot esta apagado por default
    public RobotMet() {
        encendida = true; // Esta apagada
    }

    public RobotMet(boolean encendida) {
        this.encendida = encendida; // Esta apagada
    }

    // Método de Mensaje de Bienvenida
    public static void getMensaje() {
        String b = "bienvenido al robot de estudio";
        System.out.println(b.toUpperCase());
        System.out.println("¿Qué nivel deseas estudiar?");
        System.out.println("Ingresa el número de la opción");
        System.out.println("1. Practicar operaciones básicas");
        System.out.println("2. Practicar operaciones intermedias");
        System.out.println("3. Practicar operaciones avanzadas");
    }

    // Método para encender el robot
    public boolean setEncender(boolean encendida) {
        this.encendida = encendida;
        return encendida;
    }

    // Método para apagar el robot
    public boolean getEncender() {
        return encendida;
    }

    // Método Generar Operaciones Básicas
    public void OpBasic1() {
        // Se generan dos números aleatorios
        int num1 = alt.nextInt(9) + 1;
        int num2 = alt.nextInt(9) + 1;
        int pregnum = alt.nextInt(2) + 1;
        int cont = 0;
        int result = num1 + num2; // el resultado se inicializa.

        for (int i = 1; i < 11; i++) { // Se crea un el número de preguntas del 1 al 10
            pregnum = alt.nextInt(2) + 1; // Se crea un número al aleatorio para poder generar ya se una operacion de
                                          // suma o resta
            if (pregnum == 1) {
                for (int k = 0; k < 1; k++) { // Se genera la operacion suma con números diferentes
                    num1 = alt.nextInt(9) + 1;
                    num2 = alt.nextInt(9) + 1;
                    result = num1 + num2;
                    System.out.print("Pregunta " + i + ": " + num1 + "+" + num2 + "=");
                    int resultU = lector.nextInt();
                    if (resultU == result) {
                        System.out.println("Correct!\nEl resultado es: " + result + "\nSigue continuando.");
                        cont++;
                    } else if (resultU != result) {
                        System.out.println("Incorrect! El resultudo es: " + result);
                    }
                    // Con este mismo algoritmo se puede generar la resta y la multiplicación solo
                    // se cambia el operador
                }
            }

            else if (pregnum == 2) {
                for (int j = 0; j < 1; j++) {
                    num1 = alt.nextInt(9) + 1;
                    num2 = alt.nextInt(9) + 1;
                    int result2 = num1 - num2;
                    System.out.print("Pregunta " + i + ": " + num1 + "-" + num2 + "=");
                    int resultU = lector.nextInt();
                    if (resultU == result2) {
                        System.out.println("Correct!\nEl resultado es:" + result2 + "\nSigue continuando.");
                        cont++;
                    } else if (resultU != result2) {
                        System.out.println("Incorrect! El resultudo es: " + result2);
                    }
                }

            }
        }
        // Al final se cuenta cuantas preguntas tienes bien o mal, si son menor a 6
        // estas reprobado si es mayor a 6 estas aprobado
        if (cont < 6) {
            System.out.println("¡REPROBASTE!\nResultado " + cont);
        } else if (cont >= 6) {
            System.out.println("¡APROBASTE! Resultado " + cont);
        }

    }

    // //Método Generar Operaciones Intermedias
    public void OpInter() {
        int num1 = alt.nextInt(99 - 10) + 10;
        int num2 = alt.nextInt(99 - 10) + 10;
        int cont = 0;
        int pregnum = alt.nextInt(3) + 1;
        int result = num1 + num2;

        for (int i = 1; i < 11; i++) {
            pregnum = alt.nextInt(3) + 1;
            if (pregnum == 1) {
                for (int k = 0; k < 1; k++) {
                    num1 = alt.nextInt(99 - 10) + 10;
                    num2 = alt.nextInt(99 - 10) + 10;
                    result = num1 + num2;
                    System.out.print("Pregunta " + i + ": " + num1 + "+" + num2 + "=");
                    int resultU = lector.nextInt();
                    if (resultU == result) {
                        System.out.println("Correct!\nEl resultado es:" + result + "\nSigue continuando.");
                        cont++;
                    } else if (resultU != result) {
                        System.out.println("Incorrect! El resultudo es: " + result);
                    }
                }
            }

            else if (pregnum == 2) {
                for (int j = 0; j < 1; j++) {
                    num1 = alt.nextInt(99 - 10) + 10;
                    num2 = alt.nextInt(99 - 10) + 10;
                    int result2 = num1 - num2;
                    System.out.print("Pregunta " + i + ": " + num1 + "-" + num2 + "=");
                    int resultU = lector.nextInt();
                    if (resultU == result2) {
                        System.out.println("Correct!\nEl resultado es:" + result2 + "\nSigue continuando.");
                        cont++;
                    } else if (resultU != result2) {
                        System.out.println("Incorrect! El resultudo es: " + result2);
                    }
                }

            }

            else if (pregnum == 3) {
                for (int j = 0; j < 1; j++) {
                    num1 = alt.nextInt(99 - 10) + 10;
                    num2 = alt.nextInt(99 - 10) + 10;
                    int result3 = num1 * num2;
                    System.out.print("Pregunta " + i + ": " + num1 + "*" + num2 + "=");
                    int resultU = lector.nextInt();
                    if (resultU == result3) {
                        System.out.println("Correct!\nEl resultado es:" + result3 + "\nSigue continuando.");
                        cont++;
                    } else if (resultU != result3) {
                        System.out.println("Incorrect! El resultudo es: " + result3);
                    }
                }

            }
        }
        if (cont < 6) {
            System.out.println("¡REPROBASTE!\nResultado " + cont);
        } else if (cont >= 6) {
            System.out.println("¡APROBASTE! Resultado " + cont);
        }

    }

    // //Método Generar Operaciones Avanzadas
    public void OpAvanz() {
        int num1 = alt.nextInt(900 - 100) + 100;
        int num2 = alt.nextInt(900 - 100) + 100;
        int pregnum = alt.nextInt(2) + 1;
        int cont = 0;
        int result = num1 + num2;

        for (int i = 1; i < 11; i++) {
            pregnum = alt.nextInt(4) + 1;
            if (pregnum == 1) {
                for (int k = 0; k < 1; k++) {
                    num1 = alt.nextInt(900 - 100) + 100;
                    num2 = alt.nextInt(900 - 100) + 100;
                    result = num1 + num2;
                    System.out.print("Pregunta " + i + ": " + num1 + "+" + num2 + "=");
                    int resultU = lector.nextInt();
                    if (resultU == result) {
                        System.out.println("Correct!\nEl resultado es:" + result + "\nSigue continuando.");
                        cont++;
                    } else if (resultU != result) {
                        System.out.println("Incorrect! El resultudo es: " + result);
                    }
                }
            }

            else if (pregnum == 2) {
                for (int j = 0; j < 1; j++) {
                    num1 = alt.nextInt(900 - 100) + 100;
                    num2 = alt.nextInt(900 - 100) + 100;
                    int result2 = num1 - num2;
                    System.out.print("Pregunta " + i + ": " + num1 + "-" + num2 + "=");
                    int resultU = lector.nextInt();
                    if (resultU == result2) {
                        System.out.println("Correct!\nEl resultado es:" + result2 + "\nSigue continuando.");
                        cont++;
                    } else if (resultU != result2) {
                        System.out.println("Incorrect! El resultudo es: " + result2);
                    }
                }

            }

            else if (pregnum == 3) {
                for (int j = 0; j < 1; j++) {
                    num1 = alt.nextInt(900 - 100) + 100;
                    num2 = alt.nextInt(900 - 100) + 100;
                    int result3 = num1 * num2;
                    System.out.print("Pregunta " + i + ": " + num1 + "*" + num2 + "=");
                    int resultU = lector.nextInt();
                    if (resultU == result3) {
                        System.out.println("Correct!\nEl resultado es:" + result3 + "\nSigue continuando.");
                        cont++;
                    } else if (resultU != result3) {
                        System.out.println("Incorrect! El resultudo es: " + result3);
                    }
                }

            }

            else if (pregnum == 4) {
                for (int j = 0; j < 1; j++) {
                    num1 = alt.nextInt(900 - 100) + 100;
                    num2 = alt.nextInt(900 - 100) + 100;
                    if (num1 <= num2) { // Se evalua si el primer número es menor o igual a num2 y si lo es se crea otro
                                        // número para num1
                        while (num1 <= num2) {
                            num1 = alt.nextInt(900 - 100) + 100;
                        }
                        i--; // Aquí se resta el número ya que este no se debe de contar como pregunta
                    } else if (num1 > num2) { // Si el número es mayor se realiaza la operación, dando el resultado como
                                              // un entero
                        int result4 = num1 / num2;
                        System.out.print("Pregunta " + i + ": " + num1 + "/" + num2 + "=");
                        System.out.println("\nRecuerda que debe ser un número entero el que debes de ingresar");
                        int resultU = lector.nextInt();
                        if (resultU == result4) {
                            System.out.println("Correct!\nEl resultado es:" + result4 + "\nSigue continuando.");
                            cont++;
                        } else if (resultU != result4) {
                            System.out.println("Incorrect! El resultudo es: " + result4);
                        }
                    }
                }
            }
        }
        if (cont < 6) {
            System.out.println("¡REPROBASTE!\nResultado " + cont);
        } else if (cont >= 6) {
            System.out.println("¡APROBASTE! Resultado " + cont);
        }

    }

    // Metodo Main

    public static void main(String[] args) {
        RobotMet estado = new RobotMet();
        Scanner lector = new Scanner(System.in);
        Random pregalt = new Random();
        int pregnum = pregalt.nextInt(2) + 1;
        boolean estado2 = estado.getEncender();
        if (estado2 == false) {
            System.out.println("\nEstado del robot: apagado " + estado.getEncender());
        } else {
            System.out.println("El robot esta encendido " + estado.getEncender());
        }
        System.out.println("\n¿Quieres encender el robot?");
        System.out.println("Ingresa el true EN MINÚSCULAS si deseas encender el robot");
        boolean a = lector.nextBoolean();
        if (a == true) {
            estado.setEncender(a);
            System.out.println("Estado del robot: encendido " + estado.getEncender() + "\n");

            while (estado.getEncender() == true) {
                estado.getMensaje();
                int caso = lector.nextInt();
                switch (caso) {
                    case 1:
                        estado.OpBasic1();
                        break;
                    case 2:
                        estado.OpInter();
                        break;
                    case 3:
                        estado.OpAvanz();
                        break;
                    default:
                        System.out.println("No se encuentra la opción");
                        System.out.println("Ingresa una opción válida");
                        estado.getMensaje();
                        caso = lector.nextInt();
                        break;

                }

                System.out.println("¿Quieres apagar el robot?");
                System.out.println("Ingresa el false EN MINÚSCULAS si deseas encender el robot\n");
                System.out.println("Ingresa el true EN MINÚSCULAS si deseas continuar aprendiendo con el robot\n");
                boolean b = lector.nextBoolean();
                if (b == false) {
                    estado.setEncender(b);
                }

            }
            System.out.println("Estado del robot: apagado " + estado.getEncender());
        } else if (a == false) {
            System.out.println("Estado del robot: apagado " + estado.getEncender());
        }

    }
}