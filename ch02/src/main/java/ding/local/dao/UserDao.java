package ding.local.dao;

import ding.local.entity.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);
    List<User> selectUser();
}
