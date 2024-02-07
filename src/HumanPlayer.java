package src;

import java.io.InputStream;
import java.util.Scanner;


class HumanPlayer extends Player {
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
            System.out.println("Ingresa un número entre 1 y 100");
            while (!sc.hasNextInt()){
                System.out.println();
                System.out.println("Lo que has ingresado no es un numero válido");
                System.out.println("Ingresa un número entre 1 y 100");
                sc.next();
            }
            input = sc.nextInt();
            if (input < 1 || input > 100){
                System.out.println();
                System.out.println("Lo que has ingresado no es un numero válido");
            }
        } while (input < 1 || input > 100);
        return input;
    }
}