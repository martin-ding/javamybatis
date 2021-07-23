package ding.local.services;

import ding.local.entity.User;

import java.util.List;

public interface UserService {
    int addUser(User user);
    List<User> selectUser();

}
