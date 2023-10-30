package ru.stenyaev.RepairShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComputerController {

    @GetMapping("/computer")
    public String showAuthorizationPage() {
        return "computer.html";
    }
}
