package capstone.dao;

import capstone.entity.Player;
import capstone.entity.Stats;
import capstone.service.PlayerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findById(Long id);

}