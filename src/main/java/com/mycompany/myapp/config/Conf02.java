package com.mycompany.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.servlet.ServletContext;

/**
 * Created by Amir on 4/23/2021.
 */
@Configuration
@Import({Conf01.class})
public class Conf02 {
    @Autowired
    Conf01 conf01;

    public String getMyDirLocationFromConf01() {
        return conf01.getMyDirLocation();
    }
}
