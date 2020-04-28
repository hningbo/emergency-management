package com.ningyuanlong.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Tony on 2020/4/25.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
    }
}
