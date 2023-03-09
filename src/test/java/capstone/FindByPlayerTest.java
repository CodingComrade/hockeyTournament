package capstone;

import capstone.entity.Player;
import capstone.entity.Stats;
import capstone.service.PlayerService;
import capstone.service.StatsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FindByPlayerTest {

    private Player player;
    private Stats stats;

    @Autowired
    private StatsService statsService;

    @Autowired
    private PlayerService playerService;

    @BeforeEach
    public void setUp() {
        player = new Player();
        player.setName("test player");
        player = playerService.createPlayer(player);

        stats = new Stats();
        stats.setPlayer(player);
        stats = statsService.createStats(stats);
    }

    @Test
    public void testFindByPlayer() {
        Stats result = statsService.findByPlayer(player);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(stats.getId(), result.getId());
    }
}

