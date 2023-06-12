import java.util.Random;

/**Un jugador tira dos dados. Cada dado tiene seis caras, las cuales contienen uno, dos, tres, cuatro, cinco y seis puntos negros 
 * respectivamente. Una vez que los dados dejan de moverse, se calcula la suma de los puntos negros en las dos caras superiores. 

 i. Si la suma es 7 u 11 en el primer tiro, el jugador gana. 
ii. Si la suma es 2, 3 o 12 en el primer tiro (llamado “craps”), el jugador pierde (es decir, la “casa” gana). 
iii. Si la suma es 4, 5, 6, 8, 9 o 10 en el primer tiro, esta suma se convierte en el “punto” del jugador. 
iv. Para ganar, el jugador debe seguir tirando los dados hasta que salga otra vez “su punto” (es decir, que tire ese mismo valor de punto). 
v. El jugador pierde si tira un 7 antes de llegar a su punto. 


@author Jiménez Sánchez Emma Alicia.

Para este código pense en dos partidas:
1. La primera partida es en donde ponemos obtener 7 y 11 y ganamos, pero si tenemos 2, 3 y 12 ganamos, más si nos sale otro número 
que no seán esos se hace otra partida.
2. En la segunda partida si sacamos 7 perdemos, pero si sacamos un número que ya nos había salido ganamos.

Para la primera partida utilize un centinela el cual si va a ser falso si ganamos o perdemos, pero si seguimos jugando va a seguir
siendo verdadero, sin embargo en la partida 2 cree otro while el cual va a actuar igual al primero solo que si sale un número que ya 
nos había salido ganamos, sin embargo si sale 7 el centinela se hace falso y salimos del programa.
*/


public class Casino {

    public static void main(String[] args){
        Random carie = new Random(); //Creación de un objeto random que se va aplicar a los dos dados.
        int dado1=carie.nextInt(6)+1;
        int dado2=carie.nextInt(6)+1;
        boolean partida1=true; //Centinelas de las partidas
        boolean partida2=true;
        int result=dado1+dado2; //Inicialización de la variable resultado
        
        while(partida1){ //primera partida = verdadero
            if(result==7||result==11){
                System.out.println("Ganamos "+result);
                partida1=false; //Nos salimos ya que ganamos en la primera partida
            }
            else if(result==2||result==3 || result==12){
                System.out.println("¡Craps! La casa gana, tu resultado fue"+result);
                partida1=false; //Nos salimos ya que perdimos en la primera partida
            }
            else if(result==4||result==5 || result==6 || result==8||result==9 || result==10){
                System.out.println("Sigue jugando, tu resultado fue "+result); //como no perdimos o ganamos, debemos seguir jugando
                
                int result2=result; //el result2 nos va ayudar a comparar las resultados anteriores

                while(partida2){

                    dado1=carie.nextInt(6)+1; //Inicializamos otra vez los dados
                    dado2=carie.nextInt(6)+1;

                    int result3=dado1+dado2; //Inicializamos otro reultado

                    if(result3==7){
                        System.out.println("¡Craps! La casa gana, tu resultado fue "+result3);
                        partida2=false; //Como perdimos nos salimos de la partida2 y partida1
                        partida1=false;
                    }
                    else if(result2==result3){
                        System.out.println("Ganamos "+result3);
                        partida2=false; //Como ganamos nos salimos de la partida2 y partida1
                        partida1=false;
                    }
                }
            }
        }

       
    }
    
}

