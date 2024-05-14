package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors) {
        model.addAttribute("user", user);


        if (errors.hasErrors()){
            model.addAttribute("error", "There was a Validation error.");
            return "user/add";
        } else {
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }

    }


}