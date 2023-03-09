package capstone;


import capstone.entity.Player;
import capstone.service.PlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class findByIdTest {

    public static Player player;

    @Autowired
    PlayerService playerService;

    @BeforeEach
    public void setUp() {
        player = new Player();
        player.setName("test");
        player = playerService.createPlayer(player);
    }

    @Test
    public void findByIdTest() {
        Player test = playerService.findById(player.getId());
        Assertions.assertEquals(player.getName(), test.getName());
    }

}
