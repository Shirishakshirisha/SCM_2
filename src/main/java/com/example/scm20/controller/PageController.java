package com.example.scm20.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Request ko handel karthe hai
@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Homepage handler");
       model.addAttribute("name","Substring Technologies");
        model.addAttribute("youtubeChannel", "Learn with Shirisha");
        model.addAttribute("github", "https://github.com/Shirishakshirisha");

        
        return "home"; 
    }


    // about page handler
    @RequestMapping("/about")
    public String about(Model model) {
        System.out.println("About handler");
        model.addAttribute("isLogin", false);
        return "about"; 
    }



    // Services page handler
    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services handler");
        return "services"; 
    }


    @RequestMapping("/index")
    public String index() {
        System.out.println("Homepage handler");
       

        
        return "index"; 
    }

}
