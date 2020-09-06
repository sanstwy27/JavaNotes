package com.sanstwy27.distributedlock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sanstwy27
 * @create 9/6/2020
 */

@RestController
public class Home {
    @GetMapping("/")
    public String home() {
        return "Home page";
    }
}
