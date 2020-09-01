package com.sanstwy27.designpattern.flyweight.sample;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite webSite1 = factory.getWebSiteCategory("News");
        webSite1.use(new User("Alice"));

        WebSite webSite2 = factory.getWebSiteCategory("Blog");
        webSite2.use(new User("Bob"));

        WebSite webSite3 = factory.getWebSiteCategory("Blog");
        webSite3.use(new User("Charlie"));

        WebSite webSite4 = factory.getWebSiteCategory("Blog");
        webSite4.use(new User("David"));

        System.out.println("WebsiteCount = " + factory.getWebSiteCount());
    }
}
