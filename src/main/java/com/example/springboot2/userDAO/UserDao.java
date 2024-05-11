package com.example.springboot2.userDAO;

import com.example.springboot2.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();

    User show(int id);

    void remove(int id);

    void update(int id, User user);

    void save(User user);
}
