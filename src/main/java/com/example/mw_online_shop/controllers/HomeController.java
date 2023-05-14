package com.itstep.springapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @GetMapping("/")
    public String get() {
        return "redirect:/person";
    }

//    @GetMapping("/test")
//    public String test(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        System.out.println(name + " " + surname);
//        return "home/home";
//    }

    @GetMapping("/test")
    public String test(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname) {
        System.out.println(name + " " + surname);
        return "home/home";
    }
}
