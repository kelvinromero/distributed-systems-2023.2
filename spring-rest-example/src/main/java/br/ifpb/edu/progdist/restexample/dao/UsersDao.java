package br.ifpb.edu.progdist.restexample.dao;

import br.ifpb.edu.progdist.restexample.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDao {
    private List<User> users = new ArrayList<User>();

    public UsersDao() {
        users.add(new User(1, "João", 20));
        users.add(new User(2, "Maria", 30));
        users.add(new User(3, "José", 40));
        users.add(new User(4, "Ana", 50));
    }

    public List<User> getUsers() {
        return users;
    }

    public void insertUser(User user) {
        users.add(user);
    }

}
