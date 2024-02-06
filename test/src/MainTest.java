package src;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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