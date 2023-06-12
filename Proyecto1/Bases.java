import java.util.Scanner;

/**
La opción de la calculadora mostrará el siguiente menú:
Introduce una opci ́on:
1.- Realizar cambio de base de DECIMAL A BINARIO
2.- Realizar cambio de base de DECIMAL A OCTAL
3.- Realizar cambio de base de DECIMAL A HEXADECIMAL
4.- Realizar cambio de base de BINARIO A DECIMAL
5.- Realizar cambio de base de BINARIO A OCTAL
6.- Realizar cambio de base de BINARIO A HEXADECIMAL
7.- Realizar cambio de base de OCTAL A DECIMAL
8.- Realizar cambio de base de OCTAL A BINARIO
9.- Realizar cambio de base de OCTAL A HEXADECIMAL
10.- Realizar cambio de base de HEXADECIMAL A DECIMAL
11.- Realizar cambio de base de HEXADECIMAL A BINARIO
12.- Realizar cambio de base de HEXADECIMAL A OCTAL
*
*
*
*
* @author JiménezSánchez Emma Alicia.
*/

public class Bases {
    //Método Constructor
    public Bases(){}
    //Mensaje de entrada
    public static void Mensaje(){
        String primer="bienvenidos a la calculadora de cambio de base";
        System.out.println("\n"+primer.toUpperCase());
        System.out.println("\nEscoge la opción la cuál deseas realizar:");
        System.out.println("1.- Realizar cambio de base de DECIMAL A BINARIO");
        System.out.println("2.- Realizar cambio de base de DECIMAL A OCTAL");
        System.out.println("3.- Realizar cambio de base de DECIMAL A HEXADECIMAL");
        System.out.println("4.- Realizar cambio de base de BINARIO A DECIMAL");
        System.out.println("5.- Realizar cambio de base de BINARIO A OCTAL");
        System.out.println("6.- Realizar cambio de base de BINARIO A HEXADECIMAL");
        System.out.println("7.- Realizar cambio de base de OCTAL A DECIMAL");
        System.out.println("8.- Realizar cambio de base de OCTAL A BINARIO");
        System.out.println("9.- Realizar cambio de base de OCTAL A HEXADECIMAL");
        System.out.println("10.- Realizar cambio de base de HEXADECIMAL A DECIMAL");
        System.out.println("11.- Realizar cambio de base de HEXADECIMAL A BINARIO");
        System.out.println("12.- Realizar cambio de base de HEXADECIMAL A OCTAL");
        System.out.println("\n");
    }
    //Métodos para Validación
    //----------------------------------------------------------------------------------------------
      //Validación de un Binario
      //Es un método con visibilidad pública, estático, va a regresar un booleano y se debe
      //ingresar un String
      public static boolean ValidarBin(String a){
        //Se creá un ciclo para que revise cada parte del String
        for(int i=0; i<a.length();i++){
            char c = a.charAt(i); //Evaluá la posición de cada char en el String
            if(c!='1'&& c!='0'){//Si los valores ingresados son diferentes a 1 y 0 regresa falsó
                return false;
            }
        }
        return true;
    }

    //Validación de un Octal
    //Es un método con visibilidad pública, estático, va a regresar un booleano y se debe
    //ingresar un String
    public static boolean ValidarOctal(String a){
        //Se creá un ciclo para que revise cada parte del String
        for(int i=0; i<a.length();i++){
            char c = a.charAt(i);//Evaluá la posición de cada char en el String
            if(c == '8'|| c =='9'){//Si los valores son 8 ó 9 debe de regresar que el string es falso
                return false;
            }
        }
        return true;
    }

