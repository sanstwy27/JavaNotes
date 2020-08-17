package com.sanstwy27.service;

import org.springframework.stereotype.Service;

import java.sql.SQLDataException;

/**
 * @author Sanstwy27
 * @create 8/18/2020
 */
@Service
public interface BookShopService {
    void purchase(int userId, String isbn) throws SQLDataException;
}
