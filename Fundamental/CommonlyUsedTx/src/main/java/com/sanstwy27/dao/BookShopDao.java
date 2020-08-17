package com.sanstwy27.dao;

import com.sanstwy27.beans.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Sanstwy27
 * @create 8/18/2020
 */
@Mapper
public interface BookShopDao {
    Book findBookByIsbn(String isbn);
    void updateBookStock(String isbn);
    void updateUserAccountBalance(@Param("userId") int userId, @Param("price") double price);
}
