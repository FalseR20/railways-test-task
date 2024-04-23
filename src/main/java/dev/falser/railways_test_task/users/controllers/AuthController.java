package dev.falser.railways_test_task.users.controllers;

import dev.falser.railways_test_task.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService service;

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        return "sign-up";
    }

    @GetMapping("/sign-in")
    public String signIn(Model model) {
        return "sign-in";
    }

}