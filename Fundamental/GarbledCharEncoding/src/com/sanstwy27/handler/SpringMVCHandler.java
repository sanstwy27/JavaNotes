package com.sanstwy27.handler;

import com.sanstwy27.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sanstwy27
 * @create 8/18/2020
 */
@Controller
public class SpringMVCHandler {
    public static final String SUCCESS="success";

    // resolved Chinese character garbled problem
    @RequestMapping("/testPOJO")
    public String testPOJO(Employee employee) {
        System.out.println("Emp info: " + employee);
        return SUCCESS;
    }
}
