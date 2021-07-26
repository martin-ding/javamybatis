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
        int a = 10/0;
        return 1;
    }

    @Override
    public List<User> selectUser() {
        List<User>  list = userDao.selectUser();
        int a = 10/0;
        return list;
    }
}