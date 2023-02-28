package capstone.controller;

import capstone.entity.Player;
import capstone.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/list")
    public String listPlayers(Model theModel) {
        List<Player> thePlayers = playerService.findAll();

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


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Player thePlayer = new Player();

        theModel.addAttribute("player", thePlayer);

        return "players/playerForm";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("playerId") int theId,
                                    Model theModel){

        Player thePlayer = playerService.findById(theId);

        theModel.addAttribute("player", thePlayer);

        return "players/playerForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("playerId") int theId) {
        playerService.deleteById(theId);

        return "redirect:/players/list";
    }

    @PostMapping("/save")
    public String savePlayer(@ModelAttribute("player") Player thePlayer) {
        playerService.save(thePlayer);

        return "redirect:/players/list";
    }


}
