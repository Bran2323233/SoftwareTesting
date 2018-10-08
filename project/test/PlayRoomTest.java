import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayRoomTest {
    private PlayRoom playRoom;

    @Before
    public void initialize(){
        playRoom = new PlayRoom();
    }

    @Test
    public void the_max_should_be_54_and_the_min_should_be_28(){
        playRoom.playGames();
        assertEquals(28,playRoom.getMinTime());
        assertEquals(54,playRoom.getMaxTime());
    }
}