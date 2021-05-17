package com.mycompany.myapp.controller;

import com.mycompany.myapp.Model.tos.CarTo;
import com.mycompany.myapp.config.Conf02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Amir on 4/12/2021.
 */
@Controller
public class MainController {
    @Autowired
    Conf02 conf02;

    @Value("${amir.value02}")
    private String val02;

    @GetMapping("/")
    String test01(Model model) {
        model.addAttribute("var01", conf02.getMyDirLocationFromConf01() + "    " + val02);
        return "test";
    }

    @GetMapping("/ajax")
    String ajax01() {
        return "ajax_test";
    }

    @GetMapping("/cartest")
    String cartest(Model model,@ModelAttribute("CarTo") CarTo carto) {
        model.addAttribute("var01", carto.getModel() + carto.getFueltype());
        return "test";
    }

}
