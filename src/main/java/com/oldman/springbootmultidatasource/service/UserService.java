package com.oldman.springbootmultidatasource.service;

import com.oldman.springbootmultidatasource.domain.User;

import java.util.List;

/**
 * @author oldman
 */
public interface UserService {

    /**
     * 查询datasource_one数据库表user
     * @return
     */
    List<User> findAllByUserOne();

    /**
     * 查询datasource_two数据库表user
     * @return
     */
    List<User> findAllByUserTwo();
}
