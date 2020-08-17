package com.sanstwy27.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Sanstwy27
 * @create 8/18/2020
 */
@Mapper
public interface AccountDao {
    Double getBalanceById(int userId);
}
