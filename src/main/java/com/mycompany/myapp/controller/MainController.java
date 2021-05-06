package com.mycompany.myapp.controller;

import com.mycompany.myapp.config.Conf02;
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

    @Autowired
    Conf02 conf02;

    @GetMapping("/")
    String test01(Model model) {
        model.addAttribute("var01", conf02.getMyDirLocationFromConf01());
        return "test";
    }
}
