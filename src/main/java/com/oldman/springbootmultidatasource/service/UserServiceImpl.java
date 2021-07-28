package com.oldman.springbootmultidatasource.service;

import com.oldman.springbootmultidatasource.domain.User;
import com.oldman.springbootmultidatasource.mapper.datasourceOne.UserOneMapper;
import com.oldman.springbootmultidatasource.mapper.datasourceTwo.UserTwoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author oldman
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserOneMapper userOneMapper;
    @Autowired
    private UserTwoMapper userTwoMapper;

    @Override
    public List<User> findAllByUserOne() {
        return userOneMapper.selectAll();
    }

    @Override
    public List<User> findAllByUserTwo() {
        return userTwoMapper.selectAll();
    }
}
