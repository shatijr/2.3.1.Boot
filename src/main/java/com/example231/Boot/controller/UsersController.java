package com.example231.Boot.controller;

import com.example231.Boot.model.User;
import com.example231.Boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "pages/index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "pages/user-create";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam Integer id, Model model) {
        User user = userService.getById(id);
        System.out.println(user);
        model.addAttribute("user", user);
        return "pages/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }
}

