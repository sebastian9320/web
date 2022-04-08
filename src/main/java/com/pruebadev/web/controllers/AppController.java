package com.pruebadev.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    // http://localhost:8090/welcome
    @GetMapping("/welcome")
    public String getStarted(Model model){

        //valor del modelo 
        String username = "User";
        model.addAttribute("name", username);
        return "start";
    }
}
 