package src;

import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HumanPlayerTest extends Player {
    private final InputStream originalIn = System.in;
    @Test
    @DisplayName("Número dentro del rango")
    void testInRange(){
       HumanPlayer player = new HumanPlayer(new ByteArrayInputStream("50\n".getBytes()));
        System.setIn(originalIn);
        assertEquals(50, player.makeGuess());

    }
    @Test
    @DisplayName("Número menor que 100")
    void testOutOfRange(){
        HumanPlayer humanMock = mock(HumanPlayer.class);
        when(humanMock.makeGuess()).thenReturn(200);
        assertFalse(humanMock.makeGuess() < 100);
    }
}