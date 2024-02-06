package src;
import java.util.Random;

class ComputerPlayer extends Player{
    private Random random;

    public ComputerPlayer(){
        super();
        this.random = new Random();
    }

    public void setRandom(Random random){
        this.random = random;
    }

    public int makeGuess(){
        return random.nextInt((100 - 1 +1)+1);
    }
}
