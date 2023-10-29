package ru.stenyaev.RepairShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class oopsController {
    @GetMapping("/oops")
    public String showAuthorizationPage() {
        return "oops.html";
    }
}
