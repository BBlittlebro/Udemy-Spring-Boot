package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "/fancy-login";
    }
}
