package capstone.controller;


import capstone.DTO.PlayerStatsDTO;
import capstone.entity.Player;
import capstone.entity.Stats;
import capstone.service.PlayerService;
import capstone.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @Autowired
    private StatsService statsService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/list")
    public String listPlayers(Model theModel) {
        List<Player> thePlayers = playerService.getAllPlayers();

        theModel.addAttribute("players", thePlayers);

        return "players/list-players";
    }

    @GetMapping("/home")
    public String home() {
        return "players/home";
    }

    @GetMapping("/bracket")
    public String bracket() {
        return "players/bracket";
    }

    @GetMapping("/scores")
    public String scores() {
        return "players/scores";
    }





    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@ModelAttribute("playerStatsDTO") PlayerStatsDTO playerStatsDTO, Model theModel) {
        Player thePlayer = new Player();
        Stats stats = new Stats();

        theModel.addAttribute("thePlayer", thePlayer);
        theModel.addAttribute("stats", stats);
        theModel.addAttribute("add", "create");



        return "players/playerForm";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showformForUpdate(@PathVariable Long id, Model theModel) {
        Player player = playerService.findById(id);
        Stats stats = statsService.findByPlayer(player);
        theModel.addAttribute("player", player);
        theModel.addAttribute("add", "update");
        theModel.addAttribute("stats", stats);

        return "players/updateForm";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute PlayerStatsDTO dto) {
        Player player = playerService.findById(dto.getPlayerId());
        player.setName(dto.getName());
        player.setTeam(dto.getTeam());

        Stats stats = new Stats();
        stats.setPlayer(player);
        stats.setGamesPlayed(dto.getGamesPlayed() == null ? 0 : dto.getGamesPlayed());
        stats.setGoals(dto.getGoals() == null ? 0 : dto.getGoals());
        stats.setAssists(dto.getAssists() == null ? 0 : dto.getAssists());
        stats.setPoints(dto.getPoints() == null ? 0 : dto.getPoints());
        stats.setPlusMinus(dto.getPlusMinus() == null ? 0 : dto.getPlusMinus());
        stats.setShots(dto.getShots() == null ? 0 : dto.getShots());
        stats.setWins(dto.getWins() == null ? 0 : dto.getWins());
        stats.setLosses(dto.getLosses() == null ? 0 : dto.getLosses());
        stats.setOvertimeLosses(dto.getOvertimeLosses() == null ? 0 : dto.getOvertimeLosses());
        stats.setShutouts(dto.getShutouts() == null ? 0 : dto.getShutouts());
        stats.setSavePercentage(dto.getSavePercentage() == null ? 0.0 : dto.getSavePercentage());
        stats.setGoalsAgainstAverage(dto.getGoalsAgainstAverage() == null ? 0.0 : dto.getGoalsAgainstAverage());
        stats.setSaves(dto.getSaves() == null ? 0 : dto.getSaves());
        stats.setShotsAgainst(dto.getShotsAgainst() == null ? 0 : dto.getShotsAgainst());
        stats.setGoalsAgainst(dto.getGoalsAgainst() == null ? 0 : dto.getGoalsAgainst());


        playerService.updatePlayer(player);
        statsService.updateStats(player, stats);


        return "redirect:/players/list";
    }



    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Player player = playerService.findById(id);
        playerService.deletePlayer(player.getId());


        return "redirect:/players/list";
    }

    @PostMapping("/create") //changed showFormForAdd to save
    public String savePlayer(@ModelAttribute("playerStatsDTO") PlayerStatsDTO
                                     playerStatsDTO, Model theModel) {

        Player player = new Player();
        player.setName(playerStatsDTO.getName());
        player.setTeam(playerStatsDTO.getTeam());


        //refactor model mapper
        Stats stats = new Stats();
        stats.setPlayer(player);
        stats.setGamesPlayed(playerStatsDTO.getGamesPlayed() == null ? 0 : playerStatsDTO.getGamesPlayed());
        stats.setGoals(playerStatsDTO.getGoals() == null ? 0 : playerStatsDTO.getGoals());
        stats.setAssists(playerStatsDTO.getAssists() == null ? 0 : playerStatsDTO.getAssists());
        stats.setPoints(playerStatsDTO.getPoints() == null ? 0 : playerStatsDTO.getPoints());
        stats.setPlusMinus(playerStatsDTO.getPlusMinus() == null ? 0 : playerStatsDTO.getPlusMinus());
        stats.setShots(playerStatsDTO.getShots() == null ? 0 : playerStatsDTO.getShots());
        stats.setWins(playerStatsDTO.getWins() == null ? 0 : playerStatsDTO.getWins());
        stats.setLosses(playerStatsDTO.getLosses() == null ? 0 : playerStatsDTO.getLosses());
        stats.setOvertimeLosses(playerStatsDTO.getOvertimeLosses() == null ? 0 : playerStatsDTO.getOvertimeLosses());
        stats.setShutouts(playerStatsDTO.getShutouts() == null ? 0 : playerStatsDTO.getShutouts());
        stats.setSavePercentage(playerStatsDTO.getSavePercentage() == null ? 0.0 : playerStatsDTO.getSavePercentage());
        stats.setGoalsAgainstAverage(playerStatsDTO.getGoalsAgainstAverage() == null ? 0.0 : playerStatsDTO.getGoalsAgainstAverage());
        stats.setSaves(playerStatsDTO.getSaves() == null ? 0 : playerStatsDTO.getSaves());
        stats.setShotsAgainst(playerStatsDTO.getShotsAgainst() == null ? 0 : playerStatsDTO.getShotsAgainst());
        stats.setGoalsAgainst(playerStatsDTO.getGoalsAgainst() == null ? 0 : playerStatsDTO.getGoalsAgainst());


        playerService.createPlayer(player);
        statsService.createStats(stats);
        theModel.addAttribute("player", player);
        theModel.addAttribute("stats", stats);
        return "redirect:/players/list";

    }


}
