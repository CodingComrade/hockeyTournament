package capstone.service;


import capstone.DTO.PlayerStatsDTO;
import capstone.dao.PlayerRepository;

import capstone.entity.Player;
import capstone.entity.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@ComponentScan("capstone")
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).get();
    }

    public Player createPlayer(Player player) {

        return playerRepository.save(player);
    }

    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }




    public void deletePlayer(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
        playerRepository.delete(player);
    }

    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
