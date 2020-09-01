package com.sanstwy27.designpattern.flyweight.sample;

import java.util.HashMap;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class WebSiteFactory {
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    public WebSite getWebSiteCategory(String type) {
        if(!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }

        return (WebSite)pool.get(type);
    }

    public int getWebSiteCount() {
        return pool.size();
    }
}
