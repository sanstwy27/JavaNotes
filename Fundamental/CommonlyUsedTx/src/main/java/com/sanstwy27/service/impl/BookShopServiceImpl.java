package com.sanstwy27.service.impl;

import com.sanstwy27.beans.Book;
import com.sanstwy27.dao.AccountDao;
import com.sanstwy27.dao.BookShopDao;
import com.sanstwy27.service.BookShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLDataException;

/**
 * @author Sanstwy27
 * @create 8/18/2020
 */
@Service
public class BookShopServiceImpl implements BookShopService {
    @Resource
    private AccountDao accountDao;

    @Resource
    private BookShopDao bookShopDao;

    @Transactional
    @Override
    public void purchase(int userId, String isbn) throws SQLDataException {
        System.out.println("purchase.......");
        // 1. get book
        Book book = bookShopDao.findBookByIsbn(isbn);
        // 2. get balance
        Double balance = accountDao.getBalanceById(userId);
        if(balance < book.getPrice()) throw new SQLDataException("Balance");
        // 3. update stock
        bookShopDao.updateBookStock(isbn);
        // 4. update balance
        bookShopDao.updateUserAccountBalance(userId, book.getPrice());
    }
}
