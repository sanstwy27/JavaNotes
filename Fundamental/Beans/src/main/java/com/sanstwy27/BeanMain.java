package com.sanstwy27;

import com.sanstwy27.beans.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sanstwy27
 * @create 8/17/2020
 * @note Spring Bean
 */

public class BeanMain {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Book b1 = (Book) ioc.getBean("book");
        Book b2 = (Book) ioc.getBean("book");
        System.out.println(b1 == b2);
    }
}
