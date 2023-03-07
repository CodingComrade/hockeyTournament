package capstone.controller;

import capstone.DTO.UserDTO;
import capstone.entity.User;
import capstone.service.UserService;
import capstone.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/players")
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/login")
    public String login() {
        return "players/login";
    }


    @GetMapping("/sign-up")
    public String newUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "players/sign-up";
    }

    @PostMapping("/sign-up")
    public String newUser(@ModelAttribute UserDTO dto, Model theModel) {


        User user = new User();
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());

        try {
            userService.createUser(user);
        } catch (DataIntegrityViolationException e) {
            theModel.addAttribute("user", new UserDTO());
            theModel.addAttribute("error", "Username already exists");
            return "players/signup";
        }

        return "players/home";
    }
}
