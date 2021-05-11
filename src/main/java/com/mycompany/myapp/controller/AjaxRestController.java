package com.mycompany.myapp.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        json.put("111","aaa");
        entities.add(new JSONObject().put("111","aaa"));
        entities.add(new JSONObject().put("222","bbb"));
        return new ResponseEntity<Object>(entities.toString(), HttpStatus.OK);
    }
}
