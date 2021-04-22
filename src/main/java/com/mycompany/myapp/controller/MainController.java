package com.mycompany.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;

/**
 * Created by Amir on 4/12/2021.
 */
@Controller
public class MainController {
    @Autowired
    ServletContext servletContext;

    @GetMapping("/")
    String test01(Model model){
        model.addAttribute("var01",servletContext.getRealPath("/WEB-INF/myDIR/"));
        return "test";
    }
}
