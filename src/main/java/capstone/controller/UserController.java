package capstone.controller;

import capstone.DTO.RoleDTO;
import capstone.DTO.UserDTO;
import capstone.entity.Role;
import capstone.entity.User;
import capstone.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/players")
@Slf4j
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/login")
    public String login() {
        return "players/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, HttpSession session) {
        UserDetails user = userService.loadUserByUsername(username);

        if (user != null) {
            session.setAttribute("user", user);

            return "redirect:/players/home";
        } else {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/login";
    }

    @GetMapping("/sign-up")
    public String newUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "players/sign-up";
    }

    @PostMapping("/sign-up")
    public String newUser(@ModelAttribute("UserDTO") UserDTO dto,
                          @ModelAttribute("RoleDTO") RoleDTO roleDto,
                          Model theModel) {


        User user = new User();
        Role role = new Role();
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        user.setRole("user");
        role.setUser(user);
        role.setRole(roleDto.getRole());



        try {
            userService.createUser(user);
        } catch (DataIntegrityViolationException e) {
            theModel.addAttribute("user", new UserDTO());
            theModel.addAttribute("error", "Username already exists");
            return "players/sign-up";
        }

        return "players/home";
    }
}