    //Validación de un Hexadecimal
    //Es un método con visibilidad pública, estático, va a regresar un booleano y se debe
    //ingresar un String
    public static boolean ValidarHexa(String a){
        boolean vali = true;
        for(int i = 0; i<a.length(); i=i+1){
            char c = a.charAt(i);//Evaluá la posición de cada char en el String
            //Si el char tiene los siguientes cáracteres entonces va a ser verdadero sino el booleano
            //tendrá que ser falsó.
            if(c == '1'|| c =='2' || c == '3'|| c =='4' || 
            c == '5'|| c =='6' || c == '7'|| c =='8' ||
            c == '9'|| c =='A' || c == 'B'|| c =='C' ||
            c == 'D'|| c =='E' || c == 'F'){
                vali = true;
            }else{
                vali = false;
            }
        }
        //Se regresa el booleano.
        return vali;
    }
    //----------------------------------------------------------------------------------------------
    //Métodos para poder cambiar de base
    //Decimal a Binario
    //método con visibilidad pública, estático, que regresá un String y se le debe de ingresar un entero
    public static String DecaBin(int a){
        String salida=""; //La sálida debe ser un String
        int divtemp=a; //La divisor temporal va a ser el int que se va a ingresar 
        int residuo; //El residuo de la división
        int base=2; //La base en la que lo estamos convirtiendo
        while(divtemp>0){ //Se tiene que realizar este proceso hasta que el divisor temporal sea igual o menor a cero
            residuo=divtemp%base; //El residuo es igual al módulo del divisor temporal entre la base
            divtemp=divtemp/base; //Vas a estar dividiendo el divisor temporal entre la base que es 2
            salida=residuo+salida; //La sálida va a ser igual al residuo más los demás residuos que se
            //van realizando
        }
        return salida;
    }
    //Decimal a Octal
    //método con visibilidad pública, estático, que regresá un String y se le debe de ingresar un entero
    public static String DecaOct(int a){
        //Se realiza el mismo algoritmo del binario, solo que aquí nada más cambiamos la base a que sea 8
        String salida="";
        int divtemp=a;
        int residuo;
        int base=8;
        while(divtemp>0){
            residuo=divtemp%base;
            divtemp=divtemp/base;
            salida=residuo+salida;
        }
        return salida;
    }
    // Decimal a Hexadecimal
    //método con visibilidad pública, estático, que regresá un String y se le debe de ingresar un entero
    public static String DecaHex(int a){
        String salida="";
        String charcterHex = "123456789ABCDEF";//Las cárcteres de la basehexadecimal
        int divtemp=a; //El divisor temporal
        int residuo; //El residuo de la división
        int base=16; //La base en la que esta haciendo el cambio
        while(divtemp>0){ //El ciclo se realizara mientras que el divisor temporal sea mayor a 0
            residuo=divtemp%base; //El residuo es igual al módulo del divisor temporal entre la base
            divtemp=divtemp/base; //Se realiza la división
            salida=charcterHex.charAt(residuo-1)+salida; //Aquí se va a evakuar la posición del residuo,
            //porque cuando se tenga un residuo mayor a 9 e igual o menor a 15 se tiene que posicionar una letra.
        }
        return salida;
    }
    //Binario a Decimal
    //En este método tenemos que la visibilidad es pública, es estático, regresa un int y se le debe de ingresar un String
    public static int BinaDec(String a){
        String representacionBinario=a;//La representación en binario es el String que ingresa
		int representacionDecimal=0; //La representación decimal es lo que debe regresar
		int n = representacionBinario.length()-1; //N sería la potencia, la cuál va a ir de acuerdo al tamaño del String binario
        int base=2;
        for(int i=0; i<representacionBinario.length(); i++){//En este ciclo declaramos una variable la cual va a recorrer cada posición del cáracteres en el String
			char c = representacionBinario.charAt(i); //Cada cárcater se va a ir guardando en la variable c para poder comparar
			int var = Integer.parseInt(String.valueOf(c));//La variable var, primero regresa una representación string del char C y después esa representación se pasa a int
            //String.valurOf(paramétro)-regresa una representación String dependiendo el parametro ingresado
            //Inter.parseInt- convierte una cadena de texto en un int
			representacionDecimal += var*Math.pow(base, n); //La representación decimal se va a tener que sumar de acuerdo con lo que vaya saliendo en var por 2 a la n, que es el tamaño de la 
            //String 
			n--;//Se decrementa el exponente para ir cambiando de la posición
        }
        return representacionDecimal;  
    }

