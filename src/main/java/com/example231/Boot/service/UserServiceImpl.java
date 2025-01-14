package com.example231.Boot.service;

import com.example231.Boot.dao.UserDAO;
import com.example231.Boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(Integer id) {
        return userDAO.getById(id);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        userDAO.delete(id);
    }
}
