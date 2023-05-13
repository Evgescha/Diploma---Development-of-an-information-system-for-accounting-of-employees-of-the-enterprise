package com.hescha.employeeaccounting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    @GetMapping("/404")
    public String _404() {
        return "404";
    }

    public String index() {
        return "index";
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
