package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Player{
    Scanner sc = new Scanner(System.in);

    //Atributos
    private String name;
    protected List <Integer> guesses;
    int guess = 0;

    //    Constructor
    public Player(){
        guesses = new ArrayList<>();
    }

    //Métodos
    public int makeGuess(){
        return guess;
    };

    public String getName(String name){
        this.name = name;
        return name;
    }

    public void setGuesses (int guess){
        this.guesses.add(guess);
    }
    public List<Integer> getGuesses(){
        return guesses;
    }
}
