package src;
import java.util.Random;

class ComputerPlayer extends Player{
    private Random random;

    public ComputerPlayer(){
        super();
        this.random = new Random();
    }

    public int makeGuess(){
        return this.guess = random.nextInt((100 - 1 +1)+1);
    }
}
