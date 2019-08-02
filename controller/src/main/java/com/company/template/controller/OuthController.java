package com.company.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OuthController {

    @GetMapping(value = "/login")
    public String loign() {
        return "login";
    }

}
