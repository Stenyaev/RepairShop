package ru.stenyaev.RepairShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessfulController {

    @GetMapping("/successful")
    public String showAuthorizationPage() {
        return "successful.html";
    }

}
