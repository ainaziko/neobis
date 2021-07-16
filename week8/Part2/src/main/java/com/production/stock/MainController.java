package com.production.stock;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/registration")
    public String about(Model model) {
        model.addAttribute("title", "registration");
        return "registration";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("title", "main");
        return "main";
    }
}