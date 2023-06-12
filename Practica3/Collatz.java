import java.util.Scanner;

/**Escribe un programa que calcula la sucesi ́on de Collatz

@author Jiménez Sánchez Emma Alicia.

Para hacer este código pense primero en la condiciones que debemos cumplir, donde si era un número par debe ser divido entre 2, y
si es impar debe ser multiplicado por 3 y sumarle un 1, con ayuda de un centinela en un while, se va a repetir el proceso hasta que 
nuestra varible num sea igual a 1, en ese momento el centinela va a ser falso y se va a salir del ciclo.
*/

public class Collatz {

    public static void main(String[] args){
        Scanner lector=new Scanner(System.in); //creando un obejto para que lee lo que el usuario pongo en la terminal
        System.out.println("Introduce el número al cual se quieras sacar la serie");
        int num=lector.nextInt();
        boolean centinela=true;
        boolean salir=true;
        boolean intentos=true;


        while(centinela){


            if(num %2==0){
                num=num/2; //num=num/2 porque la variable se debe de actualizar con el nuevo valor.
            }
            else if(num %2==1){
                num=(3*num)+1;
            }

            System.out.println(num); 


            

            if(num==1){
                centinela=false; //cuando el centinela se falso, se va a salir del ciclo while.
            }

            
        }
                
    
        

    }


        
}
        



    