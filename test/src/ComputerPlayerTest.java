package src;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@DisplayName("Test Clase ComputerPlayer")
class ComputerPlayerTest extends Player {

    @Test
    @Order(1)
    @DisplayName("Test Instanciar ComputerPlayer")
    public void testCreateComputerPlayer(){
        ComputerPlayer computerPlayer = new ComputerPlayer();
        assertNotNull(computerPlayer);

        List<Integer> guesses = computerPlayer.getGuesses();
        assertNotNull(guesses);
        assertEquals(0, guesses.size());
    }

    @Test
    @Order(2)
    @DisplayName("Test mock método MakeGuess")
    public void testMakeGuessWhithMock() {
        //Mock de numero random
        Random randomMock = mock(Random.class);
        when (randomMock.nextInt(anyInt())).thenReturn(40);

        ComputerPlayer computerPlayer = new ComputerPlayer();

        computerPlayer.setRandom(randomMock);

        int guess = computerPlayer.makeGuess();

        assertEquals(40, guess);
    }
}