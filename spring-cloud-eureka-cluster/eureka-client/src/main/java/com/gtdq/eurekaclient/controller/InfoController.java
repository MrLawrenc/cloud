package com.gtdq.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : heibaiying
 */

@RestController
public class InfoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("actuator/info")
    public String info() {
        return discoveryClient.description()+" Liu Ming yao";
    }
}
