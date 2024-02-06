package src;

import java.io.InputStream;
import java.util.Scanner;


class HumanPlayer extends Player{
    Scanner sc;

    public HumanPlayer(){
        super();
        this.sc = new Scanner(System.in);
    }

    public HumanPlayer(InputStream inputStream){
        super();
        this.sc = new Scanner(inputStream);
    }

    public int makeGuess() {
        System.out.println();
        System.out.println("Haz tu suposición entre 1 y 100");
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
            } else {
                try {
                    int inputInt = Integer.parseInt(input);
                    if (inputInt > 100 || inputInt < 1) {
                        System.out.println();
                        System.out.println("El número está fuera del rango 1 - 100");
                        System.out.println("Por favor, ingresa un número entre 1 y 100");
                        return guess;
                    } else {
                        this.guess = inputInt;
                        return guess;
                    }
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Lo que has ingresado no es un número");
                    System.out.println("Por favor, ingresa un número entre 1 y 100");
                    return guess;
                }
            }
        }
    }
}
