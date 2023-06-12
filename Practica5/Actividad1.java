import java.util.Arrays;
import java.util.Random;

/**
 * @author Jiménez Sánchez Emma Alicia.
 * 
 *         Escribe un programa que genere 10 contrase ̃nas al azar, una contrase
 *         ̃na debe tener las siguientes caracter ́ısticas:
 *         • Longitud igual a 8
 *         • Incluye entre uno y dos n ́umeros (0-9)
 *         • Incluye entre una y dos may ́usculas (al inicio, en medio o al
 *         final)
 *         • Incluye exactamente un car ́acter especial al inicio, en medio o al
 *         final, estos caracteres s ́olo ser ́an los del
 *         siguiente listado ( *, #, $, &, +, ?, % ).
 *         • Incluye min ́usculas
 *         Luego de generar las contrase ̃nas deber ́as mostrarlas en la
 *         terminal, junto con un letrero que indique su nivel de
 *         seguridad.
 *         Seguridad d ́ebil: Si la contrase ̃na contiene exactamente un n
 *         ́umero y exactamente una letra may ́uscula.
 *         Seguridad media: Si la contrase ̃na contiene exactamente un n ́umero
 *         y dos letras may ́uscula o bien dos n ́umeros
 *         y exactamente una letra may ́uscula.
 *         Seguridad alta: Si la contrase ̃na contiene dos n ́umeros y dos may
 *         ́usculas.
 * 
 *         Ejemplo:
 *         Aw3M*ebq Seguridad media
 *         +abFp4hi Seguridad baja
 *         W3Qm5e$g Seguridad alta
 * 
 *         Modela las contraseñas como un objeto que se compone de contenido (la
 *         secuencia de caracteres) y el nivel de
 *         seguridad (media, baja y alta).
 * 
 */

public class Actividad1 {
    // Atributos de mi clase contraseña
    private String secuencia;
    private String seguridad;

    // Método constructor por omisión
    public Actividad1() {
        secuencia = "";
        seguridad = "";
    }

