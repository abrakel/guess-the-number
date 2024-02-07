package src;

import java.io.InputStream;
import java.util.Scanner;


class HumanPlayer extends Player {

    //Colores consola
    public static final String BS_CYAN = "\033[1;4;36m"; //negrita y subrayado
    public static final String B_CYAN = "\033[1;;36m"; //negrita
    public static final String RESET = "\u001B[0m";
    public static final String B_RED = "\033[1;31m"; //negrita
    public static final String RED = "\033[0;31m";


    Scanner sc;

    public HumanPlayer() {
        super();
        this.sc = new Scanner(System.in);
    }

    public HumanPlayer(InputStream inputStream) {
        super();
        this.sc = new Scanner(inputStream);
    }

    public int makeGuess() {
        int input;
        do {
            System.out.println(B_CYAN + ">" + RESET +" Ingresa un número entre 1 y 100");
            while (!sc.hasNextInt()){
                System.out.println();
                System.out.println(B_RED + "X" + RESET + " Lo que has ingresado no es un numero válido");
                System.out.println(B_CYAN + ">" + RESET +  " Ingresa un número entre 1 y 100");
                sc.next();
            }
            input = sc.nextInt();
            if (input < 1 || input > 100){
                System.out.println();
                System.out.println(B_RED + "X" + RESET +" Lo que has ingresado no es un numero válido");
            }
        } while (input < 1 || input > 100);
        return input;
    }
}