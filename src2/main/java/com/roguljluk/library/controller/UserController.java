package com.roguljluk.library.controller;

import com.roguljluk.library.model.dto.UserCreationDTO;
import com.roguljluk.library.service.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/register")
    public String register(Model model){
        UserCreationDTO user = new UserCreationDTO();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register")
    public String registration(@ModelAttribute UserCreationDTO user) {

        userService.createNewUser(user);

        return "redirect:login";
    }

    @RequestMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}
