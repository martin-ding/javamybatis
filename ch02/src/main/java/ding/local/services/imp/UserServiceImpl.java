package ding.local.services.imp;

import ding.local.dao.UserDao;
import ding.local.entity.User;
import ding.local.services.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int addUser(User user) {
        userDao.insertUser(user);
        return 1;
    }

    @Override
    public List<User> selectUser() {
        return userDao.selectUser();
    }
}