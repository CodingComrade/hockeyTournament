package capstone.dao;

import capstone.entity.Player;
import capstone.entity.Stats;
import capstone.service.PlayerService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByStats(Stats stats);

}