    // Método donde se genera la contraseña
    public void Generar_Sec(int opc) {
        // Los valores permitidos
        char[] mayus = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        char[] minus = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z' };
        char[] numeros = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
        char[] especiales = { '*', '#', '$', '&', '+', '?', '%' };
        char[] contraseña = new char[8]; // Tamaño de la contraseña
        Random aletoria = new Random();
        int alemayus = aletoria.nextInt(26); // Escoger aleatoriamente la letra mayúscula
        int aleminus = aletoria.nextInt(26); // Escoger aleatoriamente la letra minúscula
        int alenum = aletoria.nextInt(9); // Escoger aleatoriamente un número
        int especial = aletoria.nextInt(7); // Exoger aleatoriamente un caracter especial
        int contmayus = 0; // contador de mayusculas
        int contnum = 0; // Contador de números
        int contesp = 0; // Contador de caracteres especiales
        // De acuerdo con el número aleatorio que ingrese se va a escoger que contraseña
        // generar
        switch (opc) {
            case 0: // Contraseña Básica
                // Se hace un ciclo hasta llenar toda la contraseña
                for (int i = 0; i < contraseña.length; i++) {
                    if (i == 0 || i == 4) { // Para los lugares que estan en el principio se va a tomar ya se un número
                                            // o una letra
                        int opc1 = aletoria.nextInt(2); // Dependiendo del número aleatorio que salga se va a escojer
                                                        // que caracter poner en ese lugar
                        if (opc1 == 0) {
                            if (contmayus < 1) {
                                contraseña[i] = mayus[alemayus];
                                contmayus++;
                            } else {
                                aleminus = aletoria.nextInt(26);
                                contraseña[i] = minus[aleminus];
                            }
                        } else if (opc1 == 1) {
                            if (contnum < 1) {
                                contraseña[i] = numeros[alenum];
                                contnum++;
                            } else {
                                aleminus = aletoria.nextInt(26);
                                contraseña[i] = minus[aleminus];
                            }
                        }
                    } // En las otras posiciones se va a decidir primero donde poner el caracter
                      // especial, si el caracter especial ya esta puesto se va a poner una minuscula
                    else if (i == 1 || i == 2 || i == 3 || i == 5 || i == 6) {
                        for (int j = 0; j < 1; j++) {
                            int opc1 = aletoria.nextInt(2);
                            if (opc1 == 1) {
                                if (contesp < 1) {
                                    contraseña[i] = especiales[especial];
                                    contesp++;
                                } else {
                                    aleminus = aletoria.nextInt(26);
                                    contraseña[i] = minus[aleminus];
                                }
                            } else {
                                aleminus = aletoria.nextInt(26);
                                contraseña[i] = minus[aleminus];
                            }
                        }
                    } // Si no se cumple el caso en donde se ponga una mayuscula o minuscula antes del
                      // último caracter.
                      // En la última posición va a ir los elementos faltantes.
                    else if (i == 7) {
                        if (contnum < 1) {
                            contraseña[i] = numeros[alenum];
                            contnum++;
                        } else if (contmayus < 1) {
                            contraseña[i] = mayus[alemayus];
                            contnum++;
                        } else if (contesp < 1) {
                            contraseña[i] = especiales[especial];
                            contesp++;
                        } else {
                            aleminus = aletoria.nextInt(26);
                            contraseña[i] = minus[aleminus];
                        }
                    }
                }
                String contrasString = new String(contraseña); // Aquí se convierte la constraseña en un string(casting)
                secuencia = contrasString; // La contraseña generada se guarda en el atributo secuencia
                seguridad = "Baja";
                System.out.print("Contraseña: " + secuencia + " | " + seguridad);
                // Este algoritmo es el mismo solo para poder generar una contraseña media o
                // alta, solo cambia con las condiciones de los parametros para poder generar
                // más de una mayúscula ó número.
                break;
            case 1: // Contraseña Media
                for (int i = 0; i < contraseña.length; i++) {
                    if (i == 0 || i == 2 || i == 3 || i == 4) {
                        int opc1 = aletoria.nextInt(2);
                        if (opc1 == 0) {
                            // Si la contraseña tiene menos de 2 masyúsculas y si tiene menos de un número o
                            // igual a un número se pone poner otra mayúscula
                            if (contmayus < 2 && contnum <= 1) {
                                alemayus = aletoria.nextInt(26);
                                contraseña[i] = mayus[alemayus];
                                contmayus++;
                            } else {
                                aleminus = aletoria.nextInt(26);
                                contraseña[i] = minus[aleminus];
                            }
                        } else if (opc1 == 1) {
                            // Si la contraseña tiene menos de 2 números y no tiene mayúsculas o tiene solo
                            // una se puede poner otro número
                            if (contnum < 2 && contmayus <= 1) {
                                alenum = aletoria.nextInt(9);
                                contraseña[i] = numeros[alenum];
                                contnum++;
                            } else {
                                aleminus = aletoria.nextInt(26);
                                contraseña[i] = minus[aleminus];
                            }
                        }
                    } else if (i == 1 || i == 5 || i == 6) { // Para el case se las minúsculas o cáracteres especiales
                        for (int j = 0; j < 1; j++) {
                            int opc2 = aletoria.nextInt(2);
                            if (opc2 == 0) {
                                if (contesp < 1) {
                                    contraseña[i] = especiales[especial];
                                    contesp++;
                                } else {
                                    aleminus = aletoria.nextInt(26);
                                    contraseña[i] = minus[aleminus];
                                }
                            } else {
                                aleminus = aletoria.nextInt(26);
                                contraseña[i] = minus[aleminus];
                            }
                        }
                    } // En dado caso que falte un elemento se agrega en el final
                    else if (i == 7) {
                        // Este es para cuando ya tenemos las dos mayúsculas antes de agregar el número
                        if (contmayus >= 2 && contnum < 1) {
                            contraseña[i] = numeros[alenum];
                            contnum++;
                        } // Este es para cuando ya tenemos los dos números antes de agregar una mayúscula
                        else if (contnum >= 2 && contmayus < 1) {
                            contraseña[i] = mayus[alemayus];
                            contnum++;
                        } // Sino se agrego al caracter especial se agrega al final
                        else if (contesp < 1) {
                            contraseña[i] = especiales[especial];
                            contesp++;
                        } else {
                            aleminus = aletoria.nextInt(26);
                            contraseña[i] = minus[aleminus];
                        }
                    }
                }
                contrasString = new String(contraseña);
                secuencia = contrasString;
                seguridad = "Media";
                System.out.print("Contraseña: " + secuencia + " | " + seguridad);
                break;
            case 2: // Contraseña Alta
                for (int i = 0; i < contraseña.length; i++) {
                    if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                        int opc1 = aletoria.nextInt(3);
                        if (opc1 == 0) {
                            // Solo se puede agregar mayúsculas, cuando haya menos de dos mayúsculas en la
                            // contraseña
                            if (contmayus < 2) {
                                contraseña[i] = mayus[alemayus];
                                contmayus++;
                            } else {
                                aleminus = aletoria.nextInt(26);
                                contraseña[i] = minus[aleminus];
                            }
                        } else if (opc1 == 1) {
                            // Solo se puede agregar números, cuando haya menos de dos números en la
                            // contraseña
                            if (contnum < 2) {
                                contraseña[i] = numeros[alenum];
                                contnum++;
                            } else {
                                aleminus = aletoria.nextInt(26);
                                contraseña[i] = minus[aleminus];
                            }
                        } else if (opc1 == 2) {
                            if (contesp < 1) {
                                contraseña[i] = especiales[especial];
                                contesp++;
                            } else {
                                aleminus = aletoria.nextInt(26);
                                contraseña[i] = minus[aleminus];
                            }
                        }
                    } // Si faltaron elementos por agregar a la contraseña se agregan al final
                    else if (i == 7) {
                        if (contnum < 2 && contmayus >= 2) {
                            contraseña[i] = numeros[alenum];
                            contnum++;
                        } else if (contmayus < 2 && contnum >= 2) {
                            contraseña[i] = mayus[alemayus];
                            contnum++;
                        } else if (contesp < 1) {
                            contraseña[i] = especiales[especial];
                            contesp++;
                        } else {
                            aleminus = aletoria.nextInt(26);
                            contraseña[i] = minus[aleminus];
                        }
                    }
                }
                contrasString = new String(contraseña);
                secuencia = contrasString;
                seguridad = "Alta";
                System.out.print("Contraseña: " + secuencia + " | " + seguridad);

                break;
        }
    }

    // Método main
    public static void main(String[] args) {
        Actividad1 contraseña = new Actividad1();
        Random azar = new Random();
        System.out.println("Contraseñas generadas: ");
        // Se crea un ciclo para poder generar las 10 contraseñas, estas son generadas
        // aleatoriamente
        for (int i = 0; i < 10; i++) {
            int alet = azar.nextInt(3);
            System.out.print((i + 1) + " . ");
            contraseña.Generar_Sec(alet);
            System.out.print("\n");
        }
    }
}