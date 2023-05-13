package com.hescha.employeeaccounting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/single")
    public String single() {
        return "single";
    }

    @GetMapping("/404")
    public String _404() {
        return "404";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/gallery")
    public String gallery() {
        return "gallery";
    }

    @GetMapping("/icons")
    public String icons() {
        return "icons";
    }

    @GetMapping("/team")
    public String team() {
        return "team";
    }

    @GetMapping("/team-single")
    public String teamSingle() {
        return "team-single";
    }
}
