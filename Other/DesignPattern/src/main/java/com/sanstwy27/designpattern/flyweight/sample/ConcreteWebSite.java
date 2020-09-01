package com.sanstwy27.designpattern.flyweight.sample;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class ConcreteWebSite extends WebSite {
    // WebsiteType
    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("WebSiteType:" + type + " is running .. user:" + user.getName());
    }
}
