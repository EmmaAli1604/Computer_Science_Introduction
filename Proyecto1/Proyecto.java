import java.util.Scanner;
import java.util.Random;

/**
* Actividades a realizar.
*
*Imagina que eres Miguel, cumple con tu tarea y también realiza el juego de las canicas.
*
*Al ejecutar el programa, se debe preguntar un usuario y una contraseña:
*Si el usuario es: miguel y la contraseña: yomero
*Se deberá mostrar el siguiente menú:
*1.Jugar a las canicas
*2.Calculadora 
*
*Si el usuario es: icc y la contraseña: profesor, se debe acceder directamente a las opciones de la 
*calculadora, es decir, no se muestra la opción de jugar a las canicas.
*
* @author JiménezSánchez Emma Alicia.
*/

public class Proyecto{
    public static void main(String[] args){
        //Creación de objeto Scanner
        Scanner lector=new Scanner(System.in);
        //Primer Usuario
        String usuario="Miguel";
        String password="yomero";
        //Segundo Usuario
        String usuario2="icc";
        String password2="profesor";
        //Solicitando el ingresó del usuario y la contraseña
        System.out.println("Ingresa el usuario:");
        String Userlector=lector.nextLine();
        System.out.println("Ingresa la contraseña:");
        String PasswordLector=lector.nextLine();

        //Si el usuario es Miguel se muestra el siguiente menú
        if((Userlector.equals(usuario)) && (PasswordLector.equals(password))){
            System.out.println("\nIngrese un número del menú para poder abrir el juego o la calculadora:");
            System.out.println("1. Juego de canicas");
            System.out.println("2. Calculadora de cambio de base");
            int opc=lector.nextInt();
            //En caso de que escoja las siguientes opciones mandara a llamar al método principal del
            //código de Cánicas y Bases
            switch(opc){
                case 1:
                //Creación del objeto de canicas
                Canicas canicas=new Canicas();
                //Llamada del método Juego del archibo Canicas.java
                canicas.Juego();
                break;
                case 2:
                //Creación de objeto tipo Bases
                Bases cambio = new Bases();
                //Llamada del método principal de Cambio de Bases del archivo Bases.java
                cambio.BasesCam();
                break;
            }
            lector.close();

        }
        //Si el usuario es el profesor se mostrará la siguiente opción
        else if ((Userlector.equals(usuario2)&&(PasswordLector.equals(password2)))){
            Bases cambio2 = new Bases();
            cambio2.BasesCam();
        }
        //En caso de que el usuario no sea válido se mostrará el siguiente mensaje.
        else{
            System.out.println("Usuario o contraseña inváñidos\nIntenté de nuevo");
        }

    }
}