package com.chase.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author chase
 * Date: 2021/2/6
 **/
@Configuration
public class ConfigurationBeforeDemo {
    public ConfigurationBeforeDemo() {
        System.out.println("ConfigurationBeforeDemo");
    }
}
