package src;

import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class MainTest {

    @Test
    @DisplayName("Test mock número random")
    void testRandomNumber() {
        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(anyInt())).thenReturn(40);
        Main main = new Main();
        main.setRandom(randomMock);
        int random = main.randomNumber();
        assertEquals(40, random);
    }

    @Test
    @DisplayName("Test main")
    void testMain() {
        Main main = new Main();
        assertNotNull(main);

        Player human = new HumanPlayer();
        assertNotNull(human);

        Player cpu = new ComputerPlayer();
        assertNotNull(cpu);

    }
}