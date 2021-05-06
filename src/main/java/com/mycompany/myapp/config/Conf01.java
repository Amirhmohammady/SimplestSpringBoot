package com.mycompany.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;

/**
 * Created by Amir on 4/23/2021.
 */
@Configuration
public class Conf01 {
    @Autowired
    ServletContext servletContext;

    private String location;

    public Conf01(){

    }
    String getMyDirLocation() {
        return servletContext.getRealPath("/WEB-INF/myDIR/");
    }
}
