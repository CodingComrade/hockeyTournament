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

    public Player getPlayerById(Integer id) {
        Optional<Player> player = playerRepository.findById(id);

        Player thePlayer = null;

        if (player.isPresent()) {
            thePlayer = player.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return thePlayer;
        //return playerRepository.findById(id).orElseThrow(() -> new
        // ResourceNotFoundException("Player not found with id " + id));
    }

    public Player createPlayer(Player player) {

        return playerRepository.save(player);
    }

    public Player updatePlayer(Integer id, Player playerDetails) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
        player.setName(playerDetails.getName());
        player.setTeam(playerDetails.getTeam());
        return playerRepository.save(player);
    }




    public void deletePlayer(Integer id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
        playerRepository.delete(player);
    }

    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
