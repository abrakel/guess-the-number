package src;

import java.util.Scanner;


class HumanPlayer extends Player{
    Scanner sc = new Scanner(System.in);

    public HumanPlayer(){
        super();
    }

    public int makeGuess() {
        System.out.println("Haz tu suposición");
        this.guess = sc.nextInt();
        return guess;
    }
}
