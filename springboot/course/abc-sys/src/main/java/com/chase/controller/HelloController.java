package com.chase.controller;

import com.chase.config.MySqlConn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chase
 * Date: 2021/2/5
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Resource
    MySqlConn mySqlConn;

    @RequestMapping("/config")
    public String getConfig() {
        return mySqlConn.getUsername();
    }
}
