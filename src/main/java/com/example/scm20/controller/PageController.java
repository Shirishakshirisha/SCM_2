package com.example.scm20.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Request ko handel karthe hai
@Controller
public class PageController {

    @RequestMapping("/home")
    public String home() {
        return "home"; // home.html
    }


}
