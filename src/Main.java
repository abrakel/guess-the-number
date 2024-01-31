package src;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //Atributos globales
    private Random random;
    private int targetNumber;


    //Constructor de la clase
    public Main() {
        random = new Random();
        targetNumber = randomNumber(1, 100);
    }

    //Métodos
    // genera el nro random
    public int randomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    private boolean checkGuess(Player player, Player cpu) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu nombre");
        String name = sc.nextLine();
        System.out.println();

        while(true) {
            int guess = player.makeGuess();
            player.setGuesses(guess);
            if (guess > targetNumber) {
                System.out.println();
                System.out.println(player.getName(name) + " tu suposición fue alta: " + guess);
                System.out.println();
            } else if (guess < targetNumber) {
                System.out.println();
                System.out.println(player.getName(name) + " tu suposición fue baja: " + guess);
                System.out.println();
            } else {
                System.out.println();
                System.out.println("Acertaste " + player.getName(name) + "!");
                System.out.println("Tu historial de suposición fue: " + player.getGuesses());
                return true;
            }

            guess = cpu.makeGuess();
            cpu.setGuesses(guess);
            System.out.println("Computadora: " + guess);
            if (guess > targetNumber) {
                System.out.println("La computadora hizo una suposición alta: " + guess);
                System.out.println();
            } else if (guess < targetNumber) {
                System.out.println("La computadora hizo una suposición baja: " + guess);
                System.out.println();
            } else {
                System.out.println("La computadora acertó!");
                System.out.println("Su historial de suposición fue: " + cpu.getGuesses());
                return true;
            }
        }
    }

    public static void main (String[] args){
        Main main = new Main();
        System.out.println(main.targetNumber);

        Player player = new HumanPlayer();
        Player cpu = new ComputerPlayer();

        main.checkGuess(player, cpu);
    }
}
