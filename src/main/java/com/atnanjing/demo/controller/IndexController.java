package com.atnanjing.demo.controller;

import com.atguigu.demo.dto.UserDTO;
import com.atguigu.demo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(version = "${demo.service.version}")
    private UserService userService;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") Long id){
        UserDTO userById = userService.findUserById(id);
        return userById;
    }
    //
}
