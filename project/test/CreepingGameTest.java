import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreepingGameTest {
    private CreepingGame creepingGame;

    @Before
    public void initialize(){
        creepingGame = new CreepingGame();
    }

    @Test
    public void the_time_of_11111_should_be_54(){
        assertEquals(54,creepingGame.playGame(1,1,1,1,1));
    }
}