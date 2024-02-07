package src;

import org.junit.jupiter.api.*;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class MainTest {

    @Test
    @DisplayName("Test mock número random")
    void testMockRandom() {
        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(anyInt())).thenReturn(40);
        Main main = new Main();
        main.setRandom(randomMock);
        int random = main.randomNumber();
        assertEquals(40, random);
    }

    @RepeatedTest(5)
    @DisplayName("Numero random entre 1 y 100")
    void testRandom(){
        Main main = new Main();
        int random = main.randomNumber();
        assertTrue(random >= 1 && random <= 100);
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