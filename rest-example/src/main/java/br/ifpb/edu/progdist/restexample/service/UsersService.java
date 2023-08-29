package br.ifpb.edu.progdist.restexample.service;

import br.ifpb.edu.progdist.restexample.dao.UsersDao;
import br.ifpb.edu.progdist.restexample.model.User;

import java.util.List;

public class UsersService {
    private UsersDao userDao = new UsersDao();

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User getUserByCode(int code) {
        return getUsers().stream()
                .filter(user -> user.getCode() == code)
                .findFirst()
                .orElse(null);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
