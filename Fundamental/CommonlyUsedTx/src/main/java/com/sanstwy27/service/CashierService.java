package com.sanstwy27.service;

import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

/**
 * @author Sanstwy27
 * @create 8/18/2020
 */
@Service
public interface CashierService {
    void checkout(int userId, List<String> isbns) throws SQLDataException;
}
