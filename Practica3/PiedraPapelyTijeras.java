import java.util.Random;
import java.util.Scanner;

/**Modifica el programa ‘piedra, papel o tijeras, visto en clase que permita seleccionar un ganador en 2 de a lo más
3 veces. Los empates se mostrar ́an en pantalla pero no cuentan como una partida válida.

@author Jiménez Sánchez Emma Alicia.

En el programa basado en la clase, la modificación que hize fue agregar dos contadores donde contara las veces que ganó el usuario
o ganó la computadora, al final de la partida se evaluá los contadores donde si los dos son iguales se hace una tercera partida, pero 
en la segunda partida uno es menor o mayor al otro se sale de la partida, haciendo el booleano falso.

*/

public class PiedraPapelyTijeras{
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
		Random aleatorios = new Random();
		//int manoComputadora = aleatorios.nextInt(3);

		int manoComputadora = 0;
        int contUser=0; //creación de contadores
        int contCompu=0;
		int manoUsuario=0;


        boolean contpart=true; //creación del booleano

        while(contpart){



                System.out.println("Selecciona una mano");
                System.out.println("0: Piedra");
                System.out.println("1: Papel");
                System.out.println("2: Tijeras");
                manoUsuario = entrada.nextInt();
    
    
                if(manoUsuario == manoComputadora) { //en caso que sea un empate

                    System.out.println("\nEmpate\n");
                    System.out.println("PC " + manoComputadora);
                    System.out.println("Usario " + manoUsuario);
    
                    manoComputadora = aleatorios.nextInt(3);
    
                } 
                else {
                    
                    if(manoUsuario==0) {

                    if(manoComputadora==1) { //en caso de que perdamos se va a sumar al contador de la compu
                    System.out.println("\nPerdimos,Computadora ganó\n");
                    System.out.println("PC " + manoComputadora);
                    System.out.println("Usario " + manoUsuario);
                    contCompu++;
                    } else {
                    System.out.println("\nGanamos\n"); //en caso de que gane el usuario se va a sumar al contador del usuario
                    System.out.println("PC " + manoComputadora);
                    System.out.println("Usario " + manoUsuario);
                    contUser++;
                    }


                    }  else if (manoUsuario==1) {

                    if(manoComputadora==0) {
                    System.out.println("\nGanamos\n");
                    System.out.println("PC " + manoComputadora);
                    System.out.println("Usario " + manoUsuario);
                    contUser++;
                    } else {
                    System.out.println("\nPerdimos, Computadora ganó\n");
                    System.out.println("PC " + manoComputadora);
                    System.out.println("Usario " + manoUsuario);
                    contCompu++;

                    }

                    } else {


                    if(manoComputadora==0) {
                    System.out.println("\nPerdimos,Computadora ganó\n");
                    System.out.println("PC " + manoComputadora);
                    System.out.println("Usario " + manoUsuario);
                    contCompu++;
                    } else {
                    System.out.println("\nGanamos\n");
                    System.out.println("PC " + manoComputadora);
                    System.out.println("Usario " + manoUsuario);
                    contUser++;
                    }


                    }
                }
                    
                    if(contUser==2){ //si el contador usuario es 2 el programa termina
                        contpart=false;
                    }
                    else if(contCompu==2){ //si el contador compu es 2 el programa termina
                        contpart=false;
                    }
                    else if(contCompu==1 && contUser==1){ //en caso de que los dos sean iguales se hace una tercera partida en la cual si los dos son diferentes el programa termina.
                        contpart=true;
                        if(contCompu==2 && contUser==1){
                            contpart=false;
                        }
                        else if(contCompu==1 && contUser==2){
                            contpart=false;
                        }
                    }
    
    
                }

                
                System.out.println("\n\nLa partida termino\nPuntaje");
                System.out.println("Compu:"+contCompu);
                System.out.println("User:"+contUser);

    
            }

            
        }

		
        
    
    

