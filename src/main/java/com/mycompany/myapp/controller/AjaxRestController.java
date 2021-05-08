package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Amir on 5/8/2021.
 */
@Controller
public class AjaxRestController {
    @GetMapping("/ajaxrequest")
    public
    @ResponseBody
    String getSearchResultViaAjax() {
        return "sibzamini";
    }
}
