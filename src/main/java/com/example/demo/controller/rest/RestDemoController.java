package com.example.demo.controller.rest;

import com.example.demo.config.DespliegueConfig;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.net.MalformedURLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemoController {

    @Autowired
    DespliegueConfig config;

    @Autowired
    RestDemoService demoService;

    @ResponseBody
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public ObjectNode find() throws MalformedURLException, IOException {

        ObjectNode data = demoService.find();

        return data;
    }
}
