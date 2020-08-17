package com.sanstwy27.controller;

import com.sanstwy27.service.BookShopService;
import com.sanstwy27.service.CashierService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanstwy27
 * @create 8/18/2020
 */
@RestController
public class BookShopController {
    @Resource
    private BookShopService bookShopService;

    @Resource
    private CashierService cashierService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/bookshop/test")
    public String getBookTest() {
        try {
            bookShopService.purchase(1, "1001");
        } catch (SQLDataException throwables) {
            throwables.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping(value = "/bookshop/checkout")
    public String checkout() {
        List<String> isbns = new ArrayList<>();
        isbns.add("1001");
        isbns.add("1002");
        try {
            cashierService.checkout(1, isbns);
        } catch (SQLDataException throwables) {
            throwables.printStackTrace();
        }
        return serverPort;
    }
}
