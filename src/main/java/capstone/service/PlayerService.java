package capstone.service;


import capstone.DTO.PlayerStatsDTO;
import capstone.dao.PlayerRepository;

import capstone.entity.Player;
import capstone.entity.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan("capstone")
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Integer id) {
        return playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
    }

    public Player createPlayer(Player player) {
//        Stats stats = player.getStats();
//        stats.setPlayer(player);
//        player.setStats(stats);
        return playerRepository.save(player);
    }

    public Player updatePlayer(Integer id, Player playerDetails) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
        player.setName(playerDetails.getName());
        player.setTeam(playerDetails.getTeam());
        return playerRepository.save(player);
    }

    public void deletePlayer(Integer id) {
        Player player =
                playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
        playerRepository.delete(player);
    }

    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
