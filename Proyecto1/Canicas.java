import java.util.Scanner;
import java.util.Random;

/**
* Actividades a realizar.
*Esta opción reparte 10 canicas a Miguel y 10 se las queda la computadora.Se pregunta a Miguel 
*cuántas canicas quiere apostar.La computadora aleatoriamente asignará una cantidad de canicas 
*que la computadora apostará.Se preguntará a Miguel si la cantidad seleccionada es par o impar. 
*Si adivinó el valor, suma las canicas de la computadora a su propiedad, de lo contrario, él resta
*sus canicas y se añaden a las de la computadora.Se volverá a preguntar nuevamente cuantas canicas 
*se quiere aposta, pero ahora la computadora tratará de adivinar si la cantidad de canicas que está 
*apostando Miguel es par o impar.Así sucesivamente.
*
*Gana quien se quede con 20 canicas.
*
*
* @author JiménezSánchez Emma Alicia.
*/

public class Canicas {
    //Método principal donde se declara el juego de las cánicas 
    public static void Juego(){
        //Mensaje de bienvenida
        System.out.println("\nBIENVENIDOS AL JUEGO DE LAS CANICAS!");
        //Creación de lo objetos Random y Scanner
        Random canica=new Random();
        Scanner lector = new Scanner(System.in);
        //Creación de las variables
        int miguel=10; //Número de cánicas iniciales que va a tener el usuario
        int compu=10; //Número de cánicas iniciales que va a tener la computadora
        int impar=1; //Declaración e inicialización de la variable impar
        int par=0; //Declaración e inicialización de la variable par
        boolean Soldadorojo=true; //Declaración e inicialización de la varaible centinela para poder repetir el ciclo hasta cierto punto

        while(Soldadorojo){
            //La partida del Usuario
            System.out.println("\nEs tu turno de elegir");
            //---------------------------------------------------------
            //Validación del número de cánicas
            //Checa si el número ingresado es igual o menor al número de cánicas disponibles
            System.out.println("Tienes de canicas: "+miguel);
            System.out.println("¿Cuánto apuestas?");
            int apuestaU=lector.nextInt();
            do{
                if(apuestaU<=miguel){
                    System.out.println("Si podemos apostar\n");
                    break;
                }
                else{
                    System.out.println("\nNo tienes esa cantidad de canicas\nIngresa una cantidad válida\n");
                    System.out.println("¿Cuánto apuestas?");
                    apuestaU=lector.nextInt();
                }

            }while(apuestaU>=miguel);
            //---------------------------------------------------------------------------------------
            int apuestaCompu=canica.nextInt(compu)+1; //Cánicas que va a apostar la computadora
            System.out.println("\n¿Las canicas que tiene la computadora es impar o par?");
            System.out.println("Ingresa 1 si es impar");
            System.out.println("Ingresa 2 si es par\n");
            //El usuario va a tratar de adivinar si las cánicas de la computadora son impar o par
            int sus=lector.nextInt();
            if(sus==1){//Si el usuario sospecha que son impares
                //Si el módulo de las canicas de la computadora son iguales a uno entonces el usuario acerto
                if(impar==(apuestaCompu%2)){
                    System.out.println("Si era impar \nGanamos estas cánicas "+apuestaCompu+"\n");
                    miguel = miguel + apuestaCompu; //Las cánicas ganadas se le suman al usuario
                    compu = compu - apuestaCompu; //Las cánicas apostadas por la computadora se le restan
                }
                //Si el módulo de las canicas de la computadora son iguales a cero entonces el usuario no acerto
                else if(par==(apuestaCompu%2)){
                    System.out.println("No era impar \nPerdimos estas cánicas "+apuestaU+"\n");
                    miguel = miguel - apuestaU;//Lo que aposto el usuario se le resta a sus cánincas iniciales
                    compu = compu + apuestaU; //Las cánicas apostadas por el usuario se le suman a la cantidad de la computadora
                }
            }
            else if(sus==2){ //Si el usuario sospecha que son pares
                //Si el módulo de las canicas de la computadora son iguales a cero entonces el usuario acerto
                if(par==(apuestaCompu%2)){
                    System.out.println("Si era par \nGanamos estas cánicas "+apuestaCompu+"\n");
                    miguel = miguel + apuestaCompu; //Las cánicas ganadas se le suman al usuario
                    compu = compu - apuestaCompu; //Las cánicas apostadas por la computadora se le restan
                }
                //Si el módulo de las canicas de la computadora son iguales a uno entonces el usuario no acerto
                else if(impar==(apuestaCompu%2)){
                    System.out.println("No era par \nPerdimos estas cánicas "+apuestaU+"\n");
                    miguel = miguel - apuestaU; //Lo que aposto el usuario se le resta a sus cánincas iniciales
                    compu = compu + apuestaU; //Las cánicas apostadas por el usuario se le suman a la cantidad de la computadora
                }
            }
            //---------------------------------------------------------------------------------------
            //Se hace una revision para ver si uno de los dos ya perdió ó ganó 
            if(miguel<=0 && compu ==20){ //Si gana la computadora y el usuario pierde
                System.out.println("Perdimos al juego de las canicas");
                Soldadorojo=false;
                break;
            }
            else if(miguel==20 && compu<=0){ //Si gana el usuario y la computadora pierde
                System.out.println("Sobrevivimos al juego de las cánicas");
                Soldadorojo=false;
                break;
            }
            //--------------------------------------------------------------------------------------------------------
            //------------------------------------------------------------------------------------------------------------------
            //Partida de la Compu 
            apuestaCompu=canica.nextInt(compu)+1; //Aquí la computadora escoge las cánicas que quiere apostar
            System.out.println("\nAhora es el turno de la computadora!!!\n");
            //---------------------------------------------------------------------------------------------------
            System.out.println("Tienes de canicas: "+miguel);//Hacemos recordatorio de cuantas cánicas tiene disponible el usuario
            System.out.println("¿Cuánto apuestas?");
            //Cuantas cánicas apuesta el usuario
            apuestaU=lector.nextInt();
            //Revision de que el número de cánicas ingresado por el usuario, sean menores o igual al número 
            //que realmente tiene disponible
            do{
                if(apuestaU<=miguel){
                    System.out.println("Si podemos apostar\n");
                    break;
                }
                else{
                    System.out.println("\nNo tienes esa cantidad de canicas\nIngresa una cantidad válida\n");
                    System.out.println("¿Cuánto apuestas?");
                    apuestaU=lector.nextInt();
                }

            }while(apuestaU>=miguel);
            //--------------------------------------------------------------------------------------------------
            //Suposición de la computadora de las cánicas del usuario
            int suscompu=canica.nextInt(2)+1;
            System.out.println("\nLa computadora supuso esto "+suscompu);
            //Si la computadora sospecha que nuestras cánicas son impar
            if(suscompu==1){
                //Si la computadora acierta 
                if(impar==(apuestaU%2)){
                    System.out.println("La computadora acerto\nSi era impar \nPerdimos estas cánicas "+apuestaU+"\n");
                    miguel = miguel - apuestaU; //El usuario pierde las cánicas apostadas y se le resta a su monto
                    compu = compu + apuestaU;//La apuesta que el usuario hizó, se le suma al monto de la computadora
                }
                //Si la computadora no acierta 
                else if(par==(apuestaU%2)){
                    System.out.println("La computadora erró\nNo era impar \nGanamos estas cánicas "+apuestaCompu+"\n");
                    miguel = miguel + apuestaCompu; //La apuesta que la computadora hizó, se le suma al monto del usuario
                    compu = compu - apuestaCompu; //La computadora pierde las cánicas apostadas y se le resta a su monto
                }
            }
            //Si la computadora sospecha que nuestras cánicas son par
            else if(suscompu==2){
                //Si la computadora acierta
                if(par==(apuestaU%2)){
                    System.out.println("La computadora acerto\nSi era par \nPerdimos estas cánicas "+apuestaU+"\n");
                    miguel = miguel - apuestaU; //El usuario pierde las cánicas apostadas y se le resta a su monto
                    compu = compu + apuestaU; //La apuesta que el usuario hizó, se le suma al monto de la computadora
                }
                //Si la computadora no cierta
                else if(impar==(apuestaU%2)){
                    System.out.println("La computadora erro\nNo era par \nGanamos estas cánicas "+apuestaCompu+"\n");
                    miguel = miguel + apuestaCompu; //La apuesta que la computadora hizó, se le suma al monto del usuario
                    compu = compu - apuestaCompu; //La computadora pierde las cánicas apostadas y se le resta a su monto
                }
            }
            //Se hace una revision para ver si uno de los dos ya perdió ó ganó 
            if(miguel<=0 && compu ==20){
                System.out.println("Perdimos al juego de las canicas");//Si gana la computadora y el usuario pierde
                Soldadorojo=false;
            }
            else if(miguel==20 && compu<=0){
                System.out.println("Sobrevivimos al juego de las cánicas");//Si gana el usuario y la computadora pierde
                Soldadorojo=false;
            }
        }

    }
}
