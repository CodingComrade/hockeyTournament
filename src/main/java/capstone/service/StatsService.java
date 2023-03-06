package capstone.service;

import capstone.dao.StatsRepository;
import capstone.entity.Player;
import capstone.entity.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {

    @Autowired
    private StatsRepository statsRepository;

    public List<Stats> getAllStats() {
        return statsRepository.findAll();
    }

    public Stats getStatsById(Long id) {
        return statsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
    }


    public Stats findByPlayer(Player player) {
        return statsRepository.findByPlayer(player);
    }


    public Stats createStats(Stats stats) {
        return statsRepository.save(stats);
    }

    public Stats updateStats(Player player, Stats statsDetails) {
       Stats stats = statsRepository.findByPlayer(player);
       // Stats stats =
                //statsRepository.findById(id).orElseThrow(() -> new
        // ResourceNotFoundException("Player not found with id " + id));
        stats.setGamesPlayed(statsDetails.getGamesPlayed());
        stats.setGoals(statsDetails.getGoals());
        stats.setAssists(statsDetails.getAssists());
        stats.setPoints(statsDetails.getPoints());
        stats.setPlusMinus(statsDetails.getPlusMinus());
        stats.setShots(statsDetails.getShots());
        stats.setWins(statsDetails.getWins());
        stats.setLosses(statsDetails.getLosses());
        stats.setOvertimeLosses(statsDetails.getOvertimeLosses());
        stats.setShutouts(statsDetails.getShutouts());
        stats.setSavePercentage(statsDetails.getSavePercentage());
        stats.setGoalsAgainstAverage(statsDetails.getGoalsAgainstAverage());
        stats.setSaves(statsDetails.getSaves());
        stats.setShotsAgainst(statsDetails.getShotsAgainst());
        stats.setGoalsAgainst(statsDetails.getGoalsAgainst());
        return statsRepository.save(stats);
    }

    public void deleteStats(Long id) {
        Stats stats = statsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
        statsRepository.delete(stats);
    }

    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
