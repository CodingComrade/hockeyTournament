package capstone.service;

import capstone.dao.StatsRepository;
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

    public Stats getStatsById(Integer id) {
        return statsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
    }

    public Stats createStats(Stats stats) {
        return statsRepository.save(stats);
    }

    public Stats updateStats(Integer id, Stats statsDetails) {
        Stats stats =
                statsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
        stats.setGamesPlayed(statsDetails.getGamesPlayed());
        stats.setGoals(statsDetails.getGoals());
        stats.setAssists(statsDetails.getAssists());
        stats.setPoints(statsDetails.getPoints());
        stats.setPlusMinus(statsDetails.getPlusMinus());
        stats.setShots(statsDetails.getShots());
        stats.setWins(statsDetails.getWins());
        stats.setLosses(statsDetails.getLosses());
        stats.setOTL(statsDetails.getOTL());
        stats.setShutouts(statsDetails.getShutouts());
        stats.setSVPercent(statsDetails.getSVPercent());
        stats.setGAA(statsDetails.getGAA());
        stats.setSaves(statsDetails.getSaves());
        stats.setShotsAgainst(statsDetails.getShotsAgainst());
        stats.setGoalsAgainst(statsDetails.getGoalsAgainst());
        return statsRepository.save(stats);
    }

    public void deleteStats(Integer id) {
        Stats stats = statsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));
        statsRepository.delete(stats);
    }

    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
