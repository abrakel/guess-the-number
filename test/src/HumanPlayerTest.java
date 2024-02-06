package src;

import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest extends Player {
    private HumanPlayer player;
    private final InputStream originalIn = System.in;


    @Test
    @DisplayName("Número dentro del rango")
    void testInRange(){
        player = new HumanPlayer(new ByteArrayInputStream("50\n".getBytes()));
        assertEquals(50, player.makeGuess());
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("Número fuera del rango")
    void testOutOfRange(){
        player = new HumanPlayer(new ByteArrayInputStream("200\n".getBytes()));
        System.out.println(player.guess);
        System.setIn(originalIn);
        assertEquals(0, player.guess);
    }

}