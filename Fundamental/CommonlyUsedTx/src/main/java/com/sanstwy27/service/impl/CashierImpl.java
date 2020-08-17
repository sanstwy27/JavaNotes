package com.sanstwy27.service.impl;

import com.sanstwy27.service.BookShopService;
import com.sanstwy27.service.CashierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLDataException;
import java.util.List;

/**
 * @author Sanstwy27
 * @create 8/18/2020
 */
@Service
public class CashierImpl implements CashierService {
    @Resource
    private BookShopService bookShopService;

    //@Transactional
    @Transactional(rollbackFor=Exception.class)
    @Override
    public void checkout(int userId, List<String> isbns) throws SQLDataException {
        for(String isbn: isbns){
            bookShopService.purchase(userId, isbn);
        }
    }
}
