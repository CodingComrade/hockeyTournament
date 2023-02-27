package capstone.dao;

import capstone.entity.Player;
import capstone.service.PlayerService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
