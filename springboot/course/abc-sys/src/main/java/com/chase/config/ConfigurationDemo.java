package com.chase.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiuxing.lzh
 * Date: 2021/2/6
 **/
@Configuration
@AutoConfigureAfter(ConfigurationBeforeDemo.class)
public class ConfigurationDemo {
    public ConfigurationDemo( ){
        System.out.println("ConfigurationDemo");
    }

}
