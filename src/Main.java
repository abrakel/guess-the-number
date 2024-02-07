package src;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //colores consola
    public static final String B_CYAN = "\033[1;;36m"; //negrita
    public static final String CYAN = "\033[1;;36m";
    public static final String RESET = "\u001B[0m";
    public static final String B_RED = "\033[1;31m"; //negrita
    public static final String RED = "\033[0;31m";
    public static final String BS_MOR = "\033[1;4;35m"; //negrita
    public static final String B_MOR = "\033[1;35m"; //negrita
    public static final String MOR = "\033[0;35m";

    //Atributos globales
    private Random random;
    private int targetNumber;


    //Constructor de la clase
    public Main() {
        this.random = new Random();
        this.targetNumber = randomNumber();
    }

    //Métodos
    // genera el nro random
    public int randomNumber() {
        return random.nextInt((100 - 1 +1)+1);
    }
    public void setRandom(Random random){
        this.random = random;
    }
    private boolean checkGuess(Player player, Player cpu) {
        Scanner sc = new Scanner(System.in);
        System.out.println(BS_MOR + "<<< GUESS THE NUMBER >>>" + RESET);
        System.out.println("El juego donde tienes que adivinar el número generado automáticamente\n");
        System.out.println(B_CYAN + ">" + RESET + " Ingresa tu nombre para comenzar");
        String name = sc.nextLine();
        while (name.isEmpty()){
            System.out.println(B_RED + "X" + RESET +" Por favor, ingresa un nombre válido");
            name = sc.nextLine();
        }
        while (true) {
            int guess = player.makeGuess();
            player.setGuesses(guess);
            if (guess > targetNumber) {
                System.out.println();
                System.out.println(B_MOR + ">> " + player.getName(name) + RESET + MOR + " tu suposición fue alta: " + guess + RESET);
            } else if (guess < targetNumber) {
                System.out.println();
                System.out.println(B_MOR + ">> " + player.getName(name) + RESET + MOR+" tu suposición fue baja: " + guess + RESET);
            } else {
                System.out.println();
                System.out.println(B_MOR + "Acertaste " + player.getName(name) + "!" + RESET);
                System.out.println("Tu historial de suposición fue: " + player.getGuesses());
                return true;
            }
            guess = cpu.makeGuess();
            cpu.setGuesses(guess);
            if (guess > targetNumber) {
                System.out.println(B_CYAN + ">> " + "La computadora hizo una suposición alta: " +RESET+ CYAN + guess + RESET);
                System.out.println();
            } else if (guess < targetNumber) {
                System.out.println(B_CYAN + ">> " + "La computadora hizo una suposición baja: " +RESET+ CYAN + guess + RESET);
                System.out.println();
            } else {
                System.out.println();
                System.out.println(B_CYAN + "La computadora acertó!" + RESET);
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