    //Octal a decimal
    //En este método tenemos que la visibilidad es pública, es estático, regresa un int y se le debe de ingresar un String
    public static int OctaDec(String a){
        //El algoritmo es el mismo que la conversion de binario a decimal solo que la base se cambia, en lugar de 2 es 8
        String representacionOctal=a;
        int base=8;
		int representacionDecimal=Integer.parseInt(representacionOctal,base);
        //El Integer.parseInt lo ocupo Cinthia para poder resolver el ejercico de Rodrigo
        //El Integer.parseInt(String, int radix) puede recibir dos parametros, donde el int radix convierte el string de acuerdo a la representación que se desee, en este caso es hexadecimal
        //Otra manera de realizarlo 
		// int n = representacionOctal.length()-1;
		// for(int i=0; i<representacionOctal.length(); i++) {
		// 	char c = representacionOctal.charAt(i);
		// 	int var = Integer.parseInt(String.valueOf(c));
		// 	representacionDecimal += var*Math.pow(base, n);
		// 	n--;
        // }
        return representacionDecimal;  
    }

    //Hexadecimal a Decimal
    //En este método tenemos que la visibilidad es pública, es estático, regresa un int y se le debe de ingresar un String
    public static int HexaDec(String a){
        String representacionHexa=a; //La representación en Hexadecimal
        int base=16; //La base en la que se esta realizando
        int representacionDecimal = Integer.parseInt(representacionHexa,base); 
        //El Integer.parseInt(String, int radix) puede recibir dos parametros, donde el int radix convierte el string de acuerdo a la representación que se desee, en este caso es hexadecimal
        return representacionDecimal;  
    }
    //---------------------------------------------------------------------------------------------------------
    //Metódo principal del Cambio de Bases
    public static void BasesCam(){
        //Creación del obejto Scanner
        Scanner lector = new Scanner(System.in);
        Mensaje();//Inicialización del mensaje de bienvenida
        int opc=lector.nextInt(), dec1; //Lector de opciones 
        boolean dato; //Booleano para poder identificar si el dato es válido o no es válido
        String binario1,octal1,hexa1; //Los Strings que van a representar las entredas binarios, octales o hexadecimales
        //El menú de opciones de acuerdo a con lo que el usuario introduzca
        switch(opc){
            case 1: //Decimal a binario
            System.out.println("Ingresa el valor en decimal: ");
            dec1= lector.nextInt();
            System.out.println("Valor en binario: "+DecaBin(dec1));
            break;

            case 2://Decimal a ocatl
            System.out.println("Ingresa el valor en decimal: ");
            dec1= lector.nextInt();
            System.out.println("Valor en octal: "+DecaOct(dec1));
            break;

            case 3: //Decimal a hexadecimal
            System.out.println("Ingresa el valor en decimal: ");
            dec1= lector.nextInt();
            System.out.println("Valor en hexadecimal: "+DecaHex(dec1));
            break;

            case 4://Binario a decimal
            do{
                System.out.println("Ingresa el valor en binario: ");
                binario1=lector.next();
                if(ValidarBin(binario1)==false){//Validación del dato, si es falso debe introducir un valor que sea válido,
                    // si es un valor válido se va a ir al else donde el valor va a ser válido y se va a salir del ciclo.
                    //Este proceso se va a repetir en cada uno de los casos para poder verificar si el dato introducido es verdadero
                    System.out.println("valor inválido");
                    dato = true;
                }else{
                    System.out.println("Si es un valor válido");
                    dato = false;
                }
            }while(dato);
            System.out.println("El número en decimal es: "+BinaDec(binario1));
            break;

            case 5:
            do{
                System.out.println("Ingresa el valor en binario: ");
                binario1=lector.next();
                if(ValidarBin(binario1)==false){
                    System.out.println("valor inválido");
                    dato = true;
                }else{
                    System.out.println("Si es un valor válido");
                    dato = false;
                }
            }while(dato);
            System.out.println("Valor en octal: "+DecaOct(BinaDec(binario1)));//Después de verificar que los datos son correctos se hace el cambio de base
            //donde primero se cambia de binario a decimal y después de decimal a octal, esto se va a realizar en las opciones donde no se cambie a decimal
            break;

            case 6:
            System.out.println("Ingresa el valor en binario: ");
            binario1=lector.next();
            do{
                System.out.println("Ingresa el valor en binario: ");
                binario1=lector.next();
                if(ValidarBin(binario1)==false){
                    System.out.println("valor inválido");
                    dato = true;
                }else{
                    System.out.println("Si es un valor válido");
                    dato = false;
                }
            }while(dato);
            System.out.println("Valor en hexadecimal: "+DecaHex(BinaDec(binario1)));
            break;

            case 7:
            do{
                System.out.println("Ingresa el valor en octal: ");
            octal1=lector.next();
                if(ValidarOctal(octal1)==false){
                    System.out.println("valor inválido");
                    dato =true;
                }else{
                    System.out.println("Si es un valor válido");
                    dato = false;
                }
            }while(dato);
            System.out.println("Valor en decimal: "+OctaDec(octal1));
            break;

            case 8:
            do{
                System.out.println("Ingresa el valor en octal: ");
            octal1=lector.next();
                if(ValidarOctal(octal1)==false){
                    System.out.println("valor inválido");
                    dato =true;
                }else{
                    System.out.println("Si es un valor válido");
                    dato = false;
                }
            }while(dato);
            System.out.println("Valor en binario: "+DecaBin(OctaDec(octal1)));
            break;

            case 9:
            do{
                System.out.println("Ingresa el valor en octal: ");
            octal1=lector.next();
                if(ValidarOctal(octal1)==false){
                    System.out.println("valor inválido");
                    dato =true;
                }else{
                    System.out.println("Si es un valor válido");
                    dato = false;
                }
            }while(dato);
            System.out.println("Valor en hexadecimal: "+DecaHex(OctaDec(octal1)));
            break;

            case 10:
            do{
                System.out.println("Ingresa el valor en hexadecimal: ");
                hexa1=lector.next();
                if(ValidarHexa(hexa1)==false){
                    System.out.println("valor inválido.");
                    dato=true;
                }else{
                    System.out.println("Si es un valor válido.");
                    dato= false;
                }
            }while(dato);
            System.out.println("Valor en decimal: "+HexaDec(hexa1));
            break;

            case 11:
            do{
                System.out.println("Ingresa el valor en hexadecimal: ");
                hexa1=lector.next();
                if(ValidarHexa(hexa1)==false){
                    System.out.println("valor inválido.");
                    dato=true;
                }else{
                    System.out.println("Si es un valor válido.");
                    dato= false;
                }
            }while(dato);
            System.out.println("Valor en binario: "+DecaBin(HexaDec(hexa1)));
            break;

            case 12:
            do{
                System.out.println("Ingresa el valor en hexadecimal: ");
                hexa1=lector.next();
                if(ValidarHexa(hexa1)==false){
                    System.out.println("valor inválido.");
                    dato=true;
                }else{
                    System.out.println("Si es un valor válido.");
                    dato= false;
                }
            }while(dato);
            System.out.println("Valor en octal: "+DecaOct(HexaDec(hexa1)));
            break;

            default: 
            System.out.println("Ese valor no esta en las opciones. Escoge un valor dentro de las opciones");//En caso que el usuario no ingrese correctamente una de las opciones
        }

        lector.close();
    }
}