package ru.stenyaev.RepairShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LaptopController {

    @GetMapping("/laptop")
    public String showAuthorizationPage() {
        return "laptop.html";
    }
}
