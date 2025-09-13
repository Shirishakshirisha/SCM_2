package com.example.scm20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.scm20.Services.UserService;
import com.example.scm20.entities.User;
import com.example.scm20.forms.UserForm;

// Request ko handel karthe hai
@Controller
public class PageController {


    @Autowired
    UserService userService;

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

    // contact page handler
    @GetMapping("/contact")
    public String contact(){
        return new String("contact");
    }

    // Login page handler
    @GetMapping("/login")
    public String login(){
        return new String("login");
    }

    // Login page handler
    @GetMapping("/register")
    public String register(Model model){
       UserForm userForm = new UserForm();
    //    u can add the default data in the empty from 
    //  u can delete this code also and ur name and othe data
        // userForm.setName("Shirisha K");
        // userForm.setPassword("Shirisha@000");
        // userForm.setEmail("shirisha@123gmail.com");
        // userForm.setAbout("About Shirisha");
        // userForm.setPhoneNumber("1234567890");


         // UserForm--> User
        User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic(
        "https://icon-library.com/images/anonymous-avatar-icon/anonymous-avatar-icon-25.jpg")
        .build();
        User savedUser = userService.saveUser(user);

        System.out.println("User saved");

        userService.saveUser(user);
         model.addAttribute("userForm", userForm);
        return "register";
    }
    
    @RequestMapping("/index")
    public String index() {
        System.out.println("Homepage handler");
        return "index";
    }

    @RequestMapping(value="/do-register",method=RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("Processing registration");
        System.out.println(userForm);
        return "redirect:/register";
    }

}
