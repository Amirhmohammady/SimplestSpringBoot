package com.mycompany.myapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amir on 5/8/2021.
 */
@RestController
public class AjaxRestController {
    @GetMapping("/ajaxrequest")
    public ResponseEntity<Object> getSearchResultViaAjax() {
/*        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        return new ResponseEntity<Object>(map, HttpStatus.OK);*/
        List<JSONObject> entities = new ArrayList<JSONObject>();
        JSONObject json = new JSONObject();
        //json.put("111","aaa");
/*
        json.put("isPassCorrect", true);
        json.put("message", "bbb");
*/
        entities.add(json);
        return new ResponseEntity<Object>(entities.toString(), HttpStatus.OK);
    }
}
