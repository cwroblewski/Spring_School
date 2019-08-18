package com.szkola.Szkola.controller;

import com.szkola.Szkola.model.SystemUser;
import com.szkola.Szkola.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class registerController {

    @Autowired
    SystemUserService systemUserService;

    @GetMapping("/user/registration")
    public String showRegistrationForm(Model model) {
        SystemUser user = new SystemUser();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/user/registration")
    public String saveSystemUSer(SystemUser systemUser)
    {
        if(systemUser.getConfirmPassword().equals(systemUser.getPassword()))
        {
            systemUserService.save(systemUser);
            return "register";
        }
        else
        {
            return "register";
        }
    }
}