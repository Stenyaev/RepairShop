package ru.stenyaev.RepairShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhoneController {
    @GetMapping("/phone")
    public String showAuthorizationPage() {
        return "phone.html";
    }
}
